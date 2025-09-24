#include "stdio.h"

#define phi 1.618

int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    float c = a*a + b*b;
    printf("%d", (int)(c/phi));

    return 0;
}