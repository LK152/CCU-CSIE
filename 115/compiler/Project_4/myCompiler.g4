grammar myCompiler;

options {
	language = Java;
}

@header {
    import java.util.HashMap;
    import java.util.ArrayList;
}

@members {
    boolean TRACEON = false;

    // ====================== Type information ======================
    public enum Type {
       ERR, BOOL, INT, FLOAT, VOID;
    }

    // Information attached to an expression / symbol.
    //   theType : the (semantic) type of the value.
    //   operand : the textual LLVM operand that *holds* the value
    //             ("%t3", an immediate like "10", or a float-hex like
    //              "0x3FF8000000000000"). For a symbol-table entry it is
    //             the alloca address (e.g. "%t0").
    class Info {
       Type   theType;
       String operand;
       Info() { theType = Type.ERR; operand = ""; }
       Info(Type t, String op) { theType = t; operand = op; }
    }

    // Signature of a user-defined function (for type-checking calls).
    class Func {
       Type ret;
       ArrayList<Type> params;
       Func(Type r, ArrayList<Type> p) { ret = r; params = p; }
    }

    // ====================== Tables / counters =====================
    // Symbol table for the *current* function only (locals + params).
    HashMap<String,Info> symtab   = new HashMap<String,Info>();
    // Global table of function signatures.
    HashMap<String,Func> functab  = new HashMap<String,Func>();

    int varCount   = 0;   // next %t temporary / slot index
    int labelCount = 0;   // next Lxx label index
    int strCount   = 0;   // next @.str global index

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

    String llTy(Type t) {
       switch (t) {
          case INT:   return "i32";
          case FLOAT: return "float";
          case VOID:  return "void";
          default:    return "i32";
       }
    }

    // LLVM float literal: 64-bit hex of the (double-widened) float value.
    // This is always exactly representable as a float, so LLVM accepts it.
    String fltHex(float f) {
       long bits = Double.doubleToLongBits((double) f);
       return String.format("0x%016X", bits);
    }

    // Coerce 'in' to target type, emitting a conversion instruction if needed.
    // Returns the operand string of the (possibly converted) value.
    String coerce(Info in, Type target) {
       if (in.theType == target) return in.operand;
       String r = newReg();
       if (in.theType == Type.INT && target == Type.FLOAT) {
          emit("  " + r + " = sitofp i32 " + in.operand + " to float");
       } else if (in.theType == Type.FLOAT && target == Type.INT) {
          emit("  " + r + " = fptosi float " + in.operand + " to i32");
       } else {
          // BOOL/unknown -> just return as-is
          return in.operand;
       }
       return r;
    }

    // Binary arithmetic with implicit int->float promotion.
    Info binArith(String op, Info a, Info b) {
       Type rt = (a.theType == Type.FLOAT || b.theType == Type.FLOAT)
                 ? Type.FLOAT : Type.INT;
       String oa = coerce(a, rt);
       String ob = coerce(b, rt);
       String r  = newReg();
       String ins;
       if (rt == Type.INT) {
          if      (op.equals("+")) ins = "add nsw i32";
          else if (op.equals("-")) ins = "sub nsw i32";
          else if (op.equals("*")) ins = "mul nsw i32";
          else                     ins = "sdiv i32";
       } else {
          if      (op.equals("+")) ins = "fadd float";
          else if (op.equals("-")) ins = "fsub float";
          else if (op.equals("*")) ins = "fmul float";
          else                     ins = "fdiv float";
       }
       emit("  " + r + " = " + ins + " " + oa + ", " + ob);
       return new Info(rt, r);
    }

    // The "##" operator:  a ## b = a^b + b^a  (both float, result float).
    Info hashOp(Info a, Info b) {
       String oa = coerce(a, Type.FLOAT);
       String ob = coerce(b, Type.FLOAT);
       String r  = newReg();
       emit("  " + r + " = call float @__hashOp(float " + oa + ", float " + ob + ")");
       return new Info(Type.FLOAT, r);
    }

    // Build an i1 condition value from a relational compare (or truthiness).
    Info compare(Info a, String relop, Info b) {
       Type ct = (a.theType == Type.FLOAT || b.theType == Type.FLOAT)
                 ? Type.FLOAT : Type.INT;
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
       String r = newReg();
       if (a.theType == Type.FLOAT)
          emit("  " + r + " = fcmp one float " + a.operand + ", 0.0");
       else
          emit("  " + r + " = icmp ne i32 " + a.operand + ", 0");
       return new Info(Type.BOOL, r);
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

    // ---- printf / scanf ----
    void emitPrintf(String fmt, ArrayList<String> vals) {
       StringBuilder argstr = new StringBuilder();
       for (String v : vals) {
          if (v.startsWith("float ")) {
             // C default-argument promotion: float is passed as double.
             String d = newReg();
             emit("  " + d + " = fpext " + v + " to double");
             argstr.append(", double ").append(d);
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
       symtab = new HashMap<String,Info>();
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
       sb.append("; ---- external / runtime declarations ----\n");
       sb.append("declare i32 @printf(ptr, ...)\n");
       sb.append("declare i32 @scanf(ptr, ...)\n");
       sb.append("declare float @__hashOp(float, float)\n");
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

program: func_def+ EOF;

func_def:
	type Identifier '(' params ')' {
           curRet  = $type.attr_type;
           curName = $Identifier.text;
           // record signature so later functions can call this one
           functab.put(curName, new Func(curRet,
                       new ArrayList<Type>(curParamTypes)));
           beginFunction();
        } '{' declarations statements '}' {
           endFunction();
        };

params
	@init { curParamTypes = new ArrayList<Type>();
        curParamNames = new ArrayList<String>(); }: (
		type Identifier { curParamTypes.add($type.attr_type);
            curParamNames.add($Identifier.text); } (
			',' type Identifier { curParamTypes.add($type.attr_type);
            curParamNames.add($Identifier.text); }
		)*
	)?;

declarations:
	type first = Identifier {
           if (symtab.containsKey($first.text)) {
              System.out.println("Type Error: line " + $first.getLine()
                                 + ": Redeclared identifier '" + $first.text + "'.");
              System.exit(0);
           }
           String slot1 = newReg();
           emit("  " + slot1 + " = alloca " + llTy($type.attr_type));
           symtab.put($first.text, new Info($type.attr_type, slot1));
        } (
		',' more = Identifier {
           if (symtab.containsKey($more.text)) {
              System.out.println("Type Error: line " + $more.getLine()
                                 + ": Redeclared identifier '" + $more.text + "'.");
              System.exit(0);
           }
           String slot2 = newReg();
           emit("  " + slot2 + " = alloca " + llTy($type.attr_type));
           symtab.put($more.text, new Info($type.attr_type, slot2));
        }
	)* ';' declarations
	| /* empty */;

type
	returns[Type attr_type]:
	INT { $attr_type = Type.INT;   }
	| FLOAT { $attr_type = Type.FLOAT; }
	| VOID { $attr_type = Type.VOID;  };

statements: statement statements | /* empty */;

statement:
	assign_stmt ';'
	| if_stmt
	| while_stmt
	| return_stmt ';'
	| func_call_stmt ';'
	| block_stmt;

block_stmt: '{' statements '}';

// ---------------- assignment ----------------
assign_stmt:
	Identifier '=' arith_expression {
           Info lhs = symtab.get($Identifier.text);
           if (lhs == null) {
              System.out.println("Type Error: line " + $Identifier.getLine()
                                 + ": Undeclared identifier '"
                                 + $Identifier.text + "'.");
              System.exit(0);
           }
           String v = coerce($arith_expression.theInfo, lhs.theType);
           emit("  store " + llTy(lhs.theType) + " " + v + ", ptr " + lhs.operand);
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
        }
	| RETURN {
           emit("  ret void");
           emit(newLabel() + ":");
        };

// ---------------- if / if-else ----------------
if_stmt
	locals[String lThen, String lElse, String lEnd]:
	IF '(' cond_expression ')' {
           $lThen = newLabel(); $lElse = newLabel(); $lEnd = newLabel();
           emit("  br i1 " + $cond_expression.theInfo.operand
                + ", label %" + $lThen + ", label %" + $lElse);
           emit($lThen + ":");
        } block_stmt {
           emit("  br label %" + $lEnd);
           emit($lElse + ":");
        } (ELSE block_stmt)? {
           emit("  br label %" + $lEnd);
           emit($lEnd + ":");
        };

// ---------------- while ----------------
while_stmt
	locals[String lCond, String lBody, String lEnd]:
	WHILE {
           $lCond = newLabel(); $lBody = newLabel(); $lEnd = newLabel();
           emit("  br label %" + $lCond);
           emit($lCond + ":");
        } '(' cond_expression ')' {
           emit("  br i1 " + $cond_expression.theInfo.operand
                + ", label %" + $lBody + ", label %" + $lEnd);
           emit($lBody + ":");
        } block_stmt {
           emit("  br label %" + $lCond);
           emit($lEnd + ":");
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
	STRING_LITERAL {
           $fmtName = makeStringGlobal($STRING_LITERAL.text);
           $argPiece = "ptr " + $fmtName;
        }
	| '&' Identifier {
           Info v = symtab.get($Identifier.text);
           $addrList.add("ptr " + v.operand);
           $argPiece = "ptr " + v.operand;
        }
	| arith_expression {
           Info v = $arith_expression.theInfo;
           // store raw typed operand; printf promotes float->double itself
           $valList.add(llTy(v.theType) + " " + v.operand);
           $argPiece = llTy(v.theType) + " " + v.operand;
        };

// ---------------- conditions ----------------
cond_expression
	returns[Info theInfo]
	locals[boolean rel]
	@init { $theInfo = new Info(); $rel = false; }:
	a = arith_expression (
		RelationOP b = arith_expression {
           $theInfo = compare($a.theInfo, $RelationOP.text, $b.theInfo);
           $rel = true;
        }
	)? { if (!$rel) $theInfo = truth($a.theInfo); };

// ---------------- arithmetic ----------------
arith_expression
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
		'*' b = castExpr { $theInfo = binArith("*", $theInfo, $b.theInfo); }
		| '/' c = castExpr { $theInfo = binArith("/", $theInfo, $c.theInfo); }
		| '##' d = castExpr { $theInfo = hashOp($theInfo, $d.theInfo); }
	)*;

castExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	'(' type ')' e = castExpr {
           String v = coerce($e.theInfo, $type.attr_type);
           $theInfo = new Info($type.attr_type, v);
        }
	| s = signExpr { $theInfo = $s.theInfo; };

signExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	'-' e = signExpr {
           Info in = $e.theInfo;
           String r = newReg();
           if (in.theType == Type.FLOAT) {
              emit("  " + r + " = fneg float " + in.operand);
              $theInfo = new Info(Type.FLOAT, r);
           } else {
              emit("  " + r + " = sub nsw i32 0, " + in.operand);
              $theInfo = new Info(Type.INT, r);
           }
        }
	| p = primaryExpr { $theInfo = $p.theInfo; };

primaryExpr
	returns[Info theInfo]
	@init { $theInfo = new Info(); }:
	Integer_constant { $theInfo = new Info(Type.INT, $Integer_constant.text); }
	| Floating_point_constant { $theInfo = new Info(Type.FLOAT,
                              fltHex(Float.parseFloat($Floating_point_constant.text))); }
	| Identifier '(' call_args ')' // value-returning function call
	{
           String fn = $Identifier.text;
           Func f = functab.get(fn);
           Type rt = (f == null) ? Type.INT : f.ret;
           String r = newReg();
           emit("  " + r + " = call " + llTy(rt) + " @" + fn
                + "(" + $call_args.argList + ")");
           $theInfo = new Info(rt, r);
        }
	| Identifier // variable read
	{
           Info v = symtab.get($Identifier.text);
           if (v == null) {
              System.out.println("Type Error: line " + $Identifier.getLine()
                                 + ": Undeclared identifier '"
                                 + $Identifier.text + "'.");
              System.exit(0);
           }
           String r = newReg();
           emit("  " + r + " = load " + llTy(v.theType) + ", ptr " + v.operand);
           $theInfo = new Info(v.theType, r);
        }
	| '(' arith_expression ')' { $theInfo = $arith_expression.theInfo; };

// ===================================================================== Lexer rules
// =====================================================================
INT: 'int';
FLOAT: 'float';
VOID: 'void';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';

RelationOP: '>=' | '<=' | '==' | '!=' | '>' | '<';

Identifier: ('a' ..'z' | 'A' ..'Z' | '_') (
		'a' ..'z'
		| 'A' ..'Z'
		| '0' ..'9'
		| '_'
	)*;
Floating_point_constant: ('0' ..'9')+ '.' ('0' ..'9')+;
Integer_constant: ('0' ..'9')+;

STRING_LITERAL: '"' ( EscapeSequence | ~('\\' | '"'))* '"';

WS: ( ' ' | '\t' | '\r' | '\n') -> skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~('\n' | '\r')* -> skip;

fragment EscapeSequence:
	'\\' ('b' | 't' | 'n' | 'f' | 'r' | '\'' | '"' | '\\');