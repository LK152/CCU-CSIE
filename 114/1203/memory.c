#include "stdio.h"
#include "string.h"

int main() {
    int n, flg = 1;
    scanf("%d", &n);
    int cnt[26][n];
    memset(cnt, 0, sizeof(cnt));
    for (int i = 0; i < n; i++) {
        char str[100];
        scanf("%s", str);
        for (int j = 0; j < strlen(str); j++) {
            cnt[str[j] - 97][i]++;
        }
    }

    for (int i = 0; i < 26; i++) {
        int j = 0, min = 100;
        while (j < n) {
            if (!cnt[i][j]) {
                min = 0;
                break;
            }
            if (cnt[i][j] < min)
                min = cnt[i][j];
            j++;
        }

        if (min) {
            flg = 0;
            for (int o = 0; o < min; o++)
                printf("%c", i + 97);
        }
    }
    if (flg)
        printf("No Content");

    return 0;
}