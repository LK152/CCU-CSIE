#include "stdio.h"

void step(int n, int rmd[100], int cnt[100]) {
    if (n == -2) {
        printf("%d", 1);
        return;
    }
    if (n == -1) {
        printf("%d", 0);
        return;
    }

    for (int i = 0; i < cnt[n]; i++) {
        step(n - 1, rmd, cnt);
    }

    if (rmd[n])
        step(n - 2, rmd, cnt);
}

int main() {
    int b, s, stp = 1, rmder[100], cnt[100];
    scanf("%d %d", &b, &s);
    int rst = s - b;
    rmder[0] = b;
    cnt[0] = rst / b;
    s = rst;
    rst = b;
    while (1) {
        rmder[stp] = s % rst;
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