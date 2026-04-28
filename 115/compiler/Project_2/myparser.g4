grammar myparser;

@members {
    public static final boolean TRACEON = true;
}

program
    : declarationList EOF
    { if (TRACEON) System.out.println("program: declarationList EOF"); }
    ;

declarationList
    : declarationList declaration
    { if (TRACEON) System.out.println("declarationList: declarationList declaration"); }
    | declaration
    { if (TRACEON) System.out.println("declarationList: declaration"); }
    ;

declaration
    : varDeclaration
    { if (TRACEON) System.out.println("declaration: varDeclaration"); }
    | funDeclaration
    { if (TRACEON) System.out.println("declaration: funDeclaration"); }
    ;

varDeclaration
    : typeSpecifier ID SEMI
    { if (TRACEON) System.out.println("varDeclaration: typeSpecifier ID ;"); }
    | typeSpecifier ID LBRACKET INT_NUM RBRACKET SEMI
    { if (TRACEON) System.out.println("varDeclaration: typeSpecifier ID [ Integer ] ;"); }
    ;

typeSpecifier
    : INT_TYPE
    { if (TRACEON) System.out.println("typeSpecifier: int"); }
    | VOID_TYPE
    { if (TRACEON) System.out.println("typeSpecifier: void"); }
    | FLOAT_TYPE
    { if (TRACEON) System.out.println("typeSpecifier: float"); }
    ;

funDeclaration
    : typeSpecifier ID LPAREN params RPAREN compoundStmt
    { if (TRACEON) System.out.println("funDeclaration: typeSpecifier ID ( params ) compoundStmt"); }
    ;

params
    : paramList
    { if (TRACEON) System.out.println("params: paramList"); }
    | VOID_TYPE
    { if (TRACEON) System.out.println("params: void"); }
    | /* empty */
    { if (TRACEON) System.out.println("params: empty"); }
    ;

paramList
    : paramList COMMA param
    { if (TRACEON) System.out.println("paramList: paramList , param"); }
    | param
    { if (TRACEON) System.out.println("paramList: param"); }
    ;

param
    : typeSpecifier ID
    { if (TRACEON) System.out.println("param: typeSpecifier ID"); }
    | typeSpecifier ID LBRACKET RBRACKET
    { if (TRACEON) System.out.println("param: typeSpecifier ID [ ]"); }
    ;

compoundStmt
    : LBRACE localDeclarations statementList RBRACE
    { if (TRACEON) System.out.println("compoundStmt: { localDeclarations statementList }"); }
    ;

localDeclarations
    : localDeclarations varDeclaration
    { if (TRACEON) System.out.println("localDeclarations: localDeclarations varDeclaration"); }
    | /* empty */
    { if (TRACEON) System.out.println("localDeclarations: empty"); }
    ;

statementList
    : statementList statement
    { if (TRACEON) System.out.println("statementList: statementList statement"); }
    | /* empty */
    { if (TRACEON) System.out.println("statementList: empty"); }
    ;

statement
    : expressionStmt
    { if (TRACEON) System.out.println("statement: expressionStmt"); }
    | compoundStmt
    { if (TRACEON) System.out.println("statement: compoundStmt"); }
    | selectionStmt
    { if (TRACEON) System.out.println("statement: selectionStmt"); }
    | iterationStmt
    { if (TRACEON) System.out.println("statement: iterationStmt"); }
    | returnStmt
    { if (TRACEON) System.out.println("statement: returnStmt"); }
    ;

expressionStmt
    : expression SEMI
    { if (TRACEON) System.out.println("expressionStmt: expression ;"); }
    | SEMI
    { if (TRACEON) System.out.println("expressionStmt: ;"); }
    ;

selectionStmt
    : IF_ LPAREN expression RPAREN statement ELSE_ statement
    { if (TRACEON) System.out.println("selectionStmt: if ( expression ) statement else statement"); }
    | IF_ LPAREN expression RPAREN statement
    { if (TRACEON) System.out.println("selectionStmt: if ( expression ) statement"); }
    ;

iterationStmt
    : WHILE_ LPAREN expression RPAREN statement
    { if (TRACEON) System.out.println("iterationStmt: while ( expression ) statement"); }
    ;

returnStmt
    : RETURN_ SEMI
    { if (TRACEON) System.out.println("returnStmt: return ;"); }
    | RETURN_ expression SEMI
    { if (TRACEON) System.out.println("returnStmt: return expression ;"); }
    ;

