# Project 4 — C Subset Compiler for LLVM IR

## Requirements

| Tool | Version |
|------|---------|
| Java (JDK) | 8 or later |
| ANTLR4 | 4.13.2 (included as `antlr-4.13.2-complete.jar`) |
| clang | Any modern version |

---

## How to Compile and Run

### Step 1 — Build the compiler

```bash
make build
```

Runs ANTLR4 to generate the lexer/parser from `myCompiler.g4`, then compiles all `.java` files.

### Step 2 — Compile a C source file to LLVM IR

```bash
java -cp .:antlr-4.13.2-complete.jar myCompiler_test <input>.c > <output>.ll
```

### Step 3 — Link and execute

```bash
clang <output>.ll myRuntime.c -o <program> -lm
./<program>
```

### Makefile shortcuts

```bash
make run TEST=test        # build, compile test.c → test.ll, link, and run
make gen-ll TEST=test     # compile test.c → test.ll only (no link/run)
make run-all              # build, compile, link, and run all test files
make gen-ll-all           # compile all test files to .ll only (no link/run)
```

---

## Supported C Subset

### Types

| Type | LLVM | Notes |
|------|------|-------|
| `int` | `i32` | |
| `float` | `float` | |
| `double` | `double` | |
| `void` | `void` | return type only |
| `char` | `i8` | |
| `bool` | `i1` | `true`/`false` literals supported |
| `long long`, `unsigned long long` | `i64` | |
| `unsigned`, `long`, `short`, etc. | `i32` | mapped to int |
| Pointer `T*` | `ptr` | any depth |
| Array `T[N]`, `T[N][M]` | `[N x T]` | stack-allocated |
| `struct`, `union` | `%struct.Name` | named fields, anonymous blocks |
| `typedef` | — | scalar and function-pointer aliases |

### Statements

| Statement | Notes |
|-----------|-------|
| Assignment `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `\|=`, `^=`, `<<=`, `>>=` | scalars, array elements, struct fields, pointer-to-struct fields, `*ptr` |
| `++` / `--` | prefix and postfix forms |
| `if` / `if-else` | arbitrary nesting, bare body or braced |
| `while` | `break` and `continue` supported |
| `for` | C99 init declaration, multiple update expressions, `break` / `continue` |
| `do`-`while` | `break` and `continue` supported |
| `switch` / `case` / `default` | integer/char/enum case values, C fall-through, `break` |
| `return` | coerces to declared return type |
| `break` / `continue` | target nearest enclosing loop or switch |
| `goto` / label | forward and backward jumps within a function |
| Function call | value-returning (in expression) or void (as statement) |

### Expressions

| Feature | Notes |
|---------|-------|
| Arithmetic `+`, `-`, `*`, `/`, `%` | `int`, `float`, `double`; implicit promotion |
| Bitwise `&`, `\|`, `^`, `~`, `<<`, `>>` | integer operands only |
| Logical `&&`, `\|\|`, `!` | short-circuit emitted as `and i1` / `or i1` |
| Comparison `>`, `>=`, `<`, `<=`, `==`, `!=` | all scalar types |
| Ternary `? :` | result type is wider branch |
| Comma operator `(a, b, c)` | inside parentheses only |
| Unary `-`, `+` | negation / no-op |
| Address-of `&id` | yields stack-slot address |
| Dereference `*expr` | loads through pointer |
| `##` operator | `a ## b` = a^b + b^a (float result) |
| Type cast `(T)` | scalar casts and pointer casts |
| `sizeof(T)` | compile-time constant |
| `sizeof(struct S)` | sum of field sizes |
| Array element `a[i]`, `a[i][j]` | read and write |
| Struct member `.field`, `->field` | read and write |
| Function-pointer call `arr[i](args)` | via pointer array element |
| `NULL`, `true`, `false` | integer / bool literals |
| Hex literals `0xFF` | `int` |
| Char literals `'A'`, `'\n'` | `int` |
| Float suffix `1.5f` | `float` literal |
| String literal adjacent concat `"a" "b"` | produces single string global |

### Top-Level Declarations

| Feature | Notes |
|---------|-------|
| Global variables | scalar and array; zero-initialised in IR |
| `enum` | hex values, expression values, optional implicit counter |
| `struct` | named fields, pointer fields, bit-fields (width ignored), anonymous union/struct blocks |
| `union` | treated as struct |
| `typedef` | scalar alias, function-pointer alias |
| Function prototype | for mutual recursion |
| `#include`, `#define`, `#if`, … | silently skipped by lexer |

---

## Code Optimizations

All optimisations happen during code generation with no separate pass.

### 1. Constant Folding

Arithmetic, bitwise, comparison, and conversion operations on compile-time constants are evaluated at compile time — no instruction is emitted.

