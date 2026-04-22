// Generated from myparser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class myparserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		INT=25, FLOAT=26, CHAR=27, DOUBLE=28, BOOL=29, VOID=30, IF=31, ELSE=32, 
		WHILE=33, FOR=34, RETURN=35, TRUE=36, FALSE=37, PRINTF=38, SCANF=39, OR=40, 
		AND=41, INTLIT=42, FLOATLIT=43, CHARLIT=44, STRLIT=45, ID=46, WS=47, LINE_COMMENT=48, 
		BLOCK_COMMENT=49;
	public static final int
		RULE_program = 0, RULE_functionDef = 1, RULE_returnType = 2, RULE_paramList = 3, 
		RULE_param = 4, RULE_type = 5, RULE_block = 6, RULE_declarations = 7, 
		RULE_declaration = 8, RULE_stmts = 9, RULE_stmt = 10, RULE_assignStmt = 11, 
		RULE_ifStmt = 12, RULE_whileStmt = 13, RULE_forStmt = 14, RULE_forInit = 15, 
		RULE_forUpdate = 16, RULE_returnStmt = 17, RULE_funcCallStmt = 18, RULE_argList = 19, 
		RULE_printfStmt = 20, RULE_scanfStmt = 21, RULE_expr = 22, RULE_andExpr = 23, 
		RULE_eqExpr = 24, RULE_relExpr = 25, RULE_addExpr = 26, RULE_mulExpr = 27, 
		RULE_unaryExpr = 28, RULE_primaryExpr = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDef", "returnType", "paramList", "param", "type", 
			"block", "declarations", "declaration", "stmts", "stmt", "assignStmt", 
			"ifStmt", "whileStmt", "forStmt", "forInit", "forUpdate", "returnStmt", 
			"funcCallStmt", "argList", "printfStmt", "scanfStmt", "expr", "andExpr", 
			"eqExpr", "relExpr", "addExpr", "mulExpr", "unaryExpr", "primaryExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'['", "']'", "'{'", "'}'", "';'", "'='", 
			"'++'", "'--'", "'&'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'int'", "'float'", "'char'", 
			"'double'", "'bool'", "'void'", "'if'", "'else'", "'while'", "'for'", 
			"'return'", "'true'", "'false'", "'printf'", "'scanf'", "'||'", "'&&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT", "FLOAT", "CHAR", "DOUBLE", "BOOL", "VOID", "IF", "ELSE", 
			"WHILE", "FOR", "RETURN", "TRUE", "FALSE", "PRINTF", "SCANF", "OR", "AND", 
			"INTLIT", "FLOATLIT", "CHARLIT", "STRLIT", "ID", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "myparser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public static final boolean TRACEON = true;

	public myparserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(myparserParser.EOF, 0); }
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2113929216L) != 0)) {
				{
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(60);
					functionDef();
					}
					break;
				case 2:
					{
					setState(61);
					declaration();
					}
					break;
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(EOF);
			 if (TRACEON) System.out.println("program: (functionDef | declaration)* EOF"); 
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
	public static class FunctionDefContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode VOID() { return getToken(myparserParser.VOID, 0); }
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDef);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				returnType();
				setState(71);
				match(ID);
				setState(72);
				match(T__0);
				setState(73);
				paramList();
				setState(74);
				match(T__1);
				setState(75);
				block();
				 if (TRACEON) System.out.println("functionDef: returnType ID ( paramList ) block"); 
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(VOID);
				setState(79);
				match(ID);
				setState(80);
				match(T__0);
				setState(81);
				paramList();
				setState(82);
				match(T__1);
				setState(83);
				block();
				 if (TRACEON) System.out.println("functionDef: VOID ID ( paramList ) block"); 
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
	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			 if (TRACEON) System.out.println("returnType: type"); 
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
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramList);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				param();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(92);
					match(T__2);
					setState(93);
					param();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 if (TRACEON) System.out.println("paramList: param (, param)*"); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 if (TRACEON) System.out.println("paramList: (empty)"); 
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
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				type();
				setState(105);
				match(ID);
				 if (TRACEON) System.out.println("param: type ID"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				type();
				setState(109);
				match(ID);
				setState(110);
				match(T__3);
				setState(111);
				match(T__4);
				 if (TRACEON) System.out.println("param: type ID [ ]"); 
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
		public TerminalNode INT() { return getToken(myparserParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(myparserParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(myparserParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(myparserParser.DOUBLE, 0); }
		public TerminalNode BOOL() { return getToken(myparserParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(INT);
				 if (TRACEON) System.out.println("type: INT"); 
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(FLOAT);
				 if (TRACEON) System.out.println("type: FLOAT"); 
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				match(CHAR);
				 if (TRACEON) System.out.println("type: CHAR"); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(DOUBLE);
				 if (TRACEON) System.out.println("type: DOUBLE"); 
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(BOOL);
				 if (TRACEON) System.out.println("type: BOOL"); 
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
	public static class BlockContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__5);
			setState(129);
			declarations();
			setState(130);
			stmts();
			setState(131);
			match(T__6);
			 if (TRACEON) System.out.println("block: { declarations stmts }"); 
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
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declarations);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				declaration();
				setState(135);
				declarations();
				 if (TRACEON) System.out.println("declarations: declaration declarations"); 
				}
				break;
			case T__5:
			case T__6:
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case PRINTF:
			case SCANF:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				 if (TRACEON) System.out.println("declarations: (empty)"); 
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
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public TerminalNode INTLIT() { return getToken(myparserParser.INTLIT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				type();
				setState(142);
				match(ID);
				setState(143);
				match(T__7);
				 if (TRACEON) System.out.println("declaration: type ID ;"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				type();
				setState(147);
				match(ID);
				setState(148);
				match(T__3);
				setState(149);
				match(INTLIT);
				setState(150);
				match(T__4);
				setState(151);
				match(T__7);
				 if (TRACEON) System.out.println("declaration: type ID [ INTLIT ] ;"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				type();
				setState(155);
				match(ID);
				setState(156);
				match(T__8);
				setState(157);
				expr(0);
				setState(158);
				match(T__7);
				 if (TRACEON) System.out.println("declaration: type ID = expr ;"); 
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
	public static class StmtsContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmts);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case PRINTF:
			case SCANF:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				stmt();
				setState(164);
				stmts();
				 if (TRACEON) System.out.println("stmts: stmt stmts"); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				 if (TRACEON) System.out.println("stmts: (empty)"); 
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
	public static class StmtContext extends ParserRuleContext {
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public FuncCallStmtContext funcCallStmt() {
			return getRuleContext(FuncCallStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PrintfStmtContext printfStmt() {
			return getRuleContext(PrintfStmtContext.class,0);
		}
		public ScanfStmtContext scanfStmt() {
			return getRuleContext(ScanfStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				assignStmt();
				 if (TRACEON) System.out.println("stmt: assignStmt"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				ifStmt();
				 if (TRACEON) System.out.println("stmt: ifStmt"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				whileStmt();
				 if (TRACEON) System.out.println("stmt: whileStmt"); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				forStmt();
				 if (TRACEON) System.out.println("stmt: forStmt"); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				returnStmt();
				 if (TRACEON) System.out.println("stmt: returnStmt"); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				funcCallStmt();
				 if (TRACEON) System.out.println("stmt: funcCallStmt"); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				block();
				 if (TRACEON) System.out.println("stmt: block"); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(191);
				printfStmt();
				 if (TRACEON) System.out.println("stmt: printfStmt"); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(194);
				scanfStmt();
				 if (TRACEON) System.out.println("stmt: scanfStmt"); 
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
	public static class AssignStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignStmt);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(ID);
				setState(200);
				match(T__8);
				setState(201);
				expr(0);
				setState(202);
				match(T__7);
				 if (TRACEON) System.out.println("assignStmt: ID = expr ;"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(ID);
				setState(206);
				match(T__3);
				setState(207);
				expr(0);
				setState(208);
				match(T__4);
				setState(209);
				match(T__8);
				setState(210);
				expr(0);
				setState(211);
				match(T__7);
				 if (TRACEON) System.out.println("assignStmt: ID [ expr ] = expr ;"); 
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
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(myparserParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(myparserParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStmt);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(IF);
				setState(217);
				match(T__0);
				setState(218);
				expr(0);
				setState(219);
				match(T__1);
				setState(220);
				stmt();
				 if (TRACEON) System.out.println("ifStmt: IF ( expr ) stmt"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(IF);
				setState(224);
				match(T__0);
				setState(225);
				expr(0);
				setState(226);
				match(T__1);
				setState(227);
				stmt();
				setState(228);
				match(ELSE);
				setState(229);
				stmt();
				 if (TRACEON) System.out.println("ifStmt: IF ( expr ) stmt ELSE stmt"); 
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
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(myparserParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(WHILE);
			setState(235);
			match(T__0);
			setState(236);
			expr(0);
			setState(237);
			match(T__1);
			setState(238);
			stmt();
			 if (TRACEON) System.out.println("whileStmt: WHILE ( expr ) stmt"); 
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
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(myparserParser.FOR, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(FOR);
			setState(242);
			match(T__0);
			setState(243);
			forInit();
			setState(244);
			expr(0);
			setState(245);
			match(T__7);
			setState(246);
			forUpdate();
			setState(247);
			match(T__1);
			setState(248);
			stmt();
			 if (TRACEON) System.out.println("forStmt: FOR ( forInit expr ; forUpdate ) stmt"); 
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
	public static class ForInitContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forInit);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				type();
				setState(252);
				match(ID);
				setState(253);
				match(T__8);
				setState(254);
				expr(0);
				setState(255);
				match(T__7);
				 if (TRACEON) System.out.println("forInit: type ID = expr ;"); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(ID);
				setState(259);
				match(T__8);
				setState(260);
				expr(0);
				setState(261);
				match(T__7);
				 if (TRACEON) System.out.println("forInit: ID = expr ;"); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				match(T__7);
				 if (TRACEON) System.out.println("forInit: ;"); 
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
	public static class ForUpdateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forUpdate);
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(ID);
				setState(269);
				match(T__8);
				setState(270);
				expr(0);
				 if (TRACEON) System.out.println("forUpdate: ID = expr"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(ID);
				setState(274);
				match(T__9);
				 if (TRACEON) System.out.println("forUpdate: ID ++"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				match(ID);
				setState(277);
				match(T__10);
				 if (TRACEON) System.out.println("forUpdate: ID --"); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				 if (TRACEON) System.out.println("forUpdate: (empty)"); 
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(myparserParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStmt);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(RETURN);
				setState(283);
				expr(0);
				setState(284);
				match(T__7);
				 if (TRACEON) System.out.println("returnStmt: RETURN expr ;"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(RETURN);
				setState(288);
				match(T__7);
				 if (TRACEON) System.out.println("returnStmt: RETURN ;"); 
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
	public static class FuncCallStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FuncCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitFuncCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallStmtContext funcCallStmt() throws RecognitionException {
		FuncCallStmtContext _localctx = new FuncCallStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcCallStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(ID);
			setState(293);
			match(T__0);
			setState(294);
			argList();
			setState(295);
			match(T__1);
			setState(296);
			match(T__7);
			 if (TRACEON) System.out.println("funcCallStmt: ID ( argList ) ;"); 
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
	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argList);
		int _la;
		try {
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__19:
			case T__23:
			case TRUE:
			case FALSE:
			case INTLIT:
			case FLOATLIT:
			case CHARLIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				expr(0);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(300);
					match(T__2);
					setState(301);
					expr(0);
					}
					}
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				 if (TRACEON) System.out.println("argList: expr (, expr)*"); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				 if (TRACEON) System.out.println("argList: (empty)"); 
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
	public static class PrintfStmtContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(myparserParser.PRINTF, 0); }
		public TerminalNode STRLIT() { return getToken(myparserParser.STRLIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printfStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitPrintfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintfStmtContext printfStmt() throws RecognitionException {
		PrintfStmtContext _localctx = new PrintfStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_printfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(PRINTF);
			setState(313);
			match(T__0);
			setState(314);
			match(STRLIT);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(315);
				match(T__2);
				setState(316);
				expr(0);
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(322);
			match(T__1);
			setState(323);
			match(T__7);
			 if (TRACEON) System.out.println("printfStmt: PRINTF ( STRLIT (, expr)* ) ;"); 
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
	public static class ScanfStmtContext extends ParserRuleContext {
		public TerminalNode SCANF() { return getToken(myparserParser.SCANF, 0); }
		public TerminalNode STRLIT() { return getToken(myparserParser.STRLIT, 0); }
		public List<TerminalNode> ID() { return getTokens(myparserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(myparserParser.ID, i);
		}
		public ScanfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanfStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitScanfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanfStmtContext scanfStmt() throws RecognitionException {
		ScanfStmtContext _localctx = new ScanfStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_scanfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(SCANF);
			setState(327);
			match(T__0);
			setState(328);
			match(STRLIT);
			setState(332); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(329);
				match(T__2);
				setState(330);
				match(T__11);
				setState(331);
				match(ID);
				}
				}
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(336);
			match(T__1);
			setState(337);
			match(T__7);
			 if (TRACEON) System.out.println("scanfStmt: SCANF ( STRLIT (, & ID)+ ) ;"); 
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
	public static class ExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(myparserParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(341);
			andExpr(0);
			 if (TRACEON) System.out.println("expr: andExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(344);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(345);
					match(OR);
					setState(346);
					andExpr(0);
					 if (TRACEON) System.out.println("expr: expr OR andExpr"); 
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ParserRuleContext {
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(myparserParser.AND, 0); }
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(355);
			eqExpr(0);
			 if (TRACEON) System.out.println("andExpr: eqExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(358);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(359);
					match(AND);
					setState(360);
					eqExpr(0);
					 if (TRACEON) System.out.println("andExpr: andExpr AND eqExpr"); 
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqExprContext extends ParserRuleContext {
		public RelExprContext relExpr() {
			return getRuleContext(RelExprContext.class,0);
		}
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public EqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExprContext eqExpr() throws RecognitionException {
		return eqExpr(0);
	}

	private EqExprContext eqExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqExprContext _localctx = new EqExprContext(_ctx, _parentState);
		EqExprContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_eqExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(369);
			relExpr(0);
			 if (TRACEON) System.out.println("eqExpr: relExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqExpr);
					setState(372);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(373);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(374);
					relExpr(0);
					 if (TRACEON) System.out.println("eqExpr: eqExpr (== | !=) relExpr"); 
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelExprContext extends ParserRuleContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public RelExprContext relExpr() {
			return getRuleContext(RelExprContext.class,0);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		return relExpr(0);
	}

	private RelExprContext relExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelExprContext _localctx = new RelExprContext(_ctx, _parentState);
		RelExprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_relExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(383);
			addExpr(0);
			 if (TRACEON) System.out.println("relExpr: addExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relExpr);
					setState(386);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(387);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(388);
					addExpr(0);
					 if (TRACEON) System.out.println("relExpr: relExpr (< | > | <= | >=) addExpr"); 
					}
					} 
				}
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		return addExpr(0);
	}

	private AddExprContext addExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExprContext _localctx = new AddExprContext(_ctx, _parentState);
		AddExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_addExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(397);
			mulExpr(0);
			 if (TRACEON) System.out.println("addExpr: mulExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
					setState(400);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(401);
					_la = _input.LA(1);
					if ( !(_la==T__18 || _la==T__19) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(402);
					mulExpr(0);
					 if (TRACEON) System.out.println("addExpr: addExpr (+ | -) mulExpr"); 
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		return mulExpr(0);
	}

	private MulExprContext mulExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExprContext _localctx = new MulExprContext(_ctx, _parentState);
		MulExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_mulExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(411);
			unaryExpr();
			 if (TRACEON) System.out.println("mulExpr: unaryExpr"); 
			}
			_ctx.stop = _input.LT(-1);
			setState(421);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExpr);
					setState(414);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(415);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(416);
					unaryExpr();
					 if (TRACEON) System.out.println("mulExpr: mulExpr (* | / | %) unaryExpr"); 
					}
					} 
				}
				setState(423);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_unaryExpr);
		try {
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(T__19);
				setState(425);
				primaryExpr();
				 if (TRACEON) System.out.println("unaryExpr: - primaryExpr"); 
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(428);
				match(T__23);
				setState(429);
				primaryExpr();
				 if (TRACEON) System.out.println("unaryExpr: ! primaryExpr"); 
				}
				break;
			case T__0:
			case TRUE:
			case FALSE:
			case INTLIT:
			case FLOATLIT:
			case CHARLIT:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				primaryExpr();
				 if (TRACEON) System.out.println("unaryExpr: primaryExpr"); 
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
		public TerminalNode INTLIT() { return getToken(myparserParser.INTLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(myparserParser.FLOATLIT, 0); }
		public TerminalNode CHARLIT() { return getToken(myparserParser.CHARLIT, 0); }
		public TerminalNode TRUE() { return getToken(myparserParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(myparserParser.FALSE, 0); }
		public TerminalNode ID() { return getToken(myparserParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myparserVisitor ) return ((myparserVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primaryExpr);
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				match(INTLIT);
				 if (TRACEON) System.out.println("primaryExpr: INTLIT"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(FLOATLIT);
				 if (TRACEON) System.out.println("primaryExpr: FLOATLIT"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				match(CHARLIT);
				 if (TRACEON) System.out.println("primaryExpr: CHARLIT"); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(TRUE);
				 if (TRACEON) System.out.println("primaryExpr: TRUE"); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(445);
				match(FALSE);
				 if (TRACEON) System.out.println("primaryExpr: FALSE"); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(447);
				match(ID);
				setState(448);
				match(T__3);
				setState(449);
				expr(0);
				setState(450);
				match(T__4);
				 if (TRACEON) System.out.println("primaryExpr: ID [ expr ]"); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(453);
				match(ID);
				setState(454);
				match(T__0);
				setState(455);
				argList();
				setState(456);
				match(T__1);
				 if (TRACEON) System.out.println("primaryExpr: ID ( argList )"); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(459);
				match(ID);
				 if (TRACEON) System.out.println("primaryExpr: ID"); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(461);
				match(T__0);
				setState(462);
				expr(0);
				setState(463);
				match(T__1);
				 if (TRACEON) System.out.println("primaryExpr: ( expr )"); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 23:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 24:
			return eqExpr_sempred((EqExprContext)_localctx, predIndex);
		case 25:
			return relExpr_sempred((RelExprContext)_localctx, predIndex);
		case 26:
			return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 27:
			return mulExpr_sempred((MulExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean eqExpr_sempred(EqExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relExpr_sempred(RelExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addExpr_sempred(AddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulExpr_sempred(MulExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00011\u01d5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001\u0000"+
		"\u0005\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"W\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003_\b\u0003\n\u0003\f\u0003b\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003g\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004s\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u007f\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008c\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00a2\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00a9\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00c6\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00d7\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00e9\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u010b\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0119\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0123\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u012f\b\u0013\n\u0013\f\u0013\u0132\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0137\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u013e\b\u0014\n"+
		"\u0014\f\u0014\u0141\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0004\u0015\u014d\b\u0015\u000b\u0015\f\u0015\u014e\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u015e\b\u0016\n\u0016\f\u0016\u0161\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u016c\b\u0017\n\u0017\f\u0017\u016f\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u017a\b\u0018\n\u0018"+
		"\f\u0018\u017d\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0188\b\u0019\n\u0019\f\u0019\u018b\t\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0196\b\u001a\n\u001a\f\u001a\u0199\t\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u01a4\b\u001b\n\u001b\f\u001b\u01a7"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u01b4\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u01d3\b\u001d\u0001\u001d\u0000\u0006,.0246\u001e\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:\u0000\u0004\u0001\u0000\r\u000e\u0001\u0000\u000f"+
		"\u0012\u0001\u0000\u0013\u0014\u0001\u0000\u0015\u0017\u01e8\u0000@\u0001"+
		"\u0000\u0000\u0000\u0002V\u0001\u0000\u0000\u0000\u0004X\u0001\u0000\u0000"+
		"\u0000\u0006f\u0001\u0000\u0000\u0000\br\u0001\u0000\u0000\u0000\n~\u0001"+
		"\u0000\u0000\u0000\f\u0080\u0001\u0000\u0000\u0000\u000e\u008b\u0001\u0000"+
		"\u0000\u0000\u0010\u00a1\u0001\u0000\u0000\u0000\u0012\u00a8\u0001\u0000"+
		"\u0000\u0000\u0014\u00c5\u0001\u0000\u0000\u0000\u0016\u00d6\u0001\u0000"+
		"\u0000\u0000\u0018\u00e8\u0001\u0000\u0000\u0000\u001a\u00ea\u0001\u0000"+
		"\u0000\u0000\u001c\u00f1\u0001\u0000\u0000\u0000\u001e\u010a\u0001\u0000"+
		"\u0000\u0000 \u0118\u0001\u0000\u0000\u0000\"\u0122\u0001\u0000\u0000"+
		"\u0000$\u0124\u0001\u0000\u0000\u0000&\u0136\u0001\u0000\u0000\u0000("+
		"\u0138\u0001\u0000\u0000\u0000*\u0146\u0001\u0000\u0000\u0000,\u0154\u0001"+
		"\u0000\u0000\u0000.\u0162\u0001\u0000\u0000\u00000\u0170\u0001\u0000\u0000"+
		"\u00002\u017e\u0001\u0000\u0000\u00004\u018c\u0001\u0000\u0000\u00006"+
		"\u019a\u0001\u0000\u0000\u00008\u01b3\u0001\u0000\u0000\u0000:\u01d2\u0001"+
		"\u0000\u0000\u0000<?\u0003\u0002\u0001\u0000=?\u0003\u0010\b\u0000><\u0001"+
		"\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u0000\u0000\u0001DE\u0006\u0000"+
		"\uffff\uffff\u0000E\u0001\u0001\u0000\u0000\u0000FG\u0003\u0004\u0002"+
		"\u0000GH\u0005.\u0000\u0000HI\u0005\u0001\u0000\u0000IJ\u0003\u0006\u0003"+
		"\u0000JK\u0005\u0002\u0000\u0000KL\u0003\f\u0006\u0000LM\u0006\u0001\uffff"+
		"\uffff\u0000MW\u0001\u0000\u0000\u0000NO\u0005\u001e\u0000\u0000OP\u0005"+
		".\u0000\u0000PQ\u0005\u0001\u0000\u0000QR\u0003\u0006\u0003\u0000RS\u0005"+
		"\u0002\u0000\u0000ST\u0003\f\u0006\u0000TU\u0006\u0001\uffff\uffff\u0000"+
		"UW\u0001\u0000\u0000\u0000VF\u0001\u0000\u0000\u0000VN\u0001\u0000\u0000"+
		"\u0000W\u0003\u0001\u0000\u0000\u0000XY\u0003\n\u0005\u0000YZ\u0006\u0002"+
		"\uffff\uffff\u0000Z\u0005\u0001\u0000\u0000\u0000[`\u0003\b\u0004\u0000"+
		"\\]\u0005\u0003\u0000\u0000]_\u0003\b\u0004\u0000^\\\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0006"+
		"\u0003\uffff\uffff\u0000dg\u0001\u0000\u0000\u0000eg\u0006\u0003\uffff"+
		"\uffff\u0000f[\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000g\u0007"+
		"\u0001\u0000\u0000\u0000hi\u0003\n\u0005\u0000ij\u0005.\u0000\u0000jk"+
		"\u0006\u0004\uffff\uffff\u0000ks\u0001\u0000\u0000\u0000lm\u0003\n\u0005"+
		"\u0000mn\u0005.\u0000\u0000no\u0005\u0004\u0000\u0000op\u0005\u0005\u0000"+
		"\u0000pq\u0006\u0004\uffff\uffff\u0000qs\u0001\u0000\u0000\u0000rh\u0001"+
		"\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000s\t\u0001\u0000\u0000\u0000"+
		"tu\u0005\u0019\u0000\u0000u\u007f\u0006\u0005\uffff\uffff\u0000vw\u0005"+
		"\u001a\u0000\u0000w\u007f\u0006\u0005\uffff\uffff\u0000xy\u0005\u001b"+
		"\u0000\u0000y\u007f\u0006\u0005\uffff\uffff\u0000z{\u0005\u001c\u0000"+
		"\u0000{\u007f\u0006\u0005\uffff\uffff\u0000|}\u0005\u001d\u0000\u0000"+
		"}\u007f\u0006\u0005\uffff\uffff\u0000~t\u0001\u0000\u0000\u0000~v\u0001"+
		"\u0000\u0000\u0000~x\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000\u007f\u000b\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\u0006\u0000\u0000\u0081\u0082\u0003\u000e\u0007\u0000\u0082\u0083"+
		"\u0003\u0012\t\u0000\u0083\u0084\u0005\u0007\u0000\u0000\u0084\u0085\u0006"+
		"\u0006\uffff\uffff\u0000\u0085\r\u0001\u0000\u0000\u0000\u0086\u0087\u0003"+
		"\u0010\b\u0000\u0087\u0088\u0003\u000e\u0007\u0000\u0088\u0089\u0006\u0007"+
		"\uffff\uffff\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u008c\u0006"+
		"\u0007\uffff\uffff\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u000f\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0003\n\u0005\u0000\u008e\u008f\u0005.\u0000\u0000\u008f\u0090\u0005"+
		"\b\u0000\u0000\u0090\u0091\u0006\b\uffff\uffff\u0000\u0091\u00a2\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0003\n\u0005\u0000\u0093\u0094\u0005."+
		"\u0000\u0000\u0094\u0095\u0005\u0004\u0000\u0000\u0095\u0096\u0005*\u0000"+
		"\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098\u0005\b\u0000\u0000"+
		"\u0098\u0099\u0006\b\uffff\uffff\u0000\u0099\u00a2\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0003\n\u0005\u0000\u009b\u009c\u0005.\u0000\u0000\u009c"+
		"\u009d\u0005\t\u0000\u0000\u009d\u009e\u0003,\u0016\u0000\u009e\u009f"+
		"\u0005\b\u0000\u0000\u009f\u00a0\u0006\b\uffff\uffff\u0000\u00a0\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a1\u008d\u0001\u0000\u0000\u0000\u00a1\u0092"+
		"\u0001\u0000\u0000\u0000\u00a1\u009a\u0001\u0000\u0000\u0000\u00a2\u0011"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0003\u0014\n\u0000\u00a4\u00a5\u0003"+
		"\u0012\t\u0000\u00a5\u00a6\u0006\t\uffff\uffff\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u0006\t\uffff\uffff\u0000\u00a8\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u0013\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0003\u0016\u000b\u0000\u00ab\u00ac\u0006"+
		"\n\uffff\uffff\u0000\u00ac\u00c6\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003"+
		"\u0018\f\u0000\u00ae\u00af\u0006\n\uffff\uffff\u0000\u00af\u00c6\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0003\u001a\r\u0000\u00b1\u00b2\u0006\n"+
		"\uffff\uffff\u0000\u00b2\u00c6\u0001\u0000\u0000\u0000\u00b3\u00b4\u0003"+
		"\u001c\u000e\u0000\u00b4\u00b5\u0006\n\uffff\uffff\u0000\u00b5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0003\"\u0011\u0000\u00b7\u00b8\u0006\n"+
		"\uffff\uffff\u0000\u00b8\u00c6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003"+
		"$\u0012\u0000\u00ba\u00bb\u0006\n\uffff\uffff\u0000\u00bb\u00c6\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0003\f\u0006\u0000\u00bd\u00be\u0006\n"+
		"\uffff\uffff\u0000\u00be\u00c6\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003"+
		"(\u0014\u0000\u00c0\u00c1\u0006\n\uffff\uffff\u0000\u00c1\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0003*\u0015\u0000\u00c3\u00c4\u0006\n"+
		"\uffff\uffff\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00aa\u0001"+
		"\u0000\u0000\u0000\u00c5\u00ad\u0001\u0000\u0000\u0000\u00c5\u00b0\u0001"+
		"\u0000\u0000\u0000\u00c5\u00b3\u0001\u0000\u0000\u0000\u00c5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00b9\u0001\u0000\u0000\u0000\u00c5\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000\u0000\u0000\u00c5\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c6\u0015\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		".\u0000\u0000\u00c8\u00c9\u0005\t\u0000\u0000\u00c9\u00ca\u0003,\u0016"+
		"\u0000\u00ca\u00cb\u0005\b\u0000\u0000\u00cb\u00cc\u0006\u000b\uffff\uffff"+
		"\u0000\u00cc\u00d7\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005.\u0000\u0000"+
		"\u00ce\u00cf\u0005\u0004\u0000\u0000\u00cf\u00d0\u0003,\u0016\u0000\u00d0"+
		"\u00d1\u0005\u0005\u0000\u0000\u00d1\u00d2\u0005\t\u0000\u0000\u00d2\u00d3"+
		"\u0003,\u0016\u0000\u00d3\u00d4\u0005\b\u0000\u0000\u00d4\u00d5\u0006"+
		"\u000b\uffff\uffff\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00c7"+
		"\u0001\u0000\u0000\u0000\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d7\u0017"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u001f\u0000\u0000\u00d9\u00da"+
		"\u0005\u0001\u0000\u0000\u00da\u00db\u0003,\u0016\u0000\u00db\u00dc\u0005"+
		"\u0002\u0000\u0000\u00dc\u00dd\u0003\u0014\n\u0000\u00dd\u00de\u0006\f"+
		"\uffff\uffff\u0000\u00de\u00e9\u0001\u0000\u0000\u0000\u00df\u00e0\u0005"+
		"\u001f\u0000\u0000\u00e0\u00e1\u0005\u0001\u0000\u0000\u00e1\u00e2\u0003"+
		",\u0016\u0000\u00e2\u00e3\u0005\u0002\u0000\u0000\u00e3\u00e4\u0003\u0014"+
		"\n\u0000\u00e4\u00e5\u0005 \u0000\u0000\u00e5\u00e6\u0003\u0014\n\u0000"+
		"\u00e6\u00e7\u0006\f\uffff\uffff\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e8\u00d8\u0001\u0000\u0000\u0000\u00e8\u00df\u0001\u0000\u0000\u0000"+
		"\u00e9\u0019\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005!\u0000\u0000\u00eb"+
		"\u00ec\u0005\u0001\u0000\u0000\u00ec\u00ed\u0003,\u0016\u0000\u00ed\u00ee"+
		"\u0005\u0002\u0000\u0000\u00ee\u00ef\u0003\u0014\n\u0000\u00ef\u00f0\u0006"+
		"\r\uffff\uffff\u0000\u00f0\u001b\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005"+
		"\"\u0000\u0000\u00f2\u00f3\u0005\u0001\u0000\u0000\u00f3\u00f4\u0003\u001e"+
		"\u000f\u0000\u00f4\u00f5\u0003,\u0016\u0000\u00f5\u00f6\u0005\b\u0000"+
		"\u0000\u00f6\u00f7\u0003 \u0010\u0000\u00f7\u00f8\u0005\u0002\u0000\u0000"+
		"\u00f8\u00f9\u0003\u0014\n\u0000\u00f9\u00fa\u0006\u000e\uffff\uffff\u0000"+
		"\u00fa\u001d\u0001\u0000\u0000\u0000\u00fb\u00fc\u0003\n\u0005\u0000\u00fc"+
		"\u00fd\u0005.\u0000\u0000\u00fd\u00fe\u0005\t\u0000\u0000\u00fe\u00ff"+
		"\u0003,\u0016\u0000\u00ff\u0100\u0005\b\u0000\u0000\u0100\u0101\u0006"+
		"\u000f\uffff\uffff\u0000\u0101\u010b\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0005.\u0000\u0000\u0103\u0104\u0005\t\u0000\u0000\u0104\u0105\u0003"+
		",\u0016\u0000\u0105\u0106\u0005\b\u0000\u0000\u0106\u0107\u0006\u000f"+
		"\uffff\uffff\u0000\u0107\u010b\u0001\u0000\u0000\u0000\u0108\u0109\u0005"+
		"\b\u0000\u0000\u0109\u010b\u0006\u000f\uffff\uffff\u0000\u010a\u00fb\u0001"+
		"\u0000\u0000\u0000\u010a\u0102\u0001\u0000\u0000\u0000\u010a\u0108\u0001"+
		"\u0000\u0000\u0000\u010b\u001f\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		".\u0000\u0000\u010d\u010e\u0005\t\u0000\u0000\u010e\u010f\u0003,\u0016"+
		"\u0000\u010f\u0110\u0006\u0010\uffff\uffff\u0000\u0110\u0119\u0001\u0000"+
		"\u0000\u0000\u0111\u0112\u0005.\u0000\u0000\u0112\u0113\u0005\n\u0000"+
		"\u0000\u0113\u0119\u0006\u0010\uffff\uffff\u0000\u0114\u0115\u0005.\u0000"+
		"\u0000\u0115\u0116\u0005\u000b\u0000\u0000\u0116\u0119\u0006\u0010\uffff"+
		"\uffff\u0000\u0117\u0119\u0006\u0010\uffff\uffff\u0000\u0118\u010c\u0001"+
		"\u0000\u0000\u0000\u0118\u0111\u0001\u0000\u0000\u0000\u0118\u0114\u0001"+
		"\u0000\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119!\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0005#\u0000\u0000\u011b\u011c\u0003,\u0016\u0000"+
		"\u011c\u011d\u0005\b\u0000\u0000\u011d\u011e\u0006\u0011\uffff\uffff\u0000"+
		"\u011e\u0123\u0001\u0000\u0000\u0000\u011f\u0120\u0005#\u0000\u0000\u0120"+
		"\u0121\u0005\b\u0000\u0000\u0121\u0123\u0006\u0011\uffff\uffff\u0000\u0122"+
		"\u011a\u0001\u0000\u0000\u0000\u0122\u011f\u0001\u0000\u0000\u0000\u0123"+
		"#\u0001\u0000\u0000\u0000\u0124\u0125\u0005.\u0000\u0000\u0125\u0126\u0005"+
		"\u0001\u0000\u0000\u0126\u0127\u0003&\u0013\u0000\u0127\u0128\u0005\u0002"+
		"\u0000\u0000\u0128\u0129\u0005\b\u0000\u0000\u0129\u012a\u0006\u0012\uffff"+
		"\uffff\u0000\u012a%\u0001\u0000\u0000\u0000\u012b\u0130\u0003,\u0016\u0000"+
		"\u012c\u012d\u0005\u0003\u0000\u0000\u012d\u012f\u0003,\u0016\u0000\u012e"+
		"\u012c\u0001\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000\u0000\u0130"+
		"\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131"+
		"\u0133\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0006\u0013\uffff\uffff\u0000\u0134\u0137\u0001\u0000\u0000\u0000"+
		"\u0135\u0137\u0006\u0013\uffff\uffff\u0000\u0136\u012b\u0001\u0000\u0000"+
		"\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\'\u0001\u0000\u0000\u0000"+
		"\u0138\u0139\u0005&\u0000\u0000\u0139\u013a\u0005\u0001\u0000\u0000\u013a"+
		"\u013f\u0005-\u0000\u0000\u013b\u013c\u0005\u0003\u0000\u0000\u013c\u013e"+
		"\u0003,\u0016\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u0141\u0001"+
		"\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f\u0140\u0001"+
		"\u0000\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013f\u0001"+
		"\u0000\u0000\u0000\u0142\u0143\u0005\u0002\u0000\u0000\u0143\u0144\u0005"+
		"\b\u0000\u0000\u0144\u0145\u0006\u0014\uffff\uffff\u0000\u0145)\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0005\'\u0000\u0000\u0147\u0148\u0005\u0001"+
		"\u0000\u0000\u0148\u014c\u0005-\u0000\u0000\u0149\u014a\u0005\u0003\u0000"+
		"\u0000\u014a\u014b\u0005\f\u0000\u0000\u014b\u014d\u0005.\u0000\u0000"+
		"\u014c\u0149\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000"+
		"\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0151\u0005\u0002\u0000\u0000"+
		"\u0151\u0152\u0005\b\u0000\u0000\u0152\u0153\u0006\u0015\uffff\uffff\u0000"+
		"\u0153+\u0001\u0000\u0000\u0000\u0154\u0155\u0006\u0016\uffff\uffff\u0000"+
		"\u0155\u0156\u0003.\u0017\u0000\u0156\u0157\u0006\u0016\uffff\uffff\u0000"+
		"\u0157\u015f\u0001\u0000\u0000\u0000\u0158\u0159\n\u0002\u0000\u0000\u0159"+
		"\u015a\u0005(\u0000\u0000\u015a\u015b\u0003.\u0017\u0000\u015b\u015c\u0006"+
		"\u0016\uffff\uffff\u0000\u015c\u015e\u0001\u0000\u0000\u0000\u015d\u0158"+
		"\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160-\u0001"+
		"\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0006"+
		"\u0017\uffff\uffff\u0000\u0163\u0164\u00030\u0018\u0000\u0164\u0165\u0006"+
		"\u0017\uffff\uffff\u0000\u0165\u016d\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\n\u0002\u0000\u0000\u0167\u0168\u0005)\u0000\u0000\u0168\u0169\u0003"+
		"0\u0018\u0000\u0169\u016a\u0006\u0017\uffff\uffff\u0000\u016a\u016c\u0001"+
		"\u0000\u0000\u0000\u016b\u0166\u0001\u0000\u0000\u0000\u016c\u016f\u0001"+
		"\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016e\u0001"+
		"\u0000\u0000\u0000\u016e/\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0006\u0018\uffff\uffff\u0000\u0171\u0172\u0003"+
		"2\u0019\u0000\u0172\u0173\u0006\u0018\uffff\uffff\u0000\u0173\u017b\u0001"+
		"\u0000\u0000\u0000\u0174\u0175\n\u0002\u0000\u0000\u0175\u0176\u0007\u0000"+
		"\u0000\u0000\u0176\u0177\u00032\u0019\u0000\u0177\u0178\u0006\u0018\uffff"+
		"\uffff\u0000\u0178\u017a\u0001\u0000\u0000\u0000\u0179\u0174\u0001\u0000"+
		"\u0000\u0000\u017a\u017d\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000"+
		"\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c1\u0001\u0000\u0000"+
		"\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017e\u017f\u0006\u0019\uffff"+
		"\uffff\u0000\u017f\u0180\u00034\u001a\u0000\u0180\u0181\u0006\u0019\uffff"+
		"\uffff\u0000\u0181\u0189\u0001\u0000\u0000\u0000\u0182\u0183\n\u0002\u0000"+
		"\u0000\u0183\u0184\u0007\u0001\u0000\u0000\u0184\u0185\u00034\u001a\u0000"+
		"\u0185\u0186\u0006\u0019\uffff\uffff\u0000\u0186\u0188\u0001\u0000\u0000"+
		"\u0000\u0187\u0182\u0001\u0000\u0000\u0000\u0188\u018b\u0001\u0000\u0000"+
		"\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000"+
		"\u0000\u018a3\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000"+
		"\u018c\u018d\u0006\u001a\uffff\uffff\u0000\u018d\u018e\u00036\u001b\u0000"+
		"\u018e\u018f\u0006\u001a\uffff\uffff\u0000\u018f\u0197\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\n\u0002\u0000\u0000\u0191\u0192\u0007\u0002\u0000\u0000"+
		"\u0192\u0193\u00036\u001b\u0000\u0193\u0194\u0006\u001a\uffff\uffff\u0000"+
		"\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0190\u0001\u0000\u0000\u0000"+
		"\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0001\u0000\u0000\u0000\u01985\u0001\u0000\u0000\u0000\u0199"+
		"\u0197\u0001\u0000\u0000\u0000\u019a\u019b\u0006\u001b\uffff\uffff\u0000"+
		"\u019b\u019c\u00038\u001c\u0000\u019c\u019d\u0006\u001b\uffff\uffff\u0000"+
		"\u019d\u01a5\u0001\u0000\u0000\u0000\u019e\u019f\n\u0002\u0000\u0000\u019f"+
		"\u01a0\u0007\u0003\u0000\u0000\u01a0\u01a1\u00038\u001c\u0000\u01a1\u01a2"+
		"\u0006\u001b\uffff\uffff\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3"+
		"\u019e\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6"+
		"7\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0005\u0014\u0000\u0000\u01a9\u01aa\u0003:\u001d\u0000\u01aa\u01ab\u0006"+
		"\u001c\uffff\uffff\u0000\u01ab\u01b4\u0001\u0000\u0000\u0000\u01ac\u01ad"+
		"\u0005\u0018\u0000\u0000\u01ad\u01ae\u0003:\u001d\u0000\u01ae\u01af\u0006"+
		"\u001c\uffff\uffff\u0000\u01af\u01b4\u0001\u0000\u0000\u0000\u01b0\u01b1"+
		"\u0003:\u001d\u0000\u01b1\u01b2\u0006\u001c\uffff\uffff\u0000\u01b2\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b3\u01a8\u0001\u0000\u0000\u0000\u01b3\u01ac"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b0\u0001\u0000\u0000\u0000\u01b49\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b6\u0005*\u0000\u0000\u01b6\u01d3\u0006\u001d"+
		"\uffff\uffff\u0000\u01b7\u01b8\u0005+\u0000\u0000\u01b8\u01d3\u0006\u001d"+
		"\uffff\uffff\u0000\u01b9\u01ba\u0005,\u0000\u0000\u01ba\u01d3\u0006\u001d"+
		"\uffff\uffff\u0000\u01bb\u01bc\u0005$\u0000\u0000\u01bc\u01d3\u0006\u001d"+
		"\uffff\uffff\u0000\u01bd\u01be\u0005%\u0000\u0000\u01be\u01d3\u0006\u001d"+
		"\uffff\uffff\u0000\u01bf\u01c0\u0005.\u0000\u0000\u01c0\u01c1\u0005\u0004"+
		"\u0000\u0000\u01c1\u01c2\u0003,\u0016\u0000\u01c2\u01c3\u0005\u0005\u0000"+
		"\u0000\u01c3\u01c4\u0006\u001d\uffff\uffff\u0000\u01c4\u01d3\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c6\u0005.\u0000\u0000\u01c6\u01c7\u0005\u0001\u0000"+
		"\u0000\u01c7\u01c8\u0003&\u0013\u0000\u01c8\u01c9\u0005\u0002\u0000\u0000"+
		"\u01c9\u01ca\u0006\u001d\uffff\uffff\u0000\u01ca\u01d3\u0001\u0000\u0000"+
		"\u0000\u01cb\u01cc\u0005.\u0000\u0000\u01cc\u01d3\u0006\u001d\uffff\uffff"+
		"\u0000\u01cd\u01ce\u0005\u0001\u0000\u0000\u01ce\u01cf\u0003,\u0016\u0000"+
		"\u01cf\u01d0\u0005\u0002\u0000\u0000\u01d0\u01d1\u0006\u001d\uffff\uffff"+
		"\u0000\u01d1\u01d3\u0001\u0000\u0000\u0000\u01d2\u01b5\u0001\u0000\u0000"+
		"\u0000\u01d2\u01b7\u0001\u0000\u0000\u0000\u01d2\u01b9\u0001\u0000\u0000"+
		"\u0000\u01d2\u01bb\u0001\u0000\u0000\u0000\u01d2\u01bd\u0001\u0000\u0000"+
		"\u0000\u01d2\u01bf\u0001\u0000\u0000\u0000\u01d2\u01c5\u0001\u0000\u0000"+
		"\u0000\u01d2\u01cb\u0001\u0000\u0000\u0000\u01d2\u01cd\u0001\u0000\u0000"+
		"\u0000\u01d3;\u0001\u0000\u0000\u0000\u001c>@V`fr~\u008b\u00a1\u00a8\u00c5"+
		"\u00d6\u00e8\u010a\u0118\u0122\u0130\u0136\u013f\u014e\u015f\u016d\u017b"+
		"\u0189\u0197\u01a5\u01b3\u01d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}