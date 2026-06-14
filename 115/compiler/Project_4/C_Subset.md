# C Subset Definition

## 1. Overview

This document defines the subset of C supported by the compiler developed in Project 4. The language is a structured, statically-typed subset of C targeting LLVM IR as output.

---

## 2. Lexical Elements

### 2.1 Keywords

```
int   float   void
if    else    while   return
```

### 2.2 Identifiers

A sequence of letters (`a–z`, `A–Z`), digits (`0–9`), and underscores (`_`), starting with a letter or underscore.

```
Identifier ::= [a-zA-Z_][a-zA-Z0-9_]*
```

### 2.3 Integer Constants

```
Integer_constant ::= [0-9]+
```

### 2.4 Floating-Point Constants

```
Floating_point_constant ::= [0-9]+ '.' [0-9]+
```

### 2.5 String Literals

```
STRING_LITERAL ::= '"' ( EscapeSequence | any char except '\' and '"' )* '"'
EscapeSequence ::= '\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\'' | '"' | '\\' )
```

### 2.6 Operators

```
Arithmetic:   +  -  *  /  %  ##
Assignment:   =  +=  -=  *=  /=  %=
Increment:    ++  --
Comparison:   >  >=  <  <=  ==  !=
```

### 2.7 Comments

```
/* block comment */
// line comment
```

### 2.8 Whitespace

Spaces, tabs, and newlines are ignored.

---

## 3. Data Types

| Type    | Description                          | LLVM IR type |
|---------|--------------------------------------|--------------|
| `int`   | 32-bit signed integer                | `i32`        |
| `float` | 32-bit IEEE 754 floating-point       | `float`      |
| `void`  | No value; used as function return type only | `void` |

---

## 4. Program Structure

A program consists of one or more function definitions. There is no global variable support. Execution starts at `main`.

```
program ::= function_definition+
```

### 4.1 Function Definition

```
function_definition ::= type identifier '(' parameter_list ')' '{' declarations statements '}'
parameter_list      ::= ( type identifier ( ',' type identifier )* )?
```

**Constraints:**
- The return type may be `int`, `float`, or `void`.
- Parameters may be of type `int` or `float`.
- Function bodies begin with all local variable declarations, followed by statements.
- A function's signature is registered before its body is parsed, so forward calls within the same file are supported provided the callee is defined before the caller in source order. Mutual recursion is not supported.

---

## 5. Declarations

All local variables must be declared at the top of the function body, before any statements.

```
declarations ::= type identifier ( ',' identifier )* ';' declarations
               | ε
```

**Example:**
```c
int a, b, c;
float x, y;
```

**Constraints:**
- Declaring the same identifier twice within the same function is a type error.
- Variables are allocated on the stack (`alloca`); they are not initialised by default.

---

## 6. Statements

```
statement ::= assignment_stmt ';'
            | inc_dec_stmt ';'
            | if_stmt
            | while_stmt
            | return_stmt ';'
            | function_call_stmt ';'
            | block_stmt

block_stmt ::= '{' statements '}'
```

### 6.1 Assignment Statement

```
assignment_stmt ::= identifier op expression
op              ::= '=' | '+=' | '-=' | '*=' | '/=' | '%='
```

- The left-hand side must be a previously declared variable.
- Compound operators (`+=`, `-=`, etc.) load the current value, apply the operation, and store the result.
- If the right-hand side type differs from the variable type, implicit conversion is applied (see Section 8).

### 6.2 Increment / Decrement Statement

```
inc_dec_stmt ::= identifier '++' | identifier '--'
               | '++' identifier | '--' identifier
```

Supports both prefix and postfix forms. When used as a statement, both forms behave identically (increment or decrement by 1 and store).

### 6.3 if Statement

```
if_stmt ::= 'if' '(' condition ')' block_stmt ( 'else' block_stmt )?
```

- The condition is any arithmetic expression (compared `!= 0`) or a relational expression.
- Both the then-branch and the optional else-branch must use braces `{ }`.
- if-else statements may be nested to any depth.

### 6.4 while Statement

```
while_stmt ::= 'while' '(' condition ')' block_stmt
```

- The condition is re-evaluated before each iteration.
- The body must use braces `{ }`.
- while loops may be nested, and may contain if statements.

### 6.5 return Statement

```
return_stmt ::= 'return' expression
              | 'return'
```

- `return expression` is used for `int` and `float` functions. The expression is coerced to the function's declared return type.
- `return` (no value) is used for `void` functions.
- `main` always returns `i32`; a plain `return 0;` is sufficient.

### 6.6 Function Call Statement

```
function_call_stmt ::= identifier '(' argument_list ')'
argument_list      ::= ( argument ( ',' argument )* )?
argument           ::= expression | STRING_LITERAL | '&' identifier
```

