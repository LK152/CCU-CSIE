grammar myCompiler;

options {
	language = Java;
}

@header {
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.ArrayDeque;
}

@members {
    boolean TRACEON = false;

    // ====================== Type information ======================
    public enum Type {
       ERR, BOOL, INT, FLOAT, DOUBLE, VOID, ARRAY, STRUCT, CHAR, STRING, POINTER, LONGLONG;
    }

    // Information attached to an expression / symbol.
    class Info {
       Type   theType;
       String operand;
       // --- array fields (non-null only when theType == ARRAY) ---
       Type   elemType;   // element type; also pointee type for POINTER
       int[]  dims;       // dimension sizes, e.g. {3,4} for int a[3][4]
       // --- struct / pointer-to-struct field ---
       String structName; // matches a key in structDefs
       // --- pointer depth: 1=*, 2=**, etc. ---
       int    ptrDepth;

       Info() { theType = Type.ERR; operand = ""; }
       Info(Type t, String op) { theType = t; operand = op; }
       // array constructor
       Info(Type elem, int[] d, String op) {
          theType = Type.ARRAY; elemType = elem; dims = d; operand = op;
       }
       // struct constructor
       Info(String sn, String op) {
          theType = Type.STRUCT; structName = sn; operand = op;
       }
       // pointer constructor: pointeeType is what the pointer points to
       Info(Type pointeeTy, String sn, int depth, String op) {
          theType = Type.POINTER; elemType = pointeeTy; structName = sn;
          ptrDepth = depth; operand = op;
       }
       boolean isArray()   { return theType == Type.ARRAY; }
       boolean isStruct()  { return theType == Type.STRUCT; }
       boolean isPointer() { return theType == Type.POINTER; }
    }

    // One field inside a struct definition.
    class StructField {
       Type   t;
       String name;
       StructField(Type t, String n) { this.t = t; this.name = n; }
    }

    // Signature of a user-defined function (for type-checking calls).
    class Func {
       Type ret;
       ArrayList<Type> params;
       Func(Type r, ArrayList<Type> p) { ret = r; params = p; }
    }

    // ====================== Tables / counters =====================
    // Symbol table for the *current* function only (locals + params).
    HashMap<String,Info> symtab    = new HashMap<String,Info>();
    // Persistent table for global variables (never cleared).
    HashMap<String,Info> globalSymtab = new HashMap<String,Info>();
    // Global table of function signatures.
    HashMap<String,Func> functab   = new HashMap<String,Func>();
    // Constant propagation: maps slot address -> constant Info when the slot
    // is known to hold a compile-time constant.  Cleared at control-flow joins.
    HashMap<String,Info> constSlot = new HashMap<String,Info>();
    // Break-target stack: top is the end label for the nearest switch or loop.
    ArrayDeque<String> breakStack    = new ArrayDeque<>();
    // Continue-target stack: top is the label to jump to on 'continue' (loop only).
    ArrayDeque<String> continueStack = new ArrayDeque<>();
    // Holds the update-clause code lines for the current for-loop while body is parsed.
    ArrayList<String> pendingUpdate  = null;
    // Struct definitions: struct name -> ordered list of fields.  Global.
    HashMap<String, ArrayList<StructField>> structDefs = new HashMap<>();
    // Enum values: constant name -> integer value.  Global.
    HashMap<String, Integer> enumTab = new HashMap<>();
    // LLVM struct type declarations emitted before any code.
    ArrayList<String> structTypeDecls = new ArrayList<String>();
    // typedef aliases: typedef-name -> Type.
    HashMap<String, Type> typedefMap = new HashMap<>();
    // goto labels: user label name -> LLVM label string (allocated lazily).
    HashMap<String, String> gotoLabelMap = new HashMap<>();
    // global variable declarations (emitted before code).
    ArrayList<String> globalVarDecls = new ArrayList<String>();
    // Counter for static local variables (converted to IR globals).
    int staticCount = 0;

    int varCount   = 0;   // next %t temporary / slot index
    int labelCount = 0;   // next Lxx label index
    int strCount   = 0;   // next @.str global index

    // Platform-specific stdio stream symbol names.
    static final boolean IS_MACOS = System.getProperty("os.name", "").toLowerCase().contains("mac");
    // Hardcoded standard Linux glibc stdio stream symbols
    static final String STDOUT_SYM = "@stdout";
    static final String STDERR_SYM = "@stderr";
    static final String STDIN_SYM  = "@stdin";

    // Pre-populate known C runtime globals.
    {
        globalSymtab.put("stdout", new Info(Type.VOID, (String)null, 1, STDOUT_SYM));
        globalSymtab.put("stderr", new Info(Type.VOID, (String)null, 1, STDERR_SYM));
        globalSymtab.put("stdin",  new Info(Type.VOID, (String)null, 1, STDIN_SYM));
    }

    ArrayList<String> Decls   = new ArrayList<String>(); // top-level declares
    ArrayList<String> Globals = new ArrayList<String>(); // string constants
    ArrayList<String> TextCode= new ArrayList<String>(); // all function bodies

    // bookkeeping for the function currently being compiled
    Type    curRet;
    String  curName;
    ArrayList<Type>   curParamTypes = new ArrayList<Type>();
    ArrayList<String> curParamNames = new ArrayList<String>();

    // ====================== Helpers ===============================
    void emit(String s)      { TextCode.add(s); }
    String newReg()          { return "%t" + (varCount++); }
    String newLabel()        { return "L" + (++labelCount); }

    // Variable lookup: locals first, then globals.
    Info lookup(String name) {
       Info v = symtab.get(name);
       return v != null ? v : globalSymtab.get(name);
    }

    String llTy(Type t) {
       switch (t) {
          case INT:      return "i32";
          case LONGLONG: return "i64";
          case FLOAT:    return "float";
          case DOUBLE:   return "double";
          case VOID:     return "void";
          case CHAR:     return "i8";
          case BOOL:     return "i1";
          case STRING:   return "ptr";
          case POINTER:  return "ptr";
          default:       return "i32";
       }
    }

    // Return byte size of a scalar type (sizeof support).
    int sizeOf(Type t) {
       switch (t) {
          case CHAR:     return 1;
          case INT:      return 4;
          case FLOAT:    return 4;
          case DOUBLE:   return 8;
          case LONGLONG: return 8;
          case POINTER:  return 8;
          default:       return 4;
       }
    }

    int totalBytes(Type elem, int[] dims) {
       int n = sizeOf(elem);
       for (int d : dims) n *= d;
       return n;
    }

    // True if the last emitted line is already a branch/return (LLVM terminator).
    boolean lastIsTerminator() {
       for (int _i = TextCode.size() - 1; _i >= 0; _i--) {
          String _l = TextCode.get(_i).trim();
          if (_l.isEmpty()) continue;
          return _l.startsWith("br ") || _l.startsWith("ret ") || _l.startsWith("switch ");
       }
       return false;
    }

    // Parse a C character literal ('a', '\n', etc.) to its integer value.
    int charVal(String lit) {
       String body = lit.substring(1, lit.length() - 1);
       if (body.length() == 1) return (int) body.charAt(0);
       if (body.charAt(0) == '\\') {
          switch (body.charAt(1)) {
             case 'n':  return 10;
             case 't':  return 9;
             case 'r':  return 13;
             case '0':  return 0;
             case '\\': return 92;
             case '\'': return 39;
             case '"':  return 34;
             case 'b':  return 8;
             case 'f':  return 12;
             default:   return (int) body.charAt(1);
          }
       }
       return (int) body.charAt(0);
    }

    // Allocate (or look up) the LLVM label for a user goto/label name.
    String gotoLabelFor(String name) {
       if (!gotoLabelMap.containsKey(name)) gotoLabelMap.put(name, newLabel());
       return gotoLabelMap.get(name);
    }

    // LLVM float literal: 64-bit hex of the (double-widened) float value.
    String fltHex(float f) {
       long bits = Double.doubleToLongBits((double) f);
       return String.format("0x%016X", bits);
    }

    // LLVM double literal: 64-bit hex of the double value.
    String dblHex(double d) {
       long bits = Double.doubleToRawLongBits(d);
       return String.format("0x%016X", bits);
    }

    // Coerce 'in' to target type, emitting a conversion instruction if needed.
    String coerce(Info in, Type target) {
       if (in.theType == target) return in.operand;
       if (in.theType == Type.INT   && target == Type.FLOAT && isIntImm(in))
          return fltHex((float) getIntImm(in));
       if (in.theType == Type.FLOAT && target == Type.INT   && isFltImm(in))
          return String.valueOf((int) getFltImm(in));
       String r = newReg();
       if      (in.theType == Type.INT    && target == Type.FLOAT)
          emit("  " + r + " = sitofp i32 " + in.operand + " to float");
       else if (in.theType == Type.INT    && target == Type.DOUBLE)
          emit("  " + r + " = sitofp i32 " + in.operand + " to double");
       else if (in.theType == Type.FLOAT  && target == Type.INT)
          emit("  " + r + " = fptosi float " + in.operand + " to i32");
       else if (in.theType == Type.FLOAT  && target == Type.DOUBLE)
          emit("  " + r + " = fpext float " + in.operand + " to double");
       else if (in.theType == Type.DOUBLE && target == Type.FLOAT)
          emit("  " + r + " = fptrunc double " + in.operand + " to float");
       else if (in.theType == Type.DOUBLE && target == Type.INT)
          emit("  " + r + " = fptosi double " + in.operand + " to i32");
       else if (in.theType == Type.BOOL   && target == Type.INT)
          emit("  " + r + " = zext i1 " + in.operand + " to i32");
       else if (in.theType == Type.INT    && target == Type.BOOL)
          emit("  " + r + " = icmp ne i32 " + in.operand + ", 0");
       else if (in.theType == Type.CHAR     && target == Type.INT)
          emit("  " + r + " = sext i8 " + in.operand + " to i32");
       else if (in.theType == Type.INT      && target == Type.LONGLONG)
          emit("  " + r + " = sext i32 " + in.operand + " to i64");
       else if (in.theType == Type.LONGLONG && target == Type.INT)
          emit("  " + r + " = trunc i64 " + in.operand + " to i32");
       else if (in.theType == Type.POINTER  && target == Type.INT)
          emit("  " + r + " = ptrtoint ptr " + in.operand + " to i32");
       else if (in.theType == Type.INT      && target == Type.POINTER) {
          String _ri = newReg();
          emit("  " + _ri + " = inttoptr i32 " + in.operand + " to ptr");
          return _ri;
       }
       else return in.operand;
       return r;
    }

    // Binary arithmetic with implicit int->float promotion.
    Info binArith(String op, Info a, Info b) {
       // Pointer arithmetic: ptr +/- int → new ptr via GEP
       if ((a.theType == Type.POINTER || b.theType == Type.POINTER) && (op.equals("+") || op.equals("-"))) {
          Info _pInfo = (a.theType == Type.POINTER) ? a : b;
          Info _offInfo = (a.theType == Type.POINTER) ? b : a;
          Type _pet = (_pInfo.elemType != null && _pInfo.elemType != Type.ERR) ? _pInfo.elemType : Type.INT;
          String _off = op.equals("-") ? ("-" + _offInfo.operand) : _offInfo.operand;
          String _r = newReg();
          emit("  " + _r + " = getelementptr " + llTy(_pet) + ", ptr " + _pInfo.operand + ", i32 " + _off);
          return new Info(_pet, (String)null, 0, _r);
       }
       Type rt = (a.theType == Type.DOUBLE   || b.theType == Type.DOUBLE)   ? Type.DOUBLE
               : (a.theType == Type.FLOAT    || b.theType == Type.FLOAT)    ? Type.FLOAT
               : (a.theType == Type.LONGLONG || b.theType == Type.LONGLONG) ? Type.LONGLONG
               : Type.INT;

       // --- Constant folding ---
       boolean aImm = isIntImm(a) || isFltImm(a) || isDblImm(a);
       boolean bImm = isIntImm(b) || isFltImm(b) || isDblImm(b);
       if (aImm && bImm) {
          if (rt == Type.INT) {
             long va = getIntImm(a), vb = getIntImm(b), res;
             switch (op) {
                case "+": res = va + vb; break;
                case "-": res = va - vb; break;
                case "*": res = va * vb; break;
                case "/": res = vb != 0 ? va / vb : 0; break;
                default:  res = vb != 0 ? va % vb : 0; break;
             }
             return new Info(Type.INT, String.valueOf(res));
          } else if (rt == Type.DOUBLE) {
             double va = toDbl(a), vb = toDbl(b), res;
             switch (op) {
                case "+": res = va + vb; break;
                case "-": res = va - vb; break;
                case "*": res = va * vb; break;
                case "/": res = va / vb; break;
                default:  res = va % vb; break;
             }
             return new Info(Type.DOUBLE, dblHex(res));
          } else {
             float va = toFlt(a), vb = toFlt(b), res;
             switch (op) {
                case "+": res = va + vb; break;
                case "-": res = va - vb; break;
                case "*": res = va * vb; break;
                case "/": res = va / vb; break;
                default:  res = va % vb; break;
             }
             return new Info(Type.FLOAT, fltHex(res));
          }
       }

       // --- Algebraic identity simplifications ---
       if (op.equals("+")) {
          if (isZeroImm(b)) { return new Info(rt, coerce(a, rt)); }
          if (isZeroImm(a)) { return new Info(rt, coerce(b, rt)); }
       }
       if (op.equals("-") && isZeroImm(b)) { return new Info(rt, coerce(a, rt)); }
       if (op.equals("*")) {
          if (isOneImm(b))  { return new Info(rt, coerce(a, rt)); }
          if (isOneImm(a))  { return new Info(rt, coerce(b, rt)); }
          if (isZeroImm(b)) return new Info(rt, rt == Type.INT ? "0" : rt == Type.DOUBLE ? dblHex(0.0) : fltHex(0.0f));
          if (isZeroImm(a)) return new Info(rt, rt == Type.INT ? "0" : rt == Type.DOUBLE ? dblHex(0.0) : fltHex(0.0f));
       }
       if (op.equals("/") && isOneImm(b)) { return new Info(rt, coerce(a, rt)); }

       // --- Normal code generation ---
       String oa = coerce(a, rt);
       String ob = coerce(b, rt);
       String r  = newReg();
       String ins;
       if (rt == Type.INT) {
          if      (op.equals("+")) ins = "add nsw i32";
          else if (op.equals("-")) ins = "sub nsw i32";
          else if (op.equals("*")) ins = "mul nsw i32";
          else if (op.equals("/")) ins = "sdiv i32";
          else                     ins = "srem i32";
       } else if (rt == Type.LONGLONG) {
          if      (op.equals("+")) ins = "add nsw i64";
          else if (op.equals("-")) ins = "sub nsw i64";
          else if (op.equals("*")) ins = "mul nsw i64";
          else if (op.equals("/")) ins = "sdiv i64";
          else                     ins = "srem i64";
       } else if (rt == Type.DOUBLE) {
          if      (op.equals("+")) ins = "fadd double";
          else if (op.equals("-")) ins = "fsub double";
          else if (op.equals("*")) ins = "fmul double";
          else if (op.equals("/")) ins = "fdiv double";
          else                     ins = "frem double";
       } else {
          if      (op.equals("+")) ins = "fadd float";
          else if (op.equals("-")) ins = "fsub float";
          else if (op.equals("*")) ins = "fmul float";
          else if (op.equals("/")) ins = "fdiv float";
          else                     ins = "frem float";
       }
       emit("  " + r + " = " + ins + " " + oa + ", " + ob);
       return new Info(rt, r);
    }

    // The "##" operator:  a ## b = a^b + b^a  (both float, result float).
    Info hashOp(Info a, Info b) {
       // Constant folding: compute a^b + b^a at compile time
       if ((isIntImm(a) || isFltImm(a)) && (isIntImm(b) || isFltImm(b))) {
          float fa = toFlt(a), fb = toFlt(b);
          float res = (float)(Math.pow(fa, fb) + Math.pow(fb, fa));
          return new Info(Type.FLOAT, fltHex(res));
       }
       String oa = coerce(a, Type.FLOAT);
       String ob = coerce(b, Type.FLOAT);
       String r  = newReg();
       emit("  " + r + " = call float @__hashOp(float " + oa + ", float " + ob + ")");
       return new Info(Type.FLOAT, r);
    }

    // Bitwise / shift operation (integers only; constant-folded).
    Info bitOp(String op, Info a, Info b) {
       String oa = coerce(a, Type.INT);
       String ob = coerce(b, Type.INT);
       if (isIntImm(a) && isIntImm(b)) {
          long va = getIntImm(a), vb = getIntImm(b);
          long res;
          switch (op) {
             case "&":  res = va & vb;  break;
             case "|":  res = va | vb;  break;
             case "^":  res = va ^ vb;  break;
             case "<<": res = va << vb; break;
             default:   res = va >> vb; break;
          }
          return new Info(Type.INT, String.valueOf(res));
       }
       String r = newReg();
       String ins;
       switch (op) {
          case "&":  ins = "and i32";  break;
          case "|":  ins = "or i32";   break;
          case "^":  ins = "xor i32";  break;
          case "<<": ins = "shl i32";  break;
          default:   ins = "ashr i32"; break;
       }
       emit("  " + r + " = " + ins + " " + oa + ", " + ob);
       return new Info(Type.INT, r);
    }

    // Build an i1 condition value from a relational compare (or truthiness).
    Info compare(Info a, String relop, Info b) {
       // Constant folding
       if (isIntImm(a) && isIntImm(b)) {
          long va = getIntImm(a), vb = getIntImm(b);
          boolean res;
          if      (relop.equals(">"))  res = va > vb;
          else if (relop.equals(">=")) res = va >= vb;
          else if (relop.equals("<"))  res = va < vb;
          else if (relop.equals("<=")) res = va <= vb;
          else if (relop.equals("==")) res = va == vb;
          else                          res = va != vb;
          return new Info(Type.BOOL, res ? "true" : "false");
       }
       if ((isIntImm(a) || isFltImm(a)) && (isIntImm(b) || isFltImm(b))) {
          float va = toFlt(a), vb = toFlt(b);
          boolean res;
          if      (relop.equals(">"))  res = va > vb;
          else if (relop.equals(">=")) res = va >= vb;
          else if (relop.equals("<"))  res = va < vb;
          else if (relop.equals("<=")) res = va <= vb;
          else if (relop.equals("==")) res = va == vb;
          else                          res = va != vb;
          return new Info(Type.BOOL, res ? "true" : "false");
       }
       Type ct = (a.theType == Type.DOUBLE || b.theType == Type.DOUBLE) ? Type.DOUBLE
               : (a.theType == Type.FLOAT  || b.theType == Type.FLOAT)  ? Type.FLOAT
               : Type.INT;
       String oa = coerce(a, ct);
       String ob = coerce(b, ct);
       String r  = newReg();
       String cc;
       if (ct == Type.INT) {
          if      (relop.equals(">"))  cc = "icmp sgt i32";
          else if (relop.equals(">=")) cc = "icmp sge i32";
          else if (relop.equals("<"))  cc = "icmp slt i32";
          else if (relop.equals("<=")) cc = "icmp sle i32";
          else if (relop.equals("==")) cc = "icmp eq i32";
          else                         cc = "icmp ne i32";
       } else if (ct == Type.DOUBLE) {
          if      (relop.equals(">"))  cc = "fcmp ogt double";
          else if (relop.equals(">=")) cc = "fcmp oge double";
          else if (relop.equals("<"))  cc = "fcmp olt double";
          else if (relop.equals("<=")) cc = "fcmp ole double";
          else if (relop.equals("==")) cc = "fcmp oeq double";
          else                         cc = "fcmp one double";
       } else {
          if      (relop.equals(">"))  cc = "fcmp ogt float";
          else if (relop.equals(">=")) cc = "fcmp oge float";
          else if (relop.equals("<"))  cc = "fcmp olt float";
          else if (relop.equals("<=")) cc = "fcmp ole float";
          else if (relop.equals("==")) cc = "fcmp oeq float";
          else                         cc = "fcmp one float";
       }
       emit("  " + r + " = " + cc + " " + oa + ", " + ob);
       return new Info(Type.BOOL, r);
    }

    // Truthiness: value != 0  -> i1
    Info truth(Info a) {
       if (a.theType == Type.BOOL) return a;   // already i1
       if (isIntImm(a)) return new Info(Type.BOOL, getIntImm(a) != 0 ? "true" : "false");
       if (isFltImm(a)) return new Info(Type.BOOL, getFltImm(a) != 0.0f ? "true" : "false");
       String r = newReg();
       if (a.theType == Type.FLOAT)
          emit("  " + r + " = fcmp one float " + a.operand + ", 0.0");
       else if (a.theType == Type.DOUBLE)
          emit("  " + r + " = fcmp one double " + a.operand + ", 0.0");
       else
          emit("  " + r + " = icmp ne i32 " + a.operand + ", 0");
       return new Info(Type.BOOL, r);
    }

    // ====================== Constant-folding helpers ======================
    boolean isIntImm(Info i) {
       if (i.theType != Type.INT || i.operand.isEmpty()) return false;
       int st = (i.operand.charAt(0) == '-') ? 1 : 0;
       if (st == i.operand.length()) return false;
       for (int k = st; k < i.operand.length(); k++)
          if (!Character.isDigit(i.operand.charAt(k))) return false;
       return true;
    }

    boolean isFltImm(Info i) {
       return i.theType == Type.FLOAT && i.operand.length() > 2
              && i.operand.charAt(0) == '0' && i.operand.charAt(1) == 'x';
    }

    boolean isDblImm(Info i) {
       return i.theType == Type.DOUBLE && i.operand.length() > 2
              && i.operand.charAt(0) == '0' && i.operand.charAt(1) == 'x';
    }

    long   getIntImm(Info i) { return Long.parseLong(i.operand); }

    float  getFltImm(Info i) {
       long bits = Long.parseUnsignedLong(i.operand.substring(2), 16);
       return (float) Double.longBitsToDouble(bits);
    }

    double getDblImm(Info i) {
       long bits = Long.parseUnsignedLong(i.operand.substring(2), 16);
       return Double.longBitsToDouble(bits);
    }

    float  toFlt(Info i) {
       if (isFltImm(i)) return getFltImm(i);
       if (isDblImm(i)) return (float) getDblImm(i);
       return (float) getIntImm(i);
    }

    double toDbl(Info i) {
       if (isDblImm(i)) return getDblImm(i);
       if (isFltImm(i)) return (double) getFltImm(i);
       return (double) getIntImm(i);
    }

    boolean isZeroImm(Info i) {
       if (isIntImm(i)) return getIntImm(i) == 0;
       if (isFltImm(i)) return getFltImm(i) == 0.0f;
       if (isDblImm(i)) return getDblImm(i) == 0.0;
       return false;
    }

    boolean isOneImm(Info i) {
       if (isIntImm(i)) return getIntImm(i) == 1;
       if (isFltImm(i)) return getFltImm(i) == 1.0f;
       if (isDblImm(i)) return getDblImm(i) == 1.0;
       return false;
    }

    // ====================== Array / Struct helpers ======================
    // LLVM type string for a (possibly multi-dim) array.
    // dims={3,4}, elem=INT  ->  "[3 x [4 x i32]]"
    String llArrayTy(Type elem, int[] dims) {
       String ty = llTy(elem);
       for (int i = dims.length - 1; i >= 0; i--)
          ty = "[" + dims[i] + " x " + ty + "]";
       return ty;
    }

    // Emit a GEP for an array element; returns the pointer register.
    // idxOps: one i32 operand per dimension (already as LLVM operand strings).
    String gepArray(String slot, String arrayTy, ArrayList<String> idxOps) {
       String r = newReg();
       StringBuilder sb = new StringBuilder(
          "  " + r + " = getelementptr " + arrayTy + ", ptr " + slot + ", i32 0");
       for (String idx : idxOps) sb.append(", i32 ").append(idx);
       emit(sb.toString());
       return r;
    }

    // Emit a GEP for a struct member; returns the pointer register.
    String gepStruct(String slot, String sName, int fieldIdx) {
       String r = newReg();
       emit("  " + r + " = getelementptr %struct." + sName
            + ", ptr " + slot + ", i32 0, i32 " + fieldIdx);
       return r;
    }

    // Look up field index (-1 if not found).
    int getFieldIdx(String sName, String fieldName) {
       ArrayList<StructField> fs = structDefs.get(sName);
       if (fs == null) return -1;
       for (int i = 0; i < fs.size(); i++)
          if (fs.get(i).name.equals(fieldName)) return i;
       return -1;
    }

    // ====================== Constant propagation helpers ======================
    // Load from a slot: return the cached constant if known, otherwise emit load.
    Info smartLoad(String slotAddr, Type ty) {
       Info cached = constSlot.get(slotAddr);
       if (cached != null) return cached;
       String r = newReg();
       emit("  " + r + " = load " + llTy(ty) + ", ptr " + slotAddr);
       return new Info(ty, r);
    }

    // After a store: record constant or invalidate the slot.
    void updateConstSlot(String slotAddr, Info val) {
       if (isIntImm(val) || isFltImm(val))
          constSlot.put(slotAddr, val);
       else
          constSlot.remove(slotAddr);
    }

    // Convert a C string literal (with the surrounding quotes and C escapes)
    // into an LLVM byte string + length, register a global, return its name.
    String makeStringGlobal(String lit) {
       String body = lit.substring(1, lit.length() - 1); // strip quotes
       StringBuilder bytes = new StringBuilder();
       int len = 0;
       for (int i = 0; i < body.length(); i++) {
          char c = body.charAt(i);
          int v;
          if (c == '\\' && i + 1 < body.length()) {
             char n = body.charAt(++i);
             switch (n) {
                case 'n': v = 10; break;
                case 't': v = 9;  break;
                case 'r': v = 13; break;
                case '\\':v = 92; break;
                case '"': v = 34; break;
                case '\'':v = 39; break;
                case '0': v = 0;  break;
                default:  v = n;  break;
             }
          } else {
             v = c;
          }
          bytes.append(String.format("\\%02X", v & 0xFF));
          len++;
       }
       bytes.append("\\00"); len++;   // NUL terminator
       String name = "@.str." + (strCount++);
       Globals.add(name + " = private unnamed_addr constant [" + len +
                   " x i8] c\"" + bytes.toString() + "\"");
       return name;
    }

    int stringLen(String lit) {
       String body = lit.substring(1, lit.length() - 1);
       int len = 0;
       for (int i = 0; i < body.length(); i++) {
          if (body.charAt(i) == '\\' && i + 1 < body.length()) { i++; }
          len++;
       }
       return len + 1; // +1 for NUL terminator
    }

    // ---- printf / scanf ----
    void emitPrintf(String fmt, ArrayList<String> vals) {
       StringBuilder argstr = new StringBuilder();
       for (String v : vals) {
          if (v.startsWith("float ")) {
             String d = newReg();
             emit("  " + d + " = fpext " + v + " to double");
             argstr.append(", double ").append(d);
          } else if (v.startsWith("double ")) {
             argstr.append(", ").append(v);
          } else {
             argstr.append(", ").append(v);
          }
       }
       String r = newReg();
       emit("  " + r + " = call i32 (ptr, ...) @printf(ptr " + fmt + argstr + ")");
    }

    void emitScanf(String fmt, ArrayList<String> addrs) {
       StringBuilder c = new StringBuilder();
       String r = newReg();
       c.append("  ").append(r).append(" = call i32 (ptr, ...) @scanf(ptr ")
        .append(fmt);
       for (String a : addrs) c.append(", ").append(a);
       c.append(")");
       emit(c.toString());
    }

    // ---- function entry/exit ----
    void beginFunction() {
       symtab    = new HashMap<String,Info>();
       constSlot = new HashMap<String,Info>();
       varCount = 0; labelCount = 0;
       boolean isMain = curName.equals("main");
       Type declared = curRet;
       // main is always emitted returning i32 (so the program is runnable).
       String retTy = isMain ? "i32" : llTy(declared);

       StringBuilder hdr = new StringBuilder();
       hdr.append("\ndefine dso_local ").append(retTy)
          .append(" @").append(curName).append("(");
       for (int i = 0; i < curParamTypes.size(); i++) {
          if (i > 0) hdr.append(", ");
          hdr.append(llTy(curParamTypes.get(i))).append(" %p").append(i);
       }
       hdr.append(") {");
       emit(hdr.toString());

       // give each parameter a stack slot (alloca + store)
       for (int i = 0; i < curParamTypes.size(); i++) {
          Type pt = curParamTypes.get(i);
          String slot = newReg();
          emit("  " + slot + " = alloca " + llTy(pt));
          emit("  store " + llTy(pt) + " %p" + i + ", ptr " + slot);
          symtab.put(curParamNames.get(i), new Info(pt, slot));
       }
    }

    void endFunction() {
       boolean isMain = curName.equals("main");
       if (isMain) {
          emit("  ret i32 0");
       } else if (curRet == Type.VOID) {
          emit("  ret void");
       } else if (curRet == Type.FLOAT) {
          emit("  ret float 0.0");   // safety net if control falls through
       } else {
          emit("  ret i32 0");
       }
       emit("}");
    }

    // Assemble the whole module.
    public String getModule() {
       StringBuilder sb = new StringBuilder();
       sb.append("; ModuleID = 'myCompiler'\n");
       sb.append("target datalayout = \"e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n");
       sb.append("target triple = \"x86_64-pc-linux-gnu\"\n\n");
       sb.append("; ---- external / runtime declarations ----\n");
       sb.append("declare i32 @printf(ptr, ...)\n");
       sb.append("declare i32 @scanf(ptr, ...)\n");
       sb.append("declare i32 @fprintf(ptr, ptr, ...)\n");
       sb.append("declare float @__hashOp(float, float)\n");
       sb.append("declare ptr @strcpy(ptr, ptr)\n");
       sb.append("declare ptr @strcat(ptr, ptr)\n");
       sb.append("declare i32 @strlen(ptr)\n");
       sb.append("declare i32 @strcmp(ptr, ptr)\n");
       sb.append("declare ptr @malloc(i64)\n");
       sb.append("declare void @free(ptr)\n");
       sb.append("declare i32 @abs(i32)\n");
       sb.append("declare double @fabs(double)\n");
       sb.append("declare double @sqrt(double)\n");
       sb.append("declare double @pow(double, double)\n");
       sb.append("declare ptr @memcpy(ptr, ptr, i64)\n");
       sb.append("declare ptr @memset(ptr, i32, i64)\n");
       sb.append("@stdout = external global ptr\n");
       sb.append("@stderr = external global ptr\n");
       sb.append("@stdin  = external global ptr\n");
       if (!structTypeDecls.isEmpty()) {
          sb.append("\n; ---- struct type declarations ----\n");
          for (String s : structTypeDecls) sb.append(s).append("\n");
       }
       if (!globalVarDecls.isEmpty()) {
          sb.append("\n; ---- global variables ----\n");
          for (String g : globalVarDecls) sb.append(g).append("\n");
       }
       if (!Globals.isEmpty()) {
          sb.append("\n; ---- string constants ----\n");
          for (String g : Globals) sb.append(g).append("\n");
       }
       sb.append("\n; ---- code ----");
       for (String s : TextCode) sb.append("\n").append(s);
       sb.append("\n");
       return sb.toString();
    }
}

