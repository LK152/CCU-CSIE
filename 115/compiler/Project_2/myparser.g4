grammar myparser;

@members {
    public static final boolean TRACEON = true;
}

program
    : (functionDef | declaration)* EOF
    { if (TRACEON) System.out.println("program: (functionDef | declaration)* EOF"); }
    ;

functionDef
    : returnType ID '(' paramList ')' block
    { if (TRACEON) System.out.println("functionDef: returnType ID ( paramList ) block"); }
    | VOID ID '(' paramList ')' block
    { if (TRACEON) System.out.println("functionDef: VOID ID ( paramList ) block"); }
    ;

returnType
    : type
    { if (TRACEON) System.out.println("returnType: type"); }
    ;

paramList
    : param (',' param)*
    { if (TRACEON) System.out.println("paramList: param (, param)*"); }
    | /* empty */
    { if (TRACEON) System.out.println("paramList: (empty)"); }
    ;

param
    : type ID
    { if (TRACEON) System.out.println("param: type ID"); }
    | type ID '[' ']'
    { if (TRACEON) System.out.println("param: type ID [ ]"); }
    ;

type
    : INT
    { if (TRACEON) System.out.println("type: INT"); }
    | FLOAT
    { if (TRACEON) System.out.println("type: FLOAT"); }
    | CHAR
    { if (TRACEON) System.out.println("type: CHAR"); }
    | DOUBLE
    { if (TRACEON) System.out.println("type: DOUBLE"); }
    | BOOL
    { if (TRACEON) System.out.println("type: BOOL"); }
    ;

block
    : '{' declarations stmts '}'
    { if (TRACEON) System.out.println("block: { declarations stmts }"); }
    ;

declarations
    : declaration declarations
    { if (TRACEON) System.out.println("declarations: declaration declarations"); }
    | /* empty */
    { if (TRACEON) System.out.println("declarations: (empty)"); }
    ;

declaration
    : type ID ';'
    { if (TRACEON) System.out.println("declaration: type ID ;"); }
    | type ID '[' INTLIT ']' ';'
    { if (TRACEON) System.out.println("declaration: type ID [ INTLIT ] ;"); }
    | type ID '=' expr ';'
    { if (TRACEON) System.out.println("declaration: type ID = expr ;"); }
    ;

stmts
    : stmt stmts
    { if (TRACEON) System.out.println("stmts: stmt stmts"); }
    | /* empty */
    { if (TRACEON) System.out.println("stmts: (empty)"); }
    ;

stmt
    : assignStmt
    { if (TRACEON) System.out.println("stmt: assignStmt"); }
    | ifStmt
    { if (TRACEON) System.out.println("stmt: ifStmt"); }
    | whileStmt
    { if (TRACEON) System.out.println("stmt: whileStmt"); }
    | forStmt
    { if (TRACEON) System.out.println("stmt: forStmt"); }
    | returnStmt
    { if (TRACEON) System.out.println("stmt: returnStmt"); }
    | funcCallStmt
    { if (TRACEON) System.out.println("stmt: funcCallStmt"); }
    | block
    { if (TRACEON) System.out.println("stmt: block"); }
    | printfStmt
    { if (TRACEON) System.out.println("stmt: printfStmt"); }
    | scanfStmt
    { if (TRACEON) System.out.println("stmt: scanfStmt"); }
    ;

assignStmt
    : ID '=' expr ';'
    { if (TRACEON) System.out.println("assignStmt: ID = expr ;"); }
    | ID '[' expr ']' '=' expr ';'
    { if (TRACEON) System.out.println("assignStmt: ID [ expr ] = expr ;"); }
    ;

ifStmt
    : IF '(' expr ')' stmt
    { if (TRACEON) System.out.println("ifStmt: IF ( expr ) stmt"); }
    | IF '(' expr ')' stmt ELSE stmt
    { if (TRACEON) System.out.println("ifStmt: IF ( expr ) stmt ELSE stmt"); }
    ;

whileStmt
    : WHILE '(' expr ')' stmt
    { if (TRACEON) System.out.println("whileStmt: WHILE ( expr ) stmt"); }
    ;

forStmt
    : FOR '(' forInit expr ';' forUpdate ')' stmt
    { if (TRACEON) System.out.println("forStmt: FOR ( forInit expr ; forUpdate ) stmt"); }
    ;

forInit
    : type ID '=' expr ';'
    { if (TRACEON) System.out.println("forInit: type ID = expr ;"); }
    | ID '=' expr ';'
    { if (TRACEON) System.out.println("forInit: ID = expr ;"); }
    | ';'
    { if (TRACEON) System.out.println("forInit: ;"); }
    ;

forUpdate
    : ID '=' expr
    { if (TRACEON) System.out.println("forUpdate: ID = expr"); }
    | ID '++'
    { if (TRACEON) System.out.println("forUpdate: ID ++"); }
    | ID '--'
    { if (TRACEON) System.out.println("forUpdate: ID --"); }
    | /* empty */
    { if (TRACEON) System.out.println("forUpdate: (empty)"); }
    ;

