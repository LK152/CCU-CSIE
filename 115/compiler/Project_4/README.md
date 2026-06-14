# Project 4 — Small C Compiler for LLVM IR

## Overview

This is a prototype C compiler that translates a subset of C into LLVM IR. It is built with **ANTLR4** (grammar file `myCompiler.g4`) and implemented in **Java**. The generated LLVM IR can be compiled to a native executable using `clang`.

---

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

This runs ANTLR4 to generate the lexer/parser from `myCompiler.g4`, then compiles all `.java` files.

### Step 2 — Compile a C source file to LLVM IR

```bash
java -cp .:antlr-4.13.2-complete.jar myCompiler_test <input>.c > <output>.ll
```

### Step 3 — Link and execute

```bash
clang <output>.ll myRuntime.c -o <program> -lm
./<program>
```

### Using the Makefile shortcut

```bash
make run TEST=test
```

This builds, compiles `test.c` to `test.ll`, links with `myRuntime.c`, and runs the result.

---

## Supported C Subset

### Basic Requirements

| Feature | Description |
|---------|-------------|
| **Data types** | `int`, `float`, `void` |
| **Arithmetic** | `+`, `-`, `*`, `/`, `%` |
| **Comparison** | `>`, `>=`, `<`, `<=`, `==`, `!=` |
| **if / if-else** | Both with mandatory braces `{ }` |
| **printf** | Format strings with `%d`, `%f`; any number of arguments |
| **scanf** | Format strings with `%d`, `%f`; address arguments `&var` |
| **`##` operator** | `a ## b` = a^b + b^a (both operands coerced to float; same precedence as `*`/`/`) |

### Extended Features

| Feature | Description |
|---------|-------------|
| **Implicit type conversion** | `int op float` promotes the int to float; assigning float to int truncates |
| **Explicit type casting** | `(int)expr`, `(float)expr` |
| **Unary minus** | `-expr` for both int and float |
| **Compound assignment** | `+=`, `-=`, `*=`, `/=`, `%=` |
| **Increment / decrement** | `++` and `--`, both prefix and postfix |
| **While loop** | `while (cond) { ... }` |
| **Nested while** | While loops inside while loops |
| **While + if** | if/else inside while, while inside if |
| **Nested if** | if/else inside another if/else |
| **Multiple functions** | User-defined functions with any number of int/float parameters |
| **Function call** | Value-returning calls usable in expressions; void calls as statements |
| **Recursion** | Functions can call themselves |
| **Type error detection** | Undeclared and redeclared identifier errors with line numbers |

---

## Code Optimizations

The compiler performs several optimizations during code generation (no separate optimization pass needed).

### 1. Constant Folding

Arithmetic expressions whose operands are both compile-time constants are evaluated at compile time — no instruction is emitted.

```c
a = 2 + 3;      // emits: store i32 5
x = 1.5 * 2.0;  // emits: store float <hex for 3.0>
y = 2.0 ## 3.0; // emits: store float <hex for 17.0>  (folded at compile time)
```

Works for `+`, `-`, `*`, `/`, `%`, unary minus, `##`, type conversions, and comparisons.

### 2. Algebraic Identity Simplifications

Trivially redundant operations are eliminated without emitting instructions:

| Expression | Simplified to |
|------------|---------------|
| `x + 0`, `x - 0` | `x` |
| `x * 1`, `x / 1` | `x` |
| `x * 0` | `0` |

These apply to both `int` and `float`, with correct type promotion.

### 3. Constant Propagation

When a variable is assigned a constant, the compiler tracks that fact and substitutes the constant for subsequent reads of that variable — eliminating `load` instructions entirely.

```c
a = 10;          // constSlot[a] = 10
b = a + 5;       // reads 10 from constSlot → folds to 15, no load emitted
c = b * 2;       // reads 15 from constSlot → folds to 30, no load emitted
```

The propagation table is conservatively invalidated at all control-flow merge points (after `if`/`else`, at loop condition labels, after `while`), and at `scanf` calls that write through `&var` pointers.

### 4. Constant Type Conversion

Coercions between `int` and `float` constants are resolved at compile time without emitting `sitofp` or `fptosi` instructions.

```c
float x = 5;      // emits: store float 0x4014000000000000 (no sitofp)
int   n = 2.9;    // emits: store i32 2  (no fptosi)
```

---

## Test Programs

### test.c — Comprehensive stress test

Exercises all basic and extended features together:
- Multiple user-defined functions (`computeGCD`, `printGreeting`)
- `scanf`/`printf` with `%d` and `%f`
- Implicit and explicit type conversion
- `##` operator
- Nested `if`/`else`
- `while` loop containing an `if`
- `--` decrement as a statement
- Function call result passed to printf

**Run:** `make run TEST=test`

---

### test_types.c — Type system and custom operator

Focuses on type features:
- Implicit `int` → `float` conversion via assignment
- Truncation when assigning `float` → `int`
- Explicit `(float)` cast
- Float arithmetic across function calls
- `##` operator with float operands
- `while` loop with compound decrement (`exp -= 1`)

**Run:** `make run TEST=test_types`

---

### test_control.c — Control flow and recursion

Exercises control flow and multiple functions:
- `fibonacci(n)` — iterative, uses `while` + `++`
- `isPrime(n)` — uses nested `while` + `if`, `%` operator
- `main` calls both in separate `while` loops
- Demonstrates nested while and while+if combinations

**Run:** `make run TEST=test_control`

---

## Runtime Library (`myRuntime.c`)

Implements the `##` operator:

```c
float __hashOp(float a, float b) {
    return powf(a, b) + powf(b, a);
}
```

This function is declared in the generated IR as `declare float @__hashOp(float, float)` and linked at the `clang` step.

---

## File Structure

```
myCompiler.g4          — ANTLR4 grammar (lexer + parser + code generator)
myCompiler_test.java   — Driver: reads .c file, runs parser, prints LLVM IR
myRuntime.c            — Runtime library (implements ## operator)
Makefile               — Build and run targets
test.c / test.ll       — Stress test + generated IR
test_types.c / .ll     — Type system test + generated IR
test_control.c / .ll   — Control flow test + generated IR
antlr-4.13.2-complete.jar
```