// ===================================================================== Parser rules
// =====================================================================

program: (
		enum_def
		| struct_def
		| union_def
		| typedef_def
		| global_var_decl
		| func_proto
		| func_def
	)+ EOF;

enum_def
	locals[int nextVal]
	@init { $nextVal = 0; }:
	ENUM Identifier? '{' first_name = Identifier (
		'=' first_expr = arith_expression {
            if (isIntImm($first_expr.theInfo))
                $nextVal = (int) getIntImm($first_expr.theInfo);
          }
	)? { enumTab.put($first_name.text, $nextVal++); } (
		',' more_name = Identifier (
			'=' more_expr = arith_expression {
                if (isIntImm($more_expr.theInfo))
                    $nextVal = (int) getIntImm($more_expr.theInfo);
              }
		)? { enumTab.put($more_name.text, $nextVal++); }
	)* ','? '}' ';';

struct_def
	locals[ArrayList<StructField> fields]
	@init { $fields = new ArrayList<StructField>(); }:
	STRUCT sname = Identifier '{' struct_field[$fields]+ '}' ';' {
        structDefs.put($sname.text, $fields);
        StringBuilder td = new StringBuilder("%struct." + $sname.text + " = type { ");
        for (int _i = 0; _i < $fields.size(); _i++) {
            if (_i > 0) td.append(", ");
            td.append(llTy($fields.get(_i).t));
        }
        td.append(" }");
        structTypeDecls.add(td.toString());
    };

