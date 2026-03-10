#include "stdio.h"

int main() {
    int alp[100], idx = 0;
    char s[1000];

    scanf("%s", s);

    while (s[idx++]) {
        if (s[idx] > 'Z') {
            alp[s[idx]] = 1;
            s[idx] -= 'A';
        }
    }

    return 0;
}