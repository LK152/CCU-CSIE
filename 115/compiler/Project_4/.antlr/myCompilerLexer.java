// Generated from /Users/lk/Documents/GitHub/CCU-CSIE/115/compiler/Project_4/myCompiler.g4 by ANTLR 4.13.1

    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.ArrayDeque;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class myCompilerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT=39, FLOAT=40, DOUBLE=41, VOID=42, CHAR=43, STRING=44, LONG=45, SHORT=46, 
		UNSIGNED=47, IF=48, ELSE=49, WHILE=50, RETURN=51, ENUM=52, STRUCT=53, 
		UNION=54, TYPEDEF=55, SWITCH=56, CASE=57, DEFAULT=58, BREAK=59, FOR=60, 
		DO=61, CONTINUE=62, GOTO=63, SIZEOF=64, CONST=65, STATIC=66, NULL_KW=67, 
		TRUE_KW=68, FALSE_KW=69, BOOL_TYPE=70, ARROW=71, RelationOP=72, Identifier=73, 
		Floating_point_constant=74, HexInteger=75, LongLongConstant=76, Integer_constant=77, 
		CharLit=78, STRING_LITERAL=79, WS=80, COMMENT=81, LINE_COMMENT=82, HASH_HASH=83, 
		HASH_LINE=84;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "INT", "FLOAT", "DOUBLE", 
			"VOID", "CHAR", "STRING", "LONG", "SHORT", "UNSIGNED", "IF", "ELSE", 
			"WHILE", "RETURN", "ENUM", "STRUCT", "UNION", "TYPEDEF", "SWITCH", "CASE", 
			"DEFAULT", "BREAK", "FOR", "DO", "CONTINUE", "GOTO", "SIZEOF", "CONST", 
			"STATIC", "NULL_KW", "TRUE_KW", "FALSE_KW", "BOOL_TYPE", "ARROW", "RelationOP", 
			"Identifier", "Floating_point_constant", "HexInteger", "LongLongConstant", 
			"Integer_constant", "CharLit", "STRING_LITERAL", "WS", "COMMENT", "LINE_COMMENT", 
			"HASH_HASH", "HASH_LINE", "EscapeSequence"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'='", "','", "'}'", "';'", "':'", "'('", "'*'", "')'", 
			"'['", "']'", "'.'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", 
			"'|='", "'^='", "'<<='", "'>>='", "'++'", "'--'", "'-'", "'&'", "'?'", 
			"'||'", "'&&'", "'|'", "'^'", "'<<'", "'>>'", "'+'", "'/'", "'%'", "'~'", 
			"'!'", "'int'", "'float'", "'double'", "'void'", "'char'", "'string'", 
			"'long'", "'short'", "'unsigned'", "'if'", "'else'", "'while'", "'return'", 
			"'enum'", "'struct'", "'union'", "'typedef'", "'switch'", "'case'", "'default'", 
			"'break'", "'for'", "'do'", "'continue'", "'goto'", "'sizeof'", "'const'", 
			"'static'", "'NULL'", "'true'", "'false'", "'bool'", "'->'", null, null, 
			null, null, null, null, null, null, null, null, null, "'##'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "FLOAT", "DOUBLE", "VOID", "CHAR", "STRING", 
			"LONG", "SHORT", "UNSIGNED", "IF", "ELSE", "WHILE", "RETURN", "ENUM", 
			"STRUCT", "UNION", "TYPEDEF", "SWITCH", "CASE", "DEFAULT", "BREAK", "FOR", 
			"DO", "CONTINUE", "GOTO", "SIZEOF", "CONST", "STATIC", "NULL_KW", "TRUE_KW", 
			"FALSE_KW", "BOOL_TYPE", "ARROW", "RelationOP", "Identifier", "Floating_point_constant", 
			"HexInteger", "LongLongConstant", "Integer_constant", "CharLit", "STRING_LITERAL", 
			"WS", "COMMENT", "LINE_COMMENT", "HASH_HASH", "HASH_LINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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


	public myCompilerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "myCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000T\u0274\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"+
		"?\u0002@\u0007@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007"+
		"D\u0002E\u0007E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007"+
		"I\u0002J\u0007J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007"+
		"N\u0002O\u0007O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007"+
		"S\u0002T\u0007T\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001("+
		"\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00015\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u00018\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001>\u0001"+
		">\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0001C\u0001"+
		"C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003G\u01d3\bG\u0001H\u0001"+
		"H\u0005H\u01d7\bH\nH\fH\u01da\tH\u0001I\u0004I\u01dd\bI\u000bI\fI\u01de"+
		"\u0001I\u0001I\u0005I\u01e3\bI\nI\fI\u01e6\tI\u0001I\u0001I\u0003I\u01ea"+
		"\bI\u0001I\u0004I\u01ed\bI\u000bI\fI\u01ee\u0003I\u01f1\bI\u0001I\u0003"+
		"I\u01f4\bI\u0001I\u0004I\u01f7\bI\u000bI\fI\u01f8\u0001I\u0001I\u0003"+
		"I\u01fd\bI\u0001I\u0004I\u0200\bI\u000bI\fI\u0201\u0001I\u0003I\u0205"+
		"\bI\u0003I\u0207\bI\u0001J\u0001J\u0001J\u0004J\u020c\bJ\u000bJ\fJ\u020d"+
		"\u0001J\u0005J\u0211\bJ\nJ\fJ\u0214\tJ\u0001K\u0004K\u0217\bK\u000bK\f"+
		"K\u0218\u0001K\u0003K\u021c\bK\u0001K\u0001K\u0001K\u0003K\u0221\bK\u0001"+
		"K\u0004K\u0224\bK\u000bK\fK\u0225\u0001K\u0001K\u0001K\u0003K\u022b\b"+
		"K\u0001L\u0004L\u022e\bL\u000bL\fL\u022f\u0001L\u0003L\u0233\bL\u0001"+
		"M\u0001M\u0001M\u0003M\u0238\bM\u0001M\u0001M\u0001N\u0001N\u0001N\u0005"+
		"N\u023f\bN\nN\fN\u0242\tN\u0001N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001"+
		"P\u0001P\u0001P\u0001P\u0005P\u024e\bP\nP\fP\u0251\tP\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u025c\bQ\nQ\fQ\u025f"+
		"\tQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0005S\u0269"+
		"\bS\nS\fS\u026c\tS\u0003S\u026e\bS\u0001S\u0001S\u0001T\u0001T\u0001T"+
		"\u0001\u024f\u0000U\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"+
		")\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e"+
		"=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y="+
		"{>}?\u007f@\u0081A\u0083B\u0085C\u0087D\u0089E\u008bF\u008dG\u008fH\u0091"+
		"I\u0093J\u0095K\u0097L\u0099M\u009bN\u009dO\u009fP\u00a1Q\u00a3R\u00a5"+
		"S\u00a7T\u00a9\u0000\u0001\u0000\u0011\u0002\u0000<<>>\u0003\u0000AZ_"+
		"_az\u0004\u000009AZ__az\u0002\u0000EEee\u0002\u0000++--\u0002\u0000FF"+
		"ff\u0002\u0000XXxx\u0003\u000009AFaf\u0004\u0000LLUUlluu\u0002\u0000U"+
		"Uuu\u0002\u0000LLll\u0002\u0000\'\'\\\\\u0002\u0000\"\"\\\\\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000\n\n\r\r\u0003\u0000\n\n\r\r##\t\u0000\"\"\'\'0"+
		"0\\\\bbffnnrrtt\u0292\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000"+
		"E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001"+
		"\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000"+
		"\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000"+
		"S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001"+
		"\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000"+
		"\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000"+
		"a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001"+
		"\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000"+
		"\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000"+
		"o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s\u0001"+
		"\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001\u0000\u0000"+
		"\u0000\u0000y\u0001\u0000\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000"+
		"}\u0001\u0000\u0000\u0000\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081"+
		"\u0001\u0000\u0000\u0000\u0000\u0083\u0001\u0000\u0000\u0000\u0000\u0085"+
		"\u0001\u0000\u0000\u0000\u0000\u0087\u0001\u0000\u0000\u0000\u0000\u0089"+
		"\u0001\u0000\u0000\u0000\u0000\u008b\u0001\u0000\u0000\u0000\u0000\u008d"+
		"\u0001\u0000\u0000\u0000\u0000\u008f\u0001\u0000\u0000\u0000\u0000\u0091"+
		"\u0001\u0000\u0000\u0000\u0000\u0093\u0001\u0000\u0000\u0000\u0000\u0095"+
		"\u0001\u0000\u0000\u0000\u0000\u0097\u0001\u0000\u0000\u0000\u0000\u0099"+
		"\u0001\u0000\u0000\u0000\u0000\u009b\u0001\u0000\u0000\u0000\u0000\u009d"+
		"\u0001\u0000\u0000\u0000\u0000\u009f\u0001\u0000\u0000\u0000\u0000\u00a1"+
		"\u0001\u0000\u0000\u0000\u0000\u00a3\u0001\u0000\u0000\u0000\u0000\u00a5"+
		"\u0001\u0000\u0000\u0000\u0000\u00a7\u0001\u0000\u0000\u0000\u0001\u00ab"+
		"\u0001\u0000\u0000\u0000\u0003\u00ad\u0001\u0000\u0000\u0000\u0005\u00af"+
		"\u0001\u0000\u0000\u0000\u0007\u00b1\u0001\u0000\u0000\u0000\t\u00b3\u0001"+
		"\u0000\u0000\u0000\u000b\u00b5\u0001\u0000\u0000\u0000\r\u00b7\u0001\u0000"+
		"\u0000\u0000\u000f\u00b9\u0001\u0000\u0000\u0000\u0011\u00bb\u0001\u0000"+
		"\u0000\u0000\u0013\u00bd\u0001\u0000\u0000\u0000\u0015\u00bf\u0001\u0000"+
		"\u0000\u0000\u0017\u00c1\u0001\u0000\u0000\u0000\u0019\u00c3\u0001\u0000"+
		"\u0000\u0000\u001b\u00c6\u0001\u0000\u0000\u0000\u001d\u00c9\u0001\u0000"+
		"\u0000\u0000\u001f\u00cc\u0001\u0000\u0000\u0000!\u00cf\u0001\u0000\u0000"+
		"\u0000#\u00d2\u0001\u0000\u0000\u0000%\u00d5\u0001\u0000\u0000\u0000\'"+
		"\u00d8\u0001\u0000\u0000\u0000)\u00db\u0001\u0000\u0000\u0000+\u00df\u0001"+
		"\u0000\u0000\u0000-\u00e3\u0001\u0000\u0000\u0000/\u00e6\u0001\u0000\u0000"+
		"\u00001\u00e9\u0001\u0000\u0000\u00003\u00eb\u0001\u0000\u0000\u00005"+
		"\u00ed\u0001\u0000\u0000\u00007\u00ef\u0001\u0000\u0000\u00009\u00f2\u0001"+
		"\u0000\u0000\u0000;\u00f5\u0001\u0000\u0000\u0000=\u00f7\u0001\u0000\u0000"+
		"\u0000?\u00f9\u0001\u0000\u0000\u0000A\u00fc\u0001\u0000\u0000\u0000C"+
		"\u00ff\u0001\u0000\u0000\u0000E\u0101\u0001\u0000\u0000\u0000G\u0103\u0001"+
		"\u0000\u0000\u0000I\u0105\u0001\u0000\u0000\u0000K\u0107\u0001\u0000\u0000"+
		"\u0000M\u0109\u0001\u0000\u0000\u0000O\u010d\u0001\u0000\u0000\u0000Q"+
		"\u0113\u0001\u0000\u0000\u0000S\u011a\u0001\u0000\u0000\u0000U\u011f\u0001"+
		"\u0000\u0000\u0000W\u0124\u0001\u0000\u0000\u0000Y\u012b\u0001\u0000\u0000"+
		"\u0000[\u0130\u0001\u0000\u0000\u0000]\u0136\u0001\u0000\u0000\u0000_"+
		"\u013f\u0001\u0000\u0000\u0000a\u0142\u0001\u0000\u0000\u0000c\u0147\u0001"+
		"\u0000\u0000\u0000e\u014d\u0001\u0000\u0000\u0000g\u0154\u0001\u0000\u0000"+
		"\u0000i\u0159\u0001\u0000\u0000\u0000k\u0160\u0001\u0000\u0000\u0000m"+
		"\u0166\u0001\u0000\u0000\u0000o\u016e\u0001\u0000\u0000\u0000q\u0175\u0001"+
		"\u0000\u0000\u0000s\u017a\u0001\u0000\u0000\u0000u\u0182\u0001\u0000\u0000"+
		"\u0000w\u0188\u0001\u0000\u0000\u0000y\u018c\u0001\u0000\u0000\u0000{"+
		"\u018f\u0001\u0000\u0000\u0000}\u0198\u0001\u0000\u0000\u0000\u007f\u019d"+
		"\u0001\u0000\u0000\u0000\u0081\u01a4\u0001\u0000\u0000\u0000\u0083\u01aa"+
		"\u0001\u0000\u0000\u0000\u0085\u01b1\u0001\u0000\u0000\u0000\u0087\u01b6"+
		"\u0001\u0000\u0000\u0000\u0089\u01bb\u0001\u0000\u0000\u0000\u008b\u01c1"+
		"\u0001\u0000\u0000\u0000\u008d\u01c6\u0001\u0000\u0000\u0000\u008f\u01d2"+
		"\u0001\u0000\u0000\u0000\u0091\u01d4\u0001\u0000\u0000\u0000\u0093\u0206"+
		"\u0001\u0000\u0000\u0000\u0095\u0208\u0001\u0000\u0000\u0000\u0097\u022a"+
		"\u0001\u0000\u0000\u0000\u0099\u022d\u0001\u0000\u0000\u0000\u009b\u0234"+
		"\u0001\u0000\u0000\u0000\u009d\u023b\u0001\u0000\u0000\u0000\u009f\u0245"+
		"\u0001\u0000\u0000\u0000\u00a1\u0249\u0001\u0000\u0000\u0000\u00a3\u0257"+
		"\u0001\u0000\u0000\u0000\u00a5\u0262\u0001\u0000\u0000\u0000\u00a7\u0265"+
		"\u0001\u0000\u0000\u0000\u00a9\u0271\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005{\u0000\u0000\u00ac\u0002\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005"+
		"=\u0000\u0000\u00ae\u0004\u0001\u0000\u0000\u0000\u00af\u00b0\u0005,\u0000"+
		"\u0000\u00b0\u0006\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005}\u0000\u0000"+
		"\u00b2\b\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005;\u0000\u0000\u00b4"+
		"\n\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005:\u0000\u0000\u00b6\f\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b8\u0005(\u0000\u0000\u00b8\u000e\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0005*\u0000\u0000\u00ba\u0010\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005)\u0000\u0000\u00bc\u0012\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005[\u0000\u0000\u00be\u0014\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0005]\u0000\u0000\u00c0\u0016\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005.\u0000\u0000\u00c2\u0018\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"+\u0000\u0000\u00c4\u00c5\u0005=\u0000\u0000\u00c5\u001a\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005-\u0000\u0000\u00c7\u00c8\u0005=\u0000\u0000\u00c8"+
		"\u001c\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005*\u0000\u0000\u00ca\u00cb"+
		"\u0005=\u0000\u0000\u00cb\u001e\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"/\u0000\u0000\u00cd\u00ce\u0005=\u0000\u0000\u00ce \u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0005%\u0000\u0000\u00d0\u00d1\u0005=\u0000\u0000\u00d1"+
		"\"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005&\u0000\u0000\u00d3\u00d4"+
		"\u0005=\u0000\u0000\u00d4$\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005|"+
		"\u0000\u0000\u00d6\u00d7\u0005=\u0000\u0000\u00d7&\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0005^\u0000\u0000\u00d9\u00da\u0005=\u0000\u0000\u00da("+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0005<\u0000\u0000\u00dc\u00dd\u0005"+
		"<\u0000\u0000\u00dd\u00de\u0005=\u0000\u0000\u00de*\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005>\u0000\u0000\u00e0\u00e1\u0005>\u0000\u0000\u00e1"+
		"\u00e2\u0005=\u0000\u0000\u00e2,\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"+\u0000\u0000\u00e4\u00e5\u0005+\u0000\u0000\u00e5.\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0005-\u0000\u0000\u00e7\u00e8\u0005-\u0000\u0000\u00e8"+
		"0\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005-\u0000\u0000\u00ea2\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005&\u0000\u0000\u00ec4\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0005?\u0000\u0000\u00ee6\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0005|\u0000\u0000\u00f0\u00f1\u0005|\u0000\u0000\u00f18\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0005&\u0000\u0000\u00f3\u00f4\u0005&\u0000"+
		"\u0000\u00f4:\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005|\u0000\u0000\u00f6"+
		"<\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005^\u0000\u0000\u00f8>\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0005<\u0000\u0000\u00fa\u00fb\u0005<\u0000"+
		"\u0000\u00fb@\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005>\u0000\u0000\u00fd"+
		"\u00fe\u0005>\u0000\u0000\u00feB\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"+\u0000\u0000\u0100D\u0001\u0000\u0000\u0000\u0101\u0102\u0005/\u0000"+
		"\u0000\u0102F\u0001\u0000\u0000\u0000\u0103\u0104\u0005%\u0000\u0000\u0104"+
		"H\u0001\u0000\u0000\u0000\u0105\u0106\u0005~\u0000\u0000\u0106J\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0005!\u0000\u0000\u0108L\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0005i\u0000\u0000\u010a\u010b\u0005n\u0000\u0000\u010b"+
		"\u010c\u0005t\u0000\u0000\u010cN\u0001\u0000\u0000\u0000\u010d\u010e\u0005"+
		"f\u0000\u0000\u010e\u010f\u0005l\u0000\u0000\u010f\u0110\u0005o\u0000"+
		"\u0000\u0110\u0111\u0005a\u0000\u0000\u0111\u0112\u0005t\u0000\u0000\u0112"+
		"P\u0001\u0000\u0000\u0000\u0113\u0114\u0005d\u0000\u0000\u0114\u0115\u0005"+
		"o\u0000\u0000\u0115\u0116\u0005u\u0000\u0000\u0116\u0117\u0005b\u0000"+
		"\u0000\u0117\u0118\u0005l\u0000\u0000\u0118\u0119\u0005e\u0000\u0000\u0119"+
		"R\u0001\u0000\u0000\u0000\u011a\u011b\u0005v\u0000\u0000\u011b\u011c\u0005"+
		"o\u0000\u0000\u011c\u011d\u0005i\u0000\u0000\u011d\u011e\u0005d\u0000"+
		"\u0000\u011eT\u0001\u0000\u0000\u0000\u011f\u0120\u0005c\u0000\u0000\u0120"+
		"\u0121\u0005h\u0000\u0000\u0121\u0122\u0005a\u0000\u0000\u0122\u0123\u0005"+
		"r\u0000\u0000\u0123V\u0001\u0000\u0000\u0000\u0124\u0125\u0005s\u0000"+
		"\u0000\u0125\u0126\u0005t\u0000\u0000\u0126\u0127\u0005r\u0000\u0000\u0127"+
		"\u0128\u0005i\u0000\u0000\u0128\u0129\u0005n\u0000\u0000\u0129\u012a\u0005"+
		"g\u0000\u0000\u012aX\u0001\u0000\u0000\u0000\u012b\u012c\u0005l\u0000"+
		"\u0000\u012c\u012d\u0005o\u0000\u0000\u012d\u012e\u0005n\u0000\u0000\u012e"+
		"\u012f\u0005g\u0000\u0000\u012fZ\u0001\u0000\u0000\u0000\u0130\u0131\u0005"+
		"s\u0000\u0000\u0131\u0132\u0005h\u0000\u0000\u0132\u0133\u0005o\u0000"+
		"\u0000\u0133\u0134\u0005r\u0000\u0000\u0134\u0135\u0005t\u0000\u0000\u0135"+
		"\\\u0001\u0000\u0000\u0000\u0136\u0137\u0005u\u0000\u0000\u0137\u0138"+
		"\u0005n\u0000\u0000\u0138\u0139\u0005s\u0000\u0000\u0139\u013a\u0005i"+
		"\u0000\u0000\u013a\u013b\u0005g\u0000\u0000\u013b\u013c\u0005n\u0000\u0000"+
		"\u013c\u013d\u0005e\u0000\u0000\u013d\u013e\u0005d\u0000\u0000\u013e^"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0005i\u0000\u0000\u0140\u0141\u0005"+
		"f\u0000\u0000\u0141`\u0001\u0000\u0000\u0000\u0142\u0143\u0005e\u0000"+
		"\u0000\u0143\u0144\u0005l\u0000\u0000\u0144\u0145\u0005s\u0000\u0000\u0145"+
		"\u0146\u0005e\u0000\u0000\u0146b\u0001\u0000\u0000\u0000\u0147\u0148\u0005"+
		"w\u0000\u0000\u0148\u0149\u0005h\u0000\u0000\u0149\u014a\u0005i\u0000"+
		"\u0000\u014a\u014b\u0005l\u0000\u0000\u014b\u014c\u0005e\u0000\u0000\u014c"+
		"d\u0001\u0000\u0000\u0000\u014d\u014e\u0005r\u0000\u0000\u014e\u014f\u0005"+
		"e\u0000\u0000\u014f\u0150\u0005t\u0000\u0000\u0150\u0151\u0005u\u0000"+
		"\u0000\u0151\u0152\u0005r\u0000\u0000\u0152\u0153\u0005n\u0000\u0000\u0153"+
		"f\u0001\u0000\u0000\u0000\u0154\u0155\u0005e\u0000\u0000\u0155\u0156\u0005"+
		"n\u0000\u0000\u0156\u0157\u0005u\u0000\u0000\u0157\u0158\u0005m\u0000"+
		"\u0000\u0158h\u0001\u0000\u0000\u0000\u0159\u015a\u0005s\u0000\u0000\u015a"+
		"\u015b\u0005t\u0000\u0000\u015b\u015c\u0005r\u0000\u0000\u015c\u015d\u0005"+
		"u\u0000\u0000\u015d\u015e\u0005c\u0000\u0000\u015e\u015f\u0005t\u0000"+
		"\u0000\u015fj\u0001\u0000\u0000\u0000\u0160\u0161\u0005u\u0000\u0000\u0161"+
		"\u0162\u0005n\u0000\u0000\u0162\u0163\u0005i\u0000\u0000\u0163\u0164\u0005"+
		"o\u0000\u0000\u0164\u0165\u0005n\u0000\u0000\u0165l\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0005t\u0000\u0000\u0167\u0168\u0005y\u0000\u0000\u0168"+
		"\u0169\u0005p\u0000\u0000\u0169\u016a\u0005e\u0000\u0000\u016a\u016b\u0005"+
		"d\u0000\u0000\u016b\u016c\u0005e\u0000\u0000\u016c\u016d\u0005f\u0000"+
		"\u0000\u016dn\u0001\u0000\u0000\u0000\u016e\u016f\u0005s\u0000\u0000\u016f"+
		"\u0170\u0005w\u0000\u0000\u0170\u0171\u0005i\u0000\u0000\u0171\u0172\u0005"+
		"t\u0000\u0000\u0172\u0173\u0005c\u0000\u0000\u0173\u0174\u0005h\u0000"+
		"\u0000\u0174p\u0001\u0000\u0000\u0000\u0175\u0176\u0005c\u0000\u0000\u0176"+
		"\u0177\u0005a\u0000\u0000\u0177\u0178\u0005s\u0000\u0000\u0178\u0179\u0005"+
		"e\u0000\u0000\u0179r\u0001\u0000\u0000\u0000\u017a\u017b\u0005d\u0000"+
		"\u0000\u017b\u017c\u0005e\u0000\u0000\u017c\u017d\u0005f\u0000\u0000\u017d"+
		"\u017e\u0005a\u0000\u0000\u017e\u017f\u0005u\u0000\u0000\u017f\u0180\u0005"+
		"l\u0000\u0000\u0180\u0181\u0005t\u0000\u0000\u0181t\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0005b\u0000\u0000\u0183\u0184\u0005r\u0000\u0000\u0184"+
		"\u0185\u0005e\u0000\u0000\u0185\u0186\u0005a\u0000\u0000\u0186\u0187\u0005"+
		"k\u0000\u0000\u0187v\u0001\u0000\u0000\u0000\u0188\u0189\u0005f\u0000"+
		"\u0000\u0189\u018a\u0005o\u0000\u0000\u018a\u018b\u0005r\u0000\u0000\u018b"+
		"x\u0001\u0000\u0000\u0000\u018c\u018d\u0005d\u0000\u0000\u018d\u018e\u0005"+
		"o\u0000\u0000\u018ez\u0001\u0000\u0000\u0000\u018f\u0190\u0005c\u0000"+
		"\u0000\u0190\u0191\u0005o\u0000\u0000\u0191\u0192\u0005n\u0000\u0000\u0192"+
		"\u0193\u0005t\u0000\u0000\u0193\u0194\u0005i\u0000\u0000\u0194\u0195\u0005"+
		"n\u0000\u0000\u0195\u0196\u0005u\u0000\u0000\u0196\u0197\u0005e\u0000"+
		"\u0000\u0197|\u0001\u0000\u0000\u0000\u0198\u0199\u0005g\u0000\u0000\u0199"+
		"\u019a\u0005o\u0000\u0000\u019a\u019b\u0005t\u0000\u0000\u019b\u019c\u0005"+
		"o\u0000\u0000\u019c~\u0001\u0000\u0000\u0000\u019d\u019e\u0005s\u0000"+
		"\u0000\u019e\u019f\u0005i\u0000\u0000\u019f\u01a0\u0005z\u0000\u0000\u01a0"+
		"\u01a1\u0005e\u0000\u0000\u01a1\u01a2\u0005o\u0000\u0000\u01a2\u01a3\u0005"+
		"f\u0000\u0000\u01a3\u0080\u0001\u0000\u0000\u0000\u01a4\u01a5\u0005c\u0000"+
		"\u0000\u01a5\u01a6\u0005o\u0000\u0000\u01a6\u01a7\u0005n\u0000\u0000\u01a7"+
		"\u01a8\u0005s\u0000\u0000\u01a8\u01a9\u0005t\u0000\u0000\u01a9\u0082\u0001"+
		"\u0000\u0000\u0000\u01aa\u01ab\u0005s\u0000\u0000\u01ab\u01ac\u0005t\u0000"+
		"\u0000\u01ac\u01ad\u0005a\u0000\u0000\u01ad\u01ae\u0005t\u0000\u0000\u01ae"+
		"\u01af\u0005i\u0000\u0000\u01af\u01b0\u0005c\u0000\u0000\u01b0\u0084\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0005N\u0000\u0000\u01b2\u01b3\u0005U\u0000"+
		"\u0000\u01b3\u01b4\u0005L\u0000\u0000\u01b4\u01b5\u0005L\u0000\u0000\u01b5"+
		"\u0086\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005t\u0000\u0000\u01b7\u01b8"+
		"\u0005r\u0000\u0000\u01b8\u01b9\u0005u\u0000\u0000\u01b9\u01ba\u0005e"+
		"\u0000\u0000\u01ba\u0088\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005f\u0000"+
		"\u0000\u01bc\u01bd\u0005a\u0000\u0000\u01bd\u01be\u0005l\u0000\u0000\u01be"+
		"\u01bf\u0005s\u0000\u0000\u01bf\u01c0\u0005e\u0000\u0000\u01c0\u008a\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c2\u0005b\u0000\u0000\u01c2\u01c3\u0005o\u0000"+
		"\u0000\u01c3\u01c4\u0005o\u0000\u0000\u01c4\u01c5\u0005l\u0000\u0000\u01c5"+
		"\u008c\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005-\u0000\u0000\u01c7\u01c8"+
		"\u0005>\u0000\u0000\u01c8\u008e\u0001\u0000\u0000\u0000\u01c9\u01ca\u0005"+
		">\u0000\u0000\u01ca\u01d3\u0005=\u0000\u0000\u01cb\u01cc\u0005<\u0000"+
		"\u0000\u01cc\u01d3\u0005=\u0000\u0000\u01cd\u01ce\u0005=\u0000\u0000\u01ce"+
		"\u01d3\u0005=\u0000\u0000\u01cf\u01d0\u0005!\u0000\u0000\u01d0\u01d3\u0005"+
		"=\u0000\u0000\u01d1\u01d3\u0007\u0000\u0000\u0000\u01d2\u01c9\u0001\u0000"+
		"\u0000\u0000\u01d2\u01cb\u0001\u0000\u0000\u0000\u01d2\u01cd\u0001\u0000"+
		"\u0000\u0000\u01d2\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d1\u0001\u0000"+
		"\u0000\u0000\u01d3\u0090\u0001\u0000\u0000\u0000\u01d4\u01d8\u0007\u0001"+
		"\u0000\u0000\u01d5\u01d7\u0007\u0002\u0000\u0000\u01d6\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d7\u01da\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u0092\u0001\u0000"+
		"\u0000\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01db\u01dd\u000209\u0000"+
		"\u01dc\u01db\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000"+
		"\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000"+
		"\u01df\u01e0\u0001\u0000\u0000\u0000\u01e0\u01e4\u0005.\u0000\u0000\u01e1"+
		"\u01e3\u000209\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001"+
		"\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e5\u01f0\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e7\u01e9\u0007\u0003\u0000\u0000\u01e8\u01ea\u0007"+
		"\u0004\u0000\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ea\u01ec\u0001\u0000\u0000\u0000\u01eb\u01ed\u0002"+
		"09\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000"+
		"\u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000"+
		"\u0000\u01ef\u01f1\u0001\u0000\u0000\u0000\u01f0\u01e7\u0001\u0000\u0000"+
		"\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000\u01f1\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f2\u01f4\u0007\u0005\u0000\u0000\u01f3\u01f2\u0001\u0000\u0000"+
		"\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4\u0207\u0001\u0000\u0000"+
		"\u0000\u01f5\u01f7\u000209\u0000\u01f6\u01f5\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f8\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa"+
		"\u01fc\u0007\u0003\u0000\u0000\u01fb\u01fd\u0007\u0004\u0000\u0000\u01fc"+
		"\u01fb\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd"+
		"\u01ff\u0001\u0000\u0000\u0000\u01fe\u0200\u000209\u0000\u01ff\u01fe\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u01ff\u0001"+
		"\u0000\u0000\u0000\u0201\u0202\u0001\u0000\u0000\u0000\u0202\u0204\u0001"+
		"\u0000\u0000\u0000\u0203\u0205\u0007\u0005\u0000\u0000\u0204\u0203\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0207\u0001"+
		"\u0000\u0000\u0000\u0206\u01dc\u0001\u0000\u0000\u0000\u0206\u01f6\u0001"+
		"\u0000\u0000\u0000\u0207\u0094\u0001\u0000\u0000\u0000\u0208\u0209\u0005"+
		"0\u0000\u0000\u0209\u020b\u0007\u0006\u0000\u0000\u020a\u020c\u0007\u0007"+
		"\u0000\u0000\u020b\u020a\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000"+
		"\u0000\u0000\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000"+
		"\u0000\u0000\u020e\u0212\u0001\u0000\u0000\u0000\u020f\u0211\u0007\b\u0000"+
		"\u0000\u0210\u020f\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000"+
		"\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000"+
		"\u0000\u0213\u0096\u0001\u0000\u0000\u0000\u0214\u0212\u0001\u0000\u0000"+
		"\u0000\u0215\u0217\u000209\u0000\u0216\u0215\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0218"+
		"\u0219\u0001\u0000\u0000\u0000\u0219\u021b\u0001\u0000\u0000\u0000\u021a"+
		"\u021c\u0007\t\u0000\u0000\u021b\u021a\u0001\u0000\u0000\u0000\u021b\u021c"+
		"\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021d\u021e"+
		"\u0007\n\u0000\u0000\u021e\u0220\u0007\n\u0000\u0000\u021f\u0221\u0007"+
		"\t\u0000\u0000\u0220\u021f\u0001\u0000\u0000\u0000\u0220\u0221\u0001\u0000"+
		"\u0000\u0000\u0221\u022b\u0001\u0000\u0000\u0000\u0222\u0224\u000209\u0000"+
		"\u0223\u0222\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000\u0000\u0000"+
		"\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000\u0000\u0000"+
		"\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0228\u0007\t\u0000\u0000\u0228"+
		"\u0229\u0007\n\u0000\u0000\u0229\u022b\u0007\n\u0000\u0000\u022a\u0216"+
		"\u0001\u0000\u0000\u0000\u022a\u0223\u0001\u0000\u0000\u0000\u022b\u0098"+
		"\u0001\u0000\u0000\u0000\u022c\u022e\u000209\u0000\u022d\u022c\u0001\u0000"+
		"\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000"+
		"\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u0232\u0001\u0000"+
		"\u0000\u0000\u0231\u0233\u0007\b\u0000\u0000\u0232\u0231\u0001\u0000\u0000"+
		"\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233\u009a\u0001\u0000\u0000"+
		"\u0000\u0234\u0237\u0005\'\u0000\u0000\u0235\u0238\u0003\u00a9T\u0000"+
		"\u0236\u0238\b\u000b\u0000\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0237"+
		"\u0236\u0001\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239"+
		"\u023a\u0005\'\u0000\u0000\u023a\u009c\u0001\u0000\u0000\u0000\u023b\u0240"+
		"\u0005\"\u0000\u0000\u023c\u023f\u0003\u00a9T\u0000\u023d\u023f\b\f\u0000"+
		"\u0000\u023e\u023c\u0001\u0000\u0000\u0000\u023e\u023d\u0001\u0000\u0000"+
		"\u0000\u023f\u0242\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000\u0000"+
		"\u0000\u0240\u0241\u0001\u0000\u0000\u0000\u0241\u0243\u0001\u0000\u0000"+
		"\u0000\u0242\u0240\u0001\u0000\u0000\u0000\u0243\u0244\u0005\"\u0000\u0000"+
		"\u0244\u009e\u0001\u0000\u0000\u0000\u0245\u0246\u0007\r\u0000\u0000\u0246"+
		"\u0247\u0001\u0000\u0000\u0000\u0247\u0248\u0006O\u0000\u0000\u0248\u00a0"+
		"\u0001\u0000\u0000\u0000\u0249\u024a\u0005/\u0000\u0000\u024a\u024b\u0005"+
		"*\u0000\u0000\u024b\u024f\u0001\u0000\u0000\u0000\u024c\u024e\t\u0000"+
		"\u0000\u0000\u024d\u024c\u0001\u0000\u0000\u0000\u024e\u0251\u0001\u0000"+
		"\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u024f\u024d\u0001\u0000"+
		"\u0000\u0000\u0250\u0252\u0001\u0000\u0000\u0000\u0251\u024f\u0001\u0000"+
		"\u0000\u0000\u0252\u0253\u0005*\u0000\u0000\u0253\u0254\u0005/\u0000\u0000"+
		"\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0256\u0006P\u0000\u0000\u0256"+
		"\u00a2\u0001\u0000\u0000\u0000\u0257\u0258\u0005/\u0000\u0000\u0258\u0259"+
		"\u0005/\u0000\u0000\u0259\u025d\u0001\u0000\u0000\u0000\u025a\u025c\b"+
		"\u000e\u0000\u0000\u025b\u025a\u0001\u0000\u0000\u0000\u025c\u025f\u0001"+
		"\u0000\u0000\u0000\u025d\u025b\u0001\u0000\u0000\u0000\u025d\u025e\u0001"+
		"\u0000\u0000\u0000\u025e\u0260\u0001\u0000\u0000\u0000\u025f\u025d\u0001"+
		"\u0000\u0000\u0000\u0260\u0261\u0006Q\u0000\u0000\u0261\u00a4\u0001\u0000"+
		"\u0000\u0000\u0262\u0263\u0005#\u0000\u0000\u0263\u0264\u0005#\u0000\u0000"+
		"\u0264\u00a6\u0001\u0000\u0000\u0000\u0265\u026d\u0005#\u0000\u0000\u0266"+
		"\u026a\b\u000f\u0000\u0000\u0267\u0269\b\u000e\u0000\u0000\u0268\u0267"+
		"\u0001\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a\u0268"+
		"\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b\u026e"+
		"\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026d\u0266"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u026f"+
		"\u0001\u0000\u0000\u0000\u026f\u0270\u0006S\u0000\u0000\u0270\u00a8\u0001"+
		"\u0000\u0000\u0000\u0271\u0272\u0005\\\u0000\u0000\u0272\u0273\u0007\u0010"+
		"\u0000\u0000\u0273\u00aa\u0001\u0000\u0000\u0000\u001e\u0000\u01d2\u01d8"+
		"\u01de\u01e4\u01e9\u01ee\u01f0\u01f3\u01f8\u01fc\u0201\u0204\u0206\u020d"+
		"\u0212\u0218\u021b\u0220\u0225\u022a\u022f\u0232\u0237\u023e\u0240\u024f"+
		"\u025d\u026a\u026d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}