union_def
	locals[ArrayList<StructField> fields]
	@init { $fields = new ArrayList<StructField>(); }:
	UNION uname = Identifier '{' struct_field[$fields]+ '}' ';' {
        structDefs.put($uname.text, $fields);
        StringBuilder td = new StringBuilder("%struct." + $uname.text + " = type { ");
        for (int _i = 0; _i < $fields.size(); _i++) {
            if (_i > 0) td.append(", ");
            td.append(llTy($fields.get(_i).t));
        }
        td.append(" }");
        structTypeDecls.add(td.toString());
    };

// One field (or block) inside a struct/union definition. Handles: plain fields, pointer fields,
// bit-fields, unnamed padding, and anonymous (unnamed) union/struct blocks (flattened).
struct_field[ArrayList<StructField> outer]:
	// Anonymous union block: union { field; ... };
	UNION '{' struct_field[$outer]+ '}' ';'
	// Anonymous struct block: struct { field; ... };
	| STRUCT '{' struct_field[$outer]+ '}' ';'
	// Unnamed bit-field padding: type : bits;
	| type ':' Integer_constant ';'
	// Named bit-field: type name : bits;  (bit width ignored)
	| bf_type = type bf_name = Identifier ':' Integer_constant ';' {
        $outer.add(new StructField($bf_type.attr_type, $bf_name.text));
      }
	// Regular field with optional pointer stars
	| rf_type = type rps = ptr_stars rf_name = Identifier ';' {
        Type _rft = ($rps.depth > 0) ? Type.POINTER : $rf_type.attr_type;
        $outer.add(new StructField(_rft, $rf_name.text));
      };

typedef_def:
	TYPEDEF bt = type stars td_name = Identifier ';' {
        typedefMap.put($td_name.text, $bt.attr_type);
    }
	// Function-pointer typedef: typedef retType (*Name)(paramTypes);
	| TYPEDEF type ptr_stars '(' '*' fp_name = Identifier ')' '(' type_list ')' ';' {
        typedefMap.put($fp_name.text, Type.POINTER);
    };

// A comma-separated list of types with optional pointer stars (for function-pointer typedef params).
type_list: ( type ptr_stars ( ',' type ptr_stars)*)?;

stars: '*'*;

// Pointer-star list returning depth (number of '*').
ptr_stars
	returns[int depth]
	@init { $depth = 0; }: ( '*' { $depth++; })*;

