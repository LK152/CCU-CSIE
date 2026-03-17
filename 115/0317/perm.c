#include "stdio.h"

void bt(int idx, int n, char* s, char* ans, int* used) {
    if (idx == n) {
        ans[n] = '\0';
        printf("%s\n", ans);
        return;
    }

    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            used[i] = 1;
            ans[idx] = s[i];

            bt(idx + 1, n, s, ans, used);

            used[i] = 0;
        }
    }
}

int main() {
    int n;
    char s[10];
    char ans[10];
    int used[10] = {0};

    scanf("%d", &n);
    scanf("%s", s);

    bt(0, n, s, ans, used);

    return 0;
}