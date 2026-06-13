// Generated from /Users/lk/Documents/GitHub/CCU-CSIE/115/compiler/Project_4/myCompiler.g4 by ANTLR 4.13.1

    import java.util.HashMap;
    import java.util.ArrayList;

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
		T__9=10, T__10=11, T__11=12, T__12=13, INT=14, FLOAT=15, VOID=16, IF=17, 
		ELSE=18, WHILE=19, RETURN=20, RelationOP=21, Identifier=22, Floating_point_constant=23, 
		Integer_constant=24, STRING_LITERAL=25, WS=26, COMMENT=27, LINE_COMMENT=28;
	public static final int
		RULE_program = 0, RULE_func_def = 1, RULE_params = 2, RULE_declarations = 3, 
		RULE_type = 4, RULE_statements = 5, RULE_statement = 6, RULE_block_stmt = 7, 
		RULE_assign_stmt = 8, RULE_return_stmt = 9, RULE_if_stmt = 10, RULE_while_stmt = 11, 
		RULE_func_call_stmt = 12, RULE_call_args = 13, RULE_one_arg = 14, RULE_cond_expression = 15, 
		RULE_arith_expression = 16, RULE_multExpr = 17, RULE_castExpr = 18, RULE_signExpr = 19, 
		RULE_primaryExpr = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "func_def", "params", "declarations", "type", "statements", 
			"statement", "block_stmt", "assign_stmt", "return_stmt", "if_stmt", "while_stmt", 
			"func_call_stmt", "call_args", "one_arg", "cond_expression", "arith_expression", 
			"multExpr", "castExpr", "signExpr", "primaryExpr"
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

	public myCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(myCompilerParser.EOF, 0); }
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
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				func_def();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0) );
			setState(47);
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
	public static class Func_defContext extends ParserRuleContext {
		public TypeContext type;
		public Token Identifier;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			((Func_defContext)_localctx).type = type();
			setState(50);
			((Func_defContext)_localctx).Identifier = match(Identifier);
			setState(51);
			match(T__0);
			setState(52);
			params();
			setState(53);
			match(T__1);

			           curRet  = ((Func_defContext)_localctx).type.attr_type;
			           curName = (((Func_defContext)_localctx).Identifier!=null?((Func_defContext)_localctx).Identifier.getText():null);
			           // record signature so later functions can call this one
			           functab.put(curName, new Func(curRet,
			                       new ArrayList<Type>(curParamTypes)));
			           beginFunction();
			        
			setState(55);
			match(T__2);
			setState(56);
			declarations();
			setState(57);
			statements();
			setState(58);
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
		public Token Identifier;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
		enterRule(_localctx, 4, RULE_params);
		 curParamTypes = new ArrayList<Type>();
		        curParamNames = new ArrayList<String>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) {
				{
				setState(61);
				((ParamsContext)_localctx).type = type();
				setState(62);
				((ParamsContext)_localctx).Identifier = match(Identifier);
				 curParamTypes.add(((ParamsContext)_localctx).type.attr_type);
				            curParamNames.add((((ParamsContext)_localctx).Identifier!=null?((ParamsContext)_localctx).Identifier.getText():null)); 
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(64);
					match(T__4);
					setState(65);
					((ParamsContext)_localctx).type = type();
					setState(66);
					((ParamsContext)_localctx).Identifier = match(Identifier);
					 curParamTypes.add(((ParamsContext)_localctx).type.attr_type);
					            curParamNames.add((((ParamsContext)_localctx).Identifier!=null?((ParamsContext)_localctx).Identifier.getText():null)); 
					}
					}
					setState(73);
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
	public static class DeclarationsContext extends ParserRuleContext {
		public TypeContext type;
		public Token first;
		public Token more;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(myCompilerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myCompilerParser.Identifier, i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarations);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				((DeclarationsContext)_localctx).type = type();
				setState(77);
				((DeclarationsContext)_localctx).first = match(Identifier);

				           if (symtab.containsKey((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null))) {
				              System.out.println("Type Error: line " + ((DeclarationsContext)_localctx).first.getLine()
				                                 + ": Redeclared identifier '" + (((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null) + "'.");
				              System.exit(0);
				           }
				           String slot1 = newReg();
				           emit("  " + slot1 + " = alloca " + llTy(((DeclarationsContext)_localctx).type.attr_type));
				           symtab.put((((DeclarationsContext)_localctx).first!=null?((DeclarationsContext)_localctx).first.getText():null), new Info(((DeclarationsContext)_localctx).type.attr_type, slot1));
				        
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(79);
					match(T__4);
					setState(80);
					((DeclarationsContext)_localctx).more = match(Identifier);

					           if (symtab.containsKey((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null))) {
					              System.out.println("Type Error: line " + ((DeclarationsContext)_localctx).more.getLine()
					                                 + ": Redeclared identifier '" + (((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null) + "'.");
					              System.exit(0);
					           }
					           String slot2 = newReg();
					           emit("  " + slot2 + " = alloca " + llTy(((DeclarationsContext)_localctx).type.attr_type));
					           symtab.put((((DeclarationsContext)_localctx).more!=null?((DeclarationsContext)_localctx).more.getText():null), new Info(((DeclarationsContext)_localctx).type.attr_type, slot2));
					        
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(T__5);
				setState(88);
				declarations();
				}
				break;
			case T__2:
			case T__3:
			case IF:
			case WHILE:
			case RETURN:
			case Identifier:
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
	public static class TypeContext extends ParserRuleContext {
		public Type attr_type;
		public TerminalNode INT() { return getToken(myCompilerParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(myCompilerParser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(myCompilerParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(INT);
				 ((TypeContext)_localctx).attr_type =  Type.INT;   
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(FLOAT);
				 ((TypeContext)_localctx).attr_type =  Type.FLOAT; 
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(VOID);
				 ((TypeContext)_localctx).attr_type =  Type.VOID;  
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
		enterRule(_localctx, 10, RULE_statements);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case IF:
			case WHILE:
			case RETURN:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				statement();
				setState(102);
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
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				assign_stmt();
				setState(108);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				while_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				return_stmt();
				setState(113);
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				func_call_stmt();
				setState(116);
				match(T__5);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(118);
				block_stmt();
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
		enterRule(_localctx, 14, RULE_block_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__2);
			setState(122);
			statements();
			setState(123);
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
		public Token Identifier;
		public Arith_expressionContext arith_expression;
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((Assign_stmtContext)_localctx).Identifier = match(Identifier);
			setState(126);
			match(T__6);
			setState(127);
			((Assign_stmtContext)_localctx).arith_expression = arith_expression();

			           Info lhs = symtab.get((((Assign_stmtContext)_localctx).Identifier!=null?((Assign_stmtContext)_localctx).Identifier.getText():null));
			           if (lhs == null) {
			              System.out.println("Type Error: line " + ((Assign_stmtContext)_localctx).Identifier.getLine()
			                                 + ": Undeclared identifier '"
			                                 + (((Assign_stmtContext)_localctx).Identifier!=null?((Assign_stmtContext)_localctx).Identifier.getText():null) + "'.");
			              System.exit(0);
			           }
			           String v = coerce(((Assign_stmtContext)_localctx).arith_expression.theInfo, lhs.theType);
			           emit("  store " + llTy(lhs.theType) + " " + v + ", ptr " + lhs.operand);
			        
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
		enterRule(_localctx, 18, RULE_return_stmt);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(RETURN);
				setState(131);
				((Return_stmtContext)_localctx).arith_expression = arith_expression();

				           String v = coerce(((Return_stmtContext)_localctx).arith_expression.theInfo,
				                             curName.equals("main") ? Type.INT : curRet);
				           emit("  ret " + llTy(curName.equals("main") ? Type.INT : curRet)
				                + " " + v);
				           // open a fresh (dead) block so any following code stays legal
				           emit(newLabel() + ":");
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(RETURN);

				           emit("  ret void");
				           emit(newLabel() + ":");
				        
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
	public static class If_stmtContext extends ParserRuleContext {
		public String lThen;
		public String lElse;
		public String lEnd;
		public Cond_expressionContext cond_expression;
		public TerminalNode IF() { return getToken(myCompilerParser.IF, 0); }
		public Cond_expressionContext cond_expression() {
			return getRuleContext(Cond_expressionContext.class,0);
		}
		public List<Block_stmtContext> block_stmt() {
			return getRuleContexts(Block_stmtContext.class);
		}
		public Block_stmtContext block_stmt(int i) {
			return getRuleContext(Block_stmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(myCompilerParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IF);
			setState(139);
			match(T__0);
			setState(140);
			((If_stmtContext)_localctx).cond_expression = cond_expression();
			setState(141);
			match(T__1);

			           ((If_stmtContext)_localctx).lThen =  newLabel(); ((If_stmtContext)_localctx).lElse =  newLabel(); ((If_stmtContext)_localctx).lEnd =  newLabel();
			           emit("  br i1 " + ((If_stmtContext)_localctx).cond_expression.theInfo.operand
			                + ", label %" + _localctx.lThen + ", label %" + _localctx.lElse);
			           emit(_localctx.lThen + ":");
			        
			setState(143);
			block_stmt();

			           emit("  br label %" + _localctx.lEnd);
			           emit(_localctx.lElse + ":");
			        
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(145);
				match(ELSE);
				setState(146);
				block_stmt();
				}
			}


			           emit("  br label %" + _localctx.lEnd);
			           emit(_localctx.lEnd + ":");
			        
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
		public Cond_expressionContext cond_expression;
		public TerminalNode WHILE() { return getToken(myCompilerParser.WHILE, 0); }
		public Cond_expressionContext cond_expression() {
			return getRuleContext(Cond_expressionContext.class,0);
		}
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(WHILE);

			           ((While_stmtContext)_localctx).lCond =  newLabel(); ((While_stmtContext)_localctx).lBody =  newLabel(); ((While_stmtContext)_localctx).lEnd =  newLabel();
			           emit("  br label %" + _localctx.lCond);
			           emit(_localctx.lCond + ":");
			        
			setState(153);
			match(T__0);
			setState(154);
			((While_stmtContext)_localctx).cond_expression = cond_expression();
			setState(155);
			match(T__1);

			           emit("  br i1 " + ((While_stmtContext)_localctx).cond_expression.theInfo.operand
			                + ", label %" + _localctx.lBody + ", label %" + _localctx.lEnd);
			           emit(_localctx.lBody + ":");
			        
			setState(157);
			block_stmt();

			           emit("  br label %" + _localctx.lCond);
			           emit(_localctx.lEnd + ":");
			        
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
		enterRule(_localctx, 24, RULE_func_call_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			((Func_call_stmtContext)_localctx).Identifier = match(Identifier);
			setState(161);
			match(T__0);
			setState(162);
			((Func_call_stmtContext)_localctx).call_args = call_args();
			setState(163);
			match(T__1);

			           String fn = (((Func_call_stmtContext)_localctx).Identifier!=null?((Func_call_stmtContext)_localctx).Identifier.getText():null);
			           if (fn.equals("printf")) {
			              emitPrintf(((Func_call_stmtContext)_localctx).call_args.fmt, ((Func_call_stmtContext)_localctx).call_args.vals);
			           } else if (fn.equals("scanf")) {
			              emitScanf(((Func_call_stmtContext)_localctx).call_args.fmt, ((Func_call_stmtContext)_localctx).call_args.addrs);
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
		enterRule(_localctx, 26, RULE_call_args);

		   ((Call_argsContext)_localctx).fmt =  null;
		   ((Call_argsContext)_localctx).vals =  new ArrayList<String>();
		   ((Call_argsContext)_localctx).addrs =  new ArrayList<String>();
		   StringBuilder al = new StringBuilder();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62915842L) != 0)) {
				{
				setState(166);
				((Call_argsContext)_localctx).first = one_arg();
				 _localctx.vals.addAll(((Call_argsContext)_localctx).first.valList);
				                        _localctx.addrs.addAll(((Call_argsContext)_localctx).first.addrList);
				                        if (((Call_argsContext)_localctx).first.fmtName != null) ((Call_argsContext)_localctx).fmt =  ((Call_argsContext)_localctx).first.fmtName;
				                        al.append(((Call_argsContext)_localctx).first.argPiece); 
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(168);
					match(T__4);
					setState(169);
					((Call_argsContext)_localctx).more = one_arg();
					 _localctx.vals.addAll(((Call_argsContext)_localctx).more.valList);
					                             _localctx.addrs.addAll(((Call_argsContext)_localctx).more.addrList);
					                             if (((Call_argsContext)_localctx).more.fmtName != null) ((Call_argsContext)_localctx).fmt =  ((Call_argsContext)_localctx).more.fmtName;
					                             al.append(", ").append(((Call_argsContext)_localctx).more.argPiece); 
					}
					}
					setState(176);
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
		public Token STRING_LITERAL;
		public Token Identifier;
		public Arith_expressionContext arith_expression;
		public TerminalNode STRING_LITERAL() { return getToken(myCompilerParser.STRING_LITERAL, 0); }
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
		enterRule(_localctx, 28, RULE_one_arg);

		   ((One_argContext)_localctx).fmtName =  null;
		   ((One_argContext)_localctx).valList =  new ArrayList<String>();
		   ((One_argContext)_localctx).addrList =  new ArrayList<String>();
		   ((One_argContext)_localctx).argPiece =  "";

		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((One_argContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);

				           ((One_argContext)_localctx).fmtName =  makeStringGlobal((((One_argContext)_localctx).STRING_LITERAL!=null?((One_argContext)_localctx).STRING_LITERAL.getText():null));
				           ((One_argContext)_localctx).argPiece =  "ptr " + _localctx.fmtName;
				        
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(T__7);
				setState(184);
				((One_argContext)_localctx).Identifier = match(Identifier);

				           Info v = symtab.get((((One_argContext)_localctx).Identifier!=null?((One_argContext)_localctx).Identifier.getText():null));
				           _localctx.addrList.add("ptr " + v.operand);
				           ((One_argContext)_localctx).argPiece =  "ptr " + v.operand;
				        
				}
				break;
			case T__0:
			case T__9:
			case Identifier:
			case Floating_point_constant:
			case Integer_constant:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				((One_argContext)_localctx).arith_expression = arith_expression();

				           Info v = ((One_argContext)_localctx).arith_expression.theInfo;
				           // store raw typed operand; printf promotes float->double itself
				           _localctx.valList.add(llTy(v.theType) + " " + v.operand);
				           ((One_argContext)_localctx).argPiece =  llTy(v.theType) + " " + v.operand;
				        
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
	public static class Cond_expressionContext extends ParserRuleContext {
		public Info theInfo;
		public boolean rel;
		public Arith_expressionContext a;
		public Token RelationOP;
		public Arith_expressionContext b;
		public List<Arith_expressionContext> arith_expression() {
			return getRuleContexts(Arith_expressionContext.class);
		}
		public Arith_expressionContext arith_expression(int i) {
			return getRuleContext(Arith_expressionContext.class,i);
		}
		public TerminalNode RelationOP() { return getToken(myCompilerParser.RelationOP, 0); }
		public Cond_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_expression; }
	}

	public final Cond_expressionContext cond_expression() throws RecognitionException {
		Cond_expressionContext _localctx = new Cond_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cond_expression);
		 ((Cond_expressionContext)_localctx).theInfo =  new Info(); ((Cond_expressionContext)_localctx).rel =  false; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((Cond_expressionContext)_localctx).a = arith_expression();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RelationOP) {
				{
				setState(192);
				((Cond_expressionContext)_localctx).RelationOP = match(RelationOP);
				setState(193);
				((Cond_expressionContext)_localctx).b = arith_expression();

				           ((Cond_expressionContext)_localctx).theInfo =  compare(((Cond_expressionContext)_localctx).a.theInfo, (((Cond_expressionContext)_localctx).RelationOP!=null?((Cond_expressionContext)_localctx).RelationOP.getText():null), ((Cond_expressionContext)_localctx).b.theInfo);
				           ((Cond_expressionContext)_localctx).rel =  true;
				        
				}
			}

			 if (!_localctx.rel) ((Cond_expressionContext)_localctx).theInfo =  truth(((Cond_expressionContext)_localctx).a.theInfo); 
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
		public MultExprContext a;
		public MultExprContext b;
		public MultExprContext c;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public Arith_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expression; }
	}

	public final Arith_expressionContext arith_expression() throws RecognitionException {
		Arith_expressionContext _localctx = new Arith_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arith_expression);
		 ((Arith_expressionContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((Arith_expressionContext)_localctx).a = multExpr();
			 ((Arith_expressionContext)_localctx).theInfo =  ((Arith_expressionContext)_localctx).a.theInfo; 
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				setState(210);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(202);
					match(T__8);
					setState(203);
					((Arith_expressionContext)_localctx).b = multExpr();
					 ((Arith_expressionContext)_localctx).theInfo =  binArith("+", _localctx.theInfo, ((Arith_expressionContext)_localctx).b.theInfo); 
					}
					break;
				case T__9:
					{
					setState(206);
					match(T__9);
					setState(207);
					((Arith_expressionContext)_localctx).c = multExpr();
					 ((Arith_expressionContext)_localctx).theInfo =  binArith("-", _localctx.theInfo, ((Arith_expressionContext)_localctx).c.theInfo); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(214);
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
		public CastExprContext d;
		public List<CastExprContext> castExpr() {
			return getRuleContexts(CastExprContext.class);
		}
		public CastExprContext castExpr(int i) {
			return getRuleContext(CastExprContext.class,i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multExpr);
		 ((MultExprContext)_localctx).theInfo =  new Info(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			((MultExprContext)_localctx).a = castExpr();
			 ((MultExprContext)_localctx).theInfo =  ((MultExprContext)_localctx).a.theInfo; 
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) {
				{
				setState(229);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(217);
					match(T__10);
					setState(218);
					((MultExprContext)_localctx).b = castExpr();
					 ((MultExprContext)_localctx).theInfo =  binArith("*", _localctx.theInfo, ((MultExprContext)_localctx).b.theInfo); 
					}
					break;
				case T__11:
					{
					setState(221);
					match(T__11);
					setState(222);
					((MultExprContext)_localctx).c = castExpr();
					 ((MultExprContext)_localctx).theInfo =  binArith("/", _localctx.theInfo, ((MultExprContext)_localctx).c.theInfo); 
					}
					break;
				case T__12:
					{
					setState(225);
					match(T__12);
					setState(226);
					((MultExprContext)_localctx).d = castExpr();
					 ((MultExprContext)_localctx).theInfo =  hashOp(_localctx.theInfo, ((MultExprContext)_localctx).d.theInfo); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(233);
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
		public CastExprContext e;
		public SignExprContext s;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastExprContext castExpr() {
			return getRuleContext(CastExprContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_castExpr);
		 ((CastExprContext)_localctx).theInfo =  new Info(); 
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__0);
				setState(235);
				((CastExprContext)_localctx).type = type();
				setState(236);
				match(T__1);
				setState(237);
				((CastExprContext)_localctx).e = castExpr();

				           String v = coerce(((CastExprContext)_localctx).e.theInfo, ((CastExprContext)_localctx).type.attr_type);
				           ((CastExprContext)_localctx).theInfo =  new Info(((CastExprContext)_localctx).type.attr_type, v);
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
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
		public PrimaryExprContext p;
		public SignExprContext signExpr() {
			return getRuleContext(SignExprContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_signExpr);
		 ((SignExprContext)_localctx).theInfo =  new Info(); 
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(T__9);
				setState(246);
				((SignExprContext)_localctx).e = signExpr();

				           Info in = ((SignExprContext)_localctx).e.theInfo;
				           String r = newReg();
				           if (in.theType == Type.FLOAT) {
				              emit("  " + r + " = fneg float " + in.operand);
				              ((SignExprContext)_localctx).theInfo =  new Info(Type.FLOAT, r);
				           } else {
				              emit("  " + r + " = sub nsw i32 0, " + in.operand);
				              ((SignExprContext)_localctx).theInfo =  new Info(Type.INT, r);
				           }
				        
				}
				break;
			case T__0:
			case Identifier:
			case Floating_point_constant:
			case Integer_constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
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
		public Token Integer_constant;
		public Token Floating_point_constant;
		public Token Identifier;
		public Call_argsContext call_args;
		public Arith_expressionContext arith_expression;
		public TerminalNode Integer_constant() { return getToken(myCompilerParser.Integer_constant, 0); }
		public TerminalNode Floating_point_constant() { return getToken(myCompilerParser.Floating_point_constant, 0); }
		public TerminalNode Identifier() { return getToken(myCompilerParser.Identifier, 0); }
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public Arith_expressionContext arith_expression() {
			return getRuleContext(Arith_expressionContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExpr);
		 ((PrimaryExprContext)_localctx).theInfo =  new Info(); 
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((PrimaryExprContext)_localctx).Integer_constant = match(Integer_constant);
				 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.INT, (((PrimaryExprContext)_localctx).Integer_constant!=null?((PrimaryExprContext)_localctx).Integer_constant.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				((PrimaryExprContext)_localctx).Floating_point_constant = match(Floating_point_constant);
				 ((PrimaryExprContext)_localctx).theInfo =  new Info(Type.FLOAT,
				                              fltHex(Float.parseFloat((((PrimaryExprContext)_localctx).Floating_point_constant!=null?((PrimaryExprContext)_localctx).Floating_point_constant.getText():null)))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				((PrimaryExprContext)_localctx).Identifier = match(Identifier);
				setState(259);
				match(T__0);
				setState(260);
				((PrimaryExprContext)_localctx).call_args = call_args();
				setState(261);
				match(T__1);

				           String fn = (((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null);
				           Func f = functab.get(fn);
				           Type rt = (f == null) ? Type.INT : f.ret;
				           String r = newReg();
				           emit("  " + r + " = call " + llTy(rt) + " @" + fn
				                + "(" + ((PrimaryExprContext)_localctx).call_args.argList + ")");
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(rt, r);
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				((PrimaryExprContext)_localctx).Identifier = match(Identifier);

				           Info v = symtab.get((((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null));
				           if (v == null) {
				              System.out.println("Type Error: line " + ((PrimaryExprContext)_localctx).Identifier.getLine()
				                                 + ": Undeclared identifier '"
				                                 + (((PrimaryExprContext)_localctx).Identifier!=null?((PrimaryExprContext)_localctx).Identifier.getText():null) + "'.");
				              System.exit(0);
				           }
				           String r = newReg();
				           emit("  " + r + " = load " + llTy(v.theType) + ", ptr " + v.operand);
				           ((PrimaryExprContext)_localctx).theInfo =  new Info(v.theType, r);
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				match(T__0);
				setState(267);
				((PrimaryExprContext)_localctx).arith_expression = arith_expression();
				setState(268);
				match(T__1);
				 ((PrimaryExprContext)_localctx).theInfo =  ((PrimaryExprContext)_localctx).arith_expression.theInfo; 
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u0112\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0004"+
		"\u0000,\b\u0000\u000b\u0000\f\u0000-\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002F\b\u0002\n\u0002\f\u0002I\t\u0002\u0003\u0002"+
		"K\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\\\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"d\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006x\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u0089\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0094\b\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00ad"+
		"\b\r\n\r\f\r\u00b0\t\r\u0003\r\u00b2\b\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00be\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00c5\b\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00d3\b\u0010\n"+
		"\u0010\f\u0010\u00d6\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00e6"+
		"\b\u0011\n\u0011\f\u0011\u00e9\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00f4\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00fd\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0110\b\u0014"+
		"\u0001\u0014\u0000\u0000\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(\u0000\u0000\u011b\u0000"+
		"+\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000\u0004J\u0001"+
		"\u0000\u0000\u0000\u0006[\u0001\u0000\u0000\u0000\bc\u0001\u0000\u0000"+
		"\u0000\ni\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000\u000ey\u0001"+
		"\u0000\u0000\u0000\u0010}\u0001\u0000\u0000\u0000\u0012\u0088\u0001\u0000"+
		"\u0000\u0000\u0014\u008a\u0001\u0000\u0000\u0000\u0016\u0097\u0001\u0000"+
		"\u0000\u0000\u0018\u00a0\u0001\u0000\u0000\u0000\u001a\u00b1\u0001\u0000"+
		"\u0000\u0000\u001c\u00bd\u0001\u0000\u0000\u0000\u001e\u00bf\u0001\u0000"+
		"\u0000\u0000 \u00c8\u0001\u0000\u0000\u0000\"\u00d7\u0001\u0000\u0000"+
		"\u0000$\u00f3\u0001\u0000\u0000\u0000&\u00fc\u0001\u0000\u0000\u0000("+
		"\u010f\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000+*\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0005\u0000\u0000\u0001"+
		"0\u0001\u0001\u0000\u0000\u000012\u0003\b\u0004\u000023\u0005\u0016\u0000"+
		"\u000034\u0005\u0001\u0000\u000045\u0003\u0004\u0002\u000056\u0005\u0002"+
		"\u0000\u000067\u0006\u0001\uffff\uffff\u000078\u0005\u0003\u0000\u0000"+
		"89\u0003\u0006\u0003\u00009:\u0003\n\u0005\u0000:;\u0005\u0004\u0000\u0000"+
		";<\u0006\u0001\uffff\uffff\u0000<\u0003\u0001\u0000\u0000\u0000=>\u0003"+
		"\b\u0004\u0000>?\u0005\u0016\u0000\u0000?G\u0006\u0002\uffff\uffff\u0000"+
		"@A\u0005\u0005\u0000\u0000AB\u0003\b\u0004\u0000BC\u0005\u0016\u0000\u0000"+
		"CD\u0006\u0002\uffff\uffff\u0000DF\u0001\u0000\u0000\u0000E@\u0001\u0000"+
		"\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"J=\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0005\u0001\u0000"+
		"\u0000\u0000LM\u0003\b\u0004\u0000MN\u0005\u0016\u0000\u0000NT\u0006\u0003"+
		"\uffff\uffff\u0000OP\u0005\u0005\u0000\u0000PQ\u0005\u0016\u0000\u0000"+
		"QS\u0006\u0003\uffff\uffff\u0000RO\u0001\u0000\u0000\u0000SV\u0001\u0000"+
		"\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001"+
		"\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005\u0006\u0000\u0000"+
		"XY\u0003\u0006\u0003\u0000Y\\\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000"+
		"\u0000[L\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\u0007\u0001"+
		"\u0000\u0000\u0000]^\u0005\u000e\u0000\u0000^d\u0006\u0004\uffff\uffff"+
		"\u0000_`\u0005\u000f\u0000\u0000`d\u0006\u0004\uffff\uffff\u0000ab\u0005"+
		"\u0010\u0000\u0000bd\u0006\u0004\uffff\uffff\u0000c]\u0001\u0000\u0000"+
		"\u0000c_\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000d\t\u0001\u0000"+
		"\u0000\u0000ef\u0003\f\u0006\u0000fg\u0003\n\u0005\u0000gj\u0001\u0000"+
		"\u0000\u0000hj\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000\u0000ih\u0001"+
		"\u0000\u0000\u0000j\u000b\u0001\u0000\u0000\u0000kl\u0003\u0010\b\u0000"+
		"lm\u0005\u0006\u0000\u0000mx\u0001\u0000\u0000\u0000nx\u0003\u0014\n\u0000"+
		"ox\u0003\u0016\u000b\u0000pq\u0003\u0012\t\u0000qr\u0005\u0006\u0000\u0000"+
		"rx\u0001\u0000\u0000\u0000st\u0003\u0018\f\u0000tu\u0005\u0006\u0000\u0000"+
		"ux\u0001\u0000\u0000\u0000vx\u0003\u000e\u0007\u0000wk\u0001\u0000\u0000"+
		"\u0000wn\u0001\u0000\u0000\u0000wo\u0001\u0000\u0000\u0000wp\u0001\u0000"+
		"\u0000\u0000ws\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\r\u0001"+
		"\u0000\u0000\u0000yz\u0005\u0003\u0000\u0000z{\u0003\n\u0005\u0000{|\u0005"+
		"\u0004\u0000\u0000|\u000f\u0001\u0000\u0000\u0000}~\u0005\u0016\u0000"+
		"\u0000~\u007f\u0005\u0007\u0000\u0000\u007f\u0080\u0003 \u0010\u0000\u0080"+
		"\u0081\u0006\b\uffff\uffff\u0000\u0081\u0011\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0014\u0000\u0000\u0083\u0084\u0003 \u0010\u0000\u0084\u0085"+
		"\u0006\t\uffff\uffff\u0000\u0085\u0089\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005\u0014\u0000\u0000\u0087\u0089\u0006\t\uffff\uffff\u0000\u0088\u0082"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u0013"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u008c"+
		"\u0005\u0001\u0000\u0000\u008c\u008d\u0003\u001e\u000f\u0000\u008d\u008e"+
		"\u0005\u0002\u0000\u0000\u008e\u008f\u0006\n\uffff\uffff\u0000\u008f\u0090"+
		"\u0003\u000e\u0007\u0000\u0090\u0093\u0006\n\uffff\uffff\u0000\u0091\u0092"+
		"\u0005\u0012\u0000\u0000\u0092\u0094\u0003\u000e\u0007\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0006\n\uffff\uffff\u0000\u0096\u0015"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0013\u0000\u0000\u0098\u0099"+
		"\u0006\u000b\uffff\uffff\u0000\u0099\u009a\u0005\u0001\u0000\u0000\u009a"+
		"\u009b\u0003\u001e\u000f\u0000\u009b\u009c\u0005\u0002\u0000\u0000\u009c"+
		"\u009d\u0006\u000b\uffff\uffff\u0000\u009d\u009e\u0003\u000e\u0007\u0000"+
		"\u009e\u009f\u0006\u000b\uffff\uffff\u0000\u009f\u0017\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0005\u0016\u0000\u0000\u00a1\u00a2\u0005\u0001\u0000"+
		"\u0000\u00a2\u00a3\u0003\u001a\r\u0000\u00a3\u00a4\u0005\u0002\u0000\u0000"+
		"\u00a4\u00a5\u0006\f\uffff\uffff\u0000\u00a5\u0019\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0003\u001c\u000e\u0000\u00a7\u00ae\u0006\r\uffff\uffff\u0000"+
		"\u00a8\u00a9\u0005\u0005\u0000\u0000\u00a9\u00aa\u0003\u001c\u000e\u0000"+
		"\u00aa\u00ab\u0006\r\uffff\uffff\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a8\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000"+
		"\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b1\u00a6\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0006\r\uffff\uffff\u0000"+
		"\u00b4\u001b\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0019\u0000\u0000"+
		"\u00b6\u00be\u0006\u000e\uffff\uffff\u0000\u00b7\u00b8\u0005\b\u0000\u0000"+
		"\u00b8\u00b9\u0005\u0016\u0000\u0000\u00b9\u00be\u0006\u000e\uffff\uffff"+
		"\u0000\u00ba\u00bb\u0003 \u0010\u0000\u00bb\u00bc\u0006\u000e\uffff\uffff"+
		"\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b5\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b7\u0001\u0000\u0000\u0000\u00bd\u00ba\u0001\u0000\u0000"+
		"\u0000\u00be\u001d\u0001\u0000\u0000\u0000\u00bf\u00c4\u0003 \u0010\u0000"+
		"\u00c0\u00c1\u0005\u0015\u0000\u0000\u00c1\u00c2\u0003 \u0010\u0000\u00c2"+
		"\u00c3\u0006\u000f\uffff\uffff\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c0\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0006\u000f\uffff\uffff"+
		"\u0000\u00c7\u001f\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003\"\u0011\u0000"+
		"\u00c9\u00d4\u0006\u0010\uffff\uffff\u0000\u00ca\u00cb\u0005\t\u0000\u0000"+
		"\u00cb\u00cc\u0003\"\u0011\u0000\u00cc\u00cd\u0006\u0010\uffff\uffff\u0000"+
		"\u00cd\u00d3\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\n\u0000\u0000\u00cf"+
		"\u00d0\u0003\"\u0011\u0000\u00d0\u00d1\u0006\u0010\uffff\uffff\u0000\u00d1"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d2\u00ca\u0001\u0000\u0000\u0000\u00d2"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"!\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0003$\u0012\u0000\u00d8\u00e7\u0006\u0011\uffff\uffff\u0000\u00d9\u00da"+
		"\u0005\u000b\u0000\u0000\u00da\u00db\u0003$\u0012\u0000\u00db\u00dc\u0006"+
		"\u0011\uffff\uffff\u0000\u00dc\u00e6\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0005\f\u0000\u0000\u00de\u00df\u0003$\u0012\u0000\u00df\u00e0\u0006"+
		"\u0011\uffff\uffff\u0000\u00e0\u00e6\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0005\r\u0000\u0000\u00e2\u00e3\u0003$\u0012\u0000\u00e3\u00e4\u0006"+
		"\u0011\uffff\uffff\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00d9"+
		"\u0001\u0000\u0000\u0000\u00e5\u00dd\u0001\u0000\u0000\u0000\u00e5\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8#\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005"+
		"\u0001\u0000\u0000\u00eb\u00ec\u0003\b\u0004\u0000\u00ec\u00ed\u0005\u0002"+
		"\u0000\u0000\u00ed\u00ee\u0003$\u0012\u0000\u00ee\u00ef\u0006\u0012\uffff"+
		"\uffff\u0000\u00ef\u00f4\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003&\u0013"+
		"\u0000\u00f1\u00f2\u0006\u0012\uffff\uffff\u0000\u00f2\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f3\u00ea\u0001\u0000\u0000\u0000\u00f3\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f4%\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\n\u0000"+
		"\u0000\u00f6\u00f7\u0003&\u0013\u0000\u00f7\u00f8\u0006\u0013\uffff\uffff"+
		"\u0000\u00f8\u00fd\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003(\u0014\u0000"+
		"\u00fa\u00fb\u0006\u0013\uffff\uffff\u0000\u00fb\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f5\u0001\u0000\u0000\u0000\u00fc\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fd\'\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u0018\u0000\u0000"+
		"\u00ff\u0110\u0006\u0014\uffff\uffff\u0000\u0100\u0101\u0005\u0017\u0000"+
		"\u0000\u0101\u0110\u0006\u0014\uffff\uffff\u0000\u0102\u0103\u0005\u0016"+
		"\u0000\u0000\u0103\u0104\u0005\u0001\u0000\u0000\u0104\u0105\u0003\u001a"+
		"\r\u0000\u0105\u0106\u0005\u0002\u0000\u0000\u0106\u0107\u0006\u0014\uffff"+
		"\uffff\u0000\u0107\u0110\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0016"+
		"\u0000\u0000\u0109\u0110\u0006\u0014\uffff\uffff\u0000\u010a\u010b\u0005"+
		"\u0001\u0000\u0000\u010b\u010c\u0003 \u0010\u0000\u010c\u010d\u0005\u0002"+
		"\u0000\u0000\u010d\u010e\u0006\u0014\uffff\uffff\u0000\u010e\u0110\u0001"+
		"\u0000\u0000\u0000\u010f\u00fe\u0001\u0000\u0000\u0000\u010f\u0100\u0001"+
		"\u0000\u0000\u0000\u010f\u0102\u0001\u0000\u0000\u0000\u010f\u0108\u0001"+
		"\u0000\u0000\u0000\u010f\u010a\u0001\u0000\u0000\u0000\u0110)\u0001\u0000"+
		"\u0000\u0000\u0015-GJT[ciw\u0088\u0093\u00ae\u00b1\u00bd\u00c4\u00d2\u00d4"+
		"\u00e5\u00e7\u00f3\u00fc\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}