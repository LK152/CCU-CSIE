#include <stdio.h>
#include <math.h>

float __hashOp(float a, float b) {
    return powf(a, b) + powf(b, a);
}

// Provide 'stdout', 'stderr', 'stdin' as linkable global pointer symbols.
// On macOS these are macros; expose them via actual symbols our IR can link to.
FILE** _get_stdout_ptr(void) { return &stdout; }
FILE** _get_stderr_ptr(void) { return &stderr; }
FILE** _get_stdin_ptr (void) { return &stdin;  }