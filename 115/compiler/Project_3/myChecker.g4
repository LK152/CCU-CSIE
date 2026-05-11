grammar myChecker;

@header {
    // import packages here.
    import java.util.HashMap;
}

@members {
    boolean TRACEON = false;
    HashMap<String,Integer> symtab = new HashMap<String,Integer>();

	/*
    public enum TypeInfo {
        Integer,
		Float,
		Unknown,
		No_Exist,
		Error
    }
    */

    /* attr_type:
       1 => integer,
       2 => float,
       -1 => do not exist,
       -2 => error
     */	   

    void reportError(int line, String msg) {
        System.out.println("==Error== " + line + ": " + msg);
    }
}

program
	: VOID MAIN '(' VOID? ')' '{' declarations statements '}'
     { if (TRACEON) System.out.println("program: VOID MAIN() {...}"); }
	;

declarations
	: ( type Identifier ';'
     {
	   if (TRACEON) System.out.println("declarations: " + $Identifier.text);
	 
  	   if (symtab.containsKey($Identifier.text)) {
		   reportError($Identifier.getLine(), "Redeclared identifier.");
	   } else {
		   symtab.put($Identifier.text, $type.attr_type);	   
	   }
	 }
	)*
	;

type returns [int attr_type]
	: INT    { if (TRACEON) System.out.println("type: INT");  $attr_type = 1; }
	| FLOAT { if (TRACEON) System.out.println("type: FLOAT");  $attr_type = 2; }
	;

statements
	:statement statements
	|
    ;

bool_expression returns [int attr_type]
    : a = arith_expression
      ( op = ( EQ | NEQ | GEQ | GT | LEQ | LT ) b = arith_expression
        { if ($a.attr_type != -2 && $b.attr_type != -2 && $a.attr_type != $b.attr_type) {
            reportError($a.start.getLine(), "Type mismatch for the operator " + $op.text + " in an expression.");
              $attr_type = -2;
          } else {
            $attr_type = 3;
          }
        }
      |
        { $attr_type = $a.attr_type; }
      )
    ;

arith_expression returns [int attr_type]
	: a = multExpr { $attr_type = $a.attr_type; }
      ( '+' b = multExpr
	    { if ($a.attr_type != -2 && $b.attr_type != -2
              && $a.attr_type != $b.attr_type) {
              reportError($a.start.getLine(),
                  "Type mismatch for the operator + in an expression.");
              $attr_type = -2;
		  }
        }
	  | '-' c = multExpr
        {
          if ($a.attr_type != -2 && $c.attr_type != -2
              && $a.attr_type != $c.attr_type) {
              reportError($a.start.getLine(),
                  "Type mismatch for the operator - in an expression.");
              $attr_type = -2;
          }
        }
	  )*
	;

multExpr returns [int attr_type]
	: a = signExpr { $attr_type = $a.attr_type; }
      ( '*' b = signExpr
      {
        if ($a.attr_type != -2 && $b.attr_type != -2
              && $a.attr_type != $b.attr_type) {
              reportError($a.start.getLine(),
                  "Type mismatch for the operator * in an expression.");
              $attr_type = -2;
        }
      }
      | '/' b = signExpr
      {
        if ($a.attr_type != -2 && $b.attr_type != -2
            && $a.attr_type != $b.attr_type) {
            reportError($a.start.getLine(),
                "Type mismatch for the operator / in an expression.");
            $attr_type = -2;
        }
      }
      | '%' b = signExpr
      {
        if ($a.attr_type != -2 && $b.attr_type != -2 && $a.attr_type != $b.attr_type) {
            reportError($a.start.getLine(), "Type mismatch for the operator % in an expression.");
            $attr_type = -2;
        }
      }
	  )*
	;

signExpr returns [int attr_type]
	: primaryExpr { $attr_type = $primaryExpr.attr_type; }
	| '-' primaryExpr { $attr_type = $primaryExpr.attr_type; }
	;
		  
primaryExpr returns [int attr_type] 
	: Integer_constant        { $attr_type = 1; }
	| Floating_point_constant { $attr_type = 2; }
	| Identifier
      {
        if (symtab.containsKey($Identifier.text)) {
            $attr_type = symtab.get($Identifier.text);
        } else {
            reportError($Identifier.getLine(), "Undeclared identifier.");
            $attr_type = -2;
        }
      }
	| '(' arith_expression ')' { $attr_type = $arith_expression.attr_type; }
    ;

statement returns [int attr_type]
	: Identifier '=' arith_expression ';'
	 {
       int lhType;
	   if (symtab.containsKey($Identifier.text)) {
	       lhType = symtab.get($Identifier.text);
	   } else {
           reportError($Identifier.getLine(), "Undeclared identifier.");
           lhType = -2;
	   }
		
       int rhType = $arith_expression.attr_type;
	   if (lhType != -2 && lhType != rhType) {
        reportError($arith_expression.start.getLine(), "Type mismatch for the two sides of an assignment.");
        $attr_type = -2;
       } else {
        $attr_type = lhType;
       }
	 }
	| IF '(' bool_expression ')' if_then_statements
      {
        if ($bool_expression.attr_type != 3) {
            reportError($bool_expression.start.getLine(), "Type mismatch for condition.");
        }
        $attr_type = -1;
      }
    | WHILE '(' bool_expression ')' loop_body
      {
        if ($bool_expression.attr_type != 3) {
            reportError($bool_expression.start.getLine(), "Type mismatch for condition.");
        }
        $attr_type = -1;
      }
	;

if_then_statements
	: statement
	| '{' statements '}'
	;

loop_body
    : statement
    | '{' statements '}'
    ;

		   
/* ====== description of the tokens ====== */
EQ: '==';
NEQ: '!=';
GEQ: '>=';
GT: '>';
LEQ: '<=';
LT: '<';

ELSE: 'else';
WHILE: 'while';

FLOAT:'float';
INT:'int';
MAIN: 'main';
VOID: 'void';
IF: 'if';

Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;
Integer_constant:'0'..'9'+;

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

WS      : [ \t\r\n]+  -> skip;
COMMENT : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;