lexer grammar mylexer;

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE  : 'int';
VOID_TYPE : 'void';
FLOAT_TYPE: 'float';
WHILE_    : 'while';
ELSE_   : 'else' ;
IF_     : 'if' ;
RETURN_ : 'return' ;

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
LINE_COMMENT  : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
WS  : (' '|'\r'|'\t')+ -> skip
    ;
NEW_LINE: '\n' -> skip;

/*----------------------*/
/*      Fragments       */
/*----------------------*/
fragment LETTER : 'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT : '0'..'9';