global_var_decl
	locals[Type _gbt]:
	// Array global (must come before scalar to avoid ambiguity)
	(CONST | STATIC)* type ga = Identifier dl = dim_list ';' {
        Type _gt = $type.attr_type;
        String _gname = "@" + $ga.text;
        String _arrTy = llArrayTy(_gt, $dl.dimArray);
        globalVarDecls.add(_gname + " = global " + _arrTy + " zeroinitializer");
        globalSymtab.put($ga.text, new Info(_gt, $dl.dimArray, _gname));
    }
	// Scalar global(s): [const/static]* type [*] name [= expr] (, [*] name [= expr])* ;
	| (CONST | STATIC)* type { $_gbt = $type.attr_type; } gps1 = ptr_stars gn1 = Identifier (
		'=' gi1 = arith_expression
	)? {
        Type _gt1 = ($gps1.depth > 0) ? Type.POINTER : $_gbt;
        String _gname1 = "@" + $gn1.text;
        String _gzero1 = (_gt1 == Type.POINTER) ? "null"
                       : (_gt1 == Type.FLOAT)   ? "0.0"
                       : (_gt1 == Type.DOUBLE)  ? "0.0"
                       : "0";
        globalVarDecls.add(_gname1 + " = global " + llTy(_gt1) + " " + _gzero1);
        Info _gi1 = ($gps1.depth > 0)
                    ? new Info($_gbt, null, $gps1.depth, _gname1)
                    : new Info(_gt1, _gname1);
        globalSymtab.put($gn1.text, _gi1);
      } (
		',' gps2 = ptr_stars gn2 = Identifier (
			'=' gi2 = arith_expression
		)? {
        Type _gt2 = ($gps2.depth > 0) ? Type.POINTER : $_gbt;
        String _gname2 = "@" + $gn2.text;
        String _gzero2 = (_gt2 == Type.POINTER) ? "null"
                       : (_gt2 == Type.FLOAT)   ? "0.0"
                       : (_gt2 == Type.DOUBLE)  ? "0.0"
                       : "0";
        globalVarDecls.add(_gname2 + " = global " + llTy(_gt2) + " " + _gzero2);
        Info _gi2 = ($gps2.depth > 0)
                    ? new Info($_gbt, null, $gps2.depth, _gname2)
                    : new Info(_gt2, _gname2);
        globalSymtab.put($gn2.text, _gi2);
      }
	)* ';';

func_proto:
	type ptr_stars fn = Identifier '(' params ')' ';' {
        Type _rt = ($ptr_stars.depth > 0) ? Type.POINTER : $type.attr_type;
        functab.put($fn.text, new Func(_rt, new ArrayList<Type>(curParamTypes)));
        curParamTypes = new ArrayList<Type>();
        curParamNames = new ArrayList<String>();
    };

func_def:
	type ptr_stars fn2 = Identifier '(' params ')' {
           Type _frt = ($ptr_stars.depth > 0) ? Type.POINTER : $type.attr_type;
           curRet  = _frt;
           curName = $fn2.text;
           functab.put(curName, new Func(curRet,
                       new ArrayList<Type>(curParamTypes)));
           beginFunction();
        } '{' declarations statements '}' {
           endFunction();
        };

params
	@init { curParamTypes = new ArrayList<Type>();
        curParamNames = new ArrayList<String>(); }: (
		type pps = ptr_stars pn = Identifier ('[' ']')? {
            Type _pt = ($pps.depth > 0) ? Type.POINTER : $type.attr_type;
            curParamTypes.add(_pt);
            curParamNames.add($pn.text); } (
			',' type pps2 = ptr_stars pn2 = Identifier ('[' ']')? {
                Type _pt2 = ($pps2.depth > 0) ? Type.POINTER : $type.attr_type;
                curParamTypes.add(_pt2);
                curParamNames.add($pn2.text); }
		)*
	)?;

dim_list
	returns[int[] dimArray]
	@init { ArrayList<Integer> _dims = new ArrayList<Integer>(); }:
	(
		'[' d = Integer_constant ']' { _dims.add(Integer.parseInt($d.text)); }
	)+ {
        $dimArray = new int[_dims.size()];
        for (int _i = 0; _i < _dims.size(); _i++) $dimArray[_i] = _dims.get(_i);
    };

// Initializer list parser — values are consumed but code gen is best-effort. Handles: plain values,
// designated array [N]=, designated struct .field=, nested {}.
init_list: init_elem (',' init_elem)* ','?;
init_elem:
	'[' arith_expression ']' '=' init_val
	| '.' Identifier '=' init_val
	| init_val;
init_val: '{' init_list? '}' | arith_expression;

declarations
	locals[String _dSlot, int _dDepth, String _dStype]:
	// Struct variable (plain or pointer), optional expression or brace initializer
	STRUCT stype = Identifier sps = ptr_stars svar = Identifier {
           $_dDepth = $sps.depth; $_dStype = $stype.text;
           if ($sps.depth > 0) {
              $_dSlot = newReg();
              emit("  " + $_dSlot + " = alloca ptr");
              symtab.put($svar.text, new Info(Type.STRUCT, $stype.text, $sps.depth, $_dSlot));
           } else {
              $_dSlot = newReg();
              emit("  " + $_dSlot + " = alloca %struct." + $stype.text);
              symtab.put($svar.text, new Info($stype.text, $_dSlot));
           }
        } (
		'=' (
			'{' init_list? '}'
			| sd_init = arith_expression {
                      if ($_dDepth > 0) {
                         String _sdv = coerce($sd_init.theInfo, Type.POINTER);
                         emit("  store ptr " + _sdv + ", ptr " + $_dSlot);
                      }
                  }
		)
	)? ';' declarations
	| (CONST | STATIC)? CHAR chr_arr = Identifier '[' ']' '=' STRING_LITERAL+ ';' {
           java.util.List<org.antlr.v4.runtime.tree.TerminalNode> _slits = _localctx.STRING_LITERAL();
           StringBuilder _ssb = new StringBuilder("\"");
           for (org.antlr.v4.runtime.tree.TerminalNode _st : _slits) {
              String _ss = _st.getText();
              _ssb.append(_ss, 1, _ss.length() - 1);
           }
           _ssb.append("\"");
           String _scomb = _ssb.toString();
           int _slen = stringLen(_scomb);
           String _sGbl = makeStringGlobal(_scomb);
           String _sSlot = newReg();
           emit("  " + _sSlot + " = alloca [" + _slen + " x i8]");
           emit("  call ptr @memcpy(ptr " + _sSlot + ", ptr " + _sGbl + ", i64 " + _slen + ")");
           int[] _sDims = {_slen};
           symtab.put($chr_arr.text, new Info(Type.CHAR, _sDims, _sSlot));
        } declarations
	| (CONST | STATIC)? type arr_name = Identifier dl = dim_list (
		'=' '{' init_list? '}'
	)? ';' {
           if (symtab.containsKey($arr_name.text)) {
              System.out.println("Type Error: line " + $arr_name.getLine()
                                 + ": Redeclared identifier '" + $arr_name.text + "'.");
              System.exit(0);
           }
           String arrTyStr = llArrayTy($type.attr_type, $dl.dimArray);
           String slotA = newReg();
           emit("  " + slotA + " = alloca " + arrTyStr);
           emit("  call ptr @memset(ptr " + slotA + ", i32 0, i64 " + totalBytes($type.attr_type, $dl.dimArray) + ")");
           symtab.put($arr_name.text, new Info($type.attr_type, $dl.dimArray, slotA));
        } declarations
	| (CONST | STATIC)? type dps = ptr_stars first = Identifier {
           if (symtab.containsKey($first.text)) {
              System.out.println("Type Error: line " + $first.getLine()
                                 + ": Redeclared identifier '" + $first.text + "'.");
              System.exit(0);
           }
           Type _vt1 = ($dps.depth > 0) ? Type.POINTER : $type.attr_type;
           String slot1 = newReg();
           emit("  " + slot1 + " = alloca " + llTy(_vt1));
           Info _vi1 = ($dps.depth > 0)
                       ? new Info($type.attr_type, null, $dps.depth, slot1)
                       : new Info(_vt1, slot1);
           symtab.put($first.text, _vi1);
        } (
		'=' init1 = arith_expression {
               Type _vt1s = symtab.get($first.text).isPointer() ? Type.POINTER : $type.attr_type;
               String _iv = coerce($init1.theInfo, _vt1s);
               emit("  store " + llTy(_vt1s) + " " + _iv
                    + ", ptr " + symtab.get($first.text).operand);
               if (_vt1s != Type.POINTER)
                  updateConstSlot(symtab.get($first.text).operand, new Info(_vt1s, _iv));
           }
	)? (
		',' mps = ptr_stars more = Identifier {
           if (symtab.containsKey($more.text)) {
              System.out.println("Type Error: line " + $more.getLine()
                                 + ": Redeclared identifier '" + $more.text + "'.");
              System.exit(0);
           }
           Type _vtm = ($mps.depth > 0) ? Type.POINTER : $type.attr_type;
           String slot2 = newReg();
           emit("  " + slot2 + " = alloca " + llTy(_vtm));
           Info _vim = ($mps.depth > 0)
                       ? new Info($type.attr_type, null, $mps.depth, slot2)
                       : new Info(_vtm, slot2);
           symtab.put($more.text, _vim);
        } (
			'=' initM = arith_expression {
               Type _vtms = symtab.get($more.text).isPointer() ? Type.POINTER : $type.attr_type;
               String _mv = coerce($initM.theInfo, _vtms);
               emit("  store " + llTy(_vtms) + " " + _mv
                    + ", ptr " + symtab.get($more.text).operand);
               if (_vtms != Type.POINTER)
                  updateConstSlot(symtab.get($more.text).operand, new Info(_vtms, _mv));
           }
		)?
	)* ';' declarations
	| /* empty */;

type
	returns[Type attr_type]:
	INT { $attr_type = Type.INT;      }
	| FLOAT { $attr_type = Type.FLOAT;    }
	| DOUBLE { $attr_type = Type.DOUBLE;   }
	| VOID { $attr_type = Type.VOID;     }
	| CHAR { $attr_type = Type.CHAR;     }
	| BOOL_TYPE { $attr_type = Type.BOOL;     }
	| UNSIGNED LONG LONG { $attr_type = Type.LONGLONG; }
	| LONG LONG { $attr_type = Type.LONGLONG; }
	| UNSIGNED LONG { $attr_type = Type.INT;      }
	| UNSIGNED INT { $attr_type = Type.INT;      }
	| UNSIGNED { $attr_type = Type.INT;      }
	| LONG { $attr_type = Type.INT;      }
	| SHORT { $attr_type = Type.INT;      }
	| tdn = Identifier {
	    Type _tt = typedefMap.get($tdn.text);
	    $attr_type = (_tt != null) ? _tt : Type.INT;
	  };

statements: statement statements | /* empty */;