expression
    : var ASSIGN expression
    { if (TRACEON) System.out.println("expression: var = expression"); }
    | simpleExpression
    { if (TRACEON) System.out.println("expression: simpleExpression"); }
    ;

var
    : ID LBRACKET expression RBRACKET
    { if (TRACEON) System.out.println("var: ID [ expression ]"); }
    | ID
    { if (TRACEON) System.out.println("var: ID"); }
    ;

simpleExpression
    : additiveExpression relop additiveExpression
    { if (TRACEON) System.out.println("simpleExpression: additiveExpression relop additiveExpression"); }
    | additiveExpression
    { if (TRACEON) System.out.println("simpleExpression: additiveExpression"); }
    ;

relop
    : LE
    { if (TRACEON) System.out.println("relop: <="); }
    | LT
    { if (TRACEON) System.out.println("relop: <"); }
    | GT
    { if (TRACEON) System.out.println("relop: >"); }
    | GE
    { if (TRACEON) System.out.println("relop: >="); }
    | EQ
    { if (TRACEON) System.out.println("relop: =="); }
    | NE
    { if (TRACEON) System.out.println("relop: !="); }
    ;

additiveExpression
    : additiveExpression addop term
    { if (TRACEON) System.out.println("additiveExpression: additiveExpression addop term"); }
    | term
    { if (TRACEON) System.out.println("additiveExpression: term"); }
    ;

addop
    : PLUS
    { if (TRACEON) System.out.println("addop: +"); }
    | MINUS
    { if (TRACEON) System.out.println("addop: -"); }
    ;

term
    : term mulop factor
    { if (TRACEON) System.out.println("term: term mulop factor"); }
    | factor
    { if (TRACEON) System.out.println("term: factor"); }
    ;

mulop
    : STAR
    { if (TRACEON) System.out.println("mulop: *"); }
    | SLASH
    { if (TRACEON) System.out.println("mulop: /"); }
    | MOD
    { if (TRACEON) System.out.println("mulop: %"); }
    ;

factor
    : LPAREN expression RPAREN
    { if (TRACEON) System.out.println("factor: ( expression )"); }
    | call
    { if (TRACEON) System.out.println("factor: call"); }
    | var
    { if (TRACEON) System.out.println("factor: var"); }
    | INT_NUM
    { if (TRACEON) System.out.println("factor: Integer"); }
    | FLOAT_NUM
    { if (TRACEON) System.out.println("factor: Float"); }
    ;

call
    : ID LPAREN args RPAREN
    { if (TRACEON) System.out.println("call: ID ( args )"); }
    ;

args
    : argList
    { if (TRACEON) System.out.println("args: argList"); }
    | /* empty */
    { if (TRACEON) System.out.println("args: empty"); }
    ;

argList
    : argList COMMA expression
    { if (TRACEON) System.out.println("argList: argList , expression"); }
    | expression
    { if (TRACEON) System.out.println("argList: expression"); }
    ;

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE   : 'int'    ;
VOID_TYPE  : 'void'   ;
FLOAT_TYPE : 'float'  ;
WHILE_     : 'while'  ;
ELSE_      : 'else'   ;
IF_        : 'if'     ;
RETURN_    : 'return' ;

/*----------------------*/
/*  Compound Operators  */
/*----------------------*/
LE  : '<=' ;
GE  : '>=' ;
EQ  : '==' ;
NE  : '!=' ;

/*----------------------*/
/*   Single-char Ops    */
/*----------------------*/
PLUS   : '+' ;
MINUS  : '-' ;
STAR   : '*' ;
SLASH  : '/' ;
MOD    : '%' ;
LT     : '<' ;
GT     : '>' ;
ASSIGN : '=' ;

/*----------------------*/
/*     Punctuation      */
/*----------------------*/
SEMI     : ';' ;
COMMA    : ',' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
LBRACE   : '{' ;
RBRACE   : '}' ;

/*----------------------*/
/*      Literals        */
/*----------------------*/
FLOAT_NUM
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;
INT_NUM
    : '0'
    | [1-9] DIGIT*
    ;

/*----------------------*/
/*     Identifiers      */
/*----------------------*/
ID : LETTER (LETTER | DIGIT)* ;

/*----------------------*/
/*  Comments/Whitespace */
/*----------------------*/
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
WS            : (' ' | '\r' | '\t')+ -> skip ;
NEW_LINE      : '\n' -> skip ;

/*----------------------*/
/*      Fragments       */
/*----------------------*/
fragment LETTER : 'a'..'z' | 'A'..'Z' | '_' ;
fragment DIGIT  : '0'..'9' ;
