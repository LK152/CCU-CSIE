#include "stdio.h"
#include "string.h"

int isNum(char c) {
    if (c >= 'a' && c <= 'z') return 0;

    return 1;
}

void p(char* s, int l, int r) {
    for (int i = l;i<r;i++) {
        if (isNum(s[i])) {
            int lb = i+1, rb = lb, b = 0;

            while (1) {
                if (s[rb] == '[') b++;
                if (s[rb] == ']') b--;

                if (!b) break;
                rb++;
            }

            for (int j = 0;j<s[i]-'0';j++) p(s, lb+1, rb);

            i = rb;
        } else printf("%c", s[i]);
    }
}

int main() {
    char s[31];

    scanf("%s", s);

    p(s, 0, strlen(s));

    return 0;
}