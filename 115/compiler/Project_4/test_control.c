// Test: for, do-while, continue, &&, ||, !, bitwise ops

int main() {
    int i, s, x, y;

    // for loop
    s = 0;
    for (i = 0; i < 5; i++) {
        s = s + i;
    }
    printf("for sum 0..4 = %d\n", s);

    // for loop with continue
    s = 0;
    for (i = 0; i < 10; i++) {
        if (i % 2 == 0) {
            continue;
        }
        s = s + i;
    }
    printf("for odd sum = %d\n", s);

    // do-while
    i = 0;
    s = 0;
    do {
        s = s + i;
        i++;
    } while (i < 5);
    printf("do-while sum 0..4 = %d\n", s);

    // && and ||
    x = 3;
    y = 7;
    if (x > 0 && y > 0) {
        printf("both positive\n");
    }
    if (x > 10 || y > 5) {
        printf("at least one large\n");
    }

    // logical !
    if (!(x == 5)) {
        printf("x is not 5\n");
    }

    // bitwise ops
    x = 12;
    y = 10;
    printf("12 & 10 = %d\n", x & y);
    printf("12 | 10 = %d\n", x | y);
    printf("12 ^ 10 = %d\n", x ^ y);
    printf("12 << 2 = %d\n", x << 2);
    printf("12 >> 1 = %d\n", x >> 1);

    // bitwise NOT
    x = 0;
    printf("~0 = %d\n", ~x);

    return 0;
}
