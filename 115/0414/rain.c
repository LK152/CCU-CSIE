#include "stdio.h"

int main() {
    int n, q, arr[100001] = {0}, l, r;
    scanf("%d %d", &n, &q);
    for (int i = 0;i<n;i++) {
        int x;
        scanf("%d", &x);
        arr[i] = i == 0 ? x : x + arr[i-1];
    }

    while (q--) {
        scanf("%d %d", &l, &r);

        printf("%d\n", l > 1 ? arr[r-1] - arr[l-2] : arr[r-1]);
    }


    return 0;
}