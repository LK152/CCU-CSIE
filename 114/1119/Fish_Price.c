#include "stdio.h"

int inArray(int x, int* arr, int n) {
    int l = 0;
    int hi = n - 1;

    while (l <= hi) {
        int m = l + (hi - l) / 2;

        if (arr[m] == x)
            return 1;
        else if (arr[m] < x)
            l = m + 1;
        else
            hi = m - 1;
    }

    return 0;
}

int main() {
    int n, t;
    scanf("%d %d", &n, &t);
    int a[n], sum[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
        sum[i] = i ? sum[i - 1] + a[i] : a[i];
    }

    for (int i = 0; i < t; i++) {
        int x;
        scanf("%d", &x);
        printf(inArray(x, sum, n) ? "YES\n" : "NO\n");
    }

    return 0;
}