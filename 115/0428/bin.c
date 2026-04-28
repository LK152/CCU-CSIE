#include "stdio.h"

int main() {
    int t, n, k, a[200001], flg, b[200001], flps;

    scanf("%d", &t);

    while (t--) {
        flg = 0, flps = 0;
        scanf("%d %d", &n, &k);
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
            b[i] = 0;
        }
        b[n] = 0;

        for (int i = 0;i<n;i++) {
            flps += b[i];
            if ((a[i] + flps) % 2) {
                if (i + k > n) {
                    flg = 1;
                    break;
                }
                b[i]++;
                b[i+k]--;
                flps++;
            }
        }

        printf("%s\n", flg ? "NO" : "YES");
    }

    return 0;
}