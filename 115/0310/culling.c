#include "stdio.h"

void bt(int st, int n, int k, int arr[15], int idx) {
    if (idx == k) {
        for (int i = 0;i<k;i++) {
            printf("%d", arr[i]);
            if (i+1 < k) printf(" ");
        }
        printf("\n");
        idx = 0;

        return;
    }
    for (int i = st;i<=n;i++) {
        arr[idx] = i;
        bt(i + 1, n, k, arr, idx+1);
    }
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    int arr[15];

    bt(1, n, k, arr, 0);
    return 0;
}