statement:
	assign_stmt ';'
	| inc_dec_stmt ';'
	| if_stmt
	| while_stmt
	| for_stmt
	| do_while_stmt
	| switch_stmt
	| return_stmt ';'
	| func_call_stmt ';'
	| block_stmt
	| break_stmt
	| continue_stmt
	| goto_stmt
	| labeled_stmt
	// C99: allow array type declarations after statements inside a block
	| (CONST | STATIC)? type st4_name = Identifier st4_dl = dim_list (
		'=' '{' init_list? '}'
	)? ';' {
	       String _aty = llArrayTy($type.attr_type, $st4_dl.dimArray);
	       String _aslot = newReg();
	       emit("  " + _aslot + " = alloca " + _aty);
	       emit("  call ptr @memset(ptr " + _aslot + ", i32 0, i64 " + totalBytes($type.attr_type, $st4_dl.dimArray) + ")");
	       symtab.put($st4_name.text, new Info($type.attr_type, $st4_dl.dimArray, _aslot));
	  }
	// C99: allow type variable declarations after statements inside a block
	| (CONST | STATIC)? type st3_ps = ptr_stars st3_first = Identifier {
	       Type _vt3 = ($st3_ps.depth > 0) ? Type.POINTER : $type.attr_type;
	       String _slot3 = newReg();
	       emit("  " + _slot3 + " = alloca " + llTy(_vt3));
	       Info _vi3 = ($st3_ps.depth > 0)
	                   ? new Info($type.attr_type, null, $st3_ps.depth, _slot3)
	                   : new Info(_vt3, _slot3);
	       symtab.put($st3_first.text, _vi3);
	    } (
		'=' init3 = arith_expression {
	           Type _vt3s = symtab.get($st3_first.text).isPointer() ? Type.POINTER : $type.attr_type;
	           String _iv3 = coerce($init3.theInfo, _vt3s);
	           emit("  store " + llTy(_vt3s) + " " + _iv3 + ", ptr " + symtab.get($st3_first.text).operand);
	       }
	)? (
		',' st3_mps = ptr_stars st3_more = Identifier {
	           Type _vtm3 = ($st3_mps.depth > 0) ? Type.POINTER : $type.attr_type;
	           String _slotm3 = newReg();
	           emit("  " + _slotm3 + " = alloca " + llTy(_vtm3));
	           symtab.put($st3_more.text, ($st3_mps.depth > 0)
	               ? new Info($type.attr_type, null, $st3_mps.depth, _slotm3)
	               : new Info(_vtm3, _slotm3));
	      } (
			'=' initm3 = arith_expression {
	              Type _vtms3 = symtab.get($st3_more.text).isPointer() ? Type.POINTER : $type.attr_type;
	              emit("  store " + llTy(_vtms3) + " " + coerce($initm3.theInfo, _vtms3)
	                   + ", ptr " + symtab.get($st3_more.text).operand);
	          }
		)?
	)* ';'
	// C99: allow struct/type declarations after statements inside a block
	| STRUCT st2_type = Identifier st2_ps = ptr_stars st2_var = Identifier {
	       String _st2slot;
	       if ($st2_ps.depth > 0) {
	          _st2slot = newReg();
	          emit("  " + _st2slot + " = alloca ptr");
	          symtab.put($st2_var.text, new Info(Type.STRUCT, $st2_type.text, $st2_ps.depth, _st2slot));
	       } else {
	          _st2slot = newReg();
	          emit("  " + _st2slot + " = alloca %struct." + $st2_type.text);
	          symtab.put($st2_var.text, new Info($st2_type.text, _st2slot));
	       }
	       int _st2depth = $st2_ps.depth;
	    } (
		'=' (
			'{' init_list? '}'
			| st2_init = arith_expression {
	                  if (_st2depth > 0) {
	                     String _st2v = coerce($st2_init.theInfo, Type.POINTER);
	                     emit("  store ptr " + _st2v + ", ptr " + symtab.get($st2_var.text).operand);
	                  }
	              }
		)
	)? ';'
	| ';';

block_stmt: '{' statements '}';

// ---------------- assignment ----------------
assign_stmt
	locals[ArrayList<String> idxOps]
	@init { $idxOps = new ArrayList<String>(); }:
	// Array element: a[i][j] op= expr  (op may be '=' or any compound op)
	arr = Identifier (
		'[' ai = arith_expression ']' { $idxOps.add($ai.theInfo.operand); }
	)+ aop = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
		| '%='
		| '&='
		| '|='
		| '^='
		| '<<='
		| '>>='
	) rhs = arith_expression {
           Info arrInfo = lookup($arr.text);
           if (arrInfo == null) {
              System.out.println("Type Error: line " + $arr.getLine()
                                 + ": Undeclared identifier '" + $arr.text + "'.");
              System.exit(0);
           }
           String arrTy = llArrayTy(arrInfo.elemType, arrInfo.dims);
           String arrPtr = gepArray(arrInfo.operand, arrTy, $idxOps);
           String _aopText = $aop.getText();
           String val;
           if (_aopText.equals("=")) {
              val = coerce($rhs.theInfo, arrInfo.elemType);
           } else {
              String _loaded = newReg();
              emit("  " + _loaded + " = load " + llTy(arrInfo.elemType) + ", ptr " + arrPtr);
              Info _cur = new Info(arrInfo.elemType, _loaded);
              String _base = _aopText.substring(0, _aopText.length()-1);
              Info _res = (_base.equals("&")||_base.equals("|")||_base.equals("^")||_base.equals("<<")||_base.equals(">>"))
                          ? bitOp(_base, _cur, $rhs.theInfo)
                          : binArith(_base, _cur, $rhs.theInfo);
              val = coerce(_res, arrInfo.elemType);
           }
           emit("  store " + llTy(arrInfo.elemType) + " " + val + ", ptr " + arrPtr);
        }
	// Struct member: p.field op= expr
	| obj = Identifier '.' field = Identifier sop = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
		| '%='
		| '&='
		| '|='
		| '^='
		| '<<='
		| '>>='
	) rhs2 = arith_expression {
           Info objInfo = lookup($obj.text);
           if (objInfo == null) {
              System.out.println("Type Error: line " + $obj.getLine()
                                 + ": Undeclared identifier '" + $obj.text + "'.");
              System.exit(0);
           }
           int fidx = getFieldIdx(objInfo.structName, $field.text);
           ArrayList<StructField> flds = structDefs.get(objInfo.structName);
           Type ft = flds.get(fidx).t;
           String sptr = gepStruct(objInfo.operand, objInfo.structName, fidx);
           String _sopText = $sop.getText();
           String val2;
           if (_sopText.equals("=")) {
              val2 = coerce($rhs2.theInfo, ft);
           } else {
              String _loaded2 = newReg();
              emit("  " + _loaded2 + " = load " + llTy(ft) + ", ptr " + sptr);
              Info _cur2 = new Info(ft, _loaded2);
              String _base2 = _sopText.substring(0, _sopText.length()-1);
              Info _res2 = (_base2.equals("&")||_base2.equals("|")||_base2.equals("^")||_base2.equals("<<")||_base2.equals(">>"))
                           ? bitOp(_base2, _cur2, $rhs2.theInfo)
                           : binArith(_base2, _cur2, $rhs2.theInfo);
              val2 = coerce(_res2, ft);
           }
           emit("  store " + llTy(ft) + " " + val2 + ", ptr " + sptr);
        }
	// String literal assignment: str = "hello"
	| strVar = Identifier '=' sl = STRING_LITERAL {
           Info strInfo = lookup($strVar.text);
           if (strInfo == null) {
              System.out.println("Type Error: line " + $strVar.getLine()
                                 + ": Undeclared identifier '" + $strVar.text + "'.");
              System.exit(0);
           }
           ArrayList<String> _z = new ArrayList<>();
           _z.add("0");
           String _dest = gepArray(strInfo.operand, llArrayTy(Type.CHAR, strInfo.dims), _z);
           String _src = makeStringGlobal($sl.text);
           String _r = newReg();
           emit("  " + _r + " = call ptr @strcpy(ptr " + _dest + ", ptr " + _src + ")");
        }
	// Dereference store: *ptr = expr
	| '*' dp_id = Identifier '=' dp_rhs = arith_expression {
           Info _dpi = lookup($dp_id.text);
           if (_dpi == null) {
              System.out.println("Type Error: line " + $dp_id.getLine()
                                 + ": Undeclared identifier '" + $dp_id.text + "'.");
              System.exit(0);
           }
           // Load the ptr value from its slot, then store through it
           String _dpptr = newReg();
           emit("  " + _dpptr + " = load ptr, ptr " + _dpi.operand);
           Type _dpet = (_dpi.elemType != null && _dpi.elemType != Type.ERR) ? _dpi.elemType : Type.INT;
           String _dpv = coerce($dp_rhs.theInfo, _dpet);
           emit("  store " + llTy(_dpet) + " " + _dpv + ", ptr " + _dpptr);
        }
	// Arrow-store: ptr->field op= expr
	| arw2 = Identifier ARROW arwF2 = Identifier asop = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
		| '%='
		| '&='
		| '|='
		| '^='
		| '<<='
		| '>>='
	) arw2_rhs = arith_expression {
           Info arw2Info = lookup($arw2.text);
           if (arw2Info == null) {
              System.out.println("Type Error: line " + $arw2.getLine()
                                 + ": Undeclared identifier '" + $arw2.text + "'.");
              System.exit(0);
           }
           String _a2ptr = newReg();
           emit("  " + _a2ptr + " = load ptr, ptr " + arw2Info.operand);
           String _sn2 = arw2Info.structName;
           int _fi2 = getFieldIdx(_sn2, $arwF2.text);
           ArrayList<StructField> _fls2 = structDefs.get(_sn2);
           Type _ft2 = _fls2.get(_fi2).t;
           String _fptr2 = newReg();
           emit("  " + _fptr2 + " = getelementptr %struct." + _sn2
                + ", ptr " + _a2ptr + ", i32 0, i32 " + _fi2);
           String _asopTxt = $asop.getText();
           String _a2v;
           if (_asopTxt.equals("=")) {
              _a2v = coerce($arw2_rhs.theInfo, _ft2);
           } else {
              String _ld2 = newReg();
              emit("  " + _ld2 + " = load " + llTy(_ft2) + ", ptr " + _fptr2);
              Info _cur2 = new Info(_ft2, _ld2);
              String _base2 = _asopTxt.substring(0, _asopTxt.length()-1);
              Info _res2 = (_base2.equals("&")||_base2.equals("|")||_base2.equals("^")||_base2.equals("<<")||_base2.equals(">>"))
                           ? bitOp(_base2, _cur2, $arw2_rhs.theInfo)
                           : binArith(_base2, _cur2, $arw2_rhs.theInfo);
              _a2v = coerce(_res2, _ft2);
           }
           emit("  store " + llTy(_ft2) + " " + _a2v + ", ptr " + _fptr2);
        }
	// Plain variable (with optional compound op)
	| lhsId = Identifier op = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
		| '%='
		| '&='
		| '|='
		| '^='
		| '<<='
		| '>>='
	) arith_expression {
           Info lhs = lookup($lhsId.text);
           if (lhs == null) {
              System.out.println("Type Error: line " + $lhsId.getLine()
                                 + ": Undeclared identifier '"
                                 + $lhsId.text + "'.");
              System.exit(0);
           }
           String opText = $op.getText();
           String v;
           if (opText.equals("=")) {
              v = coerce($arith_expression.theInfo, lhs.theType);
           } else {
              Info curInfo = smartLoad(lhs.operand, lhs.theType);
              String baseOp = opText.substring(0, opText.length() - 1);
              Info result;
              if (baseOp.equals("&") || baseOp.equals("|") || baseOp.equals("^")
                  || baseOp.equals("<<") || baseOp.equals(">>")) {
                 result = bitOp(baseOp, curInfo, $arith_expression.theInfo);
              } else {
                 result = binArith(baseOp, curInfo, $arith_expression.theInfo);
              }
              v = coerce(result, lhs.theType);
           }
           emit("  store " + llTy(lhs.theType) + " " + v + ", ptr " + lhs.operand);
           updateConstSlot(lhs.operand, new Info(lhs.theType, v));
        };

// ---------------- return ----------------
return_stmt:
	RETURN arith_expression {
           String v = coerce($arith_expression.theInfo,
                             curName.equals("main") ? Type.INT : curRet);
           emit("  ret " + llTy(curName.equals("main") ? Type.INT : curRet)
                + " " + v);
           // open a fresh (dead) block so any following code stays legal
           emit(newLabel() + ":");
           constSlot.clear();
        }
	| RETURN {
           emit("  ret void");
           emit(newLabel() + ":");
           constSlot.clear();
        };

// ---------------- increment / decrement ----------------
inc_dec_stmt:
	(
		Identifier op = ('++' | '--')
		| op = ('++' | '--') Identifier
	) {
        String idName = $Identifier.text;
        Info varInfo = lookup(idName);
        if (varInfo == null) {
            System.out.println("Type error: line " + $Identifier.getLine() + ": Undeclared identifier '" + idName + "'.");
            System.exit(0);
        }

        // Load current value — use constSlot if available (enables constant folding)
        Info curInfo = smartLoad(varInfo.operand, varInfo.theType);
        Info oneInfo = (varInfo.theType == Type.FLOAT)
                       ? new Info(Type.FLOAT, fltHex(1.0f))
                       : new Info(Type.INT, "1");
        String deltaOp = $op.getText().equals("++") ? "+" : "-";
        Info newValInfo = binArith(deltaOp, curInfo, oneInfo);
        String storeVal = coerce(newValInfo, varInfo.theType);
        emit("  store " + llTy(varInfo.theType) + " " + storeVal + ", ptr " + varInfo.operand);
        updateConstSlot(varInfo.operand, new Info(varInfo.theType, storeVal));
        };