returnStmt
    : RETURN expr ';'
    { if (TRACEON) System.out.println("returnStmt: RETURN expr ;"); }
    | RETURN ';'
    { if (TRACEON) System.out.println("returnStmt: RETURN ;"); }
    ;

funcCallStmt
    : ID '(' argList ')' ';'
    { if (TRACEON) System.out.println("funcCallStmt: ID ( argList ) ;"); }
    ;

argList
    : expr (',' expr)*
    { if (TRACEON) System.out.println("argList: expr (, expr)*"); }
    | /* empty */
    { if (TRACEON) System.out.println("argList: (empty)"); }
    ;

printfStmt
    : PRINTF '(' STRLIT (',' expr)* ')' ';'
    { if (TRACEON) System.out.println("printfStmt: PRINTF ( STRLIT (, expr)* ) ;"); }
    ;

scanfStmt
    : SCANF '(' STRLIT (',' '&' ID)+ ')' ';'
    { if (TRACEON) System.out.println("scanfStmt: SCANF ( STRLIT (, & ID)+ ) ;"); }
    ;

expr
    : expr OR andExpr
    { if (TRACEON) System.out.println("expr: expr OR andExpr"); }
    | andExpr
    { if (TRACEON) System.out.println("expr: andExpr"); }
    ;

andExpr
    : andExpr AND eqExpr
    { if (TRACEON) System.out.println("andExpr: andExpr AND eqExpr"); }
    | eqExpr
    { if (TRACEON) System.out.println("andExpr: eqExpr"); }
    ;

eqExpr
    : eqExpr ('==' | '!=') relExpr
    { if (TRACEON) System.out.println("eqExpr: eqExpr (== | !=) relExpr"); }
    | relExpr
    { if (TRACEON) System.out.println("eqExpr: relExpr"); }
    ;

relExpr
    : relExpr ('<' | '>' | '<=' | '>=') addExpr
    { if (TRACEON) System.out.println("relExpr: relExpr (< | > | <= | >=) addExpr"); }
    | addExpr
    { if (TRACEON) System.out.println("relExpr: addExpr"); }
    ;

addExpr
    : addExpr ('+' | '-') mulExpr
    { if (TRACEON) System.out.println("addExpr: addExpr (+ | -) mulExpr"); }
    | mulExpr
    { if (TRACEON) System.out.println("addExpr: mulExpr"); }
    ;

mulExpr
    : mulExpr ('*' | '/' | '%') unaryExpr
    { if (TRACEON) System.out.println("mulExpr: mulExpr (* | / | %) unaryExpr"); }
    | unaryExpr
    { if (TRACEON) System.out.println("mulExpr: unaryExpr"); }
    ;

unaryExpr
    : '-' primaryExpr
    { if (TRACEON) System.out.println("unaryExpr: - primaryExpr"); }
    | '!' primaryExpr
    { if (TRACEON) System.out.println("unaryExpr: ! primaryExpr"); }
    | primaryExpr
    { if (TRACEON) System.out.println("unaryExpr: primaryExpr"); }
    ;

primaryExpr
    : INTLIT
    { if (TRACEON) System.out.println("primaryExpr: INTLIT"); }
    | FLOATLIT
    { if (TRACEON) System.out.println("primaryExpr: FLOATLIT"); }
    | CHARLIT
    { if (TRACEON) System.out.println("primaryExpr: CHARLIT"); }
    | TRUE
    { if (TRACEON) System.out.println("primaryExpr: TRUE"); }
    | FALSE
    { if (TRACEON) System.out.println("primaryExpr: FALSE"); }
    | ID '[' expr ']'
    { if (TRACEON) System.out.println("primaryExpr: ID [ expr ]"); }
    | ID '(' argList ')'
    { if (TRACEON) System.out.println("primaryExpr: ID ( argList )"); }
    | ID
    { if (TRACEON) System.out.println("primaryExpr: ID"); }
    | '(' expr ')'
    { if (TRACEON) System.out.println("primaryExpr: ( expr )"); }
    ;

INT     : 'int' ;
FLOAT   : 'float' ;
CHAR    : 'char' ;
DOUBLE  : 'double' ;
BOOL    : 'bool' ;
VOID    : 'void' ;
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;
FOR     : 'for' ;
RETURN  : 'return' ;
TRUE    : 'true' ;
FALSE   : 'false' ;
PRINTF  : 'printf' ;
SCANF   : 'scanf' ;

OR      : '||' ;
AND     : '&&' ;

INTLIT   : [0-9]+ ;
FLOATLIT : [0-9]+ '.' [0-9]* | '.' [0-9]+ ;
CHARLIT  : '\'' (~['\\\r\n] | '\\' .) '\'' ;
STRLIT   : '"' (~["\\\r\n] | '\\' .)* '"' ;

ID : [a-zA-Z_][a-zA-Z_0-9]* ;

WS          : [ \t\r\n]+         -> skip ;
LINE_COMMENT : '//' ~[\r\n]*     -> skip ;
BLOCK_COMMENT: '/*' .*? '*/'     -> skip ;
