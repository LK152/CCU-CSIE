// Generated from c:/Users/Luke/Documents/Github/CCU-CSIE/115/compiler/Project_4/myCompiler.g4 by ANTLR 4.13.1

    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.ArrayDeque;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class myCompilerParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_enum_def = 1, RULE_struct_def = 2, RULE_union_def = 3, 
		RULE_struct_field = 4, RULE_typedef_def = 5, RULE_type_list = 6, RULE_stars = 7, 
		RULE_ptr_stars = 8, RULE_global_var_decl = 9, RULE_func_proto = 10, RULE_func_def = 11, 
		RULE_params = 12, RULE_dim_list = 13, RULE_init_list = 14, RULE_init_elem = 15, 
		RULE_init_val = 16, RULE_declarations = 17, RULE_type = 18, RULE_statements = 19, 
		RULE_statement = 20, RULE_block_stmt = 21, RULE_assign_stmt = 22, RULE_return_stmt = 23, 
		RULE_inc_dec_stmt = 24, RULE_if_stmt = 25, RULE_while_stmt = 26, RULE_break_stmt = 27, 
		RULE_continue_stmt = 28, RULE_goto_stmt = 29, RULE_labeled_stmt = 30, 
		RULE_for_stmt = 31, RULE_for_init = 32, RULE_for_update = 33, RULE_for_decl = 34, 
		RULE_do_while_stmt = 35, RULE_case_val = 36, RULE_switch_stmt = 37, RULE_func_call_stmt = 38, 
		RULE_call_args = 39, RULE_one_arg = 40, RULE_arith_expression = 41, RULE_ternaryExpr = 42, 
		RULE_logicOrExpr = 43, RULE_logicAndExpr = 44, RULE_bitOrExpr = 45, RULE_bitXorExpr = 46, 
		RULE_bitAndExpr = 47, RULE_compareExpr = 48, RULE_shiftExpr = 49, RULE_addExpr = 50, 
		RULE_multExpr = 51, RULE_castExpr = 52, RULE_signExpr = 53, RULE_primaryExpr = 54, 
		RULE_comma_expr = 55, RULE_assign_expr = 56, RULE_dim_list_opt = 57;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "enum_def", "struct_def", "union_def", "struct_field", "typedef_def", 
			"type_list", "stars", "ptr_stars", "global_var_decl", "func_proto", "func_def", 
			"params", "dim_list", "init_list", "init_elem", "init_val", "declarations", 
			"type", "statements", "statement", "block_stmt", "assign_stmt", "return_stmt", 
			"inc_dec_stmt", "if_stmt", "while_stmt", "break_stmt", "continue_stmt", 
			"goto_stmt", "labeled_stmt", "for_stmt", "for_init", "for_update", "for_decl", 
			"do_while_stmt", "case_val", "switch_stmt", "func_call_stmt", "call_args", 
			"one_arg", "arith_expression", "ternaryExpr", "logicOrExpr", "logicAndExpr", 
			"bitOrExpr", "bitXorExpr", "bitAndExpr", "compareExpr", "shiftExpr", 
			"addExpr", "multExpr", "castExpr", "signExpr", "primaryExpr", "comma_expr", 
			"assign_expr", "dim_list_opt"
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

	@Override
	public String getGrammarFileName() { return "myCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public myCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(myCompilerParser.EOF, 0); }
		public List<Enum_defContext> enum_def() {
			return getRuleContexts(Enum_defContext.class);
		}
		public Enum_defContext enum_def(int i) {
			return getRuleContext(Enum_defContext.class,i);
		}
		public List<Struct_defContext> struct_def() {
			return getRuleContexts(Struct_defContext.class);
		}
		public Struct_defContext struct_def(int i) {
			return getRuleContext(Struct_defContext.class,i);
		}
		public List<Union_defContext> union_def() {
			return getRuleContexts(Union_defContext.class);
		}
		public Union_defContext union_def(int i) {
			return getRuleContext(Union_defContext.class,i);
		}
		public List<Typedef_defContext> typedef_def() {
			return getRuleContexts(Typedef_defContext.class);
		}
		public Typedef_defContext typedef_def(int i) {
			return getRuleContext(Typedef_defContext.class,i);
		}
		public List<Global_var_declContext> global_var_decl() {
			return getRuleContexts(Global_var_declContext.class);
		}
		public Global_var_declContext global_var_decl(int i) {
			return getRuleContext(Global_var_declContext.class,i);
		}
		public List<Func_protoContext> func_proto() {
			return getRuleContexts(Func_protoContext.class);
		}
		public Func_protoContext func_proto(int i) {
			return getRuleContext(Func_protoContext.class,i);
		}
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(116);
					enum_def();
					}
					break;
				case 2:
					{
					setState(117);
					struct_def();
					}
					break;
				case 3:
					{
					setState(118);
					union_def();
					}
					break;
				case 4:
					{
					setState(119);
					typedef_def();
					}
					break;
				case 5:
					{
					setState(120);
					global_var_decl();
					}
					break;
				case 6:
					{
					setState(121);
					func_proto();
					}
					break;
				case 7:
					{
					setState(122);
					func_def();
					}
					break;
				}
				}
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19528802783L) != 0) );
			setState(127);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Enum_defContext extends ParserRuleContext {
		public int nextVal;
		public Token first_name;
		public Arith_expressionContext first_expr;
		public Token more_name;
		public Arith_expressionContext more_expr;
		public TerminalNode ENUM() { return getToken(myCompilerParser.ENUM, 0); }
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public Enum_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_def; }
	}

	public final Enum_defContext enum_def() throws RecognitionException {
		Enum_defContext _localctx = new Enum_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_enum_def);
		 ((Enum_defContext)_localctx).nextVal =  0; 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ENUM);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(130);
				match(Identifier);
				}
			}

			setState(133);
			match(T__0);
			setState(134);
			((Enum_defContext)_localctx).first_name = match(Identifier);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(135);
				match(T__1);
				setState(136);
				((Enum_defContext)_localctx).first_expr = arith_expression();

				            if (isIntImm(((Enum_defContext)_localctx).first_expr.theInfo))
				                ((Enum_defContext)_localctx).nextVal =  (int) getIntImm(((Enum_defContext)_localctx).first_expr.theInfo);
				          
				}
			}

			 enumTab.put((((Enum_defContext)_localctx).first_name!=null?((Enum_defContext)_localctx).first_name.getText():null), _localctx.nextVal++); 
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					match(T__2);
					setState(143);
					((Enum_defContext)_localctx).more_name = match(Identifier);
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(144);
						match(T__1);
						setState(145);
						((Enum_defContext)_localctx).more_expr = arith_expression();

						                if (isIntImm(((Enum_defContext)_localctx).more_expr.theInfo))
						                    ((Enum_defContext)_localctx).nextVal =  (int) getIntImm(((Enum_defContext)_localctx).more_expr.theInfo);
						              
						}
					}

					 enumTab.put((((Enum_defContext)_localctx).more_name!=null?((Enum_defContext)_localctx).more_name.getText():null), _localctx.nextVal++); 
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(156);
				match(T__2);
				}
			}

			setState(159);
			match(T__3);
			setState(160);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_defContext extends ParserRuleContext {
		public ArrayList<StructField> fields;
		public Token sname;
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public Struct_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_def; }
	}

	public final Struct_defContext struct_def() throws RecognitionException {
		Struct_defContext _localctx = new Struct_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_def);
		 ((Struct_defContext)_localctx).fields =  new ArrayList<StructField>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(STRUCT);
			setState(163);
			((Struct_defContext)_localctx).sname = match(Identifier);
			setState(164);
			match(T__0);
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				struct_field(_localctx.fields);
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327402463L) != 0) );
			setState(170);
			match(T__3);
			setState(171);
			match(T__4);

			        structDefs.put((((Struct_defContext)_localctx).sname!=null?((Struct_defContext)_localctx).sname.getText():null), _localctx.fields);
			        StringBuilder td = new StringBuilder("%struct." + (((Struct_defContext)_localctx).sname!=null?((Struct_defContext)_localctx).sname.getText():null) + " = type { ");
			        for (int _i = 0; _i < _localctx.fields.size(); _i++) {
			            if (_i > 0) td.append(", ");
			            td.append(llTy(_localctx.fields.get(_i).t));
			        }
			        td.append(" }");
			        structTypeDecls.add(td.toString());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Union_defContext extends ParserRuleContext {
		public ArrayList<StructField> fields;
		public Token uname;
		public TerminalNode UNION() { return getToken(myCompilerParser.UNION, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public Union_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_def; }
	}

	public final Union_defContext union_def() throws RecognitionException {
		Union_defContext _localctx = new Union_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_union_def);
		 ((Union_defContext)_localctx).fields =  new ArrayList<StructField>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(UNION);
			setState(175);
			((Union_defContext)_localctx).uname = match(Identifier);
			setState(176);
			match(T__0);
			setState(178); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(177);
				struct_field(_localctx.fields);
				}
				}
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327402463L) != 0) );
			setState(182);
			match(T__3);
			setState(183);
			match(T__4);

			        structDefs.put((((Union_defContext)_localctx).uname!=null?((Union_defContext)_localctx).uname.getText():null), _localctx.fields);
			        StringBuilder td = new StringBuilder("%struct." + (((Union_defContext)_localctx).uname!=null?((Union_defContext)_localctx).uname.getText():null) + " = type { ");
			        for (int _i = 0; _i < _localctx.fields.size(); _i++) {
			            if (_i > 0) td.append(", ");
			            td.append(llTy(_localctx.fields.get(_i).t));
			        }
			        td.append(" }");
			        structTypeDecls.add(td.toString());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_fieldContext extends ParserRuleContext {
		public ArrayList<StructField> outer;
		public TypeContext bf_type;
		public Token bf_name;
		public TypeContext rf_type;
		public Ptr_starsContext rps;
		public Token rf_name;
		public TerminalNode UNION() { return getToken(myCompilerParser.UNION, 0); }
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Integer_constant() { return getToken(myCompilerParser.Integer_constant, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Struct_fieldContext(ParserRuleContext parent, int invokingState, ArrayList<StructField> outer) {
			super(parent, invokingState);
			this.outer = outer;
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
	}

	public final Struct_fieldContext struct_field(ArrayList<StructField> outer) throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState(), outer);
		enterRule(_localctx, 8, RULE_struct_field);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(UNION);
				setState(187);
				match(T__0);
				setState(189); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(188);
					struct_field(_localctx.outer);
					}
					}
					setState(191); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327402463L) != 0) );
				setState(193);
				match(T__3);
				setState(194);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(STRUCT);
				setState(197);
				match(T__0);
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(198);
					struct_field(_localctx.outer);
					}
					}
					setState(201); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327402463L) != 0) );
				setState(203);
				match(T__3);
				setState(204);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				type();
				setState(207);
				match(T__5);
				setState(208);
				match(Integer_constant);
				setState(209);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				((Struct_fieldContext)_localctx).bf_type = type();
				setState(212);
				((Struct_fieldContext)_localctx).bf_name = match(Identifier);
				setState(213);
				match(T__5);
				setState(214);
				match(Integer_constant);
				setState(215);
				match(T__4);

				        _localctx.outer.add(new StructField(((Struct_fieldContext)_localctx).bf_type.attr_type, (((Struct_fieldContext)_localctx).bf_name!=null?((Struct_fieldContext)_localctx).bf_name.getText():null)));
				      
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				((Struct_fieldContext)_localctx).rf_type = type();
				setState(219);
				((Struct_fieldContext)_localctx).rps = ptr_stars();
				setState(220);
				((Struct_fieldContext)_localctx).rf_name = match(Identifier);
				setState(221);
				match(T__4);

				        Type _rft = (((Struct_fieldContext)_localctx).rps.depth > 0) ? Type.POINTER : ((Struct_fieldContext)_localctx).rf_type.attr_type;
				        _localctx.outer.add(new StructField(_rft, (((Struct_fieldContext)_localctx).rf_name!=null?((Struct_fieldContext)_localctx).rf_name.getText():null)));
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Typedef_defContext extends ParserRuleContext {
		public TypeContext bt;
		public Token td_name;
		public Token fp_name;
		public TerminalNode TYPEDEF() { return getToken(myCompilerParser.TYPEDEF, 0); }
		public StarsContext stars() {
			return getRuleContext(StarsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public Typedef_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef_def; }
	}

	public final Typedef_defContext typedef_def() throws RecognitionException {
		Typedef_defContext _localctx = new Typedef_defContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typedef_def);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(TYPEDEF);
				setState(227);
				((Typedef_defContext)_localctx).bt = type();
				setState(228);
				stars();
				setState(229);
				((Typedef_defContext)_localctx).td_name = match(Identifier);
				setState(230);
				match(T__4);

				        typedefMap.put((((Typedef_defContext)_localctx).td_name!=null?((Typedef_defContext)_localctx).td_name.getText():null), ((Typedef_defContext)_localctx).bt.attr_type);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(TYPEDEF);
				setState(234);
				type();
				setState(235);
				ptr_stars();
				setState(236);
				match(T__6);
				setState(237);
				match(T__7);
				setState(238);
				((Typedef_defContext)_localctx).fp_name = match(Identifier);
				setState(239);
				match(T__8);
				setState(240);
				match(T__6);
				setState(241);
				type_list();
				setState(242);
				match(T__8);
				setState(243);
				match(T__4);

				        typedefMap.put((((Typedef_defContext)_localctx).fp_name!=null?((Typedef_defContext)_localctx).fp_name.getText():null), Type.POINTER);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_listContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<Ptr_starsContext> ptr_stars() {
			return getRuleContexts(Ptr_starsContext.class);
		}
		public Ptr_starsContext ptr_stars(int i) {
			return getRuleContext(Ptr_starsContext.class,i);
		}
		public Type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_list; }
	}

	public final Type_listContext type_list() throws RecognitionException {
		Type_listContext _localctx = new Type_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327353311L) != 0)) {
				{
				setState(248);
				type();
				setState(249);
				ptr_stars();
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(250);
					match(T__2);
					setState(251);
					type();
					setState(252);
					ptr_stars();
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StarsContext extends ParserRuleContext {
		public StarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stars; }
	}

	public final StarsContext stars() throws RecognitionException {
		StarsContext _localctx = new StarsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(261);
				match(T__7);
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ptr_starsContext extends ParserRuleContext {
		public int depth;
		public Ptr_starsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_stars; }
	}

	public final Ptr_starsContext ptr_stars() throws RecognitionException {
		Ptr_starsContext _localctx = new Ptr_starsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ptr_stars);
		 ((Ptr_starsContext)_localctx).depth =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(267);
				match(T__7);
				 _localctx.depth++; 
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Global_var_declContext extends ParserRuleContext {
		public Type _gbt;
		public TypeContext type;
		public Token ga;
		public Dim_listContext dl;
		public Ptr_starsContext gps1;
		public Token gn1;
		public Arith_expressionContext gi1;
		public Ptr_starsContext gps2;
		public Token gn2;
		public Arith_expressionContext gi2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public Dim_listContext dim_list() {
			return getRuleContext(Dim_listContext.class,0);
		}
		public List<TerminalNode> CONST() { return getTokens(myCompilerParser.CONST); }
		public TerminalNode CONST(int i) {
			return getToken(myCompilerParser.CONST, i);
		}
		public List<TerminalNode> STATIC() { return getTokens(myCompilerParser.STATIC); }
		public TerminalNode STATIC(int i) {
			return getToken(myCompilerParser.STATIC, i);
		}
		public List<Ptr_starsContext> ptr_stars() {
			return getRuleContexts(Ptr_starsContext.class);
		}
		public Ptr_starsContext ptr_stars(int i) {
			return getRuleContext(Ptr_starsContext.class,i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public Global_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_var_decl; }
	}

	public final Global_var_declContext global_var_decl() throws RecognitionException {
		Global_var_declContext _localctx = new Global_var_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_global_var_decl);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONST || _la==STATIC) {
					{
					{
					setState(274);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(280);
				((Global_var_declContext)_localctx).type = type();
				setState(281);
				((Global_var_declContext)_localctx).ga = match(Identifier);
				setState(282);
				((Global_var_declContext)_localctx).dl = dim_list();
				setState(283);
				match(T__4);

				        Type _gt = ((Global_var_declContext)_localctx).type.attr_type;
				        String _gname = "@" + (((Global_var_declContext)_localctx).ga!=null?((Global_var_declContext)_localctx).ga.getText():null);
				        String _arrTy = llArrayTy(_gt, ((Global_var_declContext)_localctx).dl.dimArray);
				        globalVarDecls.add(_gname + " = global " + _arrTy + " zeroinitializer");
				        globalSymtab.put((((Global_var_declContext)_localctx).ga!=null?((Global_var_declContext)_localctx).ga.getText():null), new Info(_gt, ((Global_var_declContext)_localctx).dl.dimArray, _gname));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONST || _la==STATIC) {
					{
					{
					setState(286);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(292);
				((Global_var_declContext)_localctx).type = type();
				 ((Global_var_declContext)_localctx)._gbt =  ((Global_var_declContext)_localctx).type.attr_type; 
				setState(294);
				((Global_var_declContext)_localctx).gps1 = ptr_stars();
				setState(295);
				((Global_var_declContext)_localctx).gn1 = match(Identifier);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(296);
					match(T__1);
					setState(297);
					((Global_var_declContext)_localctx).gi1 = arith_expression();
					}
				}


				        Type _gt1 = (((Global_var_declContext)_localctx).gps1.depth > 0) ? Type.POINTER : _localctx._gbt;
				        String _gname1 = "@" + (((Global_var_declContext)_localctx).gn1!=null?((Global_var_declContext)_localctx).gn1.getText():null);
				        String _gzero1 = (_gt1 == Type.POINTER) ? "null"
				                       : (_gt1 == Type.FLOAT)   ? "0.0"
				                       : (_gt1 == Type.DOUBLE)  ? "0.0"
				                       : "0";
				        globalVarDecls.add(_gname1 + " = global " + llTy(_gt1) + " " + _gzero1);
				        Info _gi1 = (((Global_var_declContext)_localctx).gps1.depth > 0)
				                    ? new Info(_localctx._gbt, null, ((Global_var_declContext)_localctx).gps1.depth, _gname1)
				                    : new Info(_gt1, _gname1);
				        globalSymtab.put((((Global_var_declContext)_localctx).gn1!=null?((Global_var_declContext)_localctx).gn1.getText():null), _gi1);
				      
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(301);
					match(T__2);
					setState(302);
					((Global_var_declContext)_localctx).gps2 = ptr_stars();
					setState(303);
					((Global_var_declContext)_localctx).gn2 = match(Identifier);
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(304);
						match(T__1);
						setState(305);
						((Global_var_declContext)_localctx).gi2 = arith_expression();
						}
					}


					        Type _gt2 = (((Global_var_declContext)_localctx).gps2.depth > 0) ? Type.POINTER : _localctx._gbt;
					        String _gname2 = "@" + (((Global_var_declContext)_localctx).gn2!=null?((Global_var_declContext)_localctx).gn2.getText():null);
					        String _gzero2 = (_gt2 == Type.POINTER) ? "null"
					                       : (_gt2 == Type.FLOAT)   ? "0.0"
					                       : (_gt2 == Type.DOUBLE)  ? "0.0"
					                       : "0";
					        globalVarDecls.add(_gname2 + " = global " + llTy(_gt2) + " " + _gzero2);
					        Info _gi2 = (((Global_var_declContext)_localctx).gps2.depth > 0)
					                    ? new Info(_localctx._gbt, null, ((Global_var_declContext)_localctx).gps2.depth, _gname2)
					                    : new Info(_gt2, _gname2);
					        globalSymtab.put((((Global_var_declContext)_localctx).gn2!=null?((Global_var_declContext)_localctx).gn2.getText():null), _gi2);
					      
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_protoContext extends ParserRuleContext {
		public TypeContext type;
		public Ptr_starsContext ptr_stars;
		public Token fn;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Func_protoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_proto; }
	}

	public final Func_protoContext func_proto() throws RecognitionException {
		Func_protoContext _localctx = new Func_protoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_proto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((Func_protoContext)_localctx).type = type();
			setState(320);
			((Func_protoContext)_localctx).ptr_stars = ptr_stars();
			setState(321);
			((Func_protoContext)_localctx).fn = match(Identifier);
			setState(322);
			match(T__6);
			setState(323);
			params();
			setState(324);
			match(T__8);
			setState(325);
			match(T__4);

			        Type _rt = (((Func_protoContext)_localctx).ptr_stars.depth > 0) ? Type.POINTER : ((Func_protoContext)_localctx).type.attr_type;
			        functab.put((((Func_protoContext)_localctx).fn!=null?((Func_protoContext)_localctx).fn.getText():null), new Func(_rt, new ArrayList<Type>(curParamTypes)));
			        curParamTypes = new ArrayList<Type>();
			        curParamNames = new ArrayList<String>();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_defContext extends ParserRuleContext {
		public TypeContext type;
		public Ptr_starsContext ptr_stars;
		public Token fn2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			((Func_defContext)_localctx).type = type();
			setState(329);
			((Func_defContext)_localctx).ptr_stars = ptr_stars();
			setState(330);
			((Func_defContext)_localctx).fn2 = match(Identifier);
			setState(331);
			match(T__6);
			setState(332);
			params();
			setState(333);
			match(T__8);

			           Type _frt = (((Func_defContext)_localctx).ptr_stars.depth > 0) ? Type.POINTER : ((Func_defContext)_localctx).type.attr_type;
			           curRet  = _frt;
			           curName = (((Func_defContext)_localctx).fn2!=null?((Func_defContext)_localctx).fn2.getText():null);
			           functab.put(curName, new Func(curRet,
			                       new ArrayList<Type>(curParamTypes)));
			           beginFunction();
			        
			setState(335);
			match(T__0);
			setState(336);
			declarations();
			setState(337);
			statements();
			setState(338);
			match(T__3);

			           endFunction();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public TypeContext type;
		public Ptr_starsContext pps;
		public Token pn;
		public Ptr_starsContext pps2;
		public Token pn2;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<Ptr_starsContext> ptr_stars() {
			return getRuleContexts(Ptr_starsContext.class);
		}
		public Ptr_starsContext ptr_stars(int i) {
			return getRuleContext(Ptr_starsContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_params);
		 curParamTypes = new ArrayList<Type>();
		        curParamNames = new ArrayList<String>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & 19327353311L) != 0)) {
				{
				setState(341);
				((ParamsContext)_localctx).type = type();
				setState(342);
				((ParamsContext)_localctx).pps = ptr_stars();
				setState(343);
				((ParamsContext)_localctx).pn = match(Identifier);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(344);
					match(T__9);
					setState(345);
					match(T__10);
					}
				}


				            Type _pt = (((ParamsContext)_localctx).pps.depth > 0) ? Type.POINTER : ((ParamsContext)_localctx).type.attr_type;
				            curParamTypes.add(_pt);
				            curParamNames.add((((ParamsContext)_localctx).pn!=null?((ParamsContext)_localctx).pn.getText():null)); 
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(349);
					match(T__2);
					setState(350);
					((ParamsContext)_localctx).type = type();
					setState(351);
					((ParamsContext)_localctx).pps2 = ptr_stars();
					setState(352);
					((ParamsContext)_localctx).pn2 = match(Identifier);
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
						setState(353);
						match(T__9);
						setState(354);
						match(T__10);
						}
					}


					                Type _pt2 = (((ParamsContext)_localctx).pps2.depth > 0) ? Type.POINTER : ((ParamsContext)_localctx).type.attr_type;
					                curParamTypes.add(_pt2);
					                curParamNames.add((((ParamsContext)_localctx).pn2!=null?((ParamsContext)_localctx).pn2.getText():null)); 
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dim_listContext extends ParserRuleContext {
		public int[] dimArray;
		public Token d;
		public List<TerminalNode> Integer_constant() { return getTokens(myCompilerParser.Integer_constant); }
		public TerminalNode Integer_constant(int i) {
			return getToken(myCompilerParser.Integer_constant, i);
		}
		public Dim_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim_list; }
	}

	public final Dim_listContext dim_list() throws RecognitionException {
		Dim_listContext _localctx = new Dim_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dim_list);
		 ArrayList<Integer> _dims = new ArrayList<Integer>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(366);
				match(T__9);
				setState(367);
				((Dim_listContext)_localctx).d = match(Integer_constant);
				setState(368);
				match(T__10);
				 _dims.add(Integer.parseInt((((Dim_listContext)_localctx).d!=null?((Dim_listContext)_localctx).d.getText():null))); 
				}
				}
				setState(372); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );

			        ((Dim_listContext)_localctx).dimArray =  new int[_dims.size()];
			        for (int _i = 0; _i < _dims.size(); _i++) _localctx.dimArray[_i] = _dims.get(_i);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_listContext extends ParserRuleContext {
		public List<Init_elemContext> init_elem() {
			return getRuleContexts(Init_elemContext.class);
		}
		public Init_elemContext init_elem(int i) {
			return getRuleContext(Init_elemContext.class,i);
		}
		public Init_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_list; }
	}

	public final Init_listContext init_list() throws RecognitionException {
		Init_listContext _localctx = new Init_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_init_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			init_elem();
			setState(381);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(377);
					match(T__2);
					setState(378);
					init_elem();
					}
					} 
				}
				setState(383);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(384);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_elemContext extends ParserRuleContext {
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Init_valContext init_val() {
			return getRuleContext(Init_valContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Init_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_elem; }
	}

	public final Init_elemContext init_elem() throws RecognitionException {
		Init_elemContext _localctx = new Init_elemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_init_elem);
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(T__9);
				setState(388);
				arith_expression();
				setState(389);
				match(T__10);
				setState(390);
				match(T__1);
				setState(391);
				init_val();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				match(T__11);
				setState(394);
				match(Identifier);
				setState(395);
				match(T__1);
				setState(396);
				init_val();
				}
				break;
			case T__0:
			case T__6:
			case T__7:
			case T__24:
			case T__25:
			case T__33:
			case T__36:
			case T__37:
			case SIZEOF:
			case NULL_KW:
			case TRUE_KW:
			case FALSE_KW:
			case Identifier:
			case Floating_point_constant:
			case HexInteger:
			case LongLongConstant:
			case Integer_constant:
			case CharLit:
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				init_val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_valContext extends ParserRuleContext {
		public Init_listContext init_list() {
			return getRuleContext(Init_listContext.class,0);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Init_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_val; }
	}

	public final Init_valContext init_val() throws RecognitionException {
		Init_valContext _localctx = new Init_valContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_init_val);
		int _la;
		try {
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(T__0);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597398402L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 32313L) != 0)) {
					{
					setState(401);
					init_list();
					}
				}

				setState(404);
				match(T__3);
				}
				break;
			case T__6:
			case T__7:
			case T__24:
			case T__25:
			case T__33:
			case T__36:
			case T__37:
			case SIZEOF:
			case NULL_KW:
			case TRUE_KW:
			case FALSE_KW:
			case Identifier:
			case Floating_point_constant:
			case HexInteger:
			case LongLongConstant:
			case Integer_constant:
			case CharLit:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				arith_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public String _dSlot;
		public int _dDepth;
		public String _dStype;
		public Token stype;
		public Ptr_starsContext sps;
		public Token svar;
		public Arith_expressionContext sd_init;
		public Token chr_arr;
		public TypeContext type;
		public Token arr_name;
		public Dim_listContext dl;
		public Ptr_starsContext dps;
		public Token first;
		public Arith_expressionContext init1;
		public Ptr_starsContext mps;
		public Token more;
		public Arith_expressionContext initM;
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public List<Ptr_starsContext> ptr_stars() {
			return getRuleContexts(Ptr_starsContext.class);
		}
		public Ptr_starsContext ptr_stars(int i) {
			return getRuleContext(Ptr_starsContext.class,i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public Init_listContext init_list() {
			return getRuleContext(Init_listContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(myCompilerParser.CHAR, 0); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(myCompilerParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(myCompilerParser.STRING_LITERAL, i);
		}
		public TerminalNode CONST() { return getToken(myCompilerParser.CONST, 0); }
		public TerminalNode STATIC() { return getToken(myCompilerParser.STATIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Dim_listContext dim_list() {
			return getRuleContext(Dim_listContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarations);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(STRUCT);
				setState(409);
				((DeclarationsContext)_localctx).stype = match(Identifier);
				setState(410);
				((DeclarationsContext)_localctx).sps = ptr_stars();
				setState(411);
				((DeclarationsContext)_localctx).svar = match(Identifier);

				           ((DeclarationsContext)_localctx)._dDepth =  ((DeclarationsContext)_localctx).sps.depth; ((DeclarationsContext)_localctx)._dStype =  (((DeclarationsContext)_localctx).stype!=null?((DeclarationsContext)_localctx).stype.getText():null);
				           if (((DeclarationsContext)_localctx).sps.depth > 0) {
				              ((DeclarationsContext)_localctx)._dSlot =  newReg();
				              emit("  " + _localctx._dSlot + " = alloca ptr");
				              symtab.put((((DeclarationsContext)_localctx).svar!=null?((DeclarationsContext)_localctx).svar.getText():null), new Info(Type.STRUCT, (((DeclarationsContext)_localctx).stype!=null?((DeclarationsContext)_localctx).stype.getText():null), ((DeclarationsContext)_localctx).sps.depth, _localctx._dSlot));
				           } else {
				              ((DeclarationsContext)_localctx)._dSlot =  newReg();
				              emit("  " + _localctx._dSlot + " = alloca %struct." + (((DeclarationsContext)_localctx).stype!=null?((DeclarationsContext)_localctx).stype.getText():null));
				              symtab.put((((DeclarationsContext)_localctx).svar!=null?((DeclarationsContext)_localctx).svar.getText():null), new Info((((DeclarationsContext)_localctx).stype!=null?((DeclarationsContext)_localctx).stype.getText():null), _localctx._dSlot));
				           }
				        
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(413);
					match(T__1);
					setState(422);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
						{
						setState(414);
						match(T__0);
						setState(416);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597398402L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 32313L) != 0)) {
							{
							setState(415);
							init_list();
							}
						}

						setState(418);
						match(T__3);
						}
						break;
					case T__6:
					case T__7:
					case T__24:
					case T__25:
					case T__33:
					case T__36:
					case T__37:
					case SIZEOF:
					case NULL_KW:
					case TRUE_KW:
					case FALSE_KW:
					case Identifier:
					case Floating_point_constant:
					case HexInteger:
					case LongLongConstant:
					case Integer_constant:
					case CharLit:
						{
						setState(419);
						((DeclarationsContext)_localctx).sd_init = arith_expression();

						                      if (_localctx._dDepth > 0) {
						                         String _sdv = coerce(((DeclarationsContext)_localctx).sd_init.theInfo, Type.POINTER);
						                         emit("  store ptr " + _sdv + ", ptr " + _localctx._dSlot);
						                      }
						                  
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				setState(426);
				match(T__4);
				setState(427);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==STATIC) {
					{
					setState(429);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(432);
				match(CHAR);
				setState(433);
				((DeclarationsContext)_localctx).chr_arr = match(Identifier);
				setState(434);
				match(T__9);
				setState(435);
				match(T__10);
				setState(436);
				match(T__1);
				setState(438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(437);
					match(STRING_LITERAL);
					}
					}
					setState(440); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STRING_LITERAL );
				setState(442);
				match(T__4);

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
				           symtab.put((((DeclarationsContext)_localctx).chr_arr!=null?((DeclarationsContext)_localctx).chr_arr.getText():null), new Info(Type.CHAR, _sDims, _sSlot));
				        
				setState(444);
				declarations();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==STATIC) {
					{
					setState(445);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(448);
				((DeclarationsContext)_localctx).type = type();
				setState(449);
				((DeclarationsContext)_localctx).arr_name = match(Identifier);
				setState(450);
				((DeclarationsContext)_localctx).dl = dim_list();
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(451);
					match(T__1);
					setState(452);
					match(T__0);
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597398402L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 32313L) != 0)) {
						{
						setState(453);
						init_list();
						}
					}

					setState(456);
					match(T__3);
					}
				}

				setState(459);
				match(T__4);

				           if (symtab.containsKey((((DeclarationsContext)_localctx).arr_name!=null?((DeclarationsContext)_localctx).arr_name.getText():null))) {
				              System.out.println("Type Error: line " + ((DeclarationsContext)_localctx).arr_name.getLine()
				                                 + ": Redeclared identifier '" + (((DeclarationsContext)_localctx).arr_name!=null?((DeclarationsContext)_localctx).arr_name.getText():null) + "'.");
				              System.exit(0);
				           }
				           String arrTyStr = llArrayTy(((DeclarationsContext)_localctx).type.attr_type, ((DeclarationsContext)_localctx).dl.dimArray);
				           String slotA = newReg();
				           emit("  " + slotA + " = alloca " + arrTyStr);
				           emit("  call ptr @memset(ptr " + slotA + ", i32 0, i64 " + totalBytes(((DeclarationsContext)_localctx).type.attr_type, ((DeclarationsContext)_localctx).dl.dimArray) + ")");
				           symtab.put((((DeclarationsContext)_localctx).arr_name!=null?((DeclarationsContext)_localctx).arr_name.getText():null), new Info(((DeclarationsContext)_localctx).type.attr_type, ((DeclarationsContext)_localctx).dl.dimArray, slotA));
				        
				setState(461);
				declarations();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==STATIC) {
					{
					setState(463);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(466);
				((DeclarationsContext)_localctx).type = type();
				setState(467);
				((DeclarationsContext)_localctx).dps = ptr_stars();
				setState(468);
				((DeclarationsContext)_localctx).first = match(Identifier);

				           if (symtab.containsKey((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null))) {
				              System.out.println("Type Error: line " + ((DeclarationsContext)_localctx).first.getLine()
				                                 + ": Redeclared identifier '" + (((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null) + "'.");
				              System.exit(0);
				           }
				           Type _vt1 = (((DeclarationsContext)_localctx).dps.depth > 0) ? Type.POINTER : ((DeclarationsContext)_localctx).type.attr_type;
				           String slot1 = newReg();
				           emit("  " + slot1 + " = alloca " + llTy(_vt1));
				           Info _vi1 = (((DeclarationsContext)_localctx).dps.depth > 0)
				                       ? new Info(((DeclarationsContext)_localctx).type.attr_type, null, ((DeclarationsContext)_localctx).dps.depth, slot1)
				                       : new Info(_vt1, slot1);
				           symtab.put((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null), _vi1);
				        
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(470);
					match(T__1);
					setState(471);
					((DeclarationsContext)_localctx).init1 = arith_expression();

					               Type _vt1s = symtab.get((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null)).isPointer() ? Type.POINTER : ((DeclarationsContext)_localctx).type.attr_type;
					               String _iv = coerce(((DeclarationsContext)_localctx).init1.theInfo, _vt1s);
					               emit("  store " + llTy(_vt1s) + " " + _iv
					                    + ", ptr " + symtab.get((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null)).operand);
					               if (_vt1s != Type.POINTER)
					                  updateConstSlot(symtab.get((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null)).operand, new Info(_vt1s, _iv));
					           
					}
				}

				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(476);
					match(T__2);
					setState(477);
					((DeclarationsContext)_localctx).mps = ptr_stars();
					setState(478);
					((DeclarationsContext)_localctx).more = match(Identifier);

					           if (symtab.containsKey((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null))) {
					              System.out.println("Type Error: line " + ((DeclarationsContext)_localctx).more.getLine()
					                                 + ": Redeclared identifier '" + (((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null) + "'.");
					              System.exit(0);
					           }
					           Type _vtm = (((DeclarationsContext)_localctx).mps.depth > 0) ? Type.POINTER : ((DeclarationsContext)_localctx).type.attr_type;
					           String slot2 = newReg();
					           emit("  " + slot2 + " = alloca " + llTy(_vtm));
					           Info _vim = (((DeclarationsContext)_localctx).mps.depth > 0)
					                       ? new Info(((DeclarationsContext)_localctx).type.attr_type, null, ((DeclarationsContext)_localctx).mps.depth, slot2)
					                       : new Info(_vtm, slot2);
					           symtab.put((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null), _vim);
					        
					setState(484);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(480);
						match(T__1);
						setState(481);
						((DeclarationsContext)_localctx).initM = arith_expression();

						               Type _vtms = symtab.get((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null)).isPointer() ? Type.POINTER : ((DeclarationsContext)_localctx).type.attr_type;
						               String _mv = coerce(((DeclarationsContext)_localctx).initM.theInfo, _vtms);
						               emit("  store " + llTy(_vtms) + " " + _mv
						                    + ", ptr " + symtab.get((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null)).operand);
						               if (_vtms != Type.POINTER)
						                  updateConstSlot(symtab.get((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null)).operand, new Info(_vtms, _mv));
						           
						}
					}

					}
					}
					setState(490);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(491);
				match(T__4);
				setState(492);
				declarations();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type attr_type;
		public Token tdn;
		public TerminalNode INT() { return getToken(myCompilerParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(myCompilerParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(myCompilerParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(myCompilerParser.VOID, 0); }
		public TerminalNode CHAR() { return getToken(myCompilerParser.CHAR, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(myCompilerParser.BOOL_TYPE, 0); }
		public TerminalNode UNSIGNED() { return getToken(myCompilerParser.UNSIGNED, 0); }
		public List<TerminalNode> LONG() { return getTokens(myCompilerParser.LONG); }
		public TerminalNode LONG(int i) {
			return getToken(myCompilerParser.LONG, i);
		}
		public TerminalNode SHORT() { return getToken(myCompilerParser.SHORT, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				match(INT);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(499);
				match(FLOAT);
				 ((TypeContext)_localctx).attr_type =  Type.FLOAT;    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(DOUBLE);
				 ((TypeContext)_localctx).attr_type =  Type.DOUBLE;   
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(503);
				match(VOID);
				 ((TypeContext)_localctx).attr_type =  Type.VOID;     
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(505);
				match(CHAR);
				 ((TypeContext)_localctx).attr_type =  Type.CHAR;     
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(507);
				match(BOOL_TYPE);
				 ((TypeContext)_localctx).attr_type =  Type.BOOL;     
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(509);
				match(UNSIGNED);
				setState(510);
				match(LONG);
				setState(511);
				match(LONG);
				 ((TypeContext)_localctx).attr_type =  Type.LONGLONG; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(513);
				match(LONG);
				setState(514);
				match(LONG);
				 ((TypeContext)_localctx).attr_type =  Type.LONGLONG; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(516);
				match(UNSIGNED);
				setState(517);
				match(LONG);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(519);
				match(UNSIGNED);
				setState(520);
				match(INT);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(522);
				match(UNSIGNED);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(524);
				match(LONG);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(526);
				match(SHORT);
				 ((TypeContext)_localctx).attr_type =  Type.INT;      
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(528);
				((TypeContext)_localctx).tdn = match(Identifier);

					    Type _tt = typedefMap.get((((TypeContext)_localctx).tdn!=null?((TypeContext)_localctx).tdn.getText():null));
					    ((TypeContext)_localctx).attr_type =  (_tt != null) ? _tt : Type.INT;
					  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statements);
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case T__7:
			case T__22:
			case T__23:
			case INT:
			case FLOAT:
			case DOUBLE:
			case VOID:
			case CHAR:
			case LONG:
			case SHORT:
			case UNSIGNED:
			case IF:
			case WHILE:
			case RETURN:
			case STRUCT:
			case SWITCH:
			case BREAK:
			case FOR:
			case DO:
			case CONTINUE:
			case GOTO:
			case CONST:
			case STATIC:
			case BOOL_TYPE:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				statement();
				setState(533);
				statements();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TypeContext type;
		public Token st4_name;
		public Dim_listContext st4_dl;
		public Ptr_starsContext st3_ps;
		public Token st3_first;
		public Arith_expressionContext init3;
		public Ptr_starsContext st3_mps;
		public Token st3_more;
		public Arith_expressionContext initm3;
		public Token st2_type;
		public Ptr_starsContext st2_ps;
		public Token st2_var;
		public Arith_expressionContext st2_init;
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Inc_dec_stmtContext inc_dec_stmt() {
			return getRuleContext(Inc_dec_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Do_while_stmtContext do_while_stmt() {
			return getRuleContext(Do_while_stmtContext.class,0);
		}
		public Switch_stmtContext switch_stmt() {
			return getRuleContext(Switch_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Func_call_stmtContext func_call_stmt() {
			return getRuleContext(Func_call_stmtContext.class,0);
		}
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Continue_stmtContext continue_stmt() {
			return getRuleContext(Continue_stmtContext.class,0);
		}
		public Goto_stmtContext goto_stmt() {
			return getRuleContext(Goto_stmtContext.class,0);
		}
		public Labeled_stmtContext labeled_stmt() {
			return getRuleContext(Labeled_stmtContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public Dim_listContext dim_list() {
			return getRuleContext(Dim_listContext.class,0);
		}
		public TerminalNode CONST() { return getToken(myCompilerParser.CONST, 0); }
		public TerminalNode STATIC() { return getToken(myCompilerParser.STATIC, 0); }
		public Init_listContext init_list() {
			return getRuleContext(Init_listContext.class,0);
		}
		public List<Ptr_starsContext> ptr_stars() {
			return getRuleContexts(Ptr_starsContext.class);
		}
		public Ptr_starsContext ptr_stars(int i) {
			return getRuleContext(Ptr_starsContext.class,i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statement);
		int _la;
		try {
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				assign_stmt();
				setState(539);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(541);
				inc_dec_stmt();
				setState(542);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				if_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(545);
				while_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(546);
				for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(547);
				do_while_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(548);
				switch_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(549);
				return_stmt();
				setState(550);
				match(T__4);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(552);
				func_call_stmt();
				setState(553);
				match(T__4);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(555);
				block_stmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(556);
				break_stmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(557);
				continue_stmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(558);
				goto_stmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(559);
				labeled_stmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==STATIC) {
					{
					setState(560);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(563);
				((StatementContext)_localctx).type = type();
				setState(564);
				((StatementContext)_localctx).st4_name = match(Identifier);
				setState(565);
				((StatementContext)_localctx).st4_dl = dim_list();
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(566);
					match(T__1);
					setState(567);
					match(T__0);
					setState(569);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597398402L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 32313L) != 0)) {
						{
						setState(568);
						init_list();
						}
					}

					setState(571);
					match(T__3);
					}
				}

				setState(574);
				match(T__4);

					       String _aty = llArrayTy(((StatementContext)_localctx).type.attr_type, ((StatementContext)_localctx).st4_dl.dimArray);
					       String _aslot = newReg();
					       emit("  " + _aslot + " = alloca " + _aty);
					       emit("  call ptr @memset(ptr " + _aslot + ", i32 0, i64 " + totalBytes(((StatementContext)_localctx).type.attr_type, ((StatementContext)_localctx).st4_dl.dimArray) + ")");
					       symtab.put((((StatementContext)_localctx).st4_name!=null?((StatementContext)_localctx).st4_name.getText():null), new Info(((StatementContext)_localctx).type.attr_type, ((StatementContext)_localctx).st4_dl.dimArray, _aslot));
					  
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST || _la==STATIC) {
					{
					setState(577);
					_la = _input.LA(1);
					if ( !(_la==CONST || _la==STATIC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(580);
				((StatementContext)_localctx).type = type();
				setState(581);
				((StatementContext)_localctx).st3_ps = ptr_stars();
				setState(582);
				((StatementContext)_localctx).st3_first = match(Identifier);

					       Type _vt3 = (((StatementContext)_localctx).st3_ps.depth > 0) ? Type.POINTER : ((StatementContext)_localctx).type.attr_type;
					       String _slot3 = newReg();
					       emit("  " + _slot3 + " = alloca " + llTy(_vt3));
					       Info _vi3 = (((StatementContext)_localctx).st3_ps.depth > 0)
					                   ? new Info(((StatementContext)_localctx).type.attr_type, null, ((StatementContext)_localctx).st3_ps.depth, _slot3)
					                   : new Info(_vt3, _slot3);
					       symtab.put((((StatementContext)_localctx).st3_first!=null?((StatementContext)_localctx).st3_first.getText():null), _vi3);
					    
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(584);
					match(T__1);
					setState(585);
					((StatementContext)_localctx).init3 = arith_expression();

						           Type _vt3s = symtab.get((((StatementContext)_localctx).st3_first!=null?((StatementContext)_localctx).st3_first.getText():null)).isPointer() ? Type.POINTER : ((StatementContext)_localctx).type.attr_type;
						           String _iv3 = coerce(((StatementContext)_localctx).init3.theInfo, _vt3s);
						           emit("  store " + llTy(_vt3s) + " " + _iv3 + ", ptr " + symtab.get((((StatementContext)_localctx).st3_first!=null?((StatementContext)_localctx).st3_first.getText():null)).operand);
						       
					}
				}

				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(590);
					match(T__2);
					setState(591);
					((StatementContext)_localctx).st3_mps = ptr_stars();
					setState(592);
					((StatementContext)_localctx).st3_more = match(Identifier);

						           Type _vtm3 = (((StatementContext)_localctx).st3_mps.depth > 0) ? Type.POINTER : ((StatementContext)_localctx).type.attr_type;
						           String _slotm3 = newReg();
						           emit("  " + _slotm3 + " = alloca " + llTy(_vtm3));
						           symtab.put((((StatementContext)_localctx).st3_more!=null?((StatementContext)_localctx).st3_more.getText():null), (((StatementContext)_localctx).st3_mps.depth > 0)
						               ? new Info(((StatementContext)_localctx).type.attr_type, null, ((StatementContext)_localctx).st3_mps.depth, _slotm3)
						               : new Info(_vtm3, _slotm3));
						      
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__1) {
						{
						setState(594);
						match(T__1);
						setState(595);
						((StatementContext)_localctx).initm3 = arith_expression();

							              Type _vtms3 = symtab.get((((StatementContext)_localctx).st3_more!=null?((StatementContext)_localctx).st3_more.getText():null)).isPointer() ? Type.POINTER : ((StatementContext)_localctx).type.attr_type;
							              emit("  store " + llTy(_vtms3) + " " + coerce(((StatementContext)_localctx).initm3.theInfo, _vtms3)
							                   + ", ptr " + symtab.get((((StatementContext)_localctx).st3_more!=null?((StatementContext)_localctx).st3_more.getText():null)).operand);
							          
						}
					}

					}
					}
					setState(604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(605);
				match(T__4);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(607);
				match(STRUCT);
				setState(608);
				((StatementContext)_localctx).st2_type = match(Identifier);
				setState(609);
				((StatementContext)_localctx).st2_ps = ptr_stars();
				setState(610);
				((StatementContext)_localctx).st2_var = match(Identifier);

					       String _st2slot;
					       if (((StatementContext)_localctx).st2_ps.depth > 0) {
					          _st2slot = newReg();
					          emit("  " + _st2slot + " = alloca ptr");
					          symtab.put((((StatementContext)_localctx).st2_var!=null?((StatementContext)_localctx).st2_var.getText():null), new Info(Type.STRUCT, (((StatementContext)_localctx).st2_type!=null?((StatementContext)_localctx).st2_type.getText():null), ((StatementContext)_localctx).st2_ps.depth, _st2slot));
					       } else {
					          _st2slot = newReg();
					          emit("  " + _st2slot + " = alloca %struct." + (((StatementContext)_localctx).st2_type!=null?((StatementContext)_localctx).st2_type.getText():null));
					          symtab.put((((StatementContext)_localctx).st2_var!=null?((StatementContext)_localctx).st2_var.getText():null), new Info((((StatementContext)_localctx).st2_type!=null?((StatementContext)_localctx).st2_type.getText():null), _st2slot));
					       }
					       int _st2depth = ((StatementContext)_localctx).st2_ps.depth;
					    
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(612);
					match(T__1);
					setState(621);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
						{
						setState(613);
						match(T__0);
						setState(615);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597398402L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 32313L) != 0)) {
							{
							setState(614);
							init_list();
							}
						}

						setState(617);
						match(T__3);
						}
						break;
					case T__6:
					case T__7:
					case T__24:
					case T__25:
					case T__33:
					case T__36:
					case T__37:
					case SIZEOF:
					case NULL_KW:
					case TRUE_KW:
					case FALSE_KW:
					case Identifier:
					case Floating_point_constant:
					case HexInteger:
					case LongLongConstant:
					case Integer_constant:
					case CharLit:
						{
						setState(618);
						((StatementContext)_localctx).st2_init = arith_expression();

							                  if (_st2depth > 0) {
							                     String _st2v = coerce(((StatementContext)_localctx).st2_init.theInfo, Type.POINTER);
							                     emit("  store ptr " + _st2v + ", ptr " + symtab.get((((StatementContext)_localctx).st2_var!=null?((StatementContext)_localctx).st2_var.getText():null)).operand);
							                  }
							              
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				setState(625);
				match(T__4);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(627);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_stmtContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Block_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stmt; }
	}

	public final Block_stmtContext block_stmt() throws RecognitionException {
		Block_stmtContext _localctx = new Block_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_block_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(T__0);
			setState(631);
			statements();
			setState(632);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_stmtContext extends ParserRuleContext {
		public ArrayList<String> idxOps;
		public Token arr;
		public Arith_expressionContext ai;
		public Token aop;
		public Arith_expressionContext rhs;
		public Token obj;
		public Token field;
		public Token sop;
		public Arith_expressionContext rhs2;
		public Token strVar;
		public Token sl;
		public Token dp_id;
		public Arith_expressionContext dp_rhs;
		public Token arw2;
		public Token arwF2;
		public Token asop;
		public Arith_expressionContext arw2_rhs;
		public Token lhsId;
		public Token op;
		public Arith_expressionContext arith_expression;
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public TerminalNode STRING_LITERAL() { return getToken(myCompilerParser.STRING_LITERAL, 0); }
		public TerminalNode ARROW() { return getToken(myCompilerParser.ARROW, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assign_stmt);
		 ((Assign_stmtContext)_localctx).idxOps =  new ArrayList<String>(); 
		int _la;
		try {
			setState(677);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				((Assign_stmtContext)_localctx).arr = match(Identifier);
				setState(640); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(635);
					match(T__9);
					setState(636);
					((Assign_stmtContext)_localctx).ai = arith_expression();
					setState(637);
					match(T__10);
					 _localctx.idxOps.add(((Assign_stmtContext)_localctx).ai.theInfo.operand); 
					}
					}
					setState(642); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(644);
				((Assign_stmtContext)_localctx).aop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380420L) != 0)) ) {
					((Assign_stmtContext)_localctx).aop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(645);
				((Assign_stmtContext)_localctx).rhs = arith_expression();

				           Info arrInfo = lookup((((Assign_stmtContext)_localctx).arr!=null?((Assign_stmtContext)_localctx).arr.getText():null));
				           if (arrInfo == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).arr.getLine()
				                                 + ": Undeclared identifier '" + (((Assign_stmtContext)_localctx).arr!=null?((Assign_stmtContext)_localctx).arr.getText():null) + "'.");
				              System.exit(0);
				           }
				           String arrTy = llArrayTy(arrInfo.elemType, arrInfo.dims);
				           String arrPtr = gepArray(arrInfo.operand, arrTy, _localctx.idxOps);
				           String _aopText = ((Assign_stmtContext)_localctx).aop.getText();
				           String val;
				           if (_aopText.equals("=")) {
				              val = coerce(((Assign_stmtContext)_localctx).rhs.theInfo, arrInfo.elemType);
				           } else {
				              String _loaded = newReg();
				              emit("  " + _loaded + " = load " + llTy(arrInfo.elemType) + ", ptr " + arrPtr);
				              Info _cur = new Info(arrInfo.elemType, _loaded);
				              String _base = _aopText.substring(0, _aopText.length()-1);
				              Info _res = (_base.equals("&")||_base.equals("|")||_base.equals("^")||_base.equals("<<")||_base.equals(">>"))
				                          ? bitOp(_base, _cur, ((Assign_stmtContext)_localctx).rhs.theInfo)
				                          : binArith(_base, _cur, ((Assign_stmtContext)_localctx).rhs.theInfo);
				              val = coerce(_res, arrInfo.elemType);
				           }
				           emit("  store " + llTy(arrInfo.elemType) + " " + val + ", ptr " + arrPtr);
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(648);
				((Assign_stmtContext)_localctx).obj = match(Identifier);
				setState(649);
				match(T__11);
				setState(650);
				((Assign_stmtContext)_localctx).field = match(Identifier);
				setState(651);
				((Assign_stmtContext)_localctx).sop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380420L) != 0)) ) {
					((Assign_stmtContext)_localctx).sop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(652);
				((Assign_stmtContext)_localctx).rhs2 = arith_expression();

				           Info objInfo = lookup((((Assign_stmtContext)_localctx).obj!=null?((Assign_stmtContext)_localctx).obj.getText():null));
				           if (objInfo == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).obj.getLine()
				                                 + ": Undeclared identifier '" + (((Assign_stmtContext)_localctx).obj!=null?((Assign_stmtContext)_localctx).obj.getText():null) + "'.");
				              System.exit(0);
				           }
				           int fidx = getFieldIdx(objInfo.structName, (((Assign_stmtContext)_localctx).field!=null?((Assign_stmtContext)_localctx).field.getText():null));
				           ArrayList<StructField> flds = structDefs.get(objInfo.structName);
				           Type ft = flds.get(fidx).t;
				           String sptr = gepStruct(objInfo.operand, objInfo.structName, fidx);
				           String _sopText = ((Assign_stmtContext)_localctx).sop.getText();
				           String val2;
				           if (_sopText.equals("=")) {
				              val2 = coerce(((Assign_stmtContext)_localctx).rhs2.theInfo, ft);
				           } else {
				              String _loaded2 = newReg();
				              emit("  " + _loaded2 + " = load " + llTy(ft) + ", ptr " + sptr);
				              Info _cur2 = new Info(ft, _loaded2);
				              String _base2 = _sopText.substring(0, _sopText.length()-1);
				              Info _res2 = (_base2.equals("&")||_base2.equals("|")||_base2.equals("^")||_base2.equals("<<")||_base2.equals(">>"))
				                           ? bitOp(_base2, _cur2, ((Assign_stmtContext)_localctx).rhs2.theInfo)
				                           : binArith(_base2, _cur2, ((Assign_stmtContext)_localctx).rhs2.theInfo);
				              val2 = coerce(_res2, ft);
				           }
				           emit("  store " + llTy(ft) + " " + val2 + ", ptr " + sptr);
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(655);
				((Assign_stmtContext)_localctx).strVar = match(Identifier);
				setState(656);
				match(T__1);
				setState(657);
				((Assign_stmtContext)_localctx).sl = match(STRING_LITERAL);

				           Info strInfo = lookup((((Assign_stmtContext)_localctx).strVar!=null?((Assign_stmtContext)_localctx).strVar.getText():null));
				           if (strInfo == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).strVar.getLine()
				                                 + ": Undeclared identifier '" + (((Assign_stmtContext)_localctx).strVar!=null?((Assign_stmtContext)_localctx).strVar.getText():null) + "'.");
				              System.exit(0);
				           }
				           ArrayList<String> _z = new ArrayList<>();
				           _z.add("0");
				           String _dest = gepArray(strInfo.operand, llArrayTy(Type.CHAR, strInfo.dims), _z);
				           String _src = makeStringGlobal((((Assign_stmtContext)_localctx).sl!=null?((Assign_stmtContext)_localctx).sl.getText():null));
				           String _r = newReg();
				           emit("  " + _r + " = call ptr @strcpy(ptr " + _dest + ", ptr " + _src + ")");
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(659);
				match(T__7);
				setState(660);
				((Assign_stmtContext)_localctx).dp_id = match(Identifier);
				setState(661);
				match(T__1);
				setState(662);
				((Assign_stmtContext)_localctx).dp_rhs = arith_expression();

				           Info _dpi = lookup((((Assign_stmtContext)_localctx).dp_id!=null?((Assign_stmtContext)_localctx).dp_id.getText():null));
				           if (_dpi == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).dp_id.getLine()
				                                 + ": Undeclared identifier '" + (((Assign_stmtContext)_localctx).dp_id!=null?((Assign_stmtContext)_localctx).dp_id.getText():null) + "'.");
				              System.exit(0);
				           }
				           // Load the ptr value from its slot, then store through it
				           String _dpptr = newReg();
				           emit("  " + _dpptr + " = load ptr, ptr " + _dpi.operand);
				           Type _dpet = (_dpi.elemType != null && _dpi.elemType != Type.ERR) ? _dpi.elemType : Type.INT;
				           String _dpv = coerce(((Assign_stmtContext)_localctx).dp_rhs.theInfo, _dpet);
				           emit("  store " + llTy(_dpet) + " " + _dpv + ", ptr " + _dpptr);
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(665);
				((Assign_stmtContext)_localctx).arw2 = match(Identifier);
				setState(666);
				match(ARROW);
				setState(667);
				((Assign_stmtContext)_localctx).arwF2 = match(Identifier);
				setState(668);
				((Assign_stmtContext)_localctx).asop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380420L) != 0)) ) {
					((Assign_stmtContext)_localctx).asop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(669);
				((Assign_stmtContext)_localctx).arw2_rhs = arith_expression();

				           Info arw2Info = lookup((((Assign_stmtContext)_localctx).arw2!=null?((Assign_stmtContext)_localctx).arw2.getText():null));
				           if (arw2Info == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).arw2.getLine()
				                                 + ": Undeclared identifier '" + (((Assign_stmtContext)_localctx).arw2!=null?((Assign_stmtContext)_localctx).arw2.getText():null) + "'.");
				              System.exit(0);
				           }
				           String _a2ptr = newReg();
				           emit("  " + _a2ptr + " = load ptr, ptr " + arw2Info.operand);
				           String _sn2 = arw2Info.structName;
				           int _fi2 = getFieldIdx(_sn2, (((Assign_stmtContext)_localctx).arwF2!=null?((Assign_stmtContext)_localctx).arwF2.getText():null));
				           ArrayList<StructField> _fls2 = structDefs.get(_sn2);
				           Type _ft2 = _fls2.get(_fi2).t;
				           String _fptr2 = newReg();
				           emit("  " + _fptr2 + " = getelementptr %struct." + _sn2
				                + ", ptr " + _a2ptr + ", i32 0, i32 " + _fi2);
				           String _asopTxt = ((Assign_stmtContext)_localctx).asop.getText();
				           String _a2v;
				           if (_asopTxt.equals("=")) {
				              _a2v = coerce(((Assign_stmtContext)_localctx).arw2_rhs.theInfo, _ft2);
				           } else {
				              String _ld2 = newReg();
				              emit("  " + _ld2 + " = load " + llTy(_ft2) + ", ptr " + _fptr2);
				              Info _cur2 = new Info(_ft2, _ld2);
				              String _base2 = _asopTxt.substring(0, _asopTxt.length()-1);
				              Info _res2 = (_base2.equals("&")||_base2.equals("|")||_base2.equals("^")||_base2.equals("<<")||_base2.equals(">>"))
				                           ? bitOp(_base2, _cur2, ((Assign_stmtContext)_localctx).arw2_rhs.theInfo)
				                           : binArith(_base2, _cur2, ((Assign_stmtContext)_localctx).arw2_rhs.theInfo);
				              _a2v = coerce(_res2, _ft2);
				           }
				           emit("  store " + llTy(_ft2) + " " + _a2v + ", ptr " + _fptr2);
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(672);
				((Assign_stmtContext)_localctx).lhsId = match(Identifier);
				setState(673);
				((Assign_stmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380420L) != 0)) ) {
					((Assign_stmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(674);
				((Assign_stmtContext)_localctx).arith_expression = arith_expression();

				           Info lhs = lookup((((Assign_stmtContext)_localctx).lhsId!=null?((Assign_stmtContext)_localctx).lhsId.getText():null));
				           if (lhs == null) {
				              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).lhsId.getLine()
				                                 + ": Undeclared identifier '"
				                                 + (((Assign_stmtContext)_localctx).lhsId!=null?((Assign_stmtContext)_localctx).lhsId.getText():null) + "'.");
				              System.exit(0);
				           }
				           String opText = ((Assign_stmtContext)_localctx).op.getText();
				           String v;
				           if (opText.equals("=")) {
				              v = coerce(((Assign_stmtContext)_localctx).arith_expression.theInfo, lhs.theType);
				           } else {
				              Info curInfo = smartLoad(lhs.operand, lhs.theType);
				              String baseOp = opText.substring(0, opText.length() - 1);
				              Info result;
				              if (baseOp.equals("&") || baseOp.equals("|") || baseOp.equals("^")
				                  || baseOp.equals("<<") || baseOp.equals(">>")) {
				                 result = bitOp(baseOp, curInfo, ((Assign_stmtContext)_localctx).arith_expression.theInfo);
				              } else {
				                 result = binArith(baseOp, curInfo, ((Assign_stmtContext)_localctx).arith_expression.theInfo);
				              }
				              v = coerce(result, lhs.theType);
				           }
				           emit("  store " + llTy(lhs.theType) + " " + v + ", ptr " + lhs.operand);
				           updateConstSlot(lhs.operand, new Info(lhs.theType, v));
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends ParserRuleContext {
		public Arith_expressionContext arith_expression;
		public TerminalNode RETURN() { return getToken(myCompilerParser.RETURN, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_return_stmt);
		try {
			setState(685);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				match(RETURN);
				setState(680);
				((Return_stmtContext)_localctx).arith_expression = arith_expression();

				           String v = coerce(((Return_stmtContext)_localctx).arith_expression.theInfo,
				                             curName.equals("main") ? Type.INT : curRet);
				           emit("  ret " + llTy(curName.equals("main") ? Type.INT : curRet)
				                + " " + v);
				           // open a fresh (dead) block so any following code stays legal
				           emit(newLabel() + ":");
				           constSlot.clear();
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(683);
				match(RETURN);

				           emit("  ret void");
				           emit(newLabel() + ":");
				           constSlot.clear();
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Inc_dec_stmtContext extends ParserRuleContext {
		public Token Identifier;
		public Token op;
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Inc_dec_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec_stmt; }
	}

	public final Inc_dec_stmtContext inc_dec_stmt() throws RecognitionException {
		Inc_dec_stmtContext _localctx = new Inc_dec_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_inc_dec_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(687);
				((Inc_dec_stmtContext)_localctx).Identifier = match(Identifier);
				setState(688);
				((Inc_dec_stmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
					((Inc_dec_stmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__22:
			case T__23:
				{
				setState(689);
				((Inc_dec_stmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
					((Inc_dec_stmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(690);
				((Inc_dec_stmtContext)_localctx).Identifier = match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        String idName = (((Inc_dec_stmtContext)_localctx).Identifier!=null?((Inc_dec_stmtContext)_localctx).Identifier.getText():null);
			        Info varInfo = lookup(idName);
			        if (varInfo == null) {
			            System.out.println("Type error: line " + ((Inc_dec_stmtContext)_localctx).Identifier.getLine() + ": Undeclared identifier '" + idName + "'.");
			            System.exit(0);
			        }

			        // Load current value — use constSlot if available (enables constant folding)
			        Info curInfo = smartLoad(varInfo.operand, varInfo.theType);
			        Info oneInfo = (varInfo.theType == Type.FLOAT)
			                       ? new Info(Type.FLOAT, fltHex(1.0f))
			                       : new Info(Type.INT, "1");
			        String deltaOp = ((Inc_dec_stmtContext)_localctx).op.getText().equals("++") ? "+" : "-";
			        Info newValInfo = binArith(deltaOp, curInfo, oneInfo);
			        String storeVal = coerce(newValInfo, varInfo.theType);
			        emit("  store " + llTy(varInfo.theType) + " " + storeVal + ", ptr " + varInfo.operand);
			        updateConstSlot(varInfo.operand, new Info(varInfo.theType, storeVal));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public String lThen;
		public String lElse;
		public String lEnd;
		public Arith_expressionContext ie;
		public TerminalNode IF() { return getToken(myCompilerParser.IF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(myCompilerParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			match(IF);
			setState(696);
			match(T__6);
			setState(697);
			((If_stmtContext)_localctx).ie = arith_expression();
			setState(698);
			match(T__8);

			           ((If_stmtContext)_localctx).lThen =  newLabel(); ((If_stmtContext)_localctx).lElse =  newLabel(); ((If_stmtContext)_localctx).lEnd =  newLabel();
			           Info _ic = truth(((If_stmtContext)_localctx).ie.theInfo);
			           emit("  br i1 " + _ic.operand
			                + ", label %" + _localctx.lThen + ", label %" + _localctx.lElse);
			           emit(_localctx.lThen + ":");
			           constSlot.clear();
			        
			setState(700);
			statement();

			           emit("  br label %" + _localctx.lEnd);
			           emit(_localctx.lElse + ":");
			           constSlot.clear();
			        
			setState(704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(702);
				match(ELSE);
				setState(703);
				statement();
				}
				break;
			}

			           emit("  br label %" + _localctx.lEnd);
			           emit(_localctx.lEnd + ":");
			           constSlot.clear();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public String lCond;
		public String lBody;
		public String lEnd;
		public Arith_expressionContext we;
		public TerminalNode WHILE() { return getToken(myCompilerParser.WHILE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(WHILE);

			           ((While_stmtContext)_localctx).lCond =  newLabel(); ((While_stmtContext)_localctx).lBody =  newLabel(); ((While_stmtContext)_localctx).lEnd =  newLabel();
			           emit("  br label %" + _localctx.lCond);
			           emit(_localctx.lCond + ":");
			           constSlot.clear();
			           breakStack.push(_localctx.lEnd);
			           continueStack.push(_localctx.lCond);
			        
			setState(710);
			match(T__6);
			setState(711);
			((While_stmtContext)_localctx).we = arith_expression();
			setState(712);
			match(T__8);

			           Info _wc = truth(((While_stmtContext)_localctx).we.theInfo);
			           emit("  br i1 " + _wc.operand
			                + ", label %" + _localctx.lBody + ", label %" + _localctx.lEnd);
			           emit(_localctx.lBody + ":");
			        
			setState(714);
			statement();

			           emit("  br label %" + _localctx.lCond);
			           emit(_localctx.lEnd + ":");
			           breakStack.pop();
			           continueStack.pop();
			           constSlot.clear();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(myCompilerParser.BREAK, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			match(BREAK);
			setState(718);
			match(T__4);

			        if (!breakStack.isEmpty()) {
			            emit("  br label %" + breakStack.peek());
			            emit(newLabel() + ":");
			            constSlot.clear();
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Continue_stmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(myCompilerParser.CONTINUE, 0); }
		public Continue_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_stmt; }
	}

	public final Continue_stmtContext continue_stmt() throws RecognitionException {
		Continue_stmtContext _localctx = new Continue_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_continue_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			match(CONTINUE);
			setState(722);
			match(T__4);

			        if (!continueStack.isEmpty()) {
			            emit("  br label %" + continueStack.peek());
			            emit(newLabel() + ":");
			            constSlot.clear();
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Goto_stmtContext extends ParserRuleContext {
		public Token lbl;
		public TerminalNode GOTO() { return getToken(myCompilerParser.GOTO, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Goto_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goto_stmt; }
	}

	public final Goto_stmtContext goto_stmt() throws RecognitionException {
		Goto_stmtContext _localctx = new Goto_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_goto_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			match(GOTO);
			setState(726);
			((Goto_stmtContext)_localctx).lbl = match(Identifier);
			setState(727);
			match(T__4);

			        String _gl = gotoLabelFor((((Goto_stmtContext)_localctx).lbl!=null?((Goto_stmtContext)_localctx).lbl.getText():null));
			        emit("  br label %" + _gl);
			        emit(newLabel() + ":");
			        constSlot.clear();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Labeled_stmtContext extends ParserRuleContext {
		public String _ll;
		public Token lbl;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Labeled_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeled_stmt; }
	}

	public final Labeled_stmtContext labeled_stmt() throws RecognitionException {
		Labeled_stmtContext _localctx = new Labeled_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_labeled_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			((Labeled_stmtContext)_localctx).lbl = match(Identifier);
			setState(731);
			match(T__5);

			        ((Labeled_stmtContext)_localctx)._ll =  gotoLabelFor((((Labeled_stmtContext)_localctx).lbl!=null?((Labeled_stmtContext)_localctx).lbl.getText():null));
			        emit("  br label %" + _localctx._ll);
			        emit(_localctx._ll + ":");
			        constSlot.clear();
			    
			setState(733);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_stmtContext extends ParserRuleContext {
		public String lCond;
		public String lBody;
		public String lUpdate;
		public String lEnd;
		public int updateStart;
		public Arith_expressionContext fe;
		public StatementContext body_stmt;
		public TerminalNode FOR() { return getToken(myCompilerParser.FOR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public For_updateContext for_update() {
			return getRuleContext(For_updateContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(FOR);

			        ((For_stmtContext)_localctx).lCond =  newLabel();
			        ((For_stmtContext)_localctx).lBody =  newLabel();
			        ((For_stmtContext)_localctx).lUpdate =  newLabel();
			        ((For_stmtContext)_localctx).lEnd =  newLabel();
			    
			setState(737);
			match(T__6);
			setState(742);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__22:
			case T__23:
			case INT:
			case FLOAT:
			case DOUBLE:
			case VOID:
			case CHAR:
			case LONG:
			case SHORT:
			case UNSIGNED:
			case BOOL_TYPE:
			case Identifier:
				{
				setState(738);
				for_init();
				setState(739);
				match(T__4);
				}
				break;
			case T__4:
				{
				setState(741);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			            emit("  br label %" + _localctx.lCond);
			            emit(_localctx.lCond + ":");
			            constSlot.clear();
			            breakStack.push(_localctx.lEnd);
			            continueStack.push(_localctx.lUpdate);
			        
			setState(749);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case T__24:
			case T__25:
			case T__33:
			case T__36:
			case T__37:
			case SIZEOF:
			case NULL_KW:
			case TRUE_KW:
			case FALSE_KW:
			case Identifier:
			case Floating_point_constant:
			case HexInteger:
			case LongLongConstant:
			case Integer_constant:
			case CharLit:
				{
				setState(745);
				((For_stmtContext)_localctx).fe = arith_expression();

				            Info _fc = truth(((For_stmtContext)_localctx).fe.theInfo);
				            emit("  br i1 " + _fc.operand
				                 + ", label %" + _localctx.lBody + ", label %" + _localctx.lEnd);
				          
				}
				break;
			case T__4:
				{
				 emit("  br label %" + _localctx.lBody); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(751);
			match(T__4);

			            // Capture start index so we can relocate update code after body.
			            ((For_stmtContext)_localctx).updateStart =  TextCode.size();
			            emit(_localctx.lUpdate + ":");
			        
			setState(754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25166080L) != 0) || _la==Identifier) {
				{
				setState(753);
				for_update();
				}
			}


			            // Rip update code out and save it; re-emit it later after the body.
			            ArrayList<String> _upd = new ArrayList<>();
			            for (int _i = _localctx.updateStart; _i < TextCode.size(); _i++)
			                _upd.add(TextCode.get(_i));
			            while (TextCode.size() > _localctx.updateStart) TextCode.remove(TextCode.size() - 1);
			            emit(_localctx.lBody + ":");
			            // store update code for emit after body
			            // (use a temporary list; close over with final var trick)
			            final ArrayList<String> _updFinal = _upd;
			            // We cannot close over non-final; just store in a grammar local via a workaround:
			            // emit body, then re-inject.  ANTLR doesn't support lambda captures, so we use
			            // the TextCode trick: leave a sentinel placeholder we fill in below.
			            // SIMPLER: just emit the body inline and add update after.
			            // We'll defer by storing in a member field.
			            pendingUpdate = _updFinal;
			        
			setState(757);
			match(T__8);
			setState(758);
			((For_stmtContext)_localctx).body_stmt = statement();

			        emit("  br label %" + _localctx.lUpdate);
			        for (String _s : pendingUpdate) TextCode.add(_s);
			        pendingUpdate = null;
			        emit("  br label %" + _localctx.lCond);
			        emit(_localctx.lEnd + ":");
			        breakStack.pop();
			        continueStack.pop();
			        constSlot.clear();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_initContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Inc_dec_stmtContext inc_dec_stmt() {
			return getRuleContext(Inc_dec_stmtContext.class,0);
		}
		public For_declContext for_decl() {
			return getRuleContext(For_declContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_for_init);
		try {
			setState(764);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(761);
				assign_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(762);
				inc_dec_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(763);
				for_decl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_updateContext extends ParserRuleContext {
		public List<Assign_stmtContext> assign_stmt() {
			return getRuleContexts(Assign_stmtContext.class);
		}
		public Assign_stmtContext assign_stmt(int i) {
			return getRuleContext(Assign_stmtContext.class,i);
		}
		public List<Inc_dec_stmtContext> inc_dec_stmt() {
			return getRuleContexts(Inc_dec_stmtContext.class);
		}
		public Inc_dec_stmtContext inc_dec_stmt(int i) {
			return getRuleContext(Inc_dec_stmtContext.class,i);
		}
		public For_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_update; }
	}

	public final For_updateContext for_update() throws RecognitionException {
		For_updateContext _localctx = new For_updateContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_for_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(766);
				assign_stmt();
				}
				break;
			case 2:
				{
				setState(767);
				inc_dec_stmt();
				}
				break;
			}
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(770);
				match(T__2);
				setState(773);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(771);
					assign_stmt();
					}
					break;
				case 2:
					{
					setState(772);
					inc_dec_stmt();
					}
					break;
				}
				}
				}
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_declContext extends ParserRuleContext {
		public Type _fdt;
		public TypeContext type;
		public Ptr_starsContext dps3;
		public Token fd_first;
		public Arith_expressionContext fe1;
		public Token fd_more;
		public Arith_expressionContext fe2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public For_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_decl; }
	}

	public final For_declContext for_decl() throws RecognitionException {
		For_declContext _localctx = new For_declContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_for_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
			((For_declContext)_localctx).type = type();
			setState(781);
			((For_declContext)_localctx).dps3 = ptr_stars();
			setState(782);
			((For_declContext)_localctx).fd_first = match(Identifier);

			        Type _vt3 = (((For_declContext)_localctx).dps3.depth > 0) ? Type.POINTER : ((For_declContext)_localctx).type.attr_type;
			        ((For_declContext)_localctx)._fdt =  _vt3;
			        String _fs1 = newReg();
			        emit("  " + _fs1 + " = alloca " + llTy(_vt3));
			        Info _fvi1 = (((For_declContext)_localctx).dps3.depth > 0)
			                     ? new Info(((For_declContext)_localctx).type.attr_type, null, ((For_declContext)_localctx).dps3.depth, _fs1)
			                     : new Info(_vt3, _fs1);
			        symtab.put((((For_declContext)_localctx).fd_first!=null?((For_declContext)_localctx).fd_first.getText():null), _fvi1);
			    
			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(784);
				match(T__1);
				setState(785);
				((For_declContext)_localctx).fe1 = arith_expression();

				        String _fiv1 = coerce(((For_declContext)_localctx).fe1.theInfo, _localctx._fdt);
				        emit("  store " + llTy(_localctx._fdt) + " " + _fiv1 + ", ptr " + symtab.get((((For_declContext)_localctx).fd_first!=null?((For_declContext)_localctx).fd_first.getText():null)).operand);
				    
				}
			}

			setState(801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(790);
				match(T__2);
				setState(791);
				((For_declContext)_localctx).fd_more = match(Identifier);

				        String _fs2 = newReg();
				        emit("  " + _fs2 + " = alloca " + llTy(_localctx._fdt));
				        symtab.put((((For_declContext)_localctx).fd_more!=null?((For_declContext)_localctx).fd_more.getText():null), new Info(_localctx._fdt, _fs2));
				    
				setState(797);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(793);
					match(T__1);
					setState(794);
					((For_declContext)_localctx).fe2 = arith_expression();

					        String _fiv2 = coerce(((For_declContext)_localctx).fe2.theInfo, _localctx._fdt);
					        emit("  store " + llTy(_localctx._fdt) + " " + _fiv2 + ", ptr " + symtab.get((((For_declContext)_localctx).fd_more!=null?((For_declContext)_localctx).fd_more.getText():null)).operand);
					    
					}
				}

				}
				}
				setState(803);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Do_while_stmtContext extends ParserRuleContext {
		public String lBody;
		public String lCond;
		public String lEnd;
		public Arith_expressionContext dwe;
		public TerminalNode DO() { return getToken(myCompilerParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(myCompilerParser.WHILE, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Do_while_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_stmt; }
	}

	public final Do_while_stmtContext do_while_stmt() throws RecognitionException {
		Do_while_stmtContext _localctx = new Do_while_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_do_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(DO);

			        ((Do_while_stmtContext)_localctx).lBody =  newLabel();
			        ((Do_while_stmtContext)_localctx).lCond =  newLabel();
			        ((Do_while_stmtContext)_localctx).lEnd =  newLabel();
			        emit("  br label %" + _localctx.lBody);
			        emit(_localctx.lBody + ":");
			        constSlot.clear();
			        breakStack.push(_localctx.lEnd);
			        continueStack.push(_localctx.lCond);
			    
			setState(806);
			statement();

			        // End of body: branch to lCond. Place lCond: BEFORE parsing condition so
			        // that 'continue' jumps to the start of condition evaluation (SSA safe).
			        emit("  br label %" + _localctx.lCond);
			        emit(_localctx.lCond + ":");
			        constSlot.clear();
			    
			setState(808);
			match(WHILE);
			setState(809);
			match(T__6);
			setState(810);
			((Do_while_stmtContext)_localctx).dwe = arith_expression();
			setState(811);
			match(T__8);
			setState(812);
			match(T__4);

			        Info _dc = truth(((Do_while_stmtContext)_localctx).dwe.theInfo);
			        emit("  br i1 " + _dc.operand
			             + ", label %" + _localctx.lBody + ", label %" + _localctx.lEnd);
			        emit(_localctx.lEnd + ":");
			        breakStack.pop();
			        continueStack.pop();
			        constSlot.clear();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_valContext extends ParserRuleContext {
		public int theVal;
		public Token Integer_constant;
		public Token HexInteger;
		public Token CharLit;
		public Token cid;
		public TerminalNode Integer_constant() { return getToken(myCompilerParser.Integer_constant, 0); }
		public TerminalNode HexInteger() { return getToken(myCompilerParser.HexInteger, 0); }
		public TerminalNode CharLit() { return getToken(myCompilerParser.CharLit, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Case_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_val; }
	}

	public final Case_valContext case_val() throws RecognitionException {
		Case_valContext _localctx = new Case_valContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_case_val);
		try {
			setState(826);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer_constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(815);
				((Case_valContext)_localctx).Integer_constant = match(Integer_constant);
				 ((Case_valContext)_localctx).theVal =  Integer.parseInt((((Case_valContext)_localctx).Integer_constant!=null?((Case_valContext)_localctx).Integer_constant.getText():null)); 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(817);
				match(T__24);
				setState(818);
				((Case_valContext)_localctx).Integer_constant = match(Integer_constant);
				 ((Case_valContext)_localctx).theVal =  -Integer.parseInt((((Case_valContext)_localctx).Integer_constant!=null?((Case_valContext)_localctx).Integer_constant.getText():null)); 
				}
				break;
			case HexInteger:
				enterOuterAlt(_localctx, 3);
				{
				setState(820);
				((Case_valContext)_localctx).HexInteger = match(HexInteger);
				 ((Case_valContext)_localctx).theVal =  (int) Long.parseLong(
				          (((Case_valContext)_localctx).HexInteger!=null?((Case_valContext)_localctx).HexInteger.getText():null).replaceAll("[uUlL]+$","").substring(2), 16); 
				}
				break;
			case CharLit:
				enterOuterAlt(_localctx, 4);
				{
				setState(822);
				((Case_valContext)_localctx).CharLit = match(CharLit);
				 ((Case_valContext)_localctx).theVal =  charVal((((Case_valContext)_localctx).CharLit!=null?((Case_valContext)_localctx).CharLit.getText():null)); 
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(824);
				((Case_valContext)_localctx).cid = match(Identifier);

				        Integer _ev = enumTab.get((((Case_valContext)_localctx).cid!=null?((Case_valContext)_localctx).cid.getText():null));
				        ((Case_valContext)_localctx).theVal =  (_ev != null) ? _ev : 0;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_stmtContext extends ParserRuleContext {
		public String lEnd;
		public String lDefault;
		public String swValOp;
		public ArrayList<Integer> caseVals;
		public ArrayList<String> caseLabels;
		public int swIdx;
		public boolean hasDefault;
		public Arith_expressionContext se;
		public Case_valContext cv;
		public TerminalNode SWITCH() { return getToken(myCompilerParser.SWITCH, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public List<TerminalNode> CASE() { return getTokens(myCompilerParser.CASE); }
		public TerminalNode CASE(int i) {
			return getToken(myCompilerParser.CASE, i);
		}
		public TerminalNode DEFAULT() { return getToken(myCompilerParser.DEFAULT, 0); }
		public List<Case_valContext> case_val() {
			return getRuleContexts(Case_valContext.class);
		}
		public Case_valContext case_val(int i) {
			return getRuleContext(Case_valContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Switch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_stmt; }
	}

	public final Switch_stmtContext switch_stmt() throws RecognitionException {
		Switch_stmtContext _localctx = new Switch_stmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_switch_stmt);

		        ((Switch_stmtContext)_localctx).lEnd =  newLabel();
		        ((Switch_stmtContext)_localctx).lDefault =  newLabel();
		        ((Switch_stmtContext)_localctx).swValOp =  "";
		        ((Switch_stmtContext)_localctx).caseVals =  new ArrayList<>();
		        ((Switch_stmtContext)_localctx).caseLabels =  new ArrayList<>();
		        ((Switch_stmtContext)_localctx).swIdx =  -1;
		        ((Switch_stmtContext)_localctx).hasDefault =  false;
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			match(SWITCH);
			setState(829);
			match(T__6);
			setState(830);
			((Switch_stmtContext)_localctx).se = arith_expression();
			setState(831);
			match(T__8);

			        ((Switch_stmtContext)_localctx).swValOp =  coerce(((Switch_stmtContext)_localctx).se.theInfo, Type.INT);
			        ((Switch_stmtContext)_localctx).swIdx =  TextCode.size();
			        TextCode.add(""); // placeholder; filled after all cases are seen
			        breakStack.push(_localctx.lEnd);
			    
			setState(833);
			match(T__0);
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(834);
				match(CASE);
				setState(835);
				((Switch_stmtContext)_localctx).cv = case_val();
				setState(836);
				match(T__5);

				                String _lc = newLabel();
				                _localctx.caseVals.add(((Switch_stmtContext)_localctx).cv.theVal);
				                _localctx.caseLabels.add(_lc);
				                emit(_lc + ":");
				            
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -491473451253497566L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 291L) != 0)) {
					{
					{
					setState(838);
					statement();
					}
					}
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 if (!lastIsTerminator()) emit("  br label %" + _localctx.lEnd); 
				}
				}
				setState(850);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(851);
				match(DEFAULT);
				setState(852);
				match(T__5);

				                ((Switch_stmtContext)_localctx).hasDefault =  true;
				                emit(_localctx.lDefault + ":");
				            
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -491473451253497566L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 291L) != 0)) {
					{
					{
					setState(854);
					statement();
					}
					}
					setState(859);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 if (!lastIsTerminator()) emit("  br label %" + _localctx.lEnd); 
				}
			}

			setState(863);
			match(T__3);

			        if (!_localctx.hasDefault) {
			            emit(_localctx.lDefault + ":");
			            emit("  br label %" + _localctx.lEnd);
			        }
			        StringBuilder _sw = new StringBuilder(
			            "  switch i32 " + _localctx.swValOp + ", label %" + _localctx.lDefault + " [");
			        for (int _i = 0; _i < _localctx.caseVals.size(); _i++) {
			            _sw.append("\n    i32 ").append(_localctx.caseVals.get(_i))
			               .append(", label %").append(_localctx.caseLabels.get(_i));
			        }
			        _sw.append("\n  ]");
			        TextCode.set(_localctx.swIdx, _sw.toString());
			        breakStack.pop();
			        emit(_localctx.lEnd + ":");
			        constSlot.clear();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_call_stmtContext extends ParserRuleContext {
		public Token Identifier;
		public Call_argsContext call_args;
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public Func_call_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call_stmt; }
	}

	public final Func_call_stmtContext func_call_stmt() throws RecognitionException {
		Func_call_stmtContext _localctx = new Func_call_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_func_call_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			((Func_call_stmtContext)_localctx).Identifier = match(Identifier);
			setState(867);
			match(T__6);
			setState(868);
			((Func_call_stmtContext)_localctx).call_args = call_args();
			setState(869);
			match(T__8);

			           String fn = (((Func_call_stmtContext)_localctx).Identifier!=null?((Func_call_stmtContext)_localctx).Identifier.getText():null);
			           if (fn.equals("printf")) {
			              emitPrintf(((Func_call_stmtContext)_localctx).call_args.fmt, ((Func_call_stmtContext)_localctx).call_args.vals);
			           } else if (fn.equals("scanf")) {
			              emitScanf(((Func_call_stmtContext)_localctx).call_args.fmt, ((Func_call_stmtContext)_localctx).call_args.addrs);
			              // scanf writes through &var pointers — invalidate those slots
			              for (String addr : ((Func_call_stmtContext)_localctx).call_args.addrs)
			                 constSlot.remove(addr.substring(4)); // strip "ptr "
			           } else {
			              // user-defined call, result (if any) ignored
			              Func f = functab.get(fn);
			              String rt = (f == null) ? "i32" : llTy(f.ret);
			              StringBuilder c = new StringBuilder();
			              if (f != null && f.ret == Type.VOID) c.append("  call void @");
			              else { String r = newReg(); c.append("  " + r + " = call " + rt + " @"); }
			              c.append(fn).append("(").append(((Func_call_stmtContext)_localctx).call_args.argList).append(")");
			              emit(c.toString());
			           }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Call_argsContext extends ParserRuleContext {
		public String fmt;
		public ArrayList<String> vals;
		public ArrayList<String> addrs;
		public String argList;
		public One_argContext first;
		public One_argContext more;
		public List<One_argContext> one_arg() {
			return getRuleContexts(One_argContext.class);
		}
		public One_argContext one_arg(int i) {
			return getRuleContext(One_argContext.class,i);
		}
		public Call_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_args; }
	}

	public final Call_argsContext call_args() throws RecognitionException {
		Call_argsContext _localctx = new Call_argsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_call_args);

		   ((Call_argsContext)_localctx).fmt =  null;
		   ((Call_argsContext)_localctx).vals =  new ArrayList<String>();
		   ((Call_argsContext)_localctx).addrs =  new ArrayList<String>();
		   StringBuilder al = new StringBuilder();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 429597393280L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 65081L) != 0)) {
				{
				setState(872);
				((Call_argsContext)_localctx).first = one_arg();
				 _localctx.vals.addAll(((Call_argsContext)_localctx).first.valList);
				                        _localctx.addrs.addAll(((Call_argsContext)_localctx).first.addrList);
				                        if (((Call_argsContext)_localctx).first.fmtName != null) ((Call_argsContext)_localctx).fmt =  ((Call_argsContext)_localctx).first.fmtName;
				                        al.append(((Call_argsContext)_localctx).first.argPiece); 
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(874);
					match(T__2);
					setState(875);
					((Call_argsContext)_localctx).more = one_arg();
					 _localctx.vals.addAll(((Call_argsContext)_localctx).more.valList);
					                             _localctx.addrs.addAll(((Call_argsContext)_localctx).more.addrList);
					                             if (((Call_argsContext)_localctx).more.fmtName != null) ((Call_argsContext)_localctx).fmt =  ((Call_argsContext)_localctx).more.fmtName;
					                             al.append(", ").append(((Call_argsContext)_localctx).more.argPiece); 
					}
					}
					setState(882);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 ((Call_argsContext)_localctx).argList =  al.toString(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class One_argContext extends ParserRuleContext {
		public String fmtName;
		public ArrayList<String> valList;
		public ArrayList<String> addrList;
		public String argPiece;
		public Token Identifier;
		public Arith_expressionContext arith_expression;
		public List<TerminalNode> STRING_LITERAL() { return getTokens(myCompilerParser.STRING_LITERAL); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(myCompilerParser.STRING_LITERAL, i);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public One_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_arg; }
	}

	public final One_argContext one_arg() throws RecognitionException {
		One_argContext _localctx = new One_argContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_one_arg);

		   ((One_argContext)_localctx).fmtName =  null;
		   ((One_argContext)_localctx).valList =  new ArrayList<String>();
		   ((One_argContext)_localctx).addrList =  new ArrayList<String>();
		   ((One_argContext)_localctx).argPiece =  "";

		int _la;
		try {
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(888); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(887);
					match(STRING_LITERAL);
					}
					}
					setState(890); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==STRING_LITERAL );

				           // Concatenate adjacent string literals (C standard behaviour).
				           java.util.List<org.antlr.v4.runtime.tree.TerminalNode> _lits = _localctx.STRING_LITERAL();
				           StringBuilder _sb = new StringBuilder("\"");
				           for (org.antlr.v4.runtime.tree.TerminalNode _t : _lits) {
				              String _s = _t.getText();
				              _sb.append(_s, 1, _s.length() - 1); // strip outer quotes
				           }
				           _sb.append("\"");
				           ((One_argContext)_localctx).fmtName =  makeStringGlobal(_sb.toString());
				           ((One_argContext)_localctx).argPiece =  "ptr " + _localctx.fmtName;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				match(T__25);
				setState(894);
				((One_argContext)_localctx).Identifier = match(Identifier);

				           Info v = lookup((((One_argContext)_localctx).Identifier!=null?((One_argContext)_localctx).Identifier.getText():null));
				           String _addrOp;
				           if (v.isArray() && v.elemType == Type.CHAR) {
				              ArrayList<String> _z = new ArrayList<>();
				              _z.add("0");
				              _addrOp = gepArray(v.operand, llArrayTy(Type.CHAR, v.dims), _z);
				           } else {
				              _addrOp = v.operand;
				           }
				           _localctx.addrList.add("ptr " + _addrOp);
				           ((One_argContext)_localctx).argPiece =  "ptr " + _addrOp;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(896);
				((One_argContext)_localctx).arith_expression = arith_expression();

				           Info v = ((One_argContext)_localctx).arith_expression.theInfo;
				           // store raw typed operand; printf promotes float->double itself
				           _localctx.valList.add(llTy(v.theType) + " " + v.operand);
				           ((One_argContext)_localctx).argPiece =  llTy(v.theType) + " " + v.operand;
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arith_expressionContext extends ParserRuleContext {
		public Info theInfo;
		public TernaryExprContext a;
		public TernaryExprContext ternaryExpr() {
			return getRuleContext(TernaryExprContext.class,0);
		}
		public Arith_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression; }
	}

	public final Arith_expressionContext arith_expression() throws RecognitionException {
		Arith_expressionContext _localctx = new Arith_expressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_arith_expression);
		 ((Arith_expressionContext)_localctx).theInfo =  new Info(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			((Arith_expressionContext)_localctx).a = ternaryExpr();
			 ((Arith_expressionContext)_localctx).theInfo =  ((Arith_expressionContext)_localctx).a.theInfo; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends ParserRuleContext {
		public Info theInfo;
		public LogicOrExprContext a;
		public Arith_expressionContext b;
		public TernaryExprContext c;
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public TernaryExprContext ternaryExpr() {
			return getRuleContext(TernaryExprContext.class,0);
		}
		public TernaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpr; }
	}

	public final TernaryExprContext ternaryExpr() throws RecognitionException {
		TernaryExprContext _localctx = new TernaryExprContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_ternaryExpr);
		 ((TernaryExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			((TernaryExprContext)_localctx).a = logicOrExpr();
			 ((TernaryExprContext)_localctx).theInfo =  ((TernaryExprContext)_localctx).a.theInfo; 
			setState(912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(906);
				match(T__26);
				setState(907);
				((TernaryExprContext)_localctx).b = arith_expression();
				setState(908);
				match(T__5);
				setState(909);
				((TernaryExprContext)_localctx).c = ternaryExpr();

					       Info _cond = truth(((TernaryExprContext)_localctx).a.theInfo);
					       Type _rt   = (((TernaryExprContext)_localctx).b.theInfo.theType == Type.DOUBLE || ((TernaryExprContext)_localctx).c.theInfo.theType == Type.DOUBLE) ? Type.DOUBLE
					                  : (((TernaryExprContext)_localctx).b.theInfo.theType == Type.FLOAT  || ((TernaryExprContext)_localctx).c.theInfo.theType == Type.FLOAT)  ? Type.FLOAT
					                  : Type.INT;
					       String _ty   = llTy(_rt);
					       String _slot = newReg();
					       emit("  " + _slot + " = alloca " + _ty);
					       String _lT = newLabel(), _lF = newLabel(), _lE = newLabel();
					       emit("  br i1 " + _cond.operand + ", label %" + _lT + ", label %" + _lF);
					       emit(_lT + ":");
					       emit("  store " + _ty + " " + coerce(((TernaryExprContext)_localctx).b.theInfo, _rt) + ", ptr " + _slot);
					       emit("  br label %" + _lE);
					       emit(_lF + ":");
					       emit("  store " + _ty + " " + coerce(((TernaryExprContext)_localctx).c.theInfo, _rt) + ", ptr " + _slot);
					       emit("  br label %" + _lE);
					       emit(_lE + ":");
					       String _r = newReg();
					       emit("  " + _r + " = load " + _ty + ", ptr " + _slot);
					       ((TernaryExprContext)_localctx).theInfo =  new Info(_rt, _r);
					  
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOrExprContext extends ParserRuleContext {
		public Info theInfo;
		public LogicAndExprContext a;
		public LogicAndExprContext b;
		public List<LogicAndExprContext> logicAndExpr() {
			return getRuleContexts(LogicAndExprContext.class);
		}
		public LogicAndExprContext logicAndExpr(int i) {
			return getRuleContext(LogicAndExprContext.class,i);
		}
		public LogicOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExpr; }
	}

	public final LogicOrExprContext logicOrExpr() throws RecognitionException {
		LogicOrExprContext _localctx = new LogicOrExprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_logicOrExpr);
		 ((LogicOrExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			((LogicOrExprContext)_localctx).a = logicAndExpr();
			 ((LogicOrExprContext)_localctx).theInfo =  ((LogicOrExprContext)_localctx).a.theInfo; 
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(916);
				match(T__27);
				setState(917);
				((LogicOrExprContext)_localctx).b = logicAndExpr();

					       String r = newReg();
					       emit("  " + r + " = or i1 " + truth(_localctx.theInfo).operand + ", " + truth(((LogicOrExprContext)_localctx).b.theInfo).operand);
					       ((LogicOrExprContext)_localctx).theInfo =  new Info(Type.BOOL, r);
					  
				}
				}
				setState(924);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicAndExprContext extends ParserRuleContext {
		public Info theInfo;
		public BitOrExprContext a;
		public BitOrExprContext b;
		public List<BitOrExprContext> bitOrExpr() {
			return getRuleContexts(BitOrExprContext.class);
		}
		public BitOrExprContext bitOrExpr(int i) {
			return getRuleContext(BitOrExprContext.class,i);
		}
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_logicAndExpr);
		 ((LogicAndExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			((LogicAndExprContext)_localctx).a = bitOrExpr();
			 ((LogicAndExprContext)_localctx).theInfo =  ((LogicAndExprContext)_localctx).a.theInfo; 
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__28) {
				{
				{
				setState(927);
				match(T__28);
				setState(928);
				((LogicAndExprContext)_localctx).b = bitOrExpr();

					       String r = newReg();
					       emit("  " + r + " = and i1 " + truth(_localctx.theInfo).operand + ", " + truth(((LogicAndExprContext)_localctx).b.theInfo).operand);
					       ((LogicAndExprContext)_localctx).theInfo =  new Info(Type.BOOL, r);
					  
				}
				}
				setState(935);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitOrExprContext extends ParserRuleContext {
		public Info theInfo;
		public BitXorExprContext a;
		public BitXorExprContext b;
		public List<BitXorExprContext> bitXorExpr() {
			return getRuleContexts(BitXorExprContext.class);
		}
		public BitXorExprContext bitXorExpr(int i) {
			return getRuleContext(BitXorExprContext.class,i);
		}
		public BitOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOrExpr; }
	}

	public final BitOrExprContext bitOrExpr() throws RecognitionException {
		BitOrExprContext _localctx = new BitOrExprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_bitOrExpr);
		 ((BitOrExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			((BitOrExprContext)_localctx).a = bitXorExpr();
			 ((BitOrExprContext)_localctx).theInfo =  ((BitOrExprContext)_localctx).a.theInfo; 
			setState(944);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(938);
				match(T__29);
				setState(939);
				((BitOrExprContext)_localctx).b = bitXorExpr();
				 ((BitOrExprContext)_localctx).theInfo =  bitOp("|", _localctx.theInfo, ((BitOrExprContext)_localctx).b.theInfo); 
				}
				}
				setState(946);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitXorExprContext extends ParserRuleContext {
		public Info theInfo;
		public BitAndExprContext a;
		public BitAndExprContext b;
		public List<BitAndExprContext> bitAndExpr() {
			return getRuleContexts(BitAndExprContext.class);
		}
		public BitAndExprContext bitAndExpr(int i) {
			return getRuleContext(BitAndExprContext.class,i);
		}
		public BitXorExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitXorExpr; }
	}

	public final BitXorExprContext bitXorExpr() throws RecognitionException {
		BitXorExprContext _localctx = new BitXorExprContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_bitXorExpr);
		 ((BitXorExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
			((BitXorExprContext)_localctx).a = bitAndExpr();
			 ((BitXorExprContext)_localctx).theInfo =  ((BitXorExprContext)_localctx).a.theInfo; 
			setState(955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(949);
				match(T__30);
				setState(950);
				((BitXorExprContext)_localctx).b = bitAndExpr();
				 ((BitXorExprContext)_localctx).theInfo =  bitOp("^", _localctx.theInfo, ((BitXorExprContext)_localctx).b.theInfo); 
				}
				}
				setState(957);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitAndExprContext extends ParserRuleContext {
		public Info theInfo;
		public CompareExprContext a;
		public CompareExprContext b;
		public List<CompareExprContext> compareExpr() {
			return getRuleContexts(CompareExprContext.class);
		}
		public CompareExprContext compareExpr(int i) {
			return getRuleContext(CompareExprContext.class,i);
		}
		public BitAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAndExpr; }
	}

	public final BitAndExprContext bitAndExpr() throws RecognitionException {
		BitAndExprContext _localctx = new BitAndExprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bitAndExpr);
		 ((BitAndExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			((BitAndExprContext)_localctx).a = compareExpr();
			 ((BitAndExprContext)_localctx).theInfo =  ((BitAndExprContext)_localctx).a.theInfo; 
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(960);
				match(T__25);
				setState(961);
				((BitAndExprContext)_localctx).b = compareExpr();
				 ((BitAndExprContext)_localctx).theInfo =  bitOp("&", _localctx.theInfo, ((BitAndExprContext)_localctx).b.theInfo); 
				}
				}
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompareExprContext extends ParserRuleContext {
		public Info theInfo;
		public boolean rel;
		public ShiftExprContext a;
		public Token RelationOP;
		public ShiftExprContext b;
		public List<ShiftExprContext> shiftExpr() {
			return getRuleContexts(ShiftExprContext.class);
		}
		public ShiftExprContext shiftExpr(int i) {
			return getRuleContext(ShiftExprContext.class,i);
		}
		public TerminalNode RelationOP() { return getToken(myCompilerParser.RelationOP, 0); }
		public CompareExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpr; }
	}

	public final CompareExprContext compareExpr() throws RecognitionException {
		CompareExprContext _localctx = new CompareExprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_compareExpr);
		 ((CompareExprContext)_localctx).theInfo =  new Info(); ((CompareExprContext)_localctx).rel =  false; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			((CompareExprContext)_localctx).a = shiftExpr();
			 ((CompareExprContext)_localctx).theInfo =  ((CompareExprContext)_localctx).a.theInfo; 
			setState(975);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RelationOP) {
				{
				setState(971);
				((CompareExprContext)_localctx).RelationOP = match(RelationOP);
				setState(972);
				((CompareExprContext)_localctx).b = shiftExpr();

					       ((CompareExprContext)_localctx).theInfo =  compare(((CompareExprContext)_localctx).a.theInfo, (((CompareExprContext)_localctx).RelationOP!=null?((CompareExprContext)_localctx).RelationOP.getText():null), ((CompareExprContext)_localctx).b.theInfo);
					       ((CompareExprContext)_localctx).rel =  true;
					  
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExprContext extends ParserRuleContext {
		public Info theInfo;
		public AddExprContext a;
		public AddExprContext b;
		public AddExprContext c;
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public ShiftExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpr; }
	}

	public final ShiftExprContext shiftExpr() throws RecognitionException {
		ShiftExprContext _localctx = new ShiftExprContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_shiftExpr);
		 ((ShiftExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			((ShiftExprContext)_localctx).a = addExpr();
			 ((ShiftExprContext)_localctx).theInfo =  ((ShiftExprContext)_localctx).a.theInfo; 
			setState(989);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__31 || _la==T__32) {
				{
				setState(987);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__31:
					{
					setState(979);
					match(T__31);
					setState(980);
					((ShiftExprContext)_localctx).b = addExpr();
					 ((ShiftExprContext)_localctx).theInfo =  bitOp("<<", _localctx.theInfo, ((ShiftExprContext)_localctx).b.theInfo); 
					}
					break;
				case T__32:
					{
					setState(983);
					match(T__32);
					setState(984);
					((ShiftExprContext)_localctx).c = addExpr();
					 ((ShiftExprContext)_localctx).theInfo =  bitOp(">>", _localctx.theInfo, ((ShiftExprContext)_localctx).c.theInfo); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public Info theInfo;
		public MultExprContext a;
		public MultExprContext b;
		public MultExprContext c;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_addExpr);
		 ((AddExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992);
			((AddExprContext)_localctx).a = multExpr();
			 ((AddExprContext)_localctx).theInfo =  ((AddExprContext)_localctx).a.theInfo; 
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24 || _la==T__33) {
				{
				setState(1002);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__33:
					{
					setState(994);
					match(T__33);
					setState(995);
					((AddExprContext)_localctx).b = multExpr();
					 ((AddExprContext)_localctx).theInfo =  binArith("+", _localctx.theInfo, ((AddExprContext)_localctx).b.theInfo); 
					}
					break;
				case T__24:
					{
					setState(998);
					match(T__24);
					setState(999);
					((AddExprContext)_localctx).c = multExpr();
					 ((AddExprContext)_localctx).theInfo =  binArith("-", _localctx.theInfo, ((AddExprContext)_localctx).c.theInfo); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ParserRuleContext {
		public Info theInfo;
		public CastExprContext a;
		public CastExprContext b;
		public CastExprContext c;
		public CastExprContext e;
		public CastExprContext d;
		public List<CastExprContext> castExpr() {
			return getRuleContexts(CastExprContext.class);
		}
		public CastExprContext castExpr(int i) {
			return getRuleContext(CastExprContext.class,i);
		}
		public List<TerminalNode> HASH_HASH() { return getTokens(myCompilerParser.HASH_HASH); }
		public TerminalNode HASH_HASH(int i) {
			return getToken(myCompilerParser.HASH_HASH, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_multExpr);
		 ((MultExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1007);
			((MultExprContext)_localctx).a = castExpr();
			 ((MultExprContext)_localctx).theInfo =  ((MultExprContext)_localctx).a.theInfo; 
			setState(1027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103079215360L) != 0) || _la==HASH_HASH) {
				{
				setState(1025);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(1009);
					match(T__7);
					setState(1010);
					((MultExprContext)_localctx).b = castExpr();
					 ((MultExprContext)_localctx).theInfo =  binArith("*",  _localctx.theInfo, ((MultExprContext)_localctx).b.theInfo); 
					}
					break;
				case T__34:
					{
					setState(1013);
					match(T__34);
					setState(1014);
					((MultExprContext)_localctx).c = castExpr();
					 ((MultExprContext)_localctx).theInfo =  binArith("/",  _localctx.theInfo, ((MultExprContext)_localctx).c.theInfo); 
					}
					break;
				case T__35:
					{
					setState(1017);
					match(T__35);
					setState(1018);
					((MultExprContext)_localctx).e = castExpr();
					 ((MultExprContext)_localctx).theInfo =  binArith("%",  _localctx.theInfo, ((MultExprContext)_localctx).e.theInfo); 
					}
					break;
				case HASH_HASH:
					{
					setState(1021);
					match(HASH_HASH);
					setState(1022);
					((MultExprContext)_localctx).d = castExpr();
					 ((MultExprContext)_localctx).theInfo =  hashOp(_localctx.theInfo, ((MultExprContext)_localctx).d.theInfo); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1029);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExprContext extends ParserRuleContext {
		public Info theInfo;
		public TypeContext type;
		public Ptr_starsContext cps;
		public CastExprContext e;
		public Token Identifier;
		public Ptr_starsContext cps2;
		public CastExprContext e2;
		public SignExprContext s;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Ptr_starsContext ptr_stars() {
			return getRuleContext(Ptr_starsContext.class,0);
		}
		public CastExprContext castExpr() {
			return getRuleContext(CastExprContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public SignExprContext signExpr() {
			return getRuleContext(SignExprContext.class,0);
		}
		public CastExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpr; }
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_castExpr);
		 ((CastExprContext)_localctx).theInfo =  new Info(); 
		try {
			setState(1048);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1030);
				match(T__6);
				setState(1031);
				((CastExprContext)_localctx).type = type();
				setState(1032);
				((CastExprContext)_localctx).cps = ptr_stars();
				setState(1033);
				match(T__8);
				setState(1034);
				((CastExprContext)_localctx).e = castExpr();

					       if (((CastExprContext)_localctx).cps.depth > 0) {
					          // pointer cast: treat as ptr
					          String _cv = coerce(((CastExprContext)_localctx).e.theInfo, Type.POINTER);
					          ((CastExprContext)_localctx).theInfo =  new Info(((CastExprContext)_localctx).type.attr_type, null, 0, _cv);
					       } else {
					          String v = coerce(((CastExprContext)_localctx).e.theInfo, ((CastExprContext)_localctx).type.attr_type);
					          ((CastExprContext)_localctx).theInfo =  new Info(((CastExprContext)_localctx).type.attr_type, v);
					       }
					  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1037);
				match(T__6);
				setState(1038);
				match(STRUCT);
				setState(1039);
				((CastExprContext)_localctx).Identifier = match(Identifier);
				setState(1040);
				((CastExprContext)_localctx).cps2 = ptr_stars();
				setState(1041);
				match(T__8);
				setState(1042);
				((CastExprContext)_localctx).e2 = castExpr();

					       // (struct Name*) cast — treat as opaque ptr
					       String _cv2 = coerce(((CastExprContext)_localctx).e2.theInfo, Type.POINTER);
					       ((CastExprContext)_localctx).theInfo =  new Info(Type.STRUCT, (((CastExprContext)_localctx).Identifier!=null?((CastExprContext)_localctx).Identifier.getText():null), 0, _cv2);
					  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1045);
				((CastExprContext)_localctx).s = signExpr();
				 ((CastExprContext)_localctx).theInfo =  ((CastExprContext)_localctx).s.theInfo; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignExprContext extends ParserRuleContext {
		public Info theInfo;
		public SignExprContext e;
		public SignExprContext e2;
		public Token addr_id;
		public SignExprContext e_deref;
		public SignExprContext e3;
		public SignExprContext e4;
		public PrimaryExprContext p;
		public SignExprContext signExpr() {
			return getRuleContext(SignExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public SignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signExpr; }
	}

	public final SignExprContext signExpr() throws RecognitionException {
		SignExprContext _localctx = new SignExprContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_signExpr);
		 ((SignExprContext)_localctx).theInfo =  new Info(); 
		try {
			setState(1076);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				match(T__24);
				setState(1051);
				((SignExprContext)_localctx).e = signExpr();

					       Info in = ((SignExprContext)_localctx).e.theInfo;
					       if (isFltImm(in)) {
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.FLOAT, fltHex(-getFltImm(in)));
					       } else if (isIntImm(in)) {
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(-getIntImm(in)));
					       } else if (in.theType == Type.FLOAT) {
					          String r = newReg();
					          emit("  " + r + " = fneg float " + in.operand);
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.FLOAT, r);
					       } else if (in.theType == Type.DOUBLE) {
					          String r = newReg();
					          emit("  " + r + " = fneg double " + in.operand);
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.DOUBLE, r);
					       } else {
					          String r = newReg();
					          emit("  " + r + " = sub nsw i32 0, " + in.operand);
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.INT, r);
					       }
					  
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(1054);
				match(T__33);
				setState(1055);
				((SignExprContext)_localctx).e2 = signExpr();
				 ((SignExprContext)_localctx).theInfo =  ((SignExprContext)_localctx).e2.theInfo; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(1058);
				match(T__25);
				setState(1059);
				((SignExprContext)_localctx).addr_id = match(Identifier);

					       // address-of: return the alloca slot address as a pointer value
					       Info _av = lookup((((SignExprContext)_localctx).addr_id!=null?((SignExprContext)_localctx).addr_id.getText():null));
					       if (_av == null) { ((SignExprContext)_localctx).theInfo =  new Info(Type.POINTER, null, 1, "null"); }
					       else { ((SignExprContext)_localctx).theInfo =  new Info(_av.theType, _av.structName, 1, _av.operand); }
					  
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(1061);
				match(T__7);
				setState(1062);
				((SignExprContext)_localctx).e_deref = signExpr();

					       Info _pi = ((SignExprContext)_localctx).e_deref.theInfo;
					       if (_pi.isArray()) {
					          // *array = array (decay: deref of array-decay pointer gives ptr again)
					          // Just pass through the GEP pointer as a POINTER value.
					          Type _aet = (_pi.elemType != null) ? _pi.elemType : Type.INT;
					          ((SignExprContext)_localctx).theInfo =  new Info(_aet, (String)null, 0, _pi.operand);
					       } else {
					          String _pval = _pi.operand;
					          Type _et = (_pi.elemType != null && _pi.elemType != Type.ERR) ? _pi.elemType : Type.INT;
					          String _dr = newReg();
					          emit("  " + _dr + " = load " + llTy(_et) + ", ptr " + _pval);
					          ((SignExprContext)_localctx).theInfo =  new Info(_et, _dr);
					       }
					  
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 5);
				{
				setState(1065);
				match(T__36);
				setState(1066);
				((SignExprContext)_localctx).e3 = signExpr();

					       if (isIntImm(((SignExprContext)_localctx).e3.theInfo)) {
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(~getIntImm(((SignExprContext)_localctx).e3.theInfo)));
					       } else {
					          String r = newReg();
					          emit("  " + r + " = xor i32 " + coerce(((SignExprContext)_localctx).e3.theInfo, Type.INT) + ", -1");
					          ((SignExprContext)_localctx).theInfo =  new Info(Type.INT, r);
					       }
					  
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 6);
				{
				setState(1069);
				match(T__37);
				setState(1070);
				((SignExprContext)_localctx).e4 = signExpr();

					       String r = newReg();
					       emit("  " + r + " = xor i1 " + truth(((SignExprContext)_localctx).e4.theInfo).operand + ", true");
					       ((SignExprContext)_localctx).theInfo =  new Info(Type.BOOL, r);
					  
				}
				break;
			case T__6:
			case SIZEOF:
			case NULL_KW:
			case TRUE_KW:
			case FALSE_KW:
			case Identifier:
			case Floating_point_constant:
			case HexInteger:
			case LongLongConstant:
			case Integer_constant:
			case CharLit:
				enterOuterAlt(_localctx, 7);
				{
				setState(1073);
				((SignExprContext)_localctx).p = primaryExpr();
				 ((SignExprContext)_localctx).theInfo =  ((SignExprContext)_localctx).p.theInfo; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public Info theInfo;
		public ArrayList<String> idxOps3;
		public Token Integer_constant;
		public Token LongLongConstant;
		public Token HexInteger;
		public Token CharLit;
		public Token sz_sn;
		public TypeContext sz_type;
		public Dim_list_optContext dim_list_opt;
		public Token Floating_point_constant;
		public Token fn_id;
		public Call_argsContext call_args;
		public Token fpa;
		public Arith_expressionContext fpi;
		public Call_argsContext fpc_args;
		public Token arr3;
		public Arith_expressionContext ai3;
		public Token obj3;
		public Token field3;
		public Token arw;
		public Token arwField;
		public Token var_id;
		public Comma_exprContext comma_expr;
		public TerminalNode Integer_constant() { return getToken(myCompilerParser.Integer_constant, 0); }
		public TerminalNode LongLongConstant() { return getToken(myCompilerParser.LongLongConstant, 0); }
		public TerminalNode HexInteger() { return getToken(myCompilerParser.HexInteger, 0); }
		public TerminalNode CharLit() { return getToken(myCompilerParser.CharLit, 0); }
		public TerminalNode NULL_KW() { return getToken(myCompilerParser.NULL_KW, 0); }
		public TerminalNode TRUE_KW() { return getToken(myCompilerParser.TRUE_KW, 0); }
		public TerminalNode FALSE_KW() { return getToken(myCompilerParser.FALSE_KW, 0); }
		public TerminalNode SIZEOF() { return getToken(myCompilerParser.SIZEOF, 0); }
		public TerminalNode STRUCT() { return getToken(myCompilerParser.STRUCT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public Dim_list_optContext dim_list_opt() {
			return getRuleContext(Dim_list_optContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Floating_point_constant() { return getToken(myCompilerParser.Floating_point_constant, 0); }
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(myCompilerParser.ARROW, 0); }
		public Comma_exprContext comma_expr() {
			return getRuleContext(Comma_exprContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_primaryExpr);
		 ((PrimaryExprContext)_localctx).theInfo =  new Info(); ((PrimaryExprContext)_localctx).idxOps3 =  new ArrayList<String>(); 
		int _la;
		try {
			setState(1149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1078);
				((PrimaryExprContext)_localctx).Integer_constant = match(Integer_constant);

				           // Strip optional U/L suffix before parsing
				           String _ict = (((PrimaryExprContext)_localctx).Integer_constant!=null?((PrimaryExprContext)_localctx).Integer_constant.getText():null).replaceAll("[uUlL]+$", "");
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, _ict);
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1080);
				((PrimaryExprContext)_localctx).LongLongConstant = match(LongLongConstant);

				           String _llt = (((PrimaryExprContext)_localctx).LongLongConstant!=null?((PrimaryExprContext)_localctx).LongLongConstant.getText():null).replaceAll("[uUlL]+$", "");
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.LONGLONG, _llt);
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1082);
				((PrimaryExprContext)_localctx).HexInteger = match(HexInteger);

				           String _hxt = (((PrimaryExprContext)_localctx).HexInteger!=null?((PrimaryExprContext)_localctx).HexInteger.getText():null).replaceAll("[uUlL]+$", "");
				           long hv = Long.parseLong(_hxt.substring(2), 16);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(hv));
				      
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1084);
				((PrimaryExprContext)_localctx).CharLit = match(CharLit);

				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(charVal((((PrimaryExprContext)_localctx).CharLit!=null?((PrimaryExprContext)_localctx).CharLit.getText():null))));
				      
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1086);
				match(NULL_KW);
				 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, "0"); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1088);
				match(TRUE_KW);
				 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.BOOL, "true"); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1090);
				match(FALSE_KW);
				 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.BOOL, "false"); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1092);
				match(SIZEOF);
				setState(1093);
				match(T__6);
				setState(1094);
				match(STRUCT);
				setState(1095);
				((PrimaryExprContext)_localctx).sz_sn = match(Identifier);
				setState(1096);
				match(T__8);

				           ArrayList<StructField> _sflds = structDefs.get((((PrimaryExprContext)_localctx).sz_sn!=null?((PrimaryExprContext)_localctx).sz_sn.getText():null));
				           int _ssz = 0;
				           if (_sflds != null) for (StructField _sf : _sflds) _ssz += sizeOf(_sf.t);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(_ssz));
				      
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1098);
				match(SIZEOF);
				setState(1099);
				match(T__6);
				setState(1100);
				((PrimaryExprContext)_localctx).sz_type = type();
				setState(1101);
				((PrimaryExprContext)_localctx).dim_list_opt = dim_list_opt();
				setState(1102);
				match(T__8);

				           int sz = sizeOf(((PrimaryExprContext)_localctx).sz_type.attr_type);
				           for (int _d : ((PrimaryExprContext)_localctx).dim_list_opt.dims) sz *= _d;
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(sz));
				      
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1105);
				((PrimaryExprContext)_localctx).Floating_point_constant = match(Floating_point_constant);

				           String _ft = (((PrimaryExprContext)_localctx).Floating_point_constant!=null?((PrimaryExprContext)_localctx).Floating_point_constant.getText():null);
				           boolean _isF = _ft.endsWith("f") || _ft.endsWith("F");
				           if (_isF) {
				              float _fv = Float.parseFloat(_ft.substring(0, _ft.length()-1));
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.FLOAT, fltHex(_fv));
				           } else {
				              double _dv = Double.parseDouble(_ft);
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.DOUBLE, dblHex(_dv));
				           }
				      
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1107);
				((PrimaryExprContext)_localctx).fn_id = match(Identifier);
				setState(1108);
				match(T__6);
				setState(1109);
				((PrimaryExprContext)_localctx).call_args = call_args();
				setState(1110);
				match(T__8);

				           String fn = (((PrimaryExprContext)_localctx).fn_id!=null?((PrimaryExprContext)_localctx).fn_id.getText():null);
				           Func f = functab.get(fn);
				           if (f != null) {
				              Type rt = f.ret;
				              String r = newReg();
				              emit("  " + r + " = call " + llTy(rt) + " @" + fn
				                   + "(" + ((PrimaryExprContext)_localctx).call_args.argList + ")");
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(rt, r);
				           } else {
				              Info _fpi = lookup(fn);
				              if (_fpi != null && _fpi.theType == Type.POINTER) {
				                 String _fpv2 = newReg();
				                 emit("  " + _fpv2 + " = load ptr, ptr " + _fpi.operand);
				                 String _fpr2 = newReg();
				                 emit("  " + _fpr2 + " = call i32 " + _fpv2
				                      + "(" + ((PrimaryExprContext)_localctx).call_args.argList + ")");
				                 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, _fpr2);
				              } else {
				                 String r = newReg();
				                 emit("  " + r + " = call i32 @" + fn
				                      + "(" + ((PrimaryExprContext)_localctx).call_args.argList + ")");
				                 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, r);
				              }
				           }
				        
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1113);
				((PrimaryExprContext)_localctx).fpa = match(Identifier);
				setState(1114);
				match(T__9);
				setState(1115);
				((PrimaryExprContext)_localctx).fpi = arith_expression();
				setState(1116);
				match(T__10);
				setState(1117);
				match(T__6);
				setState(1118);
				((PrimaryExprContext)_localctx).fpc_args = call_args();
				setState(1119);
				match(T__8);

				           Info _fpaInfo = lookup((((PrimaryExprContext)_localctx).fpa!=null?((PrimaryExprContext)_localctx).fpa.getText():null));
				           if (_fpaInfo != null && _fpaInfo.isArray()) {
				              ArrayList<String> _fpaIdxs = new ArrayList<>();
				              _fpaIdxs.add(((PrimaryExprContext)_localctx).fpi.theInfo.operand);
				              String _fpaEptr = gepArray(_fpaInfo.operand,
				                  llArrayTy(_fpaInfo.elemType, _fpaInfo.dims), _fpaIdxs);
				              String _fpaFp = newReg();
				              emit("  " + _fpaFp + " = load ptr, ptr " + _fpaEptr);
				              String _fpaR = newReg();
				              emit("  " + _fpaR + " = call i32 " + _fpaFp
				                   + "(" + ((PrimaryExprContext)_localctx).fpc_args.argList + ")");
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, _fpaR);
				           } else {
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, "0");
				           }
				        
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1122);
				((PrimaryExprContext)_localctx).arr3 = match(Identifier);
				setState(1128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1123);
					match(T__9);
					setState(1124);
					((PrimaryExprContext)_localctx).ai3 = arith_expression();
					setState(1125);
					match(T__10);
					 _localctx.idxOps3.add(((PrimaryExprContext)_localctx).ai3.theInfo.operand); 
					}
					}
					setState(1130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );

				           Info arrInfo3 = lookup((((PrimaryExprContext)_localctx).arr3!=null?((PrimaryExprContext)_localctx).arr3.getText():null));
				           if (arrInfo3 == null) {
				              System.out.println("Type Error: line " + ((PrimaryExprContext)_localctx).arr3.getLine()
				                                 + ": Undeclared identifier '" + (((PrimaryExprContext)_localctx).arr3!=null?((PrimaryExprContext)_localctx).arr3.getText():null) + "'.");
				              System.exit(0);
				           }
				           String arrTy3 = llArrayTy(arrInfo3.elemType, arrInfo3.dims);
				           String ptr3 = gepArray(arrInfo3.operand, arrTy3, _localctx.idxOps3);
				           String r3 = newReg();
				           emit("  " + r3 + " = load " + llTy(arrInfo3.elemType) + ", ptr " + ptr3);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(arrInfo3.elemType, r3);
				        
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1134);
				((PrimaryExprContext)_localctx).obj3 = match(Identifier);
				setState(1135);
				match(T__11);
				setState(1136);
				((PrimaryExprContext)_localctx).field3 = match(Identifier);

				           Info objInfo3 = lookup((((PrimaryExprContext)_localctx).obj3!=null?((PrimaryExprContext)_localctx).obj3.getText():null));
				           if (objInfo3 == null) {
				              System.out.println("Type Error: line " + ((PrimaryExprContext)_localctx).obj3.getLine()
				                                 + ": Undeclared identifier '" + (((PrimaryExprContext)_localctx).obj3!=null?((PrimaryExprContext)_localctx).obj3.getText():null) + "'.");
				              System.exit(0);
				           }
				           int fidx3 = getFieldIdx(objInfo3.structName, (((PrimaryExprContext)_localctx).field3!=null?((PrimaryExprContext)_localctx).field3.getText():null));
				           ArrayList<StructField> flds3 = structDefs.get(objInfo3.structName);
				           Type ft3 = flds3.get(fidx3).t;
				           String sptr3 = gepStruct(objInfo3.operand, objInfo3.structName, fidx3);
				           String r3s = newReg();
				           emit("  " + r3s + " = load " + llTy(ft3) + ", ptr " + sptr3);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(ft3, r3s);
				        
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1138);
				((PrimaryExprContext)_localctx).arw = match(Identifier);
				setState(1139);
				match(ARROW);
				setState(1140);
				((PrimaryExprContext)_localctx).arwField = match(Identifier);

				           Info arwInfo = lookup((((PrimaryExprContext)_localctx).arw!=null?((PrimaryExprContext)_localctx).arw.getText():null));
				           if (arwInfo == null) {
				              System.out.println("Type Error: line " + ((PrimaryExprContext)_localctx).arw.getLine()
				                                 + ": Undeclared identifier '" + (((PrimaryExprContext)_localctx).arw!=null?((PrimaryExprContext)_localctx).arw.getText():null) + "'.");
				              System.exit(0);
				           }
				           // Load the pointer value from the slot
				           String _arwPtr = newReg();
				           emit("  " + _arwPtr + " = load ptr, ptr " + arwInfo.operand);
				           String _sn = arwInfo.structName;
				           int _fi = getFieldIdx(_sn, (((PrimaryExprContext)_localctx).arwField!=null?((PrimaryExprContext)_localctx).arwField.getText():null));
				           ArrayList<StructField> _fls = structDefs.get(_sn);
				           Type _ft = _fls.get(_fi).t;
				           String _fptr = newReg();
				           emit("  " + _fptr + " = getelementptr %struct." + _sn
				                + ", ptr " + _arwPtr + ", i32 0, i32 " + _fi);
				           String _rv = newReg();
				           emit("  " + _rv + " = load " + llTy(_ft) + ", ptr " + _fptr);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(_ft, _rv);
				        
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1142);
				((PrimaryExprContext)_localctx).var_id = match(Identifier);

				           Integer enumVal = enumTab.get((((PrimaryExprContext)_localctx).var_id!=null?((PrimaryExprContext)_localctx).var_id.getText():null));
				           if (enumVal != null) {
				              ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, String.valueOf(enumVal));
				           } else {
				              Info v = lookup((((PrimaryExprContext)_localctx).var_id!=null?((PrimaryExprContext)_localctx).var_id.getText():null));
				              if (v == null) {
				                 if (functab.containsKey((((PrimaryExprContext)_localctx).var_id!=null?((PrimaryExprContext)_localctx).var_id.getText():null))) {
				                    ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.VOID, (String)null, 0, "@" + (((PrimaryExprContext)_localctx).var_id!=null?((PrimaryExprContext)_localctx).var_id.getText():null));
				                 } else {
				                    System.out.println("Type Error: line " + ((PrimaryExprContext)_localctx).var_id.getLine()
				                                       + ": Undeclared identifier '"
				                                       + (((PrimaryExprContext)_localctx).var_id!=null?((PrimaryExprContext)_localctx).var_id.getText():null) + "'.");
				                    System.exit(0);
				                 }
				              } else if (v.isArray() && v.elemType == Type.CHAR) {
				                 ArrayList<String> _z = new ArrayList<>();
				                 _z.add("0");
				                 String _ptr = gepArray(v.operand, llArrayTy(Type.CHAR, v.dims), _z);
				                 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.STRING, _ptr);
				              } else if (v.isArray()) {
				                 // Non-char array decays to pointer to first element.
				                 // Keep theType=ARRAY so '*' in signExpr knows not to load.
				                 ArrayList<String> _dz = new ArrayList<>();
				                 for (int _di = 0; _di < v.dims.length; _di++) _dz.add("0");
				                 String _dptr = gepArray(v.operand, llArrayTy(v.elemType, v.dims), _dz);
				                 ((PrimaryExprContext)_localctx).theInfo =  new Info(v.elemType, v.dims, _dptr); // ARRAY tag = decay ptr
				              } else if (v.isPointer()) {
				                 String _pld = newReg();
				                 emit("  " + _pld + " = load ptr, ptr " + v.operand);
				                 ((PrimaryExprContext)_localctx).theInfo =  new Info(v.elemType, v.structName, 0, _pld);
				              } else {
				                 ((PrimaryExprContext)_localctx).theInfo =  smartLoad(v.operand, v.theType);
				              }
				           }
				        
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1144);
				match(T__6);
				setState(1145);
				((PrimaryExprContext)_localctx).comma_expr = comma_expr();
				setState(1146);
				match(T__8);
				 ((PrimaryExprContext)_localctx).theInfo =  ((PrimaryExprContext)_localctx).comma_expr.theInfo; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comma_exprContext extends ParserRuleContext {
		public Info theInfo;
		public Assign_exprContext item;
		public Assign_exprContext more;
		public List<Assign_exprContext> assign_expr() {
			return getRuleContexts(Assign_exprContext.class);
		}
		public Assign_exprContext assign_expr(int i) {
			return getRuleContext(Assign_exprContext.class,i);
		}
		public Comma_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma_expr; }
	}

	public final Comma_exprContext comma_expr() throws RecognitionException {
		Comma_exprContext _localctx = new Comma_exprContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_comma_expr);
		 ((Comma_exprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			((Comma_exprContext)_localctx).item = assign_expr();
			 ((Comma_exprContext)_localctx).theInfo =  ((Comma_exprContext)_localctx).item.theInfo; 
			setState(1159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1153);
				match(T__2);
				setState(1154);
				((Comma_exprContext)_localctx).more = assign_expr();
				 ((Comma_exprContext)_localctx).theInfo =  ((Comma_exprContext)_localctx).more.theInfo; 
				}
				}
				setState(1161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_exprContext extends ParserRuleContext {
		public Info theInfo;
		public Token lv;
		public Token aop;
		public Arith_expressionContext rv;
		public Arith_expressionContext ae;
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_assign_expr);
		 ((Assign_exprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			setState(1170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1162);
				((Assign_exprContext)_localctx).lv = match(Identifier);
				setState(1163);
				((Assign_exprContext)_localctx).aop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8380420L) != 0)) ) {
					((Assign_exprContext)_localctx).aop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1164);
				((Assign_exprContext)_localctx).rv = arith_expression();

				        Info _aelhs = lookup((((Assign_exprContext)_localctx).lv!=null?((Assign_exprContext)_localctx).lv.getText():null));
				        if (_aelhs == null) {
				            System.out.println("Type Error: line " + ((Assign_exprContext)_localctx).lv.getLine()
				                               + ": Undeclared identifier '" + (((Assign_exprContext)_localctx).lv!=null?((Assign_exprContext)_localctx).lv.getText():null) + "'.");
				            System.exit(0);
				        }
				        String _aeop = ((Assign_exprContext)_localctx).aop.getText();
				        String _aev;
				        if (_aeop.equals("=")) {
				            _aev = coerce(((Assign_exprContext)_localctx).rv.theInfo, _aelhs.theType);
				        } else {
				            Info _aecur = smartLoad(_aelhs.operand, _aelhs.theType);
				            String _aebase = _aeop.substring(0, _aeop.length()-1);
				            Info _aeres = (_aebase.equals("&")||_aebase.equals("|")||_aebase.equals("^")
				                           ||_aebase.equals("<<")||_aebase.equals(">>"))
				                          ? bitOp(_aebase, _aecur, ((Assign_exprContext)_localctx).rv.theInfo)
				                          : binArith(_aebase, _aecur, ((Assign_exprContext)_localctx).rv.theInfo);
				            _aev = coerce(_aeres, _aelhs.theType);
				        }
				        emit("  store " + llTy(_aelhs.theType) + " " + _aev + ", ptr " + _aelhs.operand);
				        updateConstSlot(_aelhs.operand, new Info(_aelhs.theType, _aev));
				        ((Assign_exprContext)_localctx).theInfo =  new Info(_aelhs.theType, _aev);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1167);
				((Assign_exprContext)_localctx).ae = arith_expression();
				 ((Assign_exprContext)_localctx).theInfo =  ((Assign_exprContext)_localctx).ae.theInfo; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dim_list_optContext extends ParserRuleContext {
		public int[] dims;
		public Token Integer_constant;
		public List<TerminalNode> Integer_constant() { return getTokens(myCompilerParser.Integer_constant); }
		public TerminalNode Integer_constant(int i) {
			return getToken(myCompilerParser.Integer_constant, i);
		}
		public Dim_list_optContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim_list_opt; }
	}

	public final Dim_list_optContext dim_list_opt() throws RecognitionException {
		Dim_list_optContext _localctx = new Dim_list_optContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_dim_list_opt);
		 java.util.ArrayList<Integer> _dl = new java.util.ArrayList<Integer>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(1172);
				match(T__9);
				setState(1173);
				((Dim_list_optContext)_localctx).Integer_constant = match(Integer_constant);
				setState(1174);
				match(T__10);
				 _dl.add(Integer.parseInt((((Dim_list_optContext)_localctx).Integer_constant!=null?((Dim_list_optContext)_localctx).Integer_constant.getText():null))); 
				}
				}
				setState(1180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

				    ((Dim_list_optContext)_localctx).dims =  new int[_dl.size()];
				    for (int _i = 0; _i < _dl.size(); _i++) _localctx.dims[_i] = _dl.get(_i);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001T\u04a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000|\b\u0000"+
		"\u000b\u0000\f\u0000}\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0084\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u008c\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0095\b\u0001\u0001\u0001\u0005\u0001\u0098\b\u0001\n\u0001\f\u0001\u009b"+
		"\t\u0001\u0001\u0001\u0003\u0001\u009e\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"\u00a7\b\u0002\u000b\u0002\f\u0002\u00a8\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003\u00b3\b\u0003\u000b\u0003\f\u0003\u00b4\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"\u00be\b\u0004\u000b\u0004\f\u0004\u00bf\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00c8\b\u0004\u000b"+
		"\u0004\f\u0004\u00c9\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00e1"+
		"\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00f7\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00ff"+
		"\b\u0006\n\u0006\f\u0006\u0102\t\u0006\u0003\u0006\u0104\b\u0006\u0001"+
		"\u0007\u0005\u0007\u0107\b\u0007\n\u0007\f\u0007\u010a\t\u0007\u0001\b"+
		"\u0001\b\u0005\b\u010e\b\b\n\b\f\b\u0111\t\b\u0001\t\u0005\t\u0114\b\t"+
		"\n\t\f\t\u0117\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0120\b\t\n\t\f\t\u0123\t\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u012b\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0133\b\t\u0001\t\u0001\t\u0005\t\u0137\b\t\n\t\f\t"+
		"\u013a\t\t\u0001\t\u0001\t\u0003\t\u013e\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u015b\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0164\b\f\u0001\f\u0001\f\u0005\f\u0168"+
		"\b\f\n\f\f\f\u016b\t\f\u0003\f\u016d\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0004\r\u0173\b\r\u000b\r\f\r\u0174\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u017c\b\u000e\n\u000e\f\u000e\u017f\t\u000e"+
		"\u0001\u000e\u0003\u000e\u0182\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u018f\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u0193\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0197\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01a1\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01a7\b\u0011\u0003\u0011\u01a9"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01af"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0004\u0011\u01b7\b\u0011\u000b\u0011\f\u0011\u01b8\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01bf\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u01c7\b\u0011\u0001\u0011\u0003\u0011\u01ca\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01d1\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u01db\b\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u01e5\b\u0011\u0005\u0011\u01e7\b\u0011\n\u0011\f\u0011\u01ea\t"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01f0"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0213\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0219\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0232"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u023a\b\u0014\u0001\u0014\u0003\u0014\u023d\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0243\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u024d\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0257\b\u0014\u0005\u0014\u0259\b\u0014\n\u0014\f\u0014\u025c"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0268"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u026e"+
		"\b\u0014\u0003\u0014\u0270\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0275\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0004\u0016\u0281\b\u0016\u000b\u0016\f\u0016\u0282\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u02a6\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u02ae\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u02b4\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u02c1"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u02e7\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u02ee\b\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u02f3\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0003 \u02fd\b \u0001!\u0001!"+
		"\u0003!\u0301\b!\u0001!\u0001!\u0001!\u0003!\u0306\b!\u0005!\u0308\b!"+
		"\n!\f!\u030b\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u0315\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0003\"\u031e\b\"\u0005\"\u0320\b\"\n\"\f\"\u0323\t\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u033b\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0005%\u0348\b%\n%\f%\u034b\t%\u0001%\u0001"+
		"%\u0005%\u034f\b%\n%\f%\u0352\t%\u0001%\u0001%\u0001%\u0001%\u0005%\u0358"+
		"\b%\n%\f%\u035b\t%\u0001%\u0003%\u035e\b%\u0001%\u0001%\u0001%\u0001&"+
		"\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0005\'\u036f\b\'\n\'\f\'\u0372\t\'\u0003\'\u0374\b\'\u0001"+
		"\'\u0001\'\u0001(\u0004(\u0379\b(\u000b(\f(\u037a\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0003(\u0384\b(\u0001)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u0391\b*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0005+\u0399\b+\n+\f+\u039c\t+\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001,\u0005,\u03a4\b,\n,\f,\u03a7\t,\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0005-\u03af\b-\n-\f-\u03b2\t-\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0005.\u03ba\b.\n.\f.\u03bd\t.\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0005/\u03c5\b/\n/\f/\u03c8\t/\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00030\u03d0\b0\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00011\u00011\u00051\u03dc\b1\n1"+
		"\f1\u03df\t1\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00012\u00052\u03eb\b2\n2\f2\u03ee\t2\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00053\u0402\b3\n3\f3\u0405\t3\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00034\u0419\b4\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00035\u0435\b5\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00046\u0469\b6\u000b6\f6\u046a\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00036\u047e\b6\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00057\u0486\b7\n7\f7\u0489\t7\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u0493\b8\u00019\u0001"+
		"9\u00019\u00019\u00059\u0499\b9\n9\f9\u049c\t9\u00019\u00019\u00019\u0000"+
		"\u0000:\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnpr\u0000\u0003"+
		"\u0001\u0000AB\u0002\u0000\u0002\u0002\r\u0016\u0001\u0000\u0017\u0018"+
		"\u0514\u0000{\u0001\u0000\u0000\u0000\u0002\u0081\u0001\u0000\u0000\u0000"+
		"\u0004\u00a2\u0001\u0000\u0000\u0000\u0006\u00ae\u0001\u0000\u0000\u0000"+
		"\b\u00e0\u0001\u0000\u0000\u0000\n\u00f6\u0001\u0000\u0000\u0000\f\u0103"+
		"\u0001\u0000\u0000\u0000\u000e\u0108\u0001\u0000\u0000\u0000\u0010\u010f"+
		"\u0001\u0000\u0000\u0000\u0012\u013d\u0001\u0000\u0000\u0000\u0014\u013f"+
		"\u0001\u0000\u0000\u0000\u0016\u0148\u0001\u0000\u0000\u0000\u0018\u016c"+
		"\u0001\u0000\u0000\u0000\u001a\u0172\u0001\u0000\u0000\u0000\u001c\u0178"+
		"\u0001\u0000\u0000\u0000\u001e\u018e\u0001\u0000\u0000\u0000 \u0196\u0001"+
		"\u0000\u0000\u0000\"\u01ef\u0001\u0000\u0000\u0000$\u0212\u0001\u0000"+
		"\u0000\u0000&\u0218\u0001\u0000\u0000\u0000(\u0274\u0001\u0000\u0000\u0000"+
		"*\u0276\u0001\u0000\u0000\u0000,\u02a5\u0001\u0000\u0000\u0000.\u02ad"+
		"\u0001\u0000\u0000\u00000\u02b3\u0001\u0000\u0000\u00002\u02b7\u0001\u0000"+
		"\u0000\u00004\u02c4\u0001\u0000\u0000\u00006\u02cd\u0001\u0000\u0000\u0000"+
		"8\u02d1\u0001\u0000\u0000\u0000:\u02d5\u0001\u0000\u0000\u0000<\u02da"+
		"\u0001\u0000\u0000\u0000>\u02df\u0001\u0000\u0000\u0000@\u02fc\u0001\u0000"+
		"\u0000\u0000B\u0300\u0001\u0000\u0000\u0000D\u030c\u0001\u0000\u0000\u0000"+
		"F\u0324\u0001\u0000\u0000\u0000H\u033a\u0001\u0000\u0000\u0000J\u033c"+
		"\u0001\u0000\u0000\u0000L\u0362\u0001\u0000\u0000\u0000N\u0373\u0001\u0000"+
		"\u0000\u0000P\u0383\u0001\u0000\u0000\u0000R\u0385\u0001\u0000\u0000\u0000"+
		"T\u0388\u0001\u0000\u0000\u0000V\u0392\u0001\u0000\u0000\u0000X\u039d"+
		"\u0001\u0000\u0000\u0000Z\u03a8\u0001\u0000\u0000\u0000\\\u03b3\u0001"+
		"\u0000\u0000\u0000^\u03be\u0001\u0000\u0000\u0000`\u03c9\u0001\u0000\u0000"+
		"\u0000b\u03d1\u0001\u0000\u0000\u0000d\u03e0\u0001\u0000\u0000\u0000f"+
		"\u03ef\u0001\u0000\u0000\u0000h\u0418\u0001\u0000\u0000\u0000j\u0434\u0001"+
		"\u0000\u0000\u0000l\u047d\u0001\u0000\u0000\u0000n\u047f\u0001\u0000\u0000"+
		"\u0000p\u0492\u0001\u0000\u0000\u0000r\u049a\u0001\u0000\u0000\u0000t"+
		"|\u0003\u0002\u0001\u0000u|\u0003\u0004\u0002\u0000v|\u0003\u0006\u0003"+
		"\u0000w|\u0003\n\u0005\u0000x|\u0003\u0012\t\u0000y|\u0003\u0014\n\u0000"+
		"z|\u0003\u0016\u000b\u0000{t\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000"+
		"\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0000\u0000\u0001\u0080"+
		"\u0001\u0001\u0000\u0000\u0000\u0081\u0083\u00054\u0000\u0000\u0082\u0084"+
		"\u0005I\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u0001\u0000\u0000\u0086\u008b\u0005I\u0000\u0000\u0087\u0088\u0005\u0002"+
		"\u0000\u0000\u0088\u0089\u0003R)\u0000\u0089\u008a\u0006\u0001\uffff\uffff"+
		"\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0087\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000"+
		"\u0000\u008d\u0099\u0006\u0001\uffff\uffff\u0000\u008e\u008f\u0005\u0003"+
		"\u0000\u0000\u008f\u0094\u0005I\u0000\u0000\u0090\u0091\u0005\u0002\u0000"+
		"\u0000\u0091\u0092\u0003R)\u0000\u0092\u0093\u0006\u0001\uffff\uffff\u0000"+
		"\u0093\u0095\u0001\u0000\u0000\u0000\u0094\u0090\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0006\u0001\uffff\uffff\u0000\u0097\u008e\u0001\u0000\u0000"+
		"\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009e\u0005\u0003\u0000"+
		"\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0004\u0000"+
		"\u0000\u00a0\u00a1\u0005\u0005\u0000\u0000\u00a1\u0003\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u00055\u0000\u0000\u00a3\u00a4\u0005I\u0000\u0000\u00a4"+
		"\u00a6\u0005\u0001\u0000\u0000\u00a5\u00a7\u0003\b\u0004\u0000\u00a6\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0004\u0000\u0000\u00ab\u00ac"+
		"\u0005\u0005\u0000\u0000\u00ac\u00ad\u0006\u0002\uffff\uffff\u0000\u00ad"+
		"\u0005\u0001\u0000\u0000\u0000\u00ae\u00af\u00056\u0000\u0000\u00af\u00b0"+
		"\u0005I\u0000\u0000\u00b0\u00b2\u0005\u0001\u0000\u0000\u00b1\u00b3\u0003"+
		"\b\u0004\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0004"+
		"\u0000\u0000\u00b7\u00b8\u0005\u0005\u0000\u0000\u00b8\u00b9\u0006\u0003"+
		"\uffff\uffff\u0000\u00b9\u0007\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005"+
		"6\u0000\u0000\u00bb\u00bd\u0005\u0001\u0000\u0000\u00bc\u00be\u0003\b"+
		"\u0004\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0004"+
		"\u0000\u0000\u00c2\u00c3\u0005\u0005\u0000\u0000\u00c3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u00055\u0000\u0000\u00c5\u00c7\u0005\u0001\u0000"+
		"\u0000\u00c6\u00c8\u0003\b\u0004\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005\u0004\u0000\u0000\u00cc\u00cd\u0005\u0005\u0000\u0000"+
		"\u00cd\u00e1\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003$\u0012\u0000\u00cf"+
		"\u00d0\u0005\u0006\u0000\u0000\u00d0\u00d1\u0005M\u0000\u0000\u00d1\u00d2"+
		"\u0005\u0005\u0000\u0000\u00d2\u00e1\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0003$\u0012\u0000\u00d4\u00d5\u0005I\u0000\u0000\u00d5\u00d6\u0005\u0006"+
		"\u0000\u0000\u00d6\u00d7\u0005M\u0000\u0000\u00d7\u00d8\u0005\u0005\u0000"+
		"\u0000\u00d8\u00d9\u0006\u0004\uffff\uffff\u0000\u00d9\u00e1\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0003$\u0012\u0000\u00db\u00dc\u0003\u0010\b"+
		"\u0000\u00dc\u00dd\u0005I\u0000\u0000\u00dd\u00de\u0005\u0005\u0000\u0000"+
		"\u00de\u00df\u0006\u0004\uffff\uffff\u0000\u00df\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e0\u00ba\u0001\u0000\u0000\u0000\u00e0\u00c4\u0001\u0000\u0000"+
		"\u0000\u00e0\u00ce\u0001\u0000\u0000\u0000\u00e0\u00d3\u0001\u0000\u0000"+
		"\u0000\u00e0\u00da\u0001\u0000\u0000\u0000\u00e1\t\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u00057\u0000\u0000\u00e3\u00e4\u0003$\u0012\u0000\u00e4\u00e5"+
		"\u0003\u000e\u0007\u0000\u00e5\u00e6\u0005I\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0005\u0000\u0000\u00e7\u00e8\u0006\u0005\uffff\uffff\u0000\u00e8\u00f7"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ea\u00057\u0000\u0000\u00ea\u00eb\u0003"+
		"$\u0012\u0000\u00eb\u00ec\u0003\u0010\b\u0000\u00ec\u00ed\u0005\u0007"+
		"\u0000\u0000\u00ed\u00ee\u0005\b\u0000\u0000\u00ee\u00ef\u0005I\u0000"+
		"\u0000\u00ef\u00f0\u0005\t\u0000\u0000\u00f0\u00f1\u0005\u0007\u0000\u0000"+
		"\u00f1\u00f2\u0003\f\u0006\u0000\u00f2\u00f3\u0005\t\u0000\u0000\u00f3"+
		"\u00f4\u0005\u0005\u0000\u0000\u00f4\u00f5\u0006\u0005\uffff\uffff\u0000"+
		"\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00e2\u0001\u0000\u0000\u0000"+
		"\u00f6\u00e9\u0001\u0000\u0000\u0000\u00f7\u000b\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0003$\u0012\u0000\u00f9\u0100\u0003\u0010\b\u0000\u00fa"+
		"\u00fb\u0005\u0003\u0000\u0000\u00fb\u00fc\u0003$\u0012\u0000\u00fc\u00fd"+
		"\u0003\u0010\b\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00fa\u0001"+
		"\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0104\u0001"+
		"\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u00f8\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\r\u0001\u0000"+
		"\u0000\u0000\u0105\u0107\u0005\b\u0000\u0000\u0106\u0105\u0001\u0000\u0000"+
		"\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u000f\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010c\u0005\b\u0000\u0000"+
		"\u010c\u010e\u0006\b\uffff\uffff\u0000\u010d\u010b\u0001\u0000\u0000\u0000"+
		"\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0011\u0001\u0000\u0000\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0114\u0007\u0000\u0000\u0000"+
		"\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000"+
		"\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0003$\u0012\u0000\u0119\u011a\u0005I\u0000\u0000\u011a\u011b"+
		"\u0003\u001a\r\u0000\u011b\u011c\u0005\u0005\u0000\u0000\u011c\u011d\u0006"+
		"\t\uffff\uffff\u0000\u011d\u013e\u0001\u0000\u0000\u0000\u011e\u0120\u0007"+
		"\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001"+
		"\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001"+
		"\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0003$\u0012\u0000\u0125\u0126\u0006\t"+
		"\uffff\uffff\u0000\u0126\u0127\u0003\u0010\b\u0000\u0127\u012a\u0005I"+
		"\u0000\u0000\u0128\u0129\u0005\u0002\u0000\u0000\u0129\u012b\u0003R)\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u0138\u0006\t\uffff\uffff\u0000"+
		"\u012d\u012e\u0005\u0003\u0000\u0000\u012e\u012f\u0003\u0010\b\u0000\u012f"+
		"\u0132\u0005I\u0000\u0000\u0130\u0131\u0005\u0002\u0000\u0000\u0131\u0133"+
		"\u0003R)\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"+
		"\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0006\t\uffff"+
		"\uffff\u0000\u0135\u0137\u0001\u0000\u0000\u0000\u0136\u012d\u0001\u0000"+
		"\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b\u0001\u0000"+
		"\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c\u0005\u0005"+
		"\u0000\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d\u0115\u0001\u0000"+
		"\u0000\u0000\u013d\u0121\u0001\u0000\u0000\u0000\u013e\u0013\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0003$\u0012\u0000\u0140\u0141\u0003\u0010\b"+
		"\u0000\u0141\u0142\u0005I\u0000\u0000\u0142\u0143\u0005\u0007\u0000\u0000"+
		"\u0143\u0144\u0003\u0018\f\u0000\u0144\u0145\u0005\t\u0000\u0000\u0145"+
		"\u0146\u0005\u0005\u0000\u0000\u0146\u0147\u0006\n\uffff\uffff\u0000\u0147"+
		"\u0015\u0001\u0000\u0000\u0000\u0148\u0149\u0003$\u0012\u0000\u0149\u014a"+
		"\u0003\u0010\b\u0000\u014a\u014b\u0005I\u0000\u0000\u014b\u014c\u0005"+
		"\u0007\u0000\u0000\u014c\u014d\u0003\u0018\f\u0000\u014d\u014e\u0005\t"+
		"\u0000\u0000\u014e\u014f\u0006\u000b\uffff\uffff\u0000\u014f\u0150\u0005"+
		"\u0001\u0000\u0000\u0150\u0151\u0003\"\u0011\u0000\u0151\u0152\u0003&"+
		"\u0013\u0000\u0152\u0153\u0005\u0004\u0000\u0000\u0153\u0154\u0006\u000b"+
		"\uffff\uffff\u0000\u0154\u0017\u0001\u0000\u0000\u0000\u0155\u0156\u0003"+
		"$\u0012\u0000\u0156\u0157\u0003\u0010\b\u0000\u0157\u015a\u0005I\u0000"+
		"\u0000\u0158\u0159\u0005\n\u0000\u0000\u0159\u015b\u0005\u000b\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u0169\u0006\f\uffff\uffff\u0000"+
		"\u015d\u015e\u0005\u0003\u0000\u0000\u015e\u015f\u0003$\u0012\u0000\u015f"+
		"\u0160\u0003\u0010\b\u0000\u0160\u0163\u0005I\u0000\u0000\u0161\u0162"+
		"\u0005\n\u0000\u0000\u0162\u0164\u0005\u000b\u0000\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0006\f\uffff\uffff\u0000\u0166\u0168\u0001"+
		"\u0000\u0000\u0000\u0167\u015d\u0001\u0000\u0000\u0000\u0168\u016b\u0001"+
		"\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001"+
		"\u0000\u0000\u0000\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001"+
		"\u0000\u0000\u0000\u016c\u0155\u0001\u0000\u0000\u0000\u016c\u016d\u0001"+
		"\u0000\u0000\u0000\u016d\u0019\u0001\u0000\u0000\u0000\u016e\u016f\u0005"+
		"\n\u0000\u0000\u016f\u0170\u0005M\u0000\u0000\u0170\u0171\u0005\u000b"+
		"\u0000\u0000\u0171\u0173\u0006\r\uffff\uffff\u0000\u0172\u016e\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000"+
		"\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000"+
		"\u0000\u0000\u0176\u0177\u0006\r\uffff\uffff\u0000\u0177\u001b\u0001\u0000"+
		"\u0000\u0000\u0178\u017d\u0003\u001e\u000f\u0000\u0179\u017a\u0005\u0003"+
		"\u0000\u0000\u017a\u017c\u0003\u001e\u000f\u0000\u017b\u0179\u0001\u0000"+
		"\u0000\u0000\u017c\u017f\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u0181\u0001\u0000"+
		"\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180\u0182\u0005\u0003"+
		"\u0000\u0000\u0181\u0180\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000"+
		"\u0000\u0000\u0182\u001d\u0001\u0000\u0000\u0000\u0183\u0184\u0005\n\u0000"+
		"\u0000\u0184\u0185\u0003R)\u0000\u0185\u0186\u0005\u000b\u0000\u0000\u0186"+
		"\u0187\u0005\u0002\u0000\u0000\u0187\u0188\u0003 \u0010\u0000\u0188\u018f"+
		"\u0001\u0000\u0000\u0000\u0189\u018a\u0005\f\u0000\u0000\u018a\u018b\u0005"+
		"I\u0000\u0000\u018b\u018c\u0005\u0002\u0000\u0000\u018c\u018f\u0003 \u0010"+
		"\u0000\u018d\u018f\u0003 \u0010\u0000\u018e\u0183\u0001\u0000\u0000\u0000"+
		"\u018e\u0189\u0001\u0000\u0000\u0000\u018e\u018d\u0001\u0000\u0000\u0000"+
		"\u018f\u001f\u0001\u0000\u0000\u0000\u0190\u0192\u0005\u0001\u0000\u0000"+
		"\u0191\u0193\u0003\u001c\u000e\u0000\u0192\u0191\u0001\u0000\u0000\u0000"+
		"\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000"+
		"\u0194\u0197\u0005\u0004\u0000\u0000\u0195\u0197\u0003R)\u0000\u0196\u0190"+
		"\u0001\u0000\u0000\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0197!\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u00055\u0000\u0000\u0199\u019a\u0005I\u0000"+
		"\u0000\u019a\u019b\u0003\u0010\b\u0000\u019b\u019c\u0005I\u0000\u0000"+
		"\u019c\u01a8\u0006\u0011\uffff\uffff\u0000\u019d\u01a6\u0005\u0002\u0000"+
		"\u0000\u019e\u01a0\u0005\u0001\u0000\u0000\u019f\u01a1\u0003\u001c\u000e"+
		"\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a7\u0005\u0004\u0000"+
		"\u0000\u01a3\u01a4\u0003R)\u0000\u01a4\u01a5\u0006\u0011\uffff\uffff\u0000"+
		"\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u019e\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a3\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000"+
		"\u01a8\u019d\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005\u0005\u0000\u0000"+
		"\u01ab\u01ac\u0003\"\u0011\u0000\u01ac\u01f0\u0001\u0000\u0000\u0000\u01ad"+
		"\u01af\u0007\u0000\u0000\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b1\u0005+\u0000\u0000\u01b1\u01b2\u0005I\u0000\u0000\u01b2\u01b3\u0005"+
		"\n\u0000\u0000\u01b3\u01b4\u0005\u000b\u0000\u0000\u01b4\u01b6\u0005\u0002"+
		"\u0000\u0000\u01b5\u01b7\u0005O\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000"+
		"\u0000\u01ba\u01bb\u0005\u0005\u0000\u0000\u01bb\u01bc\u0006\u0011\uffff"+
		"\uffff\u0000\u01bc\u01f0\u0003\"\u0011\u0000\u01bd\u01bf\u0007\u0000\u0000"+
		"\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01be\u01bf\u0001\u0000\u0000"+
		"\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c1\u0003$\u0012\u0000"+
		"\u01c1\u01c2\u0005I\u0000\u0000\u01c2\u01c9\u0003\u001a\r\u0000\u01c3"+
		"\u01c4\u0005\u0002\u0000\u0000\u01c4\u01c6\u0005\u0001\u0000\u0000\u01c5"+
		"\u01c7\u0003\u001c\u000e\u0000\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8"+
		"\u01ca\u0005\u0004\u0000\u0000\u01c9\u01c3\u0001\u0000\u0000\u0000\u01c9"+
		"\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb"+
		"\u01cc\u0005\u0005\u0000\u0000\u01cc\u01cd\u0006\u0011\uffff\uffff\u0000"+
		"\u01cd\u01ce\u0003\"\u0011\u0000\u01ce\u01f0\u0001\u0000\u0000\u0000\u01cf"+
		"\u01d1\u0007\u0000\u0000\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0003$\u0012\u0000\u01d3\u01d4\u0003\u0010\b\u0000\u01d4\u01d5"+
		"\u0005I\u0000\u0000\u01d5\u01da\u0006\u0011\uffff\uffff\u0000\u01d6\u01d7"+
		"\u0005\u0002\u0000\u0000\u01d7\u01d8\u0003R)\u0000\u01d8\u01d9\u0006\u0011"+
		"\uffff\uffff\u0000\u01d9\u01db\u0001\u0000\u0000\u0000\u01da\u01d6\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01e8\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0005\u0003\u0000\u0000\u01dd\u01de\u0003"+
		"\u0010\b\u0000\u01de\u01df\u0005I\u0000\u0000\u01df\u01e4\u0006\u0011"+
		"\uffff\uffff\u0000\u01e0\u01e1\u0005\u0002\u0000\u0000\u01e1\u01e2\u0003"+
		"R)\u0000\u01e2\u01e3\u0006\u0011\uffff\uffff\u0000\u01e3\u01e5\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e0\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6\u01dc\u0001\u0000"+
		"\u0000\u0000\u01e7\u01ea\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01eb\u0001\u0000"+
		"\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01eb\u01ec\u0005\u0005"+
		"\u0000\u0000\u01ec\u01ed\u0003\"\u0011\u0000\u01ed\u01f0\u0001\u0000\u0000"+
		"\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef\u0198\u0001\u0000\u0000"+
		"\u0000\u01ef\u01ae\u0001\u0000\u0000\u0000\u01ef\u01be\u0001\u0000\u0000"+
		"\u0000\u01ef\u01d0\u0001\u0000\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000"+
		"\u0000\u01f0#\u0001\u0000\u0000\u0000\u01f1\u01f2\u0005\'\u0000\u0000"+
		"\u01f2\u0213\u0006\u0012\uffff\uffff\u0000\u01f3\u01f4\u0005(\u0000\u0000"+
		"\u01f4\u0213\u0006\u0012\uffff\uffff\u0000\u01f5\u01f6\u0005)\u0000\u0000"+
		"\u01f6\u0213\u0006\u0012\uffff\uffff\u0000\u01f7\u01f8\u0005*\u0000\u0000"+
		"\u01f8\u0213\u0006\u0012\uffff\uffff\u0000\u01f9\u01fa\u0005+\u0000\u0000"+
		"\u01fa\u0213\u0006\u0012\uffff\uffff\u0000\u01fb\u01fc\u0005F\u0000\u0000"+
		"\u01fc\u0213\u0006\u0012\uffff\uffff\u0000\u01fd\u01fe\u0005/\u0000\u0000"+
		"\u01fe\u01ff\u0005-\u0000\u0000\u01ff\u0200\u0005-\u0000\u0000\u0200\u0213"+
		"\u0006\u0012\uffff\uffff\u0000\u0201\u0202\u0005-\u0000\u0000\u0202\u0203"+
		"\u0005-\u0000\u0000\u0203\u0213\u0006\u0012\uffff\uffff\u0000\u0204\u0205"+
		"\u0005/\u0000\u0000\u0205\u0206\u0005-\u0000\u0000\u0206\u0213\u0006\u0012"+
		"\uffff\uffff\u0000\u0207\u0208\u0005/\u0000\u0000\u0208\u0209\u0005\'"+
		"\u0000\u0000\u0209\u0213\u0006\u0012\uffff\uffff\u0000\u020a\u020b\u0005"+
		"/\u0000\u0000\u020b\u0213\u0006\u0012\uffff\uffff\u0000\u020c\u020d\u0005"+
		"-\u0000\u0000\u020d\u0213\u0006\u0012\uffff\uffff\u0000\u020e\u020f\u0005"+
		".\u0000\u0000\u020f\u0213\u0006\u0012\uffff\uffff\u0000\u0210\u0211\u0005"+
		"I\u0000\u0000\u0211\u0213\u0006\u0012\uffff\uffff\u0000\u0212\u01f1\u0001"+
		"\u0000\u0000\u0000\u0212\u01f3\u0001\u0000\u0000\u0000\u0212\u01f5\u0001"+
		"\u0000\u0000\u0000\u0212\u01f7\u0001\u0000\u0000\u0000\u0212\u01f9\u0001"+
		"\u0000\u0000\u0000\u0212\u01fb\u0001\u0000\u0000\u0000\u0212\u01fd\u0001"+
		"\u0000\u0000\u0000\u0212\u0201\u0001\u0000\u0000\u0000\u0212\u0204\u0001"+
		"\u0000\u0000\u0000\u0212\u0207\u0001\u0000\u0000\u0000\u0212\u020a\u0001"+
		"\u0000\u0000\u0000\u0212\u020c\u0001\u0000\u0000\u0000\u0212\u020e\u0001"+
		"\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0213%\u0001\u0000"+
		"\u0000\u0000\u0214\u0215\u0003(\u0014\u0000\u0215\u0216\u0003&\u0013\u0000"+
		"\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000\u0000"+
		"\u0218\u0214\u0001\u0000\u0000\u0000\u0218\u0217\u0001\u0000\u0000\u0000"+
		"\u0219\'\u0001\u0000\u0000\u0000\u021a\u021b\u0003,\u0016\u0000\u021b"+
		"\u021c\u0005\u0005\u0000\u0000\u021c\u0275\u0001\u0000\u0000\u0000\u021d"+
		"\u021e\u00030\u0018\u0000\u021e\u021f\u0005\u0005\u0000\u0000\u021f\u0275"+
		"\u0001\u0000\u0000\u0000\u0220\u0275\u00032\u0019\u0000\u0221\u0275\u0003"+
		"4\u001a\u0000\u0222\u0275\u0003>\u001f\u0000\u0223\u0275\u0003F#\u0000"+
		"\u0224\u0275\u0003J%\u0000\u0225\u0226\u0003.\u0017\u0000\u0226\u0227"+
		"\u0005\u0005\u0000\u0000\u0227\u0275\u0001\u0000\u0000\u0000\u0228\u0229"+
		"\u0003L&\u0000\u0229\u022a\u0005\u0005\u0000\u0000\u022a\u0275\u0001\u0000"+
		"\u0000\u0000\u022b\u0275\u0003*\u0015\u0000\u022c\u0275\u00036\u001b\u0000"+
		"\u022d\u0275\u00038\u001c\u0000\u022e\u0275\u0003:\u001d\u0000\u022f\u0275"+
		"\u0003<\u001e\u0000\u0230\u0232\u0007\u0000\u0000\u0000\u0231\u0230\u0001"+
		"\u0000\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000\u0232\u0233\u0001"+
		"\u0000\u0000\u0000\u0233\u0234\u0003$\u0012\u0000\u0234\u0235\u0005I\u0000"+
		"\u0000\u0235\u023c\u0003\u001a\r\u0000\u0236\u0237\u0005\u0002\u0000\u0000"+
		"\u0237\u0239\u0005\u0001\u0000\u0000\u0238\u023a\u0003\u001c\u000e\u0000"+
		"\u0239\u0238\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000"+
		"\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023d\u0005\u0004\u0000\u0000"+
		"\u023c\u0236\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000"+
		"\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023f\u0005\u0005\u0000\u0000"+
		"\u023f\u0240\u0006\u0014\uffff\uffff\u0000\u0240\u0275\u0001\u0000\u0000"+
		"\u0000\u0241\u0243\u0007\u0000\u0000\u0000\u0242\u0241\u0001\u0000\u0000"+
		"\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000"+
		"\u0000\u0244\u0245\u0003$\u0012\u0000\u0245\u0246\u0003\u0010\b\u0000"+
		"\u0246\u0247\u0005I\u0000\u0000\u0247\u024c\u0006\u0014\uffff\uffff\u0000"+
		"\u0248\u0249\u0005\u0002\u0000\u0000\u0249\u024a\u0003R)\u0000\u024a\u024b"+
		"\u0006\u0014\uffff\uffff\u0000\u024b\u024d\u0001\u0000\u0000\u0000\u024c"+
		"\u0248\u0001\u0000\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d"+
		"\u025a\u0001\u0000\u0000\u0000\u024e\u024f\u0005\u0003\u0000\u0000\u024f"+
		"\u0250\u0003\u0010\b\u0000\u0250\u0251\u0005I\u0000\u0000\u0251\u0256"+
		"\u0006\u0014\uffff\uffff\u0000\u0252\u0253\u0005\u0002\u0000\u0000\u0253"+
		"\u0254\u0003R)\u0000\u0254\u0255\u0006\u0014\uffff\uffff\u0000\u0255\u0257"+
		"\u0001\u0000\u0000\u0000\u0256\u0252\u0001\u0000\u0000\u0000\u0256\u0257"+
		"\u0001\u0000\u0000\u0000\u0257\u0259\u0001\u0000\u0000\u0000\u0258\u024e"+
		"\u0001\u0000\u0000\u0000\u0259\u025c\u0001\u0000\u0000\u0000\u025a\u0258"+
		"\u0001\u0000\u0000\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025d"+
		"\u0001\u0000\u0000\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u025e"+
		"\u0005\u0005\u0000\u0000\u025e\u0275\u0001\u0000\u0000\u0000\u025f\u0260"+
		"\u00055\u0000\u0000\u0260\u0261\u0005I\u0000\u0000\u0261\u0262\u0003\u0010"+
		"\b\u0000\u0262\u0263\u0005I\u0000\u0000\u0263\u026f\u0006\u0014\uffff"+
		"\uffff\u0000\u0264\u026d\u0005\u0002\u0000\u0000\u0265\u0267\u0005\u0001"+
		"\u0000\u0000\u0266\u0268\u0003\u001c\u000e\u0000\u0267\u0266\u0001\u0000"+
		"\u0000\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268\u0269\u0001\u0000"+
		"\u0000\u0000\u0269\u026e\u0005\u0004\u0000\u0000\u026a\u026b\u0003R)\u0000"+
		"\u026b\u026c\u0006\u0014\uffff\uffff\u0000\u026c\u026e\u0001\u0000\u0000"+
		"\u0000\u026d\u0265\u0001\u0000\u0000\u0000\u026d\u026a\u0001\u0000\u0000"+
		"\u0000\u026e\u0270\u0001\u0000\u0000\u0000\u026f\u0264\u0001\u0000\u0000"+
		"\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0005\u0005\u0000\u0000\u0272\u0275\u0001\u0000\u0000"+
		"\u0000\u0273\u0275\u0005\u0005\u0000\u0000\u0274\u021a\u0001\u0000\u0000"+
		"\u0000\u0274\u021d\u0001\u0000\u0000\u0000\u0274\u0220\u0001\u0000\u0000"+
		"\u0000\u0274\u0221\u0001\u0000\u0000\u0000\u0274\u0222\u0001\u0000\u0000"+
		"\u0000\u0274\u0223\u0001\u0000\u0000\u0000\u0274\u0224\u0001\u0000\u0000"+
		"\u0000\u0274\u0225\u0001\u0000\u0000\u0000\u0274\u0228\u0001\u0000\u0000"+
		"\u0000\u0274\u022b\u0001\u0000\u0000\u0000\u0274\u022c\u0001\u0000\u0000"+
		"\u0000\u0274\u022d\u0001\u0000\u0000\u0000\u0274\u022e\u0001\u0000\u0000"+
		"\u0000\u0274\u022f\u0001\u0000\u0000\u0000\u0274\u0231\u0001\u0000\u0000"+
		"\u0000\u0274\u0242\u0001\u0000\u0000\u0000\u0274\u025f\u0001\u0000\u0000"+
		"\u0000\u0274\u0273\u0001\u0000\u0000\u0000\u0275)\u0001\u0000\u0000\u0000"+
		"\u0276\u0277\u0005\u0001\u0000\u0000\u0277\u0278\u0003&\u0013\u0000\u0278"+
		"\u0279\u0005\u0004\u0000\u0000\u0279+\u0001\u0000\u0000\u0000\u027a\u0280"+
		"\u0005I\u0000\u0000\u027b\u027c\u0005\n\u0000\u0000\u027c\u027d\u0003"+
		"R)\u0000\u027d\u027e\u0005\u000b\u0000\u0000\u027e\u027f\u0006\u0016\uffff"+
		"\uffff\u0000\u027f\u0281\u0001\u0000\u0000\u0000\u0280\u027b\u0001\u0000"+
		"\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000"+
		"\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000"+
		"\u0000\u0000\u0284\u0285\u0007\u0001\u0000\u0000\u0285\u0286\u0003R)\u0000"+
		"\u0286\u0287\u0006\u0016\uffff\uffff\u0000\u0287\u02a6\u0001\u0000\u0000"+
		"\u0000\u0288\u0289\u0005I\u0000\u0000\u0289\u028a\u0005\f\u0000\u0000"+
		"\u028a\u028b\u0005I\u0000\u0000\u028b\u028c\u0007\u0001\u0000\u0000\u028c"+
		"\u028d\u0003R)\u0000\u028d\u028e\u0006\u0016\uffff\uffff\u0000\u028e\u02a6"+
		"\u0001\u0000\u0000\u0000\u028f\u0290\u0005I\u0000\u0000\u0290\u0291\u0005"+
		"\u0002\u0000\u0000\u0291\u0292\u0005O\u0000\u0000\u0292\u02a6\u0006\u0016"+
		"\uffff\uffff\u0000\u0293\u0294\u0005\b\u0000\u0000\u0294\u0295\u0005I"+
		"\u0000\u0000\u0295\u0296\u0005\u0002\u0000\u0000\u0296\u0297\u0003R)\u0000"+
		"\u0297\u0298\u0006\u0016\uffff\uffff\u0000\u0298\u02a6\u0001\u0000\u0000"+
		"\u0000\u0299\u029a\u0005I\u0000\u0000\u029a\u029b\u0005G\u0000\u0000\u029b"+
		"\u029c\u0005I\u0000\u0000\u029c\u029d\u0007\u0001\u0000\u0000\u029d\u029e"+
		"\u0003R)\u0000\u029e\u029f\u0006\u0016\uffff\uffff\u0000\u029f\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a0\u02a1\u0005I\u0000\u0000\u02a1\u02a2\u0007\u0001"+
		"\u0000\u0000\u02a2\u02a3\u0003R)\u0000\u02a3\u02a4\u0006\u0016\uffff\uffff"+
		"\u0000\u02a4\u02a6\u0001\u0000\u0000\u0000\u02a5\u027a\u0001\u0000\u0000"+
		"\u0000\u02a5\u0288\u0001\u0000\u0000\u0000\u02a5\u028f\u0001\u0000\u0000"+
		"\u0000\u02a5\u0293\u0001\u0000\u0000\u0000\u02a5\u0299\u0001\u0000\u0000"+
		"\u0000\u02a5\u02a0\u0001\u0000\u0000\u0000\u02a6-\u0001\u0000\u0000\u0000"+
		"\u02a7\u02a8\u00053\u0000\u0000\u02a8\u02a9\u0003R)\u0000\u02a9\u02aa"+
		"\u0006\u0017\uffff\uffff\u0000\u02aa\u02ae\u0001\u0000\u0000\u0000\u02ab"+
		"\u02ac\u00053\u0000\u0000\u02ac\u02ae\u0006\u0017\uffff\uffff\u0000\u02ad"+
		"\u02a7\u0001\u0000\u0000\u0000\u02ad\u02ab\u0001\u0000\u0000\u0000\u02ae"+
		"/\u0001\u0000\u0000\u0000\u02af\u02b0\u0005I\u0000\u0000\u02b0\u02b4\u0007"+
		"\u0002\u0000\u0000\u02b1\u02b2\u0007\u0002\u0000\u0000\u02b2\u02b4\u0005"+
		"I\u0000\u0000\u02b3\u02af\u0001\u0000\u0000\u0000\u02b3\u02b1\u0001\u0000"+
		"\u0000\u0000\u02b4\u02b5\u0001\u0000\u0000\u0000\u02b5\u02b6\u0006\u0018"+
		"\uffff\uffff\u0000\u02b61\u0001\u0000\u0000\u0000\u02b7\u02b8\u00050\u0000"+
		"\u0000\u02b8\u02b9\u0005\u0007\u0000\u0000\u02b9\u02ba\u0003R)\u0000\u02ba"+
		"\u02bb\u0005\t\u0000\u0000\u02bb\u02bc\u0006\u0019\uffff\uffff\u0000\u02bc"+
		"\u02bd\u0003(\u0014\u0000\u02bd\u02c0\u0006\u0019\uffff\uffff\u0000\u02be"+
		"\u02bf\u00051\u0000\u0000\u02bf\u02c1\u0003(\u0014\u0000\u02c0\u02be\u0001"+
		"\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000\u02c1\u02c2\u0001"+
		"\u0000\u0000\u0000\u02c2\u02c3\u0006\u0019\uffff\uffff\u0000\u02c33\u0001"+
		"\u0000\u0000\u0000\u02c4\u02c5\u00052\u0000\u0000\u02c5\u02c6\u0006\u001a"+
		"\uffff\uffff\u0000\u02c6\u02c7\u0005\u0007\u0000\u0000\u02c7\u02c8\u0003"+
		"R)\u0000\u02c8\u02c9\u0005\t\u0000\u0000\u02c9\u02ca\u0006\u001a\uffff"+
		"\uffff\u0000\u02ca\u02cb\u0003(\u0014\u0000\u02cb\u02cc\u0006\u001a\uffff"+
		"\uffff\u0000\u02cc5\u0001\u0000\u0000\u0000\u02cd\u02ce\u0005;\u0000\u0000"+
		"\u02ce\u02cf\u0005\u0005\u0000\u0000\u02cf\u02d0\u0006\u001b\uffff\uffff"+
		"\u0000\u02d07\u0001\u0000\u0000\u0000\u02d1\u02d2\u0005>\u0000\u0000\u02d2"+
		"\u02d3\u0005\u0005\u0000\u0000\u02d3\u02d4\u0006\u001c\uffff\uffff\u0000"+
		"\u02d49\u0001\u0000\u0000\u0000\u02d5\u02d6\u0005?\u0000\u0000\u02d6\u02d7"+
		"\u0005I\u0000\u0000\u02d7\u02d8\u0005\u0005\u0000\u0000\u02d8\u02d9\u0006"+
		"\u001d\uffff\uffff\u0000\u02d9;\u0001\u0000\u0000\u0000\u02da\u02db\u0005"+
		"I\u0000\u0000\u02db\u02dc\u0005\u0006\u0000\u0000\u02dc\u02dd\u0006\u001e"+
		"\uffff\uffff\u0000\u02dd\u02de\u0003(\u0014\u0000\u02de=\u0001\u0000\u0000"+
		"\u0000\u02df\u02e0\u0005<\u0000\u0000\u02e0\u02e1\u0006\u001f\uffff\uffff"+
		"\u0000\u02e1\u02e6\u0005\u0007\u0000\u0000\u02e2\u02e3\u0003@ \u0000\u02e3"+
		"\u02e4\u0005\u0005\u0000\u0000\u02e4\u02e7\u0001\u0000\u0000\u0000\u02e5"+
		"\u02e7\u0005\u0005\u0000\u0000\u02e6\u02e2\u0001\u0000\u0000\u0000\u02e6"+
		"\u02e5\u0001\u0000\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000\u02e8"+
		"\u02ed\u0006\u001f\uffff\uffff\u0000\u02e9\u02ea\u0003R)\u0000\u02ea\u02eb"+
		"\u0006\u001f\uffff\uffff\u0000\u02eb\u02ee\u0001\u0000\u0000\u0000\u02ec"+
		"\u02ee\u0006\u001f\uffff\uffff\u0000\u02ed\u02e9\u0001\u0000\u0000\u0000"+
		"\u02ed\u02ec\u0001\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000"+
		"\u02ef\u02f0\u0005\u0005\u0000\u0000\u02f0\u02f2\u0006\u001f\uffff\uffff"+
		"\u0000\u02f1\u02f3\u0003B!\u0000\u02f2\u02f1\u0001\u0000\u0000\u0000\u02f2"+
		"\u02f3\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000\u0000\u02f4"+
		"\u02f5\u0006\u001f\uffff\uffff\u0000\u02f5\u02f6\u0005\t\u0000\u0000\u02f6"+
		"\u02f7\u0003(\u0014\u0000\u02f7\u02f8\u0006\u001f\uffff\uffff\u0000\u02f8"+
		"?\u0001\u0000\u0000\u0000\u02f9\u02fd\u0003,\u0016\u0000\u02fa\u02fd\u0003"+
		"0\u0018\u0000\u02fb\u02fd\u0003D\"\u0000\u02fc\u02f9\u0001\u0000\u0000"+
		"\u0000\u02fc\u02fa\u0001\u0000\u0000\u0000\u02fc\u02fb\u0001\u0000\u0000"+
		"\u0000\u02fdA\u0001\u0000\u0000\u0000\u02fe\u0301\u0003,\u0016\u0000\u02ff"+
		"\u0301\u00030\u0018\u0000\u0300\u02fe\u0001\u0000\u0000\u0000\u0300\u02ff"+
		"\u0001\u0000\u0000\u0000\u0301\u0309\u0001\u0000\u0000\u0000\u0302\u0305"+
		"\u0005\u0003\u0000\u0000\u0303\u0306\u0003,\u0016\u0000\u0304\u0306\u0003"+
		"0\u0018\u0000\u0305\u0303\u0001\u0000\u0000\u0000\u0305\u0304\u0001\u0000"+
		"\u0000\u0000\u0306\u0308\u0001\u0000\u0000\u0000\u0307\u0302\u0001\u0000"+
		"\u0000\u0000\u0308\u030b\u0001\u0000\u0000\u0000\u0309\u0307\u0001\u0000"+
		"\u0000\u0000\u0309\u030a\u0001\u0000\u0000\u0000\u030aC\u0001\u0000\u0000"+
		"\u0000\u030b\u0309\u0001\u0000\u0000\u0000\u030c\u030d\u0003$\u0012\u0000"+
		"\u030d\u030e\u0003\u0010\b\u0000\u030e\u030f\u0005I\u0000\u0000\u030f"+
		"\u0314\u0006\"\uffff\uffff\u0000\u0310\u0311\u0005\u0002\u0000\u0000\u0311"+
		"\u0312\u0003R)\u0000\u0312\u0313\u0006\"\uffff\uffff\u0000\u0313\u0315"+
		"\u0001\u0000\u0000\u0000\u0314\u0310\u0001\u0000\u0000\u0000\u0314\u0315"+
		"\u0001\u0000\u0000\u0000\u0315\u0321\u0001\u0000\u0000\u0000\u0316\u0317"+
		"\u0005\u0003\u0000\u0000\u0317\u0318\u0005I\u0000\u0000\u0318\u031d\u0006"+
		"\"\uffff\uffff\u0000\u0319\u031a\u0005\u0002\u0000\u0000\u031a\u031b\u0003"+
		"R)\u0000\u031b\u031c\u0006\"\uffff\uffff\u0000\u031c\u031e\u0001\u0000"+
		"\u0000\u0000\u031d\u0319\u0001\u0000\u0000\u0000\u031d\u031e\u0001\u0000"+
		"\u0000\u0000\u031e\u0320\u0001\u0000\u0000\u0000\u031f\u0316\u0001\u0000"+
		"\u0000\u0000\u0320\u0323\u0001\u0000\u0000\u0000\u0321\u031f\u0001\u0000"+
		"\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000\u0322E\u0001\u0000\u0000"+
		"\u0000\u0323\u0321\u0001\u0000\u0000\u0000\u0324\u0325\u0005=\u0000\u0000"+
		"\u0325\u0326\u0006#\uffff\uffff\u0000\u0326\u0327\u0003(\u0014\u0000\u0327"+
		"\u0328\u0006#\uffff\uffff\u0000\u0328\u0329\u00052\u0000\u0000\u0329\u032a"+
		"\u0005\u0007\u0000\u0000\u032a\u032b\u0003R)\u0000\u032b\u032c\u0005\t"+
		"\u0000\u0000\u032c\u032d\u0005\u0005\u0000\u0000\u032d\u032e\u0006#\uffff"+
		"\uffff\u0000\u032eG\u0001\u0000\u0000\u0000\u032f\u0330\u0005M\u0000\u0000"+
		"\u0330\u033b\u0006$\uffff\uffff\u0000\u0331\u0332\u0005\u0019\u0000\u0000"+
		"\u0332\u0333\u0005M\u0000\u0000\u0333\u033b\u0006$\uffff\uffff\u0000\u0334"+
		"\u0335\u0005K\u0000\u0000\u0335\u033b\u0006$\uffff\uffff\u0000\u0336\u0337"+
		"\u0005N\u0000\u0000\u0337\u033b\u0006$\uffff\uffff\u0000\u0338\u0339\u0005"+
		"I\u0000\u0000\u0339\u033b\u0006$\uffff\uffff\u0000\u033a\u032f\u0001\u0000"+
		"\u0000\u0000\u033a\u0331\u0001\u0000\u0000\u0000\u033a\u0334\u0001\u0000"+
		"\u0000\u0000\u033a\u0336\u0001\u0000\u0000\u0000\u033a\u0338\u0001\u0000"+
		"\u0000\u0000\u033bI\u0001\u0000\u0000\u0000\u033c\u033d\u00058\u0000\u0000"+
		"\u033d\u033e\u0005\u0007\u0000\u0000\u033e\u033f\u0003R)\u0000\u033f\u0340"+
		"\u0005\t\u0000\u0000\u0340\u0341\u0006%\uffff\uffff\u0000\u0341\u0350"+
		"\u0005\u0001\u0000\u0000\u0342\u0343\u00059\u0000\u0000\u0343\u0344\u0003"+
		"H$\u0000\u0344\u0345\u0005\u0006\u0000\u0000\u0345\u0349\u0006%\uffff"+
		"\uffff\u0000\u0346\u0348\u0003(\u0014\u0000\u0347\u0346\u0001\u0000\u0000"+
		"\u0000\u0348\u034b\u0001\u0000\u0000\u0000\u0349\u0347\u0001\u0000\u0000"+
		"\u0000\u0349\u034a\u0001\u0000\u0000\u0000\u034a\u034c\u0001\u0000\u0000"+
		"\u0000\u034b\u0349\u0001\u0000\u0000\u0000\u034c\u034d\u0006%\uffff\uffff"+
		"\u0000\u034d\u034f\u0001\u0000\u0000\u0000\u034e\u0342\u0001\u0000\u0000"+
		"\u0000\u034f\u0352\u0001\u0000\u0000\u0000\u0350\u034e\u0001\u0000\u0000"+
		"\u0000\u0350\u0351\u0001\u0000\u0000\u0000\u0351\u035d\u0001\u0000\u0000"+
		"\u0000\u0352\u0350\u0001\u0000\u0000\u0000\u0353\u0354\u0005:\u0000\u0000"+
		"\u0354\u0355\u0005\u0006\u0000\u0000\u0355\u0359\u0006%\uffff\uffff\u0000"+
		"\u0356\u0358\u0003(\u0014\u0000\u0357\u0356\u0001\u0000\u0000\u0000\u0358"+
		"\u035b\u0001\u0000\u0000\u0000\u0359\u0357\u0001\u0000\u0000\u0000\u0359"+
		"\u035a\u0001\u0000\u0000\u0000\u035a\u035c\u0001\u0000\u0000\u0000\u035b"+
		"\u0359\u0001\u0000\u0000\u0000\u035c\u035e\u0006%\uffff\uffff\u0000\u035d"+
		"\u0353\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e"+
		"\u035f\u0001\u0000\u0000\u0000\u035f\u0360\u0005\u0004\u0000\u0000\u0360"+
		"\u0361\u0006%\uffff\uffff\u0000\u0361K\u0001\u0000\u0000\u0000\u0362\u0363"+
		"\u0005I\u0000\u0000\u0363\u0364\u0005\u0007\u0000\u0000\u0364\u0365\u0003"+
		"N\'\u0000\u0365\u0366\u0005\t\u0000\u0000\u0366\u0367\u0006&\uffff\uffff"+
		"\u0000\u0367M\u0001\u0000\u0000\u0000\u0368\u0369\u0003P(\u0000\u0369"+
		"\u0370\u0006\'\uffff\uffff\u0000\u036a\u036b\u0005\u0003\u0000\u0000\u036b"+
		"\u036c\u0003P(\u0000\u036c\u036d\u0006\'\uffff\uffff\u0000\u036d\u036f"+
		"\u0001\u0000\u0000\u0000\u036e\u036a\u0001\u0000\u0000\u0000\u036f\u0372"+
		"\u0001\u0000\u0000\u0000\u0370\u036e\u0001\u0000\u0000\u0000\u0370\u0371"+
		"\u0001\u0000\u0000\u0000\u0371\u0374\u0001\u0000\u0000\u0000\u0372\u0370"+
		"\u0001\u0000\u0000\u0000\u0373\u0368\u0001\u0000\u0000\u0000\u0373\u0374"+
		"\u0001\u0000\u0000\u0000\u0374\u0375\u0001\u0000\u0000\u0000\u0375\u0376"+
		"\u0006\'\uffff\uffff\u0000\u0376O\u0001\u0000\u0000\u0000\u0377\u0379"+
		"\u0005O\u0000\u0000\u0378\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001"+
		"\u0000\u0000\u0000\u037a\u0378\u0001\u0000\u0000\u0000\u037a\u037b\u0001"+
		"\u0000\u0000\u0000\u037b\u037c\u0001\u0000\u0000\u0000\u037c\u0384\u0006"+
		"(\uffff\uffff\u0000\u037d\u037e\u0005\u001a\u0000\u0000\u037e\u037f\u0005"+
		"I\u0000\u0000\u037f\u0384\u0006(\uffff\uffff\u0000\u0380\u0381\u0003R"+
		")\u0000\u0381\u0382\u0006(\uffff\uffff\u0000\u0382\u0384\u0001\u0000\u0000"+
		"\u0000\u0383\u0378\u0001\u0000\u0000\u0000\u0383\u037d\u0001\u0000\u0000"+
		"\u0000\u0383\u0380\u0001\u0000\u0000\u0000\u0384Q\u0001\u0000\u0000\u0000"+
		"\u0385\u0386\u0003T*\u0000\u0386\u0387\u0006)\uffff\uffff\u0000\u0387"+
		"S\u0001\u0000\u0000\u0000\u0388\u0389\u0003V+\u0000\u0389\u0390\u0006"+
		"*\uffff\uffff\u0000\u038a\u038b\u0005\u001b\u0000\u0000\u038b\u038c\u0003"+
		"R)\u0000\u038c\u038d\u0005\u0006\u0000\u0000\u038d\u038e\u0003T*\u0000"+
		"\u038e\u038f\u0006*\uffff\uffff\u0000\u038f\u0391\u0001\u0000\u0000\u0000"+
		"\u0390\u038a\u0001\u0000\u0000\u0000\u0390\u0391\u0001\u0000\u0000\u0000"+
		"\u0391U\u0001\u0000\u0000\u0000\u0392\u0393\u0003X,\u0000\u0393\u039a"+
		"\u0006+\uffff\uffff\u0000\u0394\u0395\u0005\u001c\u0000\u0000\u0395\u0396"+
		"\u0003X,\u0000\u0396\u0397\u0006+\uffff\uffff\u0000\u0397\u0399\u0001"+
		"\u0000\u0000\u0000\u0398\u0394\u0001\u0000\u0000\u0000\u0399\u039c\u0001"+
		"\u0000\u0000\u0000\u039a\u0398\u0001\u0000\u0000\u0000\u039a\u039b\u0001"+
		"\u0000\u0000\u0000\u039bW\u0001\u0000\u0000\u0000\u039c\u039a\u0001\u0000"+
		"\u0000\u0000\u039d\u039e\u0003Z-\u0000\u039e\u03a5\u0006,\uffff\uffff"+
		"\u0000\u039f\u03a0\u0005\u001d\u0000\u0000\u03a0\u03a1\u0003Z-\u0000\u03a1"+
		"\u03a2\u0006,\uffff\uffff\u0000\u03a2\u03a4\u0001\u0000\u0000\u0000\u03a3"+
		"\u039f\u0001\u0000\u0000\u0000\u03a4\u03a7\u0001\u0000\u0000\u0000\u03a5"+
		"\u03a3\u0001\u0000\u0000\u0000\u03a5\u03a6\u0001\u0000\u0000\u0000\u03a6"+
		"Y\u0001\u0000\u0000\u0000\u03a7\u03a5\u0001\u0000\u0000\u0000\u03a8\u03a9"+
		"\u0003\\.\u0000\u03a9\u03b0\u0006-\uffff\uffff\u0000\u03aa\u03ab\u0005"+
		"\u001e\u0000\u0000\u03ab\u03ac\u0003\\.\u0000\u03ac\u03ad\u0006-\uffff"+
		"\uffff\u0000\u03ad\u03af\u0001\u0000\u0000\u0000\u03ae\u03aa\u0001\u0000"+
		"\u0000\u0000\u03af\u03b2\u0001\u0000\u0000\u0000\u03b0\u03ae\u0001\u0000"+
		"\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1[\u0001\u0000\u0000"+
		"\u0000\u03b2\u03b0\u0001\u0000\u0000\u0000\u03b3\u03b4\u0003^/\u0000\u03b4"+
		"\u03bb\u0006.\uffff\uffff\u0000\u03b5\u03b6\u0005\u001f\u0000\u0000\u03b6"+
		"\u03b7\u0003^/\u0000\u03b7\u03b8\u0006.\uffff\uffff\u0000\u03b8\u03ba"+
		"\u0001\u0000\u0000\u0000\u03b9\u03b5\u0001\u0000\u0000\u0000\u03ba\u03bd"+
		"\u0001\u0000\u0000\u0000\u03bb\u03b9\u0001\u0000\u0000\u0000\u03bb\u03bc"+
		"\u0001\u0000\u0000\u0000\u03bc]\u0001\u0000\u0000\u0000\u03bd\u03bb\u0001"+
		"\u0000\u0000\u0000\u03be\u03bf\u0003`0\u0000\u03bf\u03c6\u0006/\uffff"+
		"\uffff\u0000\u03c0\u03c1\u0005\u001a\u0000\u0000\u03c1\u03c2\u0003`0\u0000"+
		"\u03c2\u03c3\u0006/\uffff\uffff\u0000\u03c3\u03c5\u0001\u0000\u0000\u0000"+
		"\u03c4\u03c0\u0001\u0000\u0000\u0000\u03c5\u03c8\u0001\u0000\u0000\u0000"+
		"\u03c6\u03c4\u0001\u0000\u0000\u0000\u03c6\u03c7\u0001\u0000\u0000\u0000"+
		"\u03c7_\u0001\u0000\u0000\u0000\u03c8\u03c6\u0001\u0000\u0000\u0000\u03c9"+
		"\u03ca\u0003b1\u0000\u03ca\u03cf\u00060\uffff\uffff\u0000\u03cb\u03cc"+
		"\u0005H\u0000\u0000\u03cc\u03cd\u0003b1\u0000\u03cd\u03ce\u00060\uffff"+
		"\uffff\u0000\u03ce\u03d0\u0001\u0000\u0000\u0000\u03cf\u03cb\u0001\u0000"+
		"\u0000\u0000\u03cf\u03d0\u0001\u0000\u0000\u0000\u03d0a\u0001\u0000\u0000"+
		"\u0000\u03d1\u03d2\u0003d2\u0000\u03d2\u03dd\u00061\uffff\uffff\u0000"+
		"\u03d3\u03d4\u0005 \u0000\u0000\u03d4\u03d5\u0003d2\u0000\u03d5\u03d6"+
		"\u00061\uffff\uffff\u0000\u03d6\u03dc\u0001\u0000\u0000\u0000\u03d7\u03d8"+
		"\u0005!\u0000\u0000\u03d8\u03d9\u0003d2\u0000\u03d9\u03da\u00061\uffff"+
		"\uffff\u0000\u03da\u03dc\u0001\u0000\u0000\u0000\u03db\u03d3\u0001\u0000"+
		"\u0000\u0000\u03db\u03d7\u0001\u0000\u0000\u0000\u03dc\u03df\u0001\u0000"+
		"\u0000\u0000\u03dd\u03db\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000"+
		"\u0000\u0000\u03dec\u0001\u0000\u0000\u0000\u03df\u03dd\u0001\u0000\u0000"+
		"\u0000\u03e0\u03e1\u0003f3\u0000\u03e1\u03ec\u00062\uffff\uffff\u0000"+
		"\u03e2\u03e3\u0005\"\u0000\u0000\u03e3\u03e4\u0003f3\u0000\u03e4\u03e5"+
		"\u00062\uffff\uffff\u0000\u03e5\u03eb\u0001\u0000\u0000\u0000\u03e6\u03e7"+
		"\u0005\u0019\u0000\u0000\u03e7\u03e8\u0003f3\u0000\u03e8\u03e9\u00062"+
		"\uffff\uffff\u0000\u03e9\u03eb\u0001\u0000\u0000\u0000\u03ea\u03e2\u0001"+
		"\u0000\u0000\u0000\u03ea\u03e6\u0001\u0000\u0000\u0000\u03eb\u03ee\u0001"+
		"\u0000\u0000\u0000\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ec\u03ed\u0001"+
		"\u0000\u0000\u0000\u03ede\u0001\u0000\u0000\u0000\u03ee\u03ec\u0001\u0000"+
		"\u0000\u0000\u03ef\u03f0\u0003h4\u0000\u03f0\u0403\u00063\uffff\uffff"+
		"\u0000\u03f1\u03f2\u0005\b\u0000\u0000\u03f2\u03f3\u0003h4\u0000\u03f3"+
		"\u03f4\u00063\uffff\uffff\u0000\u03f4\u0402\u0001\u0000\u0000\u0000\u03f5"+
		"\u03f6\u0005#\u0000\u0000\u03f6\u03f7\u0003h4\u0000\u03f7\u03f8\u0006"+
		"3\uffff\uffff\u0000\u03f8\u0402\u0001\u0000\u0000\u0000\u03f9\u03fa\u0005"+
		"$\u0000\u0000\u03fa\u03fb\u0003h4\u0000\u03fb\u03fc\u00063\uffff\uffff"+
		"\u0000\u03fc\u0402\u0001\u0000\u0000\u0000\u03fd\u03fe\u0005S\u0000\u0000"+
		"\u03fe\u03ff\u0003h4\u0000\u03ff\u0400\u00063\uffff\uffff\u0000\u0400"+
		"\u0402\u0001\u0000\u0000\u0000\u0401\u03f1\u0001\u0000\u0000\u0000\u0401"+
		"\u03f5\u0001\u0000\u0000\u0000\u0401\u03f9\u0001\u0000\u0000\u0000\u0401"+
		"\u03fd\u0001\u0000\u0000\u0000\u0402\u0405\u0001\u0000\u0000\u0000\u0403"+
		"\u0401\u0001\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000\u0404"+
		"g\u0001\u0000\u0000\u0000\u0405\u0403\u0001\u0000\u0000\u0000\u0406\u0407"+
		"\u0005\u0007\u0000\u0000\u0407\u0408\u0003$\u0012\u0000\u0408\u0409\u0003"+
		"\u0010\b\u0000\u0409\u040a\u0005\t\u0000\u0000\u040a\u040b\u0003h4\u0000"+
		"\u040b\u040c\u00064\uffff\uffff\u0000\u040c\u0419\u0001\u0000\u0000\u0000"+
		"\u040d\u040e\u0005\u0007\u0000\u0000\u040e\u040f\u00055\u0000\u0000\u040f"+
		"\u0410\u0005I\u0000\u0000\u0410\u0411\u0003\u0010\b\u0000\u0411\u0412"+
		"\u0005\t\u0000\u0000\u0412\u0413\u0003h4\u0000\u0413\u0414\u00064\uffff"+
		"\uffff\u0000\u0414\u0419\u0001\u0000\u0000\u0000\u0415\u0416\u0003j5\u0000"+
		"\u0416\u0417\u00064\uffff\uffff\u0000\u0417\u0419\u0001\u0000\u0000\u0000"+
		"\u0418\u0406\u0001\u0000\u0000\u0000\u0418\u040d\u0001\u0000\u0000\u0000"+
		"\u0418\u0415\u0001\u0000\u0000\u0000\u0419i\u0001\u0000\u0000\u0000\u041a"+
		"\u041b\u0005\u0019\u0000\u0000\u041b\u041c\u0003j5\u0000\u041c\u041d\u0006"+
		"5\uffff\uffff\u0000\u041d\u0435\u0001\u0000\u0000\u0000\u041e\u041f\u0005"+
		"\"\u0000\u0000\u041f\u0420\u0003j5\u0000\u0420\u0421\u00065\uffff\uffff"+
		"\u0000\u0421\u0435\u0001\u0000\u0000\u0000\u0422\u0423\u0005\u001a\u0000"+
		"\u0000\u0423\u0424\u0005I\u0000\u0000\u0424\u0435\u00065\uffff\uffff\u0000"+
		"\u0425\u0426\u0005\b\u0000\u0000\u0426\u0427\u0003j5\u0000\u0427\u0428"+
		"\u00065\uffff\uffff\u0000\u0428\u0435\u0001\u0000\u0000\u0000\u0429\u042a"+
		"\u0005%\u0000\u0000\u042a\u042b\u0003j5\u0000\u042b\u042c\u00065\uffff"+
		"\uffff\u0000\u042c\u0435\u0001\u0000\u0000\u0000\u042d\u042e\u0005&\u0000"+
		"\u0000\u042e\u042f\u0003j5\u0000\u042f\u0430\u00065\uffff\uffff\u0000"+
		"\u0430\u0435\u0001\u0000\u0000\u0000\u0431\u0432\u0003l6\u0000\u0432\u0433"+
		"\u00065\uffff\uffff\u0000\u0433\u0435\u0001\u0000\u0000\u0000\u0434\u041a"+
		"\u0001\u0000\u0000\u0000\u0434\u041e\u0001\u0000\u0000\u0000\u0434\u0422"+
		"\u0001\u0000\u0000\u0000\u0434\u0425\u0001\u0000\u0000\u0000\u0434\u0429"+
		"\u0001\u0000\u0000\u0000\u0434\u042d\u0001\u0000\u0000\u0000\u0434\u0431"+
		"\u0001\u0000\u0000\u0000\u0435k\u0001\u0000\u0000\u0000\u0436\u0437\u0005"+
		"M\u0000\u0000\u0437\u047e\u00066\uffff\uffff\u0000\u0438\u0439\u0005L"+
		"\u0000\u0000\u0439\u047e\u00066\uffff\uffff\u0000\u043a\u043b\u0005K\u0000"+
		"\u0000\u043b\u047e\u00066\uffff\uffff\u0000\u043c\u043d\u0005N\u0000\u0000"+
		"\u043d\u047e\u00066\uffff\uffff\u0000\u043e\u043f\u0005C\u0000\u0000\u043f"+
		"\u047e\u00066\uffff\uffff\u0000\u0440\u0441\u0005D\u0000\u0000\u0441\u047e"+
		"\u00066\uffff\uffff\u0000\u0442\u0443\u0005E\u0000\u0000\u0443\u047e\u0006"+
		"6\uffff\uffff\u0000\u0444\u0445\u0005@\u0000\u0000\u0445\u0446\u0005\u0007"+
		"\u0000\u0000\u0446\u0447\u00055\u0000\u0000\u0447\u0448\u0005I\u0000\u0000"+
		"\u0448\u0449\u0005\t\u0000\u0000\u0449\u047e\u00066\uffff\uffff\u0000"+
		"\u044a\u044b\u0005@\u0000\u0000\u044b\u044c\u0005\u0007\u0000\u0000\u044c"+
		"\u044d\u0003$\u0012\u0000\u044d\u044e\u0003r9\u0000\u044e\u044f\u0005"+
		"\t\u0000\u0000\u044f\u0450\u00066\uffff\uffff\u0000\u0450\u047e\u0001"+
		"\u0000\u0000\u0000\u0451\u0452\u0005J\u0000\u0000\u0452\u047e\u00066\uffff"+
		"\uffff\u0000\u0453\u0454\u0005I\u0000\u0000\u0454\u0455\u0005\u0007\u0000"+
		"\u0000\u0455\u0456\u0003N\'\u0000\u0456\u0457\u0005\t\u0000\u0000\u0457"+
		"\u0458\u00066\uffff\uffff\u0000\u0458\u047e\u0001\u0000\u0000\u0000\u0459"+
		"\u045a\u0005I\u0000\u0000\u045a\u045b\u0005\n\u0000\u0000\u045b\u045c"+
		"\u0003R)\u0000\u045c\u045d\u0005\u000b\u0000\u0000\u045d\u045e\u0005\u0007"+
		"\u0000\u0000\u045e\u045f\u0003N\'\u0000\u045f\u0460\u0005\t\u0000\u0000"+
		"\u0460\u0461\u00066\uffff\uffff\u0000\u0461\u047e\u0001\u0000\u0000\u0000"+
		"\u0462\u0468\u0005I\u0000\u0000\u0463\u0464\u0005\n\u0000\u0000\u0464"+
		"\u0465\u0003R)\u0000\u0465\u0466\u0005\u000b\u0000\u0000\u0466\u0467\u0006"+
		"6\uffff\uffff\u0000\u0467\u0469\u0001\u0000\u0000\u0000\u0468\u0463\u0001"+
		"\u0000\u0000\u0000\u0469\u046a\u0001\u0000\u0000\u0000\u046a\u0468\u0001"+
		"\u0000\u0000\u0000\u046a\u046b\u0001\u0000\u0000\u0000\u046b\u046c\u0001"+
		"\u0000\u0000\u0000\u046c\u046d\u00066\uffff\uffff\u0000\u046d\u047e\u0001"+
		"\u0000\u0000\u0000\u046e\u046f\u0005I\u0000\u0000\u046f\u0470\u0005\f"+
		"\u0000\u0000\u0470\u0471\u0005I\u0000\u0000\u0471\u047e\u00066\uffff\uffff"+
		"\u0000\u0472\u0473\u0005I\u0000\u0000\u0473\u0474\u0005G\u0000\u0000\u0474"+
		"\u0475\u0005I\u0000\u0000\u0475\u047e\u00066\uffff\uffff\u0000\u0476\u0477"+
		"\u0005I\u0000\u0000\u0477\u047e\u00066\uffff\uffff\u0000\u0478\u0479\u0005"+
		"\u0007\u0000\u0000\u0479\u047a\u0003n7\u0000\u047a\u047b\u0005\t\u0000"+
		"\u0000\u047b\u047c\u00066\uffff\uffff\u0000\u047c\u047e\u0001\u0000\u0000"+
		"\u0000\u047d\u0436\u0001\u0000\u0000\u0000\u047d\u0438\u0001\u0000\u0000"+
		"\u0000\u047d\u043a\u0001\u0000\u0000\u0000\u047d\u043c\u0001\u0000\u0000"+
		"\u0000\u047d\u043e\u0001\u0000\u0000\u0000\u047d\u0440\u0001\u0000\u0000"+
		"\u0000\u047d\u0442\u0001\u0000\u0000\u0000\u047d\u0444\u0001\u0000\u0000"+
		"\u0000\u047d\u044a\u0001\u0000\u0000\u0000\u047d\u0451\u0001\u0000\u0000"+
		"\u0000\u047d\u0453\u0001\u0000\u0000\u0000\u047d\u0459\u0001\u0000\u0000"+
		"\u0000\u047d\u0462\u0001\u0000\u0000\u0000\u047d\u046e\u0001\u0000\u0000"+
		"\u0000\u047d\u0472\u0001\u0000\u0000\u0000\u047d\u0476\u0001\u0000\u0000"+
		"\u0000\u047d\u0478\u0001\u0000\u0000\u0000\u047em\u0001\u0000\u0000\u0000"+
		"\u047f\u0480\u0003p8\u0000\u0480\u0487\u00067\uffff\uffff\u0000\u0481"+
		"\u0482\u0005\u0003\u0000\u0000\u0482\u0483\u0003p8\u0000\u0483\u0484\u0006"+
		"7\uffff\uffff\u0000\u0484\u0486\u0001\u0000\u0000\u0000\u0485\u0481\u0001"+
		"\u0000\u0000\u0000\u0486\u0489\u0001\u0000\u0000\u0000\u0487\u0485\u0001"+
		"\u0000\u0000\u0000\u0487\u0488\u0001\u0000\u0000\u0000\u0488o\u0001\u0000"+
		"\u0000\u0000\u0489\u0487\u0001\u0000\u0000\u0000\u048a\u048b\u0005I\u0000"+
		"\u0000\u048b\u048c\u0007\u0001\u0000\u0000\u048c\u048d\u0003R)\u0000\u048d"+
		"\u048e\u00068\uffff\uffff\u0000\u048e\u0493\u0001\u0000\u0000\u0000\u048f"+
		"\u0490\u0003R)\u0000\u0490\u0491\u00068\uffff\uffff\u0000\u0491\u0493"+
		"\u0001\u0000\u0000\u0000\u0492\u048a\u0001\u0000\u0000\u0000\u0492\u048f"+
		"\u0001\u0000\u0000\u0000\u0493q\u0001\u0000\u0000\u0000\u0494\u0495\u0005"+
		"\n\u0000\u0000\u0495\u0496\u0005M\u0000\u0000\u0496\u0497\u0005\u000b"+
		"\u0000\u0000\u0497\u0499\u00069\uffff\uffff\u0000\u0498\u0494\u0001\u0000"+
		"\u0000\u0000\u0499\u049c\u0001\u0000\u0000\u0000\u049a\u0498\u0001\u0000"+
		"\u0000\u0000\u049a\u049b\u0001\u0000\u0000\u0000\u049b\u049d\u0001\u0000"+
		"\u0000\u0000\u049c\u049a\u0001\u0000\u0000\u0000\u049d\u049e\u00069\uffff"+
		"\uffff\u0000\u049es\u0001\u0000\u0000\u0000g{}\u0083\u008b\u0094\u0099"+
		"\u009d\u00a8\u00b4\u00bf\u00c9\u00e0\u00f6\u0100\u0103\u0108\u010f\u0115"+
		"\u0121\u012a\u0132\u0138\u013d\u015a\u0163\u0169\u016c\u0174\u017d\u0181"+
		"\u018e\u0192\u0196\u01a0\u01a6\u01a8\u01ae\u01b8\u01be\u01c6\u01c9\u01d0"+
		"\u01da\u01e4\u01e8\u01ef\u0212\u0218\u0231\u0239\u023c\u0242\u024c\u0256"+
		"\u025a\u0267\u026d\u026f\u0274\u0282\u02a5\u02ad\u02b3\u02c0\u02e6\u02ed"+
		"\u02f2\u02fc\u0300\u0305\u0309\u0314\u031d\u0321\u033a\u0349\u0350\u0359"+
		"\u035d\u0370\u0373\u037a\u0383\u0390\u039a\u03a5\u03b0\u03bb\u03c6\u03cf"+
		"\u03db\u03dd\u03ea\u03ec\u0401\u0403\u0418\u0434\u046a\u047d\u0487\u0492"+
		"\u049a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}