// ---------------- if / if-else ----------------
if_stmt
	locals[String lThen, String lElse, String lEnd]:
	IF '(' ie = arith_expression ')' {
           $lThen = newLabel(); $lElse = newLabel(); $lEnd = newLabel();
           Info _ic = truth($ie.theInfo);
           emit("  br i1 " + _ic.operand
                + ", label %" + $lThen + ", label %" + $lElse);
           emit($lThen + ":");
           constSlot.clear();
        } statement {
           emit("  br label %" + $lEnd);
           emit($lElse + ":");
           constSlot.clear();
        } (ELSE statement)? {
           emit("  br label %" + $lEnd);
           emit($lEnd + ":");
           constSlot.clear();
        };

// ---------------- while ----------------
while_stmt
	locals[String lCond, String lBody, String lEnd]:
	WHILE {
           $lCond = newLabel(); $lBody = newLabel(); $lEnd = newLabel();
           emit("  br label %" + $lCond);
           emit($lCond + ":");
           constSlot.clear();
           breakStack.push($lEnd);
           continueStack.push($lCond);
        } '(' we = arith_expression ')' {
           Info _wc = truth($we.theInfo);
           emit("  br i1 " + _wc.operand
                + ", label %" + $lBody + ", label %" + $lEnd);
           emit($lBody + ":");
        } statement {
           emit("  br label %" + $lCond);
           emit($lEnd + ":");
           breakStack.pop();
           continueStack.pop();
           constSlot.clear();
        };

// ---------------- break ----------------
break_stmt:
	BREAK ';' {
        if (!breakStack.isEmpty()) {
            emit("  br label %" + breakStack.peek());
            emit(newLabel() + ":");
            constSlot.clear();
        }
    };

// ---------------- continue ----------------
continue_stmt:
	CONTINUE ';' {
        if (!continueStack.isEmpty()) {
            emit("  br label %" + continueStack.peek());
            emit(newLabel() + ":");
            constSlot.clear();
        }
    };

// ---------------- goto / label ----------------
goto_stmt:
	GOTO lbl = Identifier ';' {
        String _gl = gotoLabelFor($lbl.text);
        emit("  br label %" + _gl);
        emit(newLabel() + ":");
        constSlot.clear();
    };

labeled_stmt
	locals[String _ll]:
	lbl = Identifier ':' {
        $_ll = gotoLabelFor($lbl.text);
        emit("  br label %" + $_ll);
        emit($_ll + ":");
        constSlot.clear();
    } statement;

// ---------------- for ---------------- for (init; cond; update) body emits: init → br Lcond Lcond:
// cond → br Lbody / Lend Lbody: body → br Lupdate Lupdate: update → br Lcond Lend:
for_stmt
	locals[
        String lCond, String lBody, String lUpdate, String lEnd,
        int updateStart
    ]:
	FOR {
        $lCond   = newLabel();
        $lBody   = newLabel();
        $lUpdate = newLabel();
        $lEnd    = newLabel();
    } '(' (
		for_init ';'
		| ';'
	) // initialiser (assignment or empty)
	{
            emit("  br label %" + $lCond);
            emit($lCond + ":");
            constSlot.clear();
            breakStack.push($lEnd);
            continueStack.push($lUpdate);
        } (
		fe = arith_expression {
            Info _fc = truth($fe.theInfo);
            emit("  br i1 " + _fc.operand
                 + ", label %" + $lBody + ", label %" + $lEnd);
          }
		| /* empty */ { emit("  br label %" + $lBody); }
	) ';' {
            // Capture start index so we can relocate update code after body.
            $updateStart = TextCode.size();
            emit($lUpdate + ":");
        } (for_update)? {
            // Rip update code out and save it; re-emit it later after the body.
            ArrayList<String> _upd = new ArrayList<>();
            for (int _i = $updateStart; _i < TextCode.size(); _i++)
                _upd.add(TextCode.get(_i));
            while (TextCode.size() > $updateStart) TextCode.remove(TextCode.size() - 1);
            emit($lBody + ":");
            // store update code for emit after body
            // (use a temporary list; close over with final var trick)
            final ArrayList<String> _updFinal = _upd;
            // We cannot close over non-final; just store in a grammar local via a workaround:
            // emit body, then re-inject.  ANTLR doesn't support lambda captures, so we use
            // the TextCode trick: leave a sentinel placeholder we fill in below.
            // SIMPLER: just emit the body inline and add update after.
            // We'll defer by storing in a member field.
            pendingUpdate = _updFinal;
        } ')' body_stmt = statement {
        emit("  br label %" + $lUpdate);
        for (String _s : pendingUpdate) TextCode.add(_s);
        pendingUpdate = null;
        emit("  br label %" + $lCond);
        emit($lEnd + ":");
        breakStack.pop();
        continueStack.pop();
        constSlot.clear();
    };

for_init: assign_stmt | inc_dec_stmt | for_decl;
for_update: (assign_stmt | inc_dec_stmt) (
		',' (assign_stmt | inc_dec_stmt)
	)*;

// C99-style for-init declaration: for (int i = 0, j = 0; ...)
for_decl
	locals[Type _fdt]:
	type dps3 = ptr_stars fd_first = Identifier {
        Type _vt3 = ($dps3.depth > 0) ? Type.POINTER : $type.attr_type;
        $_fdt = _vt3;
        String _fs1 = newReg();
        emit("  " + _fs1 + " = alloca " + llTy(_vt3));
        Info _fvi1 = ($dps3.depth > 0)
                     ? new Info($type.attr_type, null, $dps3.depth, _fs1)
                     : new Info(_vt3, _fs1);
        symtab.put($fd_first.text, _fvi1);
    } (
		'=' fe1 = arith_expression {
        String _fiv1 = coerce($fe1.theInfo, $_fdt);
        emit("  store " + llTy($_fdt) + " " + _fiv1 + ", ptr " + symtab.get($fd_first.text).operand);
    }
	)? (
		',' fd_more = Identifier {
        String _fs2 = newReg();
        emit("  " + _fs2 + " = alloca " + llTy($_fdt));
        symtab.put($fd_more.text, new Info($_fdt, _fs2));
    } (
			'=' fe2 = arith_expression {
        String _fiv2 = coerce($fe2.theInfo, $_fdt);
        emit("  store " + llTy($_fdt) + " " + _fiv2 + ", ptr " + symtab.get($fd_more.text).operand);
    }
		)?
	)*;

// ---------------- do-while ----------------
do_while_stmt
	locals[String lBody, String lCond, String lEnd]:
	DO {
        $lBody = newLabel();
        $lCond = newLabel();
        $lEnd  = newLabel();
        emit("  br label %" + $lBody);
        emit($lBody + ":");
        constSlot.clear();
        breakStack.push($lEnd);
        continueStack.push($lCond);
    } statement {
        // End of body: branch to lCond. Place lCond: BEFORE parsing condition so
        // that 'continue' jumps to the start of condition evaluation (SSA safe).
        emit("  br label %" + $lCond);
        emit($lCond + ":");
        constSlot.clear();
    } WHILE '(' dwe = arith_expression ')' ';' {
        Info _dc = truth($dwe.theInfo);
        emit("  br i1 " + _dc.operand
             + ", label %" + $lBody + ", label %" + $lEnd);
        emit($lEnd + ":");
        breakStack.pop();
        continueStack.pop();
        constSlot.clear();
    };

// ---------------- switch ---------------- case value: integer constant OR enum identifier
case_val
	returns[int theVal]:
	Integer_constant { $theVal = Integer.parseInt($Integer_constant.text); }
	| '-' Integer_constant { $theVal = -Integer.parseInt($Integer_constant.text); }
	| HexInteger { $theVal = (int) Long.parseLong(
          $HexInteger.text.replaceAll("[uUlL]+$","").substring(2), 16); }
	| CharLit { $theVal = charVal($CharLit.text); }
	| cid = Identifier {
        Integer _ev = enumTab.get($cid.text);
        $theVal = (_ev != null) ? _ev : 0;
    };

switch_stmt
	locals[
        String lEnd, String lDefault, String swValOp,
        ArrayList<Integer> caseVals, ArrayList<String> caseLabels,
        int swIdx, boolean hasDefault
    ]
	@init {
        $lEnd       = newLabel();
        $lDefault   = newLabel();
        $swValOp    = "";
        $caseVals   = new ArrayList<>();
        $caseLabels = new ArrayList<>();
        $swIdx      = -1;
        $hasDefault = false;
    }:
	SWITCH '(' se = arith_expression ')' {
        $swValOp = coerce($se.theInfo, Type.INT);
        $swIdx   = TextCode.size();
        TextCode.add(""); // placeholder; filled after all cases are seen
        breakStack.push($lEnd);
    } '{' (
		CASE cv = case_val ':' {
                String _lc = newLabel();
                $caseVals.add($cv.theVal);
                $caseLabels.add(_lc);
                emit(_lc + ":");
            } statement* { if (!lastIsTerminator()) emit("  br label %" + $lEnd); }
	)* (
		DEFAULT ':' {
                $hasDefault = true;
                emit($lDefault + ":");
            } statement* { if (!lastIsTerminator()) emit("  br label %" + $lEnd); }
	)? '}' {
        if (!$hasDefault) {
            emit($lDefault + ":");
            emit("  br label %" + $lEnd);
        }
        StringBuilder _sw = new StringBuilder(
            "  switch i32 " + $swValOp + ", label %" + $lDefault + " [");
        for (int _i = 0; _i < $caseVals.size(); _i++) {
            _sw.append("\n    i32 ").append($caseVals.get(_i))
               .append(", label %").append($caseLabels.get(_i));
        }
        _sw.append("\n  ]");
        TextCode.set($swIdx, _sw.toString());
        breakStack.pop();
        emit($lEnd + ":");
        constSlot.clear();
    };

// ---------------- statement-level function call ---------------- Covers printf / scanf and void
// (or ignored-result) user calls.
func_call_stmt:
	Identifier '(' call_args ')' {
           String fn = $Identifier.text;
           if (fn.equals("printf")) {
              emitPrintf($call_args.fmt, $call_args.vals);
           } else if (fn.equals("scanf")) {
              emitScanf($call_args.fmt, $call_args.addrs);
              // scanf writes through &var pointers — invalidate those slots
              for (String addr : $call_args.addrs)
                 constSlot.remove(addr.substring(4)); // strip "ptr "
           } else {
              // user-defined call, result (if any) ignored
              Func f = functab.get(fn);
              String rt = (f == null) ? "i32" : llTy(f.ret);
              StringBuilder c = new StringBuilder();
              if (f != null && f.ret == Type.VOID) c.append("  call void @");
              else { String r = newReg(); c.append("  " + r + " = call " + rt + " @"); }
              c.append(fn).append("(").append($call_args.argList).append(")");
              emit(c.toString());
           }
        };

// Collect arguments for a call. We expose several views so the caller can handle printf / scanf /
// normal calls uniformly. fmt : the format-string global name (printf/scanf), else null vals :
// evaluated value args as "type operand" (printf) addrs : "ptr %slot" address args (scanf, from
// &id) argList : comma-separated "type operand" for a normal user call
call_args
	returns[String fmt, ArrayList<String> vals,
                   ArrayList<String> addrs, String argList]
	@init {
   $fmt = null;
   $vals  = new ArrayList<String>();
   $addrs = new ArrayList<String>();
   StringBuilder al = new StringBuilder();
}: (
		first = one_arg { $vals.addAll($first.valList);
                        $addrs.addAll($first.addrList);
                        if ($first.fmtName != null) $fmt = $first.fmtName;
                        al.append($first.argPiece); } (
			',' more = one_arg { $vals.addAll($more.valList);
                             $addrs.addAll($more.addrList);
                             if ($more.fmtName != null) $fmt = $more.fmtName;
                             al.append(", ").append($more.argPiece); }
		)*
	)? { $argList = al.toString(); };

