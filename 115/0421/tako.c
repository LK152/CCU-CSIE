#include "stdio.h"

int main() {
    int n, s[101], q[101], flag = 0;
    scanf("%d", &n);

    for (int i = 0;i<n;i++) {
        scanf("%d", q+i);
    }
    for (int i = 0;i<n;i++) {
        scanf("%d", s+i);
    }

    for (int i = 0;i<n;i++) {
        for (int j = 0;j<n;j++) {
            if(s[i] == q[j]) {
                q[j] = -1;
                break;
            }
            if (j == n-1) flag = 1;
        }
        if (flag) break;
    }

    int sum = 0;
    for (int i = 0;i<n;i++) {
        if (q[i] != -1) sum++;
    }

    printf("%d", sum);

    return 0;
}