#include "stdio.h"

int min(int a, int b) {
    return a < b ? a : b;
}

void genArr(int* a, int* b, int n, int idx) {
    b[idx] = a[idx];

    if (idx > 0)
        for (int i = idx - 1; i >= 0; i--)
            b[i] = min(a[i], b[i + 1]);

    if (idx < n - 1)
        for (int i = idx + 1; i < n; i++)
            b[i] = min(a[i], b[i - 1]);
}

long long sum(int* a, int n) {
    long long s = 0;
    for (int i = 0; i < n; i++)
        s += a[i];

    return s;
}

int main() {
    int n;
    scanf("%d", &n);

    int a[n], best[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    long long max = -1;

    for (int i = 0; i < n; i++) {
        int b[n];
        genArr(a, b, n, i);
        long long s = sum(b, n);
        if (s > max) {
            max = s;
            for (int j = 0; j < n; j++)
                best[j] = b[j];
        }
    }

    printf("%lld\n", max);
    for (int i = 0; i < n; i++) {
        printf("%d%c", best[i], i != n - 1 ? ' ' : '\n');
    }

    return 0;
}