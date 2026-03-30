// Test Program 3: Structs, pointers, function declarations
typedef struct {
    int x;
    int y;
} Point;

float distance(Point *p1, Point *p2);

float distance(Point *p1, Point *p2) {
    int dx = p1->x - p2->x;
    int dy = p1->y - p2->y;
    return dx * dx + dy * dy;  // simplified (no sqrt)
}

int main() {
    Point a;
    Point b;

    a.x = 0;
    a.y = 0;
    b.x = 3;
    b.y = 4;

    float d = distance(&a, &b);

    // Pointer arithmetic
    int arr[5];
    int *ptr = arr;
    int size = sizeof(arr) / sizeof(int);

    int k;
    for (k = 0; k < size; k++) {
        *(ptr + k) = k * k;
    }

    return 0;
}
