// ==========================================
// 1. Preprocessor & Included Definitions
// ==========================================
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_VAL 100
#define MACRO_FUNC(x) ((x) * 2)
#if MAX_VAL > 50 && defined(MAX_VAL)
#define READY 1
#endif

// ==========================================
// 2. Enums, Structs, Unions & Typedefs
// ==========================================
// Enum with constant folding [cite: 238]
enum Flags {
    FLAG_NONE = 0,
    FLAG_A = 1 << 0,
    FLAG_B = 1 << 1,
    FLAG_C = FLAG_A | FLAG_B
};

// Typedefs (including function pointer) [cite: 98, 99, 105, 108]
typedef unsigned long long ull;
typedef int (*MathFunc)(int, int);

// Complex Struct with anonymous union, anonymous struct, and bit-fields [cite: 77, 81, 87, 90]
struct ComplexData {
    ull id;
    union {  // Anonymous union
        int i_val;
        float f_val;
    };
    struct {  // Anonymous struct with bit-fields
        unsigned int is_active : 1;
        unsigned int : 3;  // Unnamed padding
        unsigned int category : 4;
    };
    char* name;
};

// ==========================================
// 3. Function Prototypes
// ==========================================
// Mutually recursive prototypes [cite: 241]
int isEven(int n);
int isOdd(int n);
int add(int a, int b) {
    return a + b;
}

// ==========================================
// 4. Global Variables (Static & Const)
// ==========================================
// Multiple declarations, pointers, and initializers [cite: 111, 112, 114, 240]
static const double PI = 3.1415926535;
float global_f1 = 1.5e-2f, global_f2 = 1.;  // Scientific and suffix [cite: 209, 210]
MathFunc default_math = add;                // Function pointer initialization [cite: 105, 108, 241]

// ==========================================
// 5. Main Function
// ==========================================
int main(int argc, char* argv[]) {  // main with parameters [cite: 241]

    // --- A. Local Variables & Array Initialization ---
    // String initialization & concatenation [cite: 212, 240]
    char greeting[] =
        "Hello"
        ", "
        "World!\n";

    // Multi-dimensional array & designated initializers [cite: 239]
    int matrix[3][3] = {
        {1, 2, 3},
        [2] = {7, 8, 9}  // Designated initializer
    };

    // Multiple declarations with mixed pointer types
    int x = 10, y = 20, *p1 = &x, **p2 = &p1;

    // Pre-defined macros [cite: 213]
    bool running = true;
    void* generic_ptr = NULL;

    // --- B. The Custom ## Operator ---
    // a^b + b^a (Operands and result must be float)
    float hash_res = 2.0f##3.0f;

    // --- C. All Operators & Precedence ---
    // Comma operator, ternary, bitwise, logical, arithmetic, and sizeof [cite: 187, 230]
    int calc = (x += 5, y -= 2, x > y ? (x ^ y & ~FLAG_A) : sizeof(struct ComplexData));

    // Prefix/Postfix and pointer arithmetic [cite: 234]
    int arr_val = *(*matrix + 1);          // Dereferences matrix[0][1]
    generic_ptr = (void*)(matrix[0] + 2);  // Pointer cast and arithmetic [cite: 230, 234]

    // --- D. Struct & Union Access ---
    struct ComplexData data = {.id = 0x1FLL};  // Hex literal with suffix [cite: 208]
    data.i_val = 42;                           // Access anonymous union [cite: 236]
    data.is_active = 1;                        // Access anonymous struct bit-field [cite: 236]

    struct ComplexData* d_ptr = &data;
    d_ptr->f_val = 3.14f;  // Pointer arrow access [cite: 162]

    // --- E. Control Flow ---
    // 1. For loop with inner declaration and multiple expressions [cite: 146, 241]
    for (int i = 0, j = 10; i < j; ++i, j--) {
        if (i == 5)
            break;  // Jump stmt [cite: 154]
    }

    // 2. Do-while & continue [cite: 147]
    int counter = 0;
    do {
        counter++;
        if (counter % 2 == 0)
            continue;
    } while (counter < 5);

    // 3. Switch with C-style fall-through [cite: 241]
    int switch_val = FLAG_A;
    switch (switch_val) {
        case FLAG_NONE:
            x = 0;
            break;
        case FLAG_A:  // Falls through
        case FLAG_B:
            x = 1;
            // No break implies fall-through
        default:
            x = -1;
    }

    // 4. Goto and Labels [cite: 121, 154]
    if (!running)
        goto error_handler;

    // --- F. Function Pointers & Built-ins ---
    // Function pointer array call [cite: 171]
    MathFunc funcs[1] = {add};
    int sum = funcs[0](10, 20);

    // Built-in functions [cite: 241, 242]
    char* dyn_str = (char*)malloc(50 * sizeof(char));
    if (dyn_str != NULL) {
        strcpy(dyn_str, greeting);
        printf("%s Sum: %d, Hash: %f\n", dyn_str, sum, hash_res);
        free(dyn_str);
    }

    // Standard stream usage (implicitly passed to fprintf) [cite: 214]
    fprintf(stdout, "End of test.\n");
    return 0;

error_handler:
    fprintf(stderr, "An error occurred.\n");
    return 1;
}

// ==========================================
// 6. Mutually Recursive Implementations
// ==========================================
int isEven(int n) {
    if (n == 0)
        return 1;
    return isOdd(abs(n) - 1);
}

int isOdd(int n) {
    if (n == 0)
        return 0;
    return isEven(abs(n) - 1);
}