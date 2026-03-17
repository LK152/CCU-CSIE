#include "stdio.h"

long long table[91];

void dp() {
    table[1] = 1;
    table[2] = 1;
    for (int i = 3; i < 91; i++) {
        table[i] = table[i - 1] + table[i - 2];
    }
}

char fib(int lv, long long pos) {
    if (lv == 1)
        return '0';
    if (lv == 2)
        return '1';

    if (pos <= table[lv - 2]) {
        return fib(lv - 2, pos);
    }
    return fib(lv - 1, pos - table[lv - 2]);
}

int main() {
    dp();
    int q, k;
    long long p;

    scanf("%d", &q);

    for (int i = 0; i < q; i++) {
        scanf("%d %lld", &k, &p);

        printf("%c\n", fib(k, p));
    }

    return 0;
}