Used for `printf`, `scanf`, and void (or ignored-return) user-defined calls.

---

## 7. Expressions

### 7.1 Precedence (high to low)

| Level | Operators | Associativity |
|-------|-----------|---------------|
| 1 (highest) | Unary `-`, type cast `(type)` | Right |
| 2 | `*`  `/`  `%`  `##` | Left |
| 3 | `+`  `-` | Left |
| 4 (lowest) | `>`  `>=`  `<`  `<=`  `==`  `!=` | Left (non-associative) |

### 7.2 Primary Expressions

```
primary ::= Integer_constant
           | Floating_point_constant
           | identifier
           | identifier '(' argument_list ')'   // value-returning function call
           | '(' expression ')'
```

- Reading an undeclared identifier is a type error.
- A function call in expression position uses the function's declared return type.

### 7.3 Unary Minus

```
unary_expr ::= '-' unary_expr | primary
```

Negates an `int` or `float` value. Applies to the operand recursively, so `--x` double-negates.

### 7.4 Type Cast

```
cast_expr ::= '(' type ')' cast_expr | unary_expr
```

Explicitly converts the operand to `int` or `float` (see Section 8.2).

### 7.5 The `##` Operator

```
a ## b
```

Defined as **a^b + b^a**, where both operands are coerced to `float`. The result type is always `float`. Precedence equals `*` and `/`. Implemented via the runtime function `__hashOp`.

### 7.6 Condition Expression

```
condition ::= expression relop expression
            | expression                 // truthy if != 0
relop      ::= '>' | '>=' | '<' | '<=' | '==' | '!='
```

Only a single comparison per condition is supported. Logical AND (`&&`) and OR (`||`) are not supported.

---

## 8. Type System

### 8.1 Implicit Type Conversion

Conversions happen automatically in mixed-type expressions and assignments.

| Situation | Behaviour |
|-----------|-----------|
| `int op float` or `float op int` | The `int` operand is promoted to `float`; result is `float` |
| Assign `float` → `int` variable | Truncation towards zero (`fptosi`) |
| Assign `int` → `float` variable | Exact conversion (`sitofp`) |
| Pass `int` where `float` expected (function arg) | Promoted to `float` |
| `float` argument to `printf` | Promoted to `double` (C default argument promotion) |

### 8.2 Explicit Type Cast

```c
(int)   expr    // truncates float to int, or is a no-op for int
(float) expr    // converts int to float, or is a no-op for float
```

### 8.3 Type Errors

The following conditions terminate compilation with an error message and line number:

- Reading or writing an **undeclared identifier**
- **Re-declaring** an identifier already declared in the same function

---

## 9. Built-in Functions

### 9.1 `printf`

```c
printf(STRING_LITERAL, arg1, arg2, ...)
```

Supported format specifiers: `%d` (int), `%f` (float/double), `%s` (string literal embedded directly). `float` arguments are promoted to `double` per C convention.

### 9.2 `scanf`

```c
scanf(STRING_LITERAL, &var1, &var2, ...)
```

Supported format specifiers: `%d` (reads into `int`), `%f` (reads into `float`). Arguments must be address-of expressions (`&identifier`).

---

## 10. Scoping Rules

- All variables are **function-scoped** (no block scoping, no global variables).
- A variable declared in a function is visible for the entire function body after its declaration.
- Function names are globally visible throughout the file.

---

## 11. Example Programs

### Minimal program

```c
int main() {
    printf("Hello, World!\n");
    return 0;
}
```

### Function with parameters

```c
int add(int a, int b) {
    return a + b;
}

int main() {
    int result;
    result = add(3, 4);
    printf("3 + 4 = %d\n", result);
    return 0;
}
```

### Mixed types and while loop

```c
float average(int a, int b) {
    float sum;
    sum = a + b;
    return sum / 2;
}

int main() {
    int i, n;
    float acc;
    acc = 0.0;
    n = 5;
    i = 1;
    while (i <= n) {
        acc = acc + i;
        i++;
    }
    printf("Sum 1..%d = %f\n", n, acc);
    printf("Average = %f\n", average(1, n));
    return 0;
}
```

---

## 12. Features NOT Supported

The following standard C features are outside the scope of this compiler:

- Global variables
- Arrays and pointers (except `&var` in `scanf`)
- `char` type and character literals
- `for` and `do-while` loops
- `break` and `continue`
- Logical operators (`&&`, `||`, `!`)
- Ternary operator (`? :`)
- Structs, unions, enums
- `#include` and preprocessor directives
- Standard library functions other than `printf` and `scanf`
- Forward declarations / function prototypes
- Mutual recursion between functions
