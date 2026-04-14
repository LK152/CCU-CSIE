#include "stdio.h"

int main() {
    int n, idx = 0, in[200001];

    scanf("%d", &n);
    for (int i = 0;i<n;i++) {
        scanf("%d", in + i);
    }
    printf("0 ");
    for (int i = 1;i<n;i++) {
        int flg = 0;
        idx = i - 1;
        while (in[i] <= in[idx]) {
            if (idx - 1 < 0) {
                flg = 1;
                break;
            }
            idx--;
        }
        printf("%d ", flg ? 0 : idx+1);
    }

    return 0;
}