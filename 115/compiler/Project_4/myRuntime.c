#include <stdio.h>
#include <math.h>

/* * Implementation of the custom ## operator: a^b + b^a
 * The LLVM IR expects a signature matching: float @__hashOp(float, float)
 */
float __hashOp(float a, float b) {
    // powf() is the 32-bit float version of pow() from <math.h>
    return powf(a, b) + powf(b, a);
}