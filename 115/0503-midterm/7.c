#include "stdio.h"

int main() {
    long long x, y, a, b, vx, vy, kx = 0, ky = 0;

    scanf("%lld %lld", &x, &y);
    scanf("%lld %lld", &a, &b);
    scanf("%lld %lld", &vx, &vy);

    if (a == x && b == y) {
        printf("Love Forever");

        return 0;
    }

    if ((!vx && a != x) || (!vy && b != y)) {
        printf("Single Forever");

        return 0;
    }

    kx = (a == x) ? (b-y)/vy : (a-x)/vx;
    ky = (b == y) ? (a-x)/vx : (b-y)/vy;

    if (kx != ky || kx < 0 || ky < 0) printf("Single Forever");
    else printf("Love Forever");

    return 0;
}