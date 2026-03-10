#include "stdio.h"

int main() {
    int n;
    char s[10000], a;

    scanf("%d", &n);
    scanf("%s", s);

    for (int i = 0;i<n;i++) {
        if (a != s[i]) {
            printf("%c", s[i]);
            a = s[i];
        }
    }

    return 0;
}