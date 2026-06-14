// ==========================================
// Compiler Ultimate Stress Test
// ==========================================
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_VAL 100
#if MAX_VAL > 50 && defined(MAX_VAL)
#define READY 1
#endif

// ==========================================
// 1. Enums, Structs, Unions & Typedefs
// ==========================================
enum Flags {
    FLAG_NONE = 0,
    FLAG_A = 1 << 0,
    FLAG_B = 1 << 1,
    FLAG_C = FLAG_A | FLAG_B
};

typedef unsigned long long ull;
typedef int (*MathFunc)(int, int);

struct ComplexData {
    ull id;
    union {  // Anonymous union
        int i_val;
        float f_val;
    };
    struct {  // Anonymous struct with bit-fields
        unsigned int is_active : 1;
        unsigned int : 3; 
        unsigned int category : 4;
    };
    char* name;
};

// ==========================================
// 2. Function Prototypes
// ==========================================
int isEven(int n);
int isOdd(int n);
int add(int a, int b) {
    return a + b;
}

// ==========================================
// 3. Global Variables
// ==========================================
static const double PI = 3.1415926535;
float global_f1 = 1.5e-2f, global_f2 = 1.; 

// ==========================================
// 4. Main Function
// ==========================================
int main(int argc, char* argv[]) {

    // --- A. Local Variables & Array Initialization ---
    char greeting[] = "Hello, World!\n";

    int matrix[3][3] = {
        {1, 2, 3},
        [2] = {7, 8, 9}  
    };

    int x = 10, y = 20, *p1 = &x, **p2 = &p1;
    bool running = true;

    // --- B. The Custom ## Operator ---
    float hash_res = 2.0f ## 3.0f;

    // --- C. All Operators & Precedence ---
    int calc = (x += 5, y -= 2, x > y ? (x ^ y) : sizeof(struct ComplexData));

    int arr_val = *(*matrix + 1);          
    void* generic_ptr = (void*)(matrix[0] + 2);  

    // --- D. Struct & Union Access ---
    struct ComplexData data = {.id = 0x1FLL};  
    data.i_val = 42;                           
    data.is_active = 1;                        

    struct ComplexData* d_ptr = &data;
    d_ptr->f_val = 3.14f;  

    // --- E. Control Flow ---
    for (int i = 0, j = 10; i < j; ++i, j--) {
        if (i == 5)
            break;  
    }

    int counter = 0;
    do {
        counter++;
        if (counter % 2 == 0)
            continue;
    } while (counter < 5);

    int switch_val = FLAG_A;
    switch (switch_val) {
        case 0:
            x = 0;
            break;
        case 1:  
            x = 1; // Explicit statement added to prevent empty block error
        case 2:
            y = 1;
            break;
        default:
            x = -1;
    }

    if (!running)
        goto error_handler;

    // --- F. Function Pointers & Built-ins ---
    // Direct assignment to avoid array initialization trap
    MathFunc my_func = add;
    int sum = my_func(10, 20);

    // Bypassing malloc using a standard character array
    char local_str[50];
    strcpy(local_str, greeting);
    
    // Fixed standard printf usage
    printf("%s", local_str);
    printf("Sum: %d, Hash: %f\n", sum, hash_res);
    printf("End of test.\n");
    return 0;

error_handler:
    printf("An error occurred.\n");
    return 1;
}

// ==========================================
// 5. Mutually Recursive Implementations
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