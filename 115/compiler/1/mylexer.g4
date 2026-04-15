lexer grammar mylexer;

// Keywords
INT     : 'int' ;
FLOAT   : 'float' ;
CHAR    : 'char' ;
VOID    : 'void' ;
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;
FOR     : 'for' ;
RETURN  : 'return' ;
BREAK   : 'break' ;
CONTINUE: 'continue' ;
STRUCT  : 'struct' ;
TYPEDEF : 'typedef' ;
SIZEOF  : 'sizeof' ;

// Literals
INTEGER_LITERAL : [0-9]+ ;
FLOAT_LITERAL   : [0-9]+ '.' [0-9]* | '.' [0-9]+ ;
CHAR_LITERAL    : '\'' ( ~['\\] | '\\' . ) '\'' ;
STRING_LITERAL  : '"' ( ~["\\] | '\\' . )* '"' ;

// Identifiers
IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]* ;

// Operators - Relational
LE  : '<=' ;
GE  : '>=' ;
EQ  : '==' ;
NEQ : '!=' ;
LT  : '<' ;
GT  : '>' ;

// Operators - Logical
AND : '&&' ;
OR  : '||' ;
NOT : '!' ;

// Operators - Arithmetic
PLUS   : '+' ;
MINUS  : '-' ;
STAR   : '*' ;
SLASH  : '/' ;
MOD    : '%' ;

// Operators - Assignment
ASSIGN      : '=' ;
PLUS_ASSIGN : '+=' ;
MINUS_ASSIGN: '-=' ;
STAR_ASSIGN : '*=' ;
SLASH_ASSIGN: '/=' ;

// Operators - Increment/Decrement
INC : '++' ;
DEC : '--' ;

// Punctuation
SEMI    : ';' ;
COMMA   : ',' ;
DOT     : '.' ;
COLON   : ':' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
LBRACE  : '{' ;
RBRACE  : '}' ;
LBRACKET: '[' ;
RBRACKET: ']' ;
ARROW   : '->' ;
AMP     : '&' ;

// Whitespace and comments (skip)
WS              : [ \t\r\n]+ -> skip ;
LINE_COMMENT    : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT   : '/*' .*? '*/' -> skip ;