one_arg
	returns[String fmtName, ArrayList<String> valList,
                 ArrayList<String> addrList, String argPiece]
	@init {
   $fmtName = null;
   $valList  = new ArrayList<String>();
   $addrList = new ArrayList<String>();
   $argPiece = "";
}:
	STRING_LITERAL+ {
           // Concatenate adjacent string literals (C standard behaviour).
           java.util.List<org.antlr.v4.runtime.tree.TerminalNode> _lits = _localctx.STRING_LITERAL();
           StringBuilder _sb = new StringBuilder("\"");
           for (org.antlr.v4.runtime.tree.TerminalNode _t : _lits) {
              String _s = _t.getText();
              _sb.append(_s, 1, _s.length() - 1); // strip outer quotes
           }
           _sb.append("\"");
           $fmtName = makeStringGlobal(_sb.toString());
           $argPiece = "ptr " + $fmtName;
        }
	| '&' Identifier {
           Info v = lookup($Identifier.text);
           String _addrOp;
           if (v.isArray() && v.elemType == Type.CHAR) {
              ArrayList<String> _z = new ArrayList<>();
              _z.add("0");
              _addrOp = gepArray(v.operand, llArrayTy(Type.CHAR, v.dims), _z);
           } else {
              _addrOp = v.operand;
           }
           $addrList.add("ptr " + _addrOp);
           $argPiece = "ptr " + _addrOp;
        }
	| arith_expression {
           Info v = $arith_expression.theInfo;
           // store raw typed operand; printf promotes float->double itself
           $valList.add(llTy(v.theType) + " " + v.operand);
           $argPiece = llTy(v.theType) + " " + v.operand;
        };

// ============================================================ Unified expression hierarchy (C
// standard precedence, low→high): ternary > || > && > | > ^ > & > relational > << >> > +- > */% >
// cast > unary > primary ============================================================
arith_expression
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = ternaryExpr { $theInfo = $a.theInfo; };

ternaryExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = logicOrExpr { $theInfo = $a.theInfo; } (
		'?' b = arith_expression ':' c = ternaryExpr {
	       Info _cond = truth($a.theInfo);
	       Type _rt   = ($b.theInfo.theType == Type.DOUBLE || $c.theInfo.theType == Type.DOUBLE) ? Type.DOUBLE
	                  : ($b.theInfo.theType == Type.FLOAT  || $c.theInfo.theType == Type.FLOAT)  ? Type.FLOAT
	                  : Type.INT;
	       String _ty   = llTy(_rt);
	       String _slot = newReg();
	       emit("  " + _slot + " = alloca " + _ty);
	       String _lT = newLabel(), _lF = newLabel(), _lE = newLabel();
	       emit("  br i1 " + _cond.operand + ", label %" + _lT + ", label %" + _lF);
	       emit(_lT + ":");
	       emit("  store " + _ty + " " + coerce($b.theInfo, _rt) + ", ptr " + _slot);
	       emit("  br label %" + _lE);
	       emit(_lF + ":");
	       emit("  store " + _ty + " " + coerce($c.theInfo, _rt) + ", ptr " + _slot);
	       emit("  br label %" + _lE);
	       emit(_lE + ":");
	       String _r = newReg();
	       emit("  " + _r + " = load " + _ty + ", ptr " + _slot);
	       $theInfo = new Info(_rt, _r);
	  }
	)?;

logicOrExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = logicAndExpr { $theInfo = $a.theInfo; } (
		'||' b = logicAndExpr {
	       String r = newReg();
	       emit("  " + r + " = or i1 " + truth($theInfo).operand + ", " + truth($b.theInfo).operand);
	       $theInfo = new Info(Type.BOOL, r);
	  }
	)*;

logicAndExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = bitOrExpr { $theInfo = $a.theInfo; } (
		'&&' b = bitOrExpr {
	       String r = newReg();
	       emit("  " + r + " = and i1 " + truth($theInfo).operand + ", " + truth($b.theInfo).operand);
	       $theInfo = new Info(Type.BOOL, r);
	  }
	)*;

bitOrExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = bitXorExpr { $theInfo = $a.theInfo; } (
		'|' b = bitXorExpr { $theInfo = bitOp("|", $theInfo, $b.theInfo); }
	)*;

bitXorExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = bitAndExpr { $theInfo = $a.theInfo; } (
		'^' b = bitAndExpr { $theInfo = bitOp("^", $theInfo, $b.theInfo); }
	)*;

bitAndExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = compareExpr { $theInfo = $a.theInfo; } (
		'&' b = compareExpr { $theInfo = bitOp("&", $theInfo, $b.theInfo); }
	)*;

compareExpr
	returns[Info theInfo]
	locals[boolean rel]
	@init { $theInfo = new Info(); $rel = false; }:
	a = shiftExpr { $theInfo = $a.theInfo; } (
		RelationOP b = shiftExpr {
	       $theInfo = compare($a.theInfo, $RelationOP.text, $b.theInfo);
	       $rel = true;
	  }
	)?;

shiftExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = addExpr { $theInfo = $a.theInfo; } (
		'<<' b = addExpr { $theInfo = bitOp("<<", $theInfo, $b.theInfo); }
		| '>>' c = addExpr { $theInfo = bitOp(">>", $theInfo, $c.theInfo); }
	)*;

addExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = multExpr { $theInfo = $a.theInfo; } (
		'+' b = multExpr { $theInfo = binArith("+", $theInfo, $b.theInfo); }
		| '-' c = multExpr { $theInfo = binArith("-", $theInfo, $c.theInfo); }
	)*;

multExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	a = castExpr { $theInfo = $a.theInfo; } (
		'*' b = castExpr { $theInfo = binArith("*",  $theInfo, $b.theInfo); }
		| '/' c = castExpr { $theInfo = binArith("/",  $theInfo, $c.theInfo); }
		| '%' e = castExpr { $theInfo = binArith("%",  $theInfo, $e.theInfo); }
		| '##' d = castExpr { $theInfo = hashOp($theInfo, $d.theInfo); }
	)*;

castExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	'(' type cps = ptr_stars ')' e = castExpr {
	       if ($cps.depth > 0) {
	          // pointer cast: treat as ptr
	          String _cv = coerce($e.theInfo, Type.POINTER);
	          $theInfo = new Info($type.attr_type, null, 0, _cv);
	       } else {
	          String v = coerce($e.theInfo, $type.attr_type);
	          $theInfo = new Info($type.attr_type, v);
	       }
	  }
	| '(' STRUCT Identifier cps2 = ptr_stars ')' e2 = castExpr {
	       // (struct Name*) cast — treat as opaque ptr
	       String _cv2 = coerce($e2.theInfo, Type.POINTER);
	       $theInfo = new Info(Type.STRUCT, $Identifier.text, 0, _cv2);
	  }
	| s = signExpr { $theInfo = $s.theInfo; };

signExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	'-' e = signExpr {
	       Info in = $e.theInfo;
	       if (isFltImm(in)) {
	          $theInfo = new Info(Type.FLOAT, fltHex(-getFltImm(in)));
	       } else if (isIntImm(in)) {
	          $theInfo = new Info(Type.INT, String.valueOf(-getIntImm(in)));
	       } else if (in.theType == Type.FLOAT) {
	          String r = newReg();
	          emit("  " + r + " = fneg float " + in.operand);
	          $theInfo = new Info(Type.FLOAT, r);
	       } else if (in.theType == Type.DOUBLE) {
	          String r = newReg();
	          emit("  " + r + " = fneg double " + in.operand);
	          $theInfo = new Info(Type.DOUBLE, r);
	       } else {
	          String r = newReg();
	          emit("  " + r + " = sub nsw i32 0, " + in.operand);
	          $theInfo = new Info(Type.INT, r);
	       }
	  }
	| '+' e2 = signExpr { $theInfo = $e2.theInfo; }
	| '&' addr_id = Identifier {
	       // address-of: return the alloca slot address as a pointer value
	       Info _av = lookup($addr_id.text);
	       if (_av == null) { $theInfo = new Info(Type.POINTER, null, 1, "null"); }
	       else { $theInfo = new Info(_av.theType, _av.structName, 1, _av.operand); }
	  }
	| '*' e_deref = signExpr {
	       Info _pi = $e_deref.theInfo;
	       if (_pi.isArray()) {
	          // *array = array (decay: deref of array-decay pointer gives ptr again)
	          // Just pass through the GEP pointer as a POINTER value.
	          Type _aet = (_pi.elemType != null) ? _pi.elemType : Type.INT;
	          $theInfo = new Info(_aet, (String)null, 0, _pi.operand);
	       } else {
	          String _pval = _pi.operand;
	          Type _et = (_pi.elemType != null && _pi.elemType != Type.ERR) ? _pi.elemType : Type.INT;
	          String _dr = newReg();
	          emit("  " + _dr + " = load " + llTy(_et) + ", ptr " + _pval);
	          $theInfo = new Info(_et, _dr);
	       }
	  }
	| '~' e3 = signExpr {
	       if (isIntImm($e3.theInfo)) {
	          $theInfo = new Info(Type.INT, String.valueOf(~getIntImm($e3.theInfo)));
	       } else {
	          String r = newReg();
	          emit("  " + r + " = xor i32 " + coerce($e3.theInfo, Type.INT) + ", -1");
	          $theInfo = new Info(Type.INT, r);
	       }
	  }
	| '!' e4 = signExpr {
	       String r = newReg();
	       emit("  " + r + " = xor i1 " + truth($e4.theInfo).operand + ", true");
	       $theInfo = new Info(Type.BOOL, r);
	  }
	| p = primaryExpr { $theInfo = $p.theInfo; };

