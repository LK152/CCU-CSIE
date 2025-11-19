#include "stdio.h"

void step(int n, int* rmd, int* cnt) {
    if (n == -2) {
        printf("1");
        return;
    }
    if (n == -1) {
        printf("0");
        return;
    }

    for (int i = 0; i < cnt[n]; i++) {
        step(n - 1, rmd, cnt);
    }

    if (rmd[n])
        step(n - 2, rmd, cnt);
}

int main() {
    int b, s, stp = 0, rmder[100], cnt[100];
    scanf("%d %d", &b, &s);
    int rst = s - b;

    while (1) {
        rmder[stp] = stp ? s % rst : b;
        cnt[stp] = rmder[stp] ? rst / rmder[stp] : rmder[stp - 1];
        s = rst;
        rst = rmder[stp];

        if (!rmder[stp])
            break;
        stp++;
    }

    step(stp, rmder, cnt);

    return 0;
}