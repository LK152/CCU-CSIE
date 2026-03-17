#include "stdio.h"

long long table[90];

void dp() {
    table[0] = 1;
    table[1] = 1;
    for (int i = 2; i < 90; i++) {
        table[i] = table[i - 1] + table[i - 2];
    }
}

char fib(int lv, long long pos) {
    if (lv == 1)
        return '0';
    if (lv == 2)
        return '1';

    if (pos <= table[lv - 3]) {
        return fib(lv - 2, pos);
    }
    return fib(lv - 1, pos - table[lv - 3]);
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