primaryExpr
	returns[Info theInfo]
	locals[ArrayList<String> idxOps3]
	@init { $theInfo = new Info(); $idxOps3 = new ArrayList<String>(); }:
	Integer_constant {
           // Strip optional U/L suffix before parsing
           String _ict = $Integer_constant.text.replaceAll("[uUlL]+$", "");
           $theInfo = new Info(Type.INT, _ict);
      }
	| LongLongConstant {
           String _llt = $LongLongConstant.text.replaceAll("[uUlL]+$", "");
           $theInfo = new Info(Type.LONGLONG, _llt);
      }
	| HexInteger {
           String _hxt = $HexInteger.text.replaceAll("[uUlL]+$", "");
           long hv = Long.parseLong(_hxt.substring(2), 16);
           $theInfo = new Info(Type.INT, String.valueOf(hv));
      }
	| CharLit {
           $theInfo = new Info(Type.INT, String.valueOf(charVal($CharLit.text)));
      }
	| NULL_KW { $theInfo = new Info(Type.INT, "0"); }
	| TRUE_KW { $theInfo = new Info(Type.BOOL, "true"); }
	| FALSE_KW { $theInfo = new Info(Type.BOOL, "false"); }
	| SIZEOF '(' STRUCT sz_sn = Identifier ')' {
           ArrayList<StructField> _sflds = structDefs.get($sz_sn.text);
           int _ssz = 0;
           if (_sflds != null) for (StructField _sf : _sflds) _ssz += sizeOf(_sf.t);
           $theInfo = new Info(Type.INT, String.valueOf(_ssz));
      }
	| SIZEOF '(' sz_type = type dim_list_opt ')' {
           int sz = sizeOf($sz_type.attr_type);
           for (int _d : $dim_list_opt.dims) sz *= _d;
           $theInfo = new Info(Type.INT, String.valueOf(sz));
      }
	| Floating_point_constant {
           String _ft = $Floating_point_constant.text;
           boolean _isF = _ft.endsWith("f") || _ft.endsWith("F");
           if (_isF) {
              float _fv = Float.parseFloat(_ft.substring(0, _ft.length()-1));
              $theInfo = new Info(Type.FLOAT, fltHex(_fv));
           } else {
              double _dv = Double.parseDouble(_ft);
              $theInfo = new Info(Type.DOUBLE, dblHex(_dv));
           }
      }
	| fn_id = Identifier '(' call_args ')' {
           String fn = $fn_id.text;
           Func f = functab.get(fn);
           if (f != null) {
              Type rt = f.ret;
              String r = newReg();
              emit("  " + r + " = call " + llTy(rt) + " @" + fn
                   + "(" + $call_args.argList + ")");
              $theInfo = new Info(rt, r);
           } else {
              Info _fpi = lookup(fn);
              if (_fpi != null && _fpi.theType == Type.POINTER) {
                 String _fpv2 = newReg();
                 emit("  " + _fpv2 + " = load ptr, ptr " + _fpi.operand);
                 String _fpr2 = newReg();
                 emit("  " + _fpr2 + " = call i32 " + _fpv2
                      + "(" + $call_args.argList + ")");
                 $theInfo = new Info(Type.INT, _fpr2);
              } else {
                 String r = newReg();
                 emit("  " + r + " = call i32 @" + fn
                      + "(" + $call_args.argList + ")");
                 $theInfo = new Info(Type.INT, r);
              }
           }
        }
	// Function pointer call through array element: arr[idx](args)
	| fpa = Identifier '[' fpi = arith_expression ']' '(' fpc_args = call_args ')' {
           Info _fpaInfo = lookup($fpa.text);
           if (_fpaInfo != null && _fpaInfo.isArray()) {
              ArrayList<String> _fpaIdxs = new ArrayList<>();
              _fpaIdxs.add($fpi.theInfo.operand);
              String _fpaEptr = gepArray(_fpaInfo.operand,
                  llArrayTy(_fpaInfo.elemType, _fpaInfo.dims), _fpaIdxs);
              String _fpaFp = newReg();
              emit("  " + _fpaFp + " = load ptr, ptr " + _fpaEptr);
              String _fpaR = newReg();
              emit("  " + _fpaR + " = call i32 " + _fpaFp
                   + "(" + $fpc_args.argList + ")");
              $theInfo = new Info(Type.INT, _fpaR);
           } else {
              $theInfo = new Info(Type.INT, "0");
           }
        }
	| arr3 = Identifier (
		'[' ai3 = arith_expression ']' { $idxOps3.add($ai3.theInfo.operand); }
	)+ {
           Info arrInfo3 = lookup($arr3.text);
           if (arrInfo3 == null) {
              System.out.println("Type Error: line " + $arr3.getLine()
                                 + ": Undeclared identifier '" + $arr3.text + "'.");
              System.exit(0);
           }
           String arrTy3 = llArrayTy(arrInfo3.elemType, arrInfo3.dims);
           String ptr3 = gepArray(arrInfo3.operand, arrTy3, $idxOps3);
           String r3 = newReg();
           emit("  " + r3 + " = load " + llTy(arrInfo3.elemType) + ", ptr " + ptr3);
           $theInfo = new Info(arrInfo3.elemType, r3);
        }
	| obj3 = Identifier '.' field3 = Identifier {
           Info objInfo3 = lookup($obj3.text);
           if (objInfo3 == null) {
              System.out.println("Type Error: line " + $obj3.getLine()
                                 + ": Undeclared identifier '" + $obj3.text + "'.");
              System.exit(0);
           }
           int fidx3 = getFieldIdx(objInfo3.structName, $field3.text);
           ArrayList<StructField> flds3 = structDefs.get(objInfo3.structName);
           Type ft3 = flds3.get(fidx3).t;
           String sptr3 = gepStruct(objInfo3.operand, objInfo3.structName, fidx3);
           String r3s = newReg();
           emit("  " + r3s + " = load " + llTy(ft3) + ", ptr " + sptr3);
           $theInfo = new Info(ft3, r3s);
        }
	// Pointer-to-struct arrow access: ptr->field
	| arw = Identifier ARROW arwField = Identifier {
           Info arwInfo = lookup($arw.text);
           if (arwInfo == null) {
              System.out.println("Type Error: line " + $arw.getLine()
                                 + ": Undeclared identifier '" + $arw.text + "'.");
              System.exit(0);
           }
           // Load the pointer value from the slot
           String _arwPtr = newReg();
           emit("  " + _arwPtr + " = load ptr, ptr " + arwInfo.operand);
           String _sn = arwInfo.structName;
           int _fi = getFieldIdx(_sn, $arwField.text);
           ArrayList<StructField> _fls = structDefs.get(_sn);
           Type _ft = _fls.get(_fi).t;
           String _fptr = newReg();
           emit("  " + _fptr + " = getelementptr %struct." + _sn
                + ", ptr " + _arwPtr + ", i32 0, i32 " + _fi);
           String _rv = newReg();
           emit("  " + _rv + " = load " + llTy(_ft) + ", ptr " + _fptr);
           $theInfo = new Info(_ft, _rv);
        }
	| var_id = Identifier {
           Integer enumVal = enumTab.get($var_id.text);
           if (enumVal != null) {
              $theInfo = new Info(Type.INT, String.valueOf(enumVal));
           } else {
              Info v = lookup($var_id.text);
              if (v == null) {
                 if (functab.containsKey($var_id.text)) {
                    $theInfo = new Info(Type.VOID, (String)null, 0, "@" + $var_id.text);
                 } else {
                    System.out.println("Type Error: line " + $var_id.getLine()
                                       + ": Undeclared identifier '"
                                       + $var_id.text + "'.");
                    System.exit(0);
                 }
              } else if (v.isArray() && v.elemType == Type.CHAR) {
                 ArrayList<String> _z = new ArrayList<>();
                 _z.add("0");
                 String _ptr = gepArray(v.operand, llArrayTy(Type.CHAR, v.dims), _z);
                 $theInfo = new Info(Type.STRING, _ptr);
              } else if (v.isArray()) {
                 // Non-char array decays to pointer to first element.
                 // Keep theType=ARRAY so '*' in signExpr knows not to load.
                 ArrayList<String> _dz = new ArrayList<>();
                 for (int _di = 0; _di < v.dims.length; _di++) _dz.add("0");
                 String _dptr = gepArray(v.operand, llArrayTy(v.elemType, v.dims), _dz);
                 $theInfo = new Info(v.elemType, v.dims, _dptr); // ARRAY tag = decay ptr
              } else if (v.isPointer()) {
                 String _pld = newReg();
                 emit("  " + _pld + " = load ptr, ptr " + v.operand);
                 $theInfo = new Info(v.elemType, v.structName, 0, _pld);
              } else {
                 $theInfo = smartLoad(v.operand, v.theType);
              }
           }
        }
	| '(' comma_expr ')' { $theInfo = $comma_expr.theInfo; };

// C comma operator: evaluates each item in order, returns last value. Used only inside parentheses
// to avoid conflict with comma-as-separator.
comma_expr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	item = assign_expr { $theInfo = $item.theInfo; } (
		',' more = assign_expr { $theInfo = $more.theInfo; }
	)*;

// Assignment-as-expression (used inside comma_expr).
assign_expr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	lv = Identifier aop = (
		'='
		| '+='
		| '-='
		| '*='
		| '/='
		| '%='
		| '&='
		| '|='
		| '^='
		| '<<='
		| '>>='
	) rv = arith_expression {
        Info _aelhs = lookup($lv.text);
        if (_aelhs == null) {
            System.out.println("Type Error: line " + $lv.getLine()
                               + ": Undeclared identifier '" + $lv.text + "'.");
            System.exit(0);
        }
        String _aeop = $aop.getText();
        String _aev;
        if (_aeop.equals("=")) {
            _aev = coerce($rv.theInfo, _aelhs.theType);
        } else {
            Info _aecur = smartLoad(_aelhs.operand, _aelhs.theType);
            String _aebase = _aeop.substring(0, _aeop.length()-1);
            Info _aeres = (_aebase.equals("&")||_aebase.equals("|")||_aebase.equals("^")
                           ||_aebase.equals("<<")||_aebase.equals(">>"))
                          ? bitOp(_aebase, _aecur, $rv.theInfo)
                          : binArith(_aebase, _aecur, $rv.theInfo);
            _aev = coerce(_aeres, _aelhs.theType);
        }
        emit("  store " + llTy(_aelhs.theType) + " " + _aev + ", ptr " + _aelhs.operand);
        updateConstSlot(_aelhs.operand, new Info(_aelhs.theType, _aev));
        $theInfo = new Info(_aelhs.theType, _aev);
    }
	| ae = arith_expression { $theInfo = $ae.theInfo; };

// Optional dimension list for sizeof: e.g. [4][3] -> dims={4,3}
dim_list_opt
	returns[int[] dims]
	@init { java.util.ArrayList<Integer> _dl = new java.util.ArrayList<Integer>(); }:
	(
		'[' Integer_constant ']' { _dl.add(Integer.parseInt($Integer_constant.text)); }
	)* {
	    $dims = new int[_dl.size()];
	    for (int _i = 0; _i < _dl.size(); _i++) $dims[_i] = _dl.get(_i);
	};

// ============================= Lexer rules =============================
INT: 'int';
FLOAT: 'float';
DOUBLE: 'double';
VOID: 'void';
CHAR: 'char';
STRING: 'string';
LONG: 'long';
SHORT: 'short';
UNSIGNED: 'unsigned';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
ENUM: 'enum';
STRUCT: 'struct';
UNION: 'union';
TYPEDEF: 'typedef';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
BREAK: 'break';
FOR: 'for';
DO: 'do';
CONTINUE: 'continue';
GOTO: 'goto';
SIZEOF: 'sizeof';
CONST: 'const';
STATIC: 'static';
NULL_KW: 'NULL';
TRUE_KW: 'true';
FALSE_KW: 'false';
BOOL_TYPE: 'bool';

ARROW: '->';
RelationOP: '>=' | '<=' | '==' | '!=' | '>' | '<';

Identifier: ('a' ..'z' | 'A' ..'Z' | '_') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;

// Float/double literal: optional f/F suffix → float, otherwise double. Handles: 1.5, 1.5f, 1e3,
// 1.5e-3, 1.5e3f
Floating_point_constant:
	('0' ..'9')+ '.' ('0' ..'9')* (
		('e' | 'E') ('+' | '-')? ('0' ..'9')+
	)? ('f' | 'F')?
	| ('0' ..'9')+ ('e' | 'E') ('+' | '-')? ('0' ..'9')+ (
		'f'
		| 'F'
	)?;

// Integer constants — optional U/L/LL/ULL suffix consumed and ignored
HexInteger:
	'0' ('x' | 'X') ('0' ..'9' | 'a' ..'f' | 'A' ..'F')+ (
		'u'
		| 'U'
		| 'l'
		| 'L'
	)*;
// Long-long decimal: must have LL suffix to distinguish from plain int
LongLongConstant: ('0' ..'9')+ ('u' | 'U')? ('l' | 'L') (
		'l'
		| 'L'
	) ('u' | 'U')?
	| ('0' ..'9')+ ('u' | 'U') ('l' | 'L') ('l' | 'L');
Integer_constant: ('0' ..'9')+ ('u' | 'U' | 'l' | 'L')?;

// Character literal: 'a', '\n', etc.
CharLit: '\'' (EscapeSequence | ~('\'' | '\\')) '\'';

// Concatenated string literals handled at grammar level in one_arg
STRING_LITERAL: '"' ( EscapeSequence | ~('\\' | '"'))* '"';

WS: ( ' ' | '\t' | '\r' | '\n') -> skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~('\n' | '\r')* -> skip;
HASH_HASH: '##';
// Skip all preprocessor directives. '#' alone or followed by non-# content. HASH_HASH (2 chars)
// beats HASH_LINE (1 char) for '##' via longest-match.
HASH_LINE: '#' (~('#' | '\n' | '\r') ~('\n' | '\r')*)? -> skip;

fragment EscapeSequence:
	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '\'' | '"' | '\\' | '0');