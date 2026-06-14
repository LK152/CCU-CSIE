// Test: enum hex, string concat, typedef, global array, compound assign on array/struct

typedef int MyInt;
typedef float MyFloat;

enum Flags { A = 0x01, B = 0x02, C = 0x10 };

struct Vec {
    int x;
    int y;
};

int global_arr[3];

int main() {
    // All declarations first (C89 style)
    MyInt   a;
    MyFloat f;
    struct Vec v;
    double d;

    // --- typedef types ---
    a = 42;
    f = 1.5;
    printf("typedef int=%d float=%.1f\n", a, f);

    // --- enum hex initializers ---
    printf("A=0x%x B=0x%x C=0x%x\n", A, B, C);

    // --- string concatenation ---
    printf("hello" " " "world\n");

    // --- global array ---
    global_arr[0] = 10;
    global_arr[1] = 20;
    global_arr[2] = 30;
    printf("global arr: %d %d %d\n", global_arr[0], global_arr[1], global_arr[2]);

    // --- compound assign on array element ---
    global_arr[0] += 5;
    global_arr[1] *= 2;
    global_arr[2] -= 10;
    printf("after ops:  %d %d %d\n", global_arr[0], global_arr[1], global_arr[2]);

    // --- compound assign on struct field ---
    v.x = 10;
    v.y = 20;
    v.x += 5;
    v.y *= 3;
    printf("vec: %d %d\n", v.x, v.y);

    // --- double constant folding ---
    d = 1.5 + 2.5;
    printf("1.5+2.5=%.1f\n", d);
    d = 3.0 * 4.0;
    printf("3.0*4.0=%.1f\n", d);

    return 0;
}
