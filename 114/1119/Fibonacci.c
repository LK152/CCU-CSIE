#include "stdio.h"

void matrixMult(long long a[4], long long b[4], long long arr[4]) {
    arr[0] = (a[0] * b[0]) % 1000000007 + (a[1] * b[2]) % 1000000007;
    arr[1] = (a[0] * b[1]) % 1000000007 + (a[1] * b[3]) % 1000000007;
    arr[2] = (a[2] * b[0]) % 1000000007 + (a[3] * b[2]) % 1000000007;
    arr[3] = (a[2] * b[1]) % 1000000007 + (a[3] * b[3]) % 1000000007;
}

void matrixPow(long long a[4], long long p, long long arr[4]) {
    if (p == 1) {
        arr[0] = a[0] % 1000000007;
        arr[1] = a[1] % 1000000007;
        arr[2] = a[2] % 1000000007;
        arr[3] = a[3] % 1000000007;
        return;
    }

    long long half[4];
    matrixPow(a, p / 2, half);

    long long sq[4];
    matrixMult(half, half, sq);

    if (p % 2 == 0) {
        arr[0] = sq[0] % 1000000007;
        arr[1] = sq[1] % 1000000007;
        arr[2] = sq[2] % 1000000007;
        arr[3] = sq[3] % 1000000007;
    } else {
        matrixMult(a, sq, arr);
    }
}

int main() {
    long long n;
    scanf("%lld", &n);

    long long a[4] = {1, 1, 1, 0};
    long long arr[4];

    if (n == 0) {
        printf("0\n");
        return 0;
    }
    if (n == 1) {
        printf("1\n");
        return 0;
    }

    matrixPow(a, n - 1, arr);
    printf("%lld\n", arr[0] % 1000000007);

    return 0;
}
