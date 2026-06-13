// Generated from /Users/lk/Documents/GitHub/CCU-CSIE/115/compiler/Project_4/myCompiler.g4 by ANTLR 4.13.1

    import java.util.HashMap;
    import java.util.ArrayList;

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
		T__9=10, T__10=11, T__11=12, T__12=13, INT=14, FLOAT=15, VOID=16, IF=17, 
		ELSE=18, WHILE=19, RETURN=20, RelationOP=21, Identifier=22, Floating_point_constant=23, 
		Integer_constant=24, STRING_LITERAL=25, WS=26, COMMENT=27, LINE_COMMENT=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "INT", "FLOAT", "VOID", "IF", "ELSE", 
			"WHILE", "RETURN", "RelationOP", "Identifier", "Floating_point_constant", 
			"Integer_constant", "STRING_LITERAL", "WS", "COMMENT", "LINE_COMMENT", 
			"EscapeSequence"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "';'", "'='", "'&'", "'+'", 
			"'-'", "'*'", "'/'", "'##'", "'int'", "'float'", "'void'", "'if'", "'else'", 
			"'while'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT", "FLOAT", "VOID", "IF", "ELSE", "WHILE", "RETURN", 
			"RelationOP", "Identifier", "Floating_point_constant", "Integer_constant", 
			"STRING_LITERAL", "WS", "COMMENT", "LINE_COMMENT"
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
		"\u0004\u0000\u001c\u00c6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0084\b\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0088\b"+
		"\u0015\n\u0015\f\u0015\u008b\t\u0015\u0001\u0016\u0004\u0016\u008e\b\u0016"+
		"\u000b\u0016\f\u0016\u008f\u0001\u0016\u0001\u0016\u0004\u0016\u0094\b"+
		"\u0016\u000b\u0016\f\u0016\u0095\u0001\u0017\u0004\u0017\u0099\b\u0017"+
		"\u000b\u0017\f\u0017\u009a\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u00a0\b\u0018\n\u0018\f\u0018\u00a3\t\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u00af\b\u001a\n\u001a\f\u001a\u00b2\t\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00bd\b\u001b\n\u001b"+
		"\f\u001b\u00c0\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u00b0\u0000\u001d\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c"+
		"9\u0000\u0001\u0000\u0007\u0002\u0000<<>>\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0002\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r"+
		"\b\u0000\"\"\'\'\\\\bbffnnrrtt\u00d0\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0003"+
		"=\u0001\u0000\u0000\u0000\u0005?\u0001\u0000\u0000\u0000\u0007A\u0001"+
		"\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bE\u0001\u0000\u0000"+
		"\u0000\rG\u0001\u0000\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011"+
		"K\u0001\u0000\u0000\u0000\u0013M\u0001\u0000\u0000\u0000\u0015O\u0001"+
		"\u0000\u0000\u0000\u0017Q\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000"+
		"\u0000\u001bV\u0001\u0000\u0000\u0000\u001dZ\u0001\u0000\u0000\u0000\u001f"+
		"`\u0001\u0000\u0000\u0000!e\u0001\u0000\u0000\u0000#h\u0001\u0000\u0000"+
		"\u0000%m\u0001\u0000\u0000\u0000\'s\u0001\u0000\u0000\u0000)\u0083\u0001"+
		"\u0000\u0000\u0000+\u0085\u0001\u0000\u0000\u0000-\u008d\u0001\u0000\u0000"+
		"\u0000/\u0098\u0001\u0000\u0000\u00001\u009c\u0001\u0000\u0000\u00003"+
		"\u00a6\u0001\u0000\u0000\u00005\u00aa\u0001\u0000\u0000\u00007\u00b8\u0001"+
		"\u0000\u0000\u00009\u00c3\u0001\u0000\u0000\u0000;<\u0005(\u0000\u0000"+
		"<\u0002\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\u0004\u0001\u0000"+
		"\u0000\u0000?@\u0005{\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005"+
		"}\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005,\u0000\u0000D\n\u0001"+
		"\u0000\u0000\u0000EF\u0005;\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005"+
		"=\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005&\u0000\u0000J\u0010"+
		"\u0001\u0000\u0000\u0000KL\u0005+\u0000\u0000L\u0012\u0001\u0000\u0000"+
		"\u0000MN\u0005-\u0000\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005*\u0000"+
		"\u0000P\u0016\u0001\u0000\u0000\u0000QR\u0005/\u0000\u0000R\u0018\u0001"+
		"\u0000\u0000\u0000ST\u0005#\u0000\u0000TU\u0005#\u0000\u0000U\u001a\u0001"+
		"\u0000\u0000\u0000VW\u0005i\u0000\u0000WX\u0005n\u0000\u0000XY\u0005t"+
		"\u0000\u0000Y\u001c\u0001\u0000\u0000\u0000Z[\u0005f\u0000\u0000[\\\u0005"+
		"l\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005a\u0000\u0000^_\u0005t\u0000"+
		"\u0000_\u001e\u0001\u0000\u0000\u0000`a\u0005v\u0000\u0000ab\u0005o\u0000"+
		"\u0000bc\u0005i\u0000\u0000cd\u0005d\u0000\u0000d \u0001\u0000\u0000\u0000"+
		"ef\u0005i\u0000\u0000fg\u0005f\u0000\u0000g\"\u0001\u0000\u0000\u0000"+
		"hi\u0005e\u0000\u0000ij\u0005l\u0000\u0000jk\u0005s\u0000\u0000kl\u0005"+
		"e\u0000\u0000l$\u0001\u0000\u0000\u0000mn\u0005w\u0000\u0000no\u0005h"+
		"\u0000\u0000op\u0005i\u0000\u0000pq\u0005l\u0000\u0000qr\u0005e\u0000"+
		"\u0000r&\u0001\u0000\u0000\u0000st\u0005r\u0000\u0000tu\u0005e\u0000\u0000"+
		"uv\u0005t\u0000\u0000vw\u0005u\u0000\u0000wx\u0005r\u0000\u0000xy\u0005"+
		"n\u0000\u0000y(\u0001\u0000\u0000\u0000z{\u0005>\u0000\u0000{\u0084\u0005"+
		"=\u0000\u0000|}\u0005<\u0000\u0000}\u0084\u0005=\u0000\u0000~\u007f\u0005"+
		"=\u0000\u0000\u007f\u0084\u0005=\u0000\u0000\u0080\u0081\u0005!\u0000"+
		"\u0000\u0081\u0084\u0005=\u0000\u0000\u0082\u0084\u0007\u0000\u0000\u0000"+
		"\u0083z\u0001\u0000\u0000\u0000\u0083|\u0001\u0000\u0000\u0000\u0083~"+
		"\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000\u0000\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084*\u0001\u0000\u0000\u0000\u0085\u0089\u0007"+
		"\u0001\u0000\u0000\u0086\u0088\u0007\u0002\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a,\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008e\u000209\u0000"+
		"\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0093\u0005.\u0000\u0000\u0092"+
		"\u0094\u000209\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001"+
		"\u0000\u0000\u0000\u0096.\u0001\u0000\u0000\u0000\u0097\u0099\u000209"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b0\u0001\u0000\u0000\u0000\u009c\u00a1\u0005\"\u0000\u0000"+
		"\u009d\u00a0\u00039\u001c\u0000\u009e\u00a0\b\u0003\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\"\u0000\u0000\u00a52"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0007\u0004\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0006\u0019\u0000\u0000\u00a94\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005/\u0000\u0000\u00ab\u00ac\u0005*\u0000"+
		"\u0000\u00ac\u00b0\u0001\u0000\u0000\u0000\u00ad\u00af\t\u0000\u0000\u0000"+
		"\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005*\u0000\u0000\u00b4\u00b5\u0005/\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0006\u001a\u0000\u0000\u00b76\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005/\u0000\u0000\u00b9\u00ba\u0005/\u0000"+
		"\u0000\u00ba\u00be\u0001\u0000\u0000\u0000\u00bb\u00bd\b\u0005\u0000\u0000"+
		"\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0006\u001b\u0000\u0000\u00c28\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\\\u0000\u0000\u00c4\u00c5\u0007\u0006\u0000\u0000\u00c5:"+
		"\u0001\u0000\u0000\u0000\n\u0000\u0083\u0089\u008f\u0095\u009a\u009f\u00a1"+
		"\u00b0\u00be\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}