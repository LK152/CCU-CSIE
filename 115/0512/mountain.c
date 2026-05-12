#include "stdio.h"
#include "stdlib.h"

typedef long long ll;

void computeLeft(ll* a, int n, ll* SL) {
    ll* sv = malloc(n * sizeof(ll));
    ll* sc = malloc(n * sizeof(ll));
    int sp = -1;
    ll cur = 0;
    SL[0] = 0;
    for (int p = 1; p < n; p++) {
        cur += a[p - 1];
        if (sp >= 0 && sv[sp] == a[p - 1])
            sc[sp]++;
        else {
            sv[++sp] = a[p - 1];
            sc[sp] = 1;
        }

        ll extra = 0;
        while (sp >= 0 && sv[sp] > a[p]) {
            cur -= sv[sp] * sc[sp];
            extra += sc[sp--];
        }
        if (extra > 0) {
            cur += a[p] * extra;
            if (sp >= 0 && sv[sp] == a[p])
                sc[sp] += extra;
            else {
                sv[++sp] = a[p];
                sc[sp] = extra;
            }
        }
        SL[p] = cur;
    }
    free(sv);
    free(sc);
}

void computeRight(ll* a, int n, ll* SR) {
    ll* sv = malloc(n * sizeof(ll));
    ll* sc = malloc(n * sizeof(ll));
    int sp = -1;
    ll cur = 0;
    SR[n - 1] = 0;
    for (int p = n - 2; p >= 0; p--) {
        cur += a[p + 1];
        if (sp >= 0 && sv[sp] == a[p + 1])
            sc[sp]++;
        else {
            sv[++sp] = a[p + 1];
            sc[sp] = 1;
        }

        ll extra = 0;
        while (sp >= 0 && sv[sp] > a[p]) {
            cur -= sv[sp] * sc[sp];
            extra += sc[sp--];
        }
        if (extra > 0) {
            cur += a[p] * extra;
            if (sp >= 0 && sv[sp] == a[p])
                sc[sp] += extra;
            else {
                sv[++sp] = a[p];
                sc[sp] = extra;
            }
        }
        SR[p] = cur;
    }
    free(sv);
    free(sc);
}

int main() {
    int n;
    scanf("%d", &n);
    ll* a = malloc(n * sizeof(ll));
    for (int i = 0; i < n; i++)
        scanf("%lld", &a[i]);

    ll* SL = calloc(n, sizeof(ll));
    ll* SR = calloc(n, sizeof(ll));
    computeLeft(a, n, SL);
    computeRight(a, n, SR);

    ll best = -1;
    for (int p = 0; p < n; p++) {
        ll s = a[p] + SL[p] + SR[p];
        if (s > best)
            best = s;
    }
    printf("%lld\n", best);

    free(a);
    free(SL);
    free(SR);
    return 0;
}