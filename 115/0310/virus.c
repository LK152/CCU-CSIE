#include "stdio.h"

int main() {
    int a, b, N, act = 0, actc = 0, gro = 0, grt = 0;

    scanf("%d %d %d", &a, &b, &N);
    grt = a;
    N--;

    while (N--) {
        actc = act;
        act += gro;
        gro = grt;
        grt = actc * b;
    }

    printf("%d", act);

    return 0;
}