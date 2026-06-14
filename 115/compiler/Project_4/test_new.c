// Test: enum, multi-dim array, struct, 1-D array (vector)

enum Direction { NORTH, SOUTH = 10, EAST, WEST };

struct Point {
    int x;
    int y;
};

struct Pair {
    float a;
    float b;
};

int sumArray(int n) {
    int arr[5];
    int i, s;
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 40;
    arr[4] = 50;
    s = 0;
    i = 0;
    while (i < n) {
        s = s + arr[i];
        i++;
    }
    return s;
}

int main() {
    // All declarations first (C89 style)
    int d, k;
    int v[4];
    int mat[2][3];
    struct Point p;
    struct Pair q;

    // --- enum ---
    d = NORTH;
    printf("NORTH=%d SOUTH=%d EAST=%d WEST=%d\n", NORTH, SOUTH, EAST, WEST);

    // --- 1-D array (vector) ---
    v[0] = 100;
    v[1] = 200;
    v[2] = 300;
    v[3] = 400;
    k = v[2];
    printf("v[2]=%d\n", k);

    // --- multi-dim array ---
    mat[0][0] = 1;
    mat[0][1] = 2;
    mat[0][2] = 3;
    mat[1][0] = 4;
    mat[1][1] = 5;
    mat[1][2] = 6;
    printf("mat[1][2]=%d\n", mat[1][2]);

    // --- struct Point ---
    p.x = 7;
    p.y = 13;
    printf("p=(%d,%d)\n", p.x, p.y);

    // --- struct Pair (float fields) ---
    q.a = 3.5;
    q.b = 1.5;
    printf("q=(%.1f,%.1f)\n", q.a, q.b);

    // --- call function using an array ---
    printf("sum(5)=%d\n", sumArray(5));

    return 0;
}
