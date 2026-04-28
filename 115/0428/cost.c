#include "stdio.h"

int main() {
    int n, i = 0, maxh = 0, maxt = 0, minh = 0, mint = 0, a[100001], maxq[100001], minq[100001];
    long long k, ans = 0;

    scanf("%d %lld", &n, &k);
    for (int i = 0;i<n;i++) {
        scanf("%d", a+i);
    }

    for (int j = 0; j < n; j++) {
        while (maxh < maxt && a[maxq[maxt - 1]] <= a[j])
            maxt--;
        maxq[maxt++] = j;

        while (minh < mint && a[minq[mint - 1]] >= a[j])
            mint--;
        minq[mint++] = j;

        while (i <= j) {
            long long mx = a[maxq[maxh]];
            long long mn = a[minq[minh]];
            long long cost = (mx - mn) * (long long)(j - i + 1);
            if (cost <= k) break;

            i++;
            if (maxq[maxh] < i) maxh++;
            if (minq[minh] < i) minh++;
        }

        ans += (j - i + 1);
    }

    printf("%lld\n", ans);
    return 0;
}