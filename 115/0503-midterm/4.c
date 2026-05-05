#include "stdio.h"

#define M 100000007

long long md(long long a, long long b) {
    return ((a % M) * (b % M)) % M;
}

long long ex(long long a, long long n) {
    if (n == 0) return 1;
    if (n == 1) return a;

    if (n % 2) return md(a, md(ex(a, (n-1)/2), ex(a, (n-1)/2)));

    return md(ex(a, n/2), ex(a, n/2));
}

int main() {
    long long a, n;

    scanf("%lld %lld", &a, &n);

    printf("%lld", ex(a, n));

    return 0;
}