```c
a = 2 + 3;          // store i32 5
x = 1.5 * 2.0;      // store double <hex for 3.0>
y = 2.0 ## 3.0;     // store float <hex for 17.0>
z = 0xFF & 0x0F;    // store i32 15
```

### 2. Algebraic Identity Simplifications

Trivially redundant operations are eliminated:

| Expression | Result |
|------------|--------|
| `x + 0`, `x - 0` | `x` |
| `x * 1`, `x / 1` | `x` |
| `x * 0` | `0` |

### 3. Constant Propagation

A variable assigned a constant is tracked; subsequent reads use the constant directly (no `load` emitted). The table is conservatively cleared at every control-flow merge point and at `scanf` calls.

```c
a = 10;       // constSlot[a] = 10
b = a + 5;    // → b = 15, no load
c = b * 2;    // → c = 30, no load
```

### 4. Constant Type Conversion

Coercions between `int`, `float`, and `double` constants are resolved at compile time:

```c
float x = 5;    // store float 0x4014000000000000  (no sitofp instruction)
int   n = 2.9;  // store i32 2  (no fptosi instruction)
```

---

## Test Programs

### `test.c` — Comprehensive stress test

Exercises all basic and extended features together: multiple user-defined functions, `scanf`/`printf`, implicit and explicit type conversion, `##` operator, nested `if`/`else`, `while` loop, compound operators.

**Run:** `make run TEST=test`

---

### `test_types.c` — Extended type features

Hex literals, char literals, `NULL`/`true`/`false`, `double` arithmetic, `sizeof`, ternary operator, bitwise compound assignments (`&=`, `|=`, `^=`, `<<=`, `>>=`), `goto`, global variables.

**Run:** `make run TEST=test_types`

---

### `test_control.c` — Control flow and operators

`for` loop, `for` with `continue`, `do`-`while`, `&&` and `||`, logical `!`, bitwise operators (`&`, `|`, `^`, `<<`, `>>`), bitwise NOT `~`.

**Run:** `make run TEST=test_control`

---

### `test_switch.c` — Switch statement

Basic integer `switch`, `switch` on enum value, `case` fall-through via absent `break`, `break` inside `while` loop, switch with no `default`.

**Run:** `make run TEST=test_switch`

---

### `test_new.c` — Arrays and structs

`enum` with explicit and implicit values, 1-D array, 2-D array, `struct` with `int` fields, `struct` with `float` fields, function taking an array, member reads/writes.

**Run:** `make run TEST=test_new`

---

### `test_extra.c` — Typedefs, global arrays, compound ops

`typedef` for `int` and `float`, `enum` with hex initialisers, adjacent string literal concatenation, global array read/write, compound assignment on array elements and struct fields, `double` constant folding.

**Run:** `make run TEST=test_extra`

---

### `test_str.c` — Char arrays and strings

`char` array declaration, string-literal assignment via `strcpy`, `scanf %s` into a char array, `printf %s`.

**Run:** `make run TEST=test_str`

---

### `testAll.c` — Full-feature integration test

Combines `#include` directives (skipped), `#define` macros (skipped), complex `struct`/`union`/`typedef`/`enum` declarations, function prototypes for mutual recursion, global variables, pointer arithmetic, designated initialisers, anonymous union/struct, bit-fields, `for` with inner declarations, `do`-`while`, `switch` fall-through, `goto`, function pointer array, `malloc`/`strcpy`/`free`, and mutually recursive functions `isEven`/`isOdd`.

**Run:** `make run TEST=testAll`

---

## Runtime Library (`myRuntime.c`)

Implements the `##` operator and exposes standard stream symbols:

```c
float __hashOp(float a, float b) {
    return powf(a, b) + powf(b, a);
}

FILE** _get_stdout_ptr(void) { return &stdout; }
FILE** _get_stderr_ptr(void) { return &stderr; }
FILE** _get_stdin_ptr (void) { return &stdin;  }
```

`__hashOp` is declared in the generated IR as `declare float @__hashOp(float, float)` and linked at the `clang` step.

---

## File Structure

```
myCompiler.g4              — ANTLR4 grammar (lexer + parser + code generator)
myCompiler_test.java       — Driver: reads .c file, runs parser, prints LLVM IR
myRuntime.c                — Runtime library (__hashOp + stream pointer helpers)
Makefile                   — Build and run targets
antlr-4.13.2-complete.jar  — ANTLR4 runtime (required)

test.c / test.ll           — Comprehensive stress test
test_types.c / test_types.ll   — Extended type features
test_control.c / test_control.ll — Control flow and operators
test_switch.c / test_switch.ll  — Switch/case with enum values and fall-through
test_new.c / test_new.ll       — Arrays, multi-dim arrays, structs
test_extra.c / test_extra.ll   — Typedefs, global arrays, compound ops
test_str.c / test_str.ll       — Char arrays and string operations
testAll.c / testAll.ll         — Full-feature integration test
```
