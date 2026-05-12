#include "stdio.h"
#include "string.h"

long long C[27][6];

void pre() {
    for (int i = 0; i <= 26; i++) {
        C[i][0] = 1;
        for (int j = 1; j <= 5; j++)
            C[i][j] = (i >= j) ? C[i - 1][j - 1] + C[i - 1][j] : 0;
    }
}

int main() {
    pre();
    int t;
    scanf("%d", &t);
    while (t--) {
        char w[10];
        scanf("%s", w);
        size_t len = strlen(w);

        int valid = 1;

        for (int i = 1; i < len; i++) {
            if (w[i] <= w[i - 1]) {
                valid = 0;
                break;
            }
        }
        
        if (!valid) {
            printf("0\n");
            continue;
        }

        long long idx = 1;
        for (int i = 1; i < len; i++)
            idx += C[26][i];

        int prev = -1;
        for (int i = 0; i < len; i++) {
            int ai = w[i] - 'a';
            for (int c = prev + 1; c < ai; c++)
                idx += C[26 - c - 1][len - i - 1];
            prev = ai;
        }

        printf("%lld\n", idx);
    }
    return 0;
}