#include "stdio.h"
#include "string.h"

int main() {
    int paren = 0, ans = 0;
    char s[200001];

    scanf("%s", s);

    for (int i = 0;i<strlen(s);i++) {
        if (s[i] == '(') paren++;
        if (s[i] == ')') paren--;

        if (paren < 0) {
            ans++;
            paren += 2;
        } else if (paren > strlen(s) - i) {
            ans++;
            paren -= 2;
        }
    }
    
    printf("%d", ans);

    return 0;
}