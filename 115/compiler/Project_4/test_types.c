// Test: new literals, ternary, double, sizeof, goto, compound assigns

int g_counter;
int g_max;

int main() {
    int a, b, c, x;
    double d;

    // --- hex literals ---
    a = 0xFF;
    b = 0x0A;
    printf("0xFF = %d\n", a);
    printf("0x0A = %d\n", b);

    // --- char literals ---
    c = 'A';
    printf("'A' = %d\n", c);

    // --- NULL, true, false ---
    a = 0;
    if (a == NULL) {
        printf("a is NULL\n");
    }
    b = true;
    printf("true  = %d\n", b);
    b = false;
    printf("false = %d\n", b);

    // --- double arithmetic ---
    d = 3.14;
    printf("pi ~ %.4f\n", d);
    d = d * 2.0;
    printf("2pi ~ %.4f\n", d);

    // --- sizeof ---
    printf("sizeof int    = %d\n", sizeof(int));
    printf("sizeof double = %d\n", sizeof(double));
    printf("sizeof char   = %d\n", sizeof(char));

    // --- ternary ---
    a = 7;
    b = (a > 5) ? 100 : 200;
    printf("ternary: %d\n", b);
    b = (a < 0) ? -1 : 1;
    printf("ternary2: %d\n", b);

    // --- compound assignments ---
    x = 0xFF;
    x &= 0x0F;
    printf("0xFF &= 0x0F = %d\n", x);
    x = 0x0F;
    x |= 0xF0;
    printf("0x0F |= 0xF0 = %d\n", x);
    x = 0xFF;
    x ^= 0x0F;
    printf("0xFF ^= 0x0F = %d\n", x);
    x = 1;
    x <<= 4;
    printf("1 <<= 4 = %d\n", x);
    x = 256;
    x >>= 3;
    printf("256 >>= 3 = %d\n", x);

    // --- goto ---
    a = 0;
    loop:
    if (a < 3) {
        a++;
        goto loop;
    }
    printf("goto loop count: %d\n", a);

    // --- global variables ---
    g_counter = 5;
    g_max = 10;
    printf("globals: %d %d\n", g_counter, g_max);

    return 0;
}
