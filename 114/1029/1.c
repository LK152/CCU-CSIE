#include "ctype.h"
#include "stdio.h"

char caesarEncrypt(char c, long long int n) {
    if (!isalpha(c))
        return c;

    if (n >= 26)
        n %= 26;
    if (isupper(c)) {
        if ((c + n) > 90)
            n -= 26;

        return c + n;
    }

    if ((c + n) > 122)
        n -= 26;

    return c + n;
}

char caesarDecrypt(char c, long long int n) {
    if (!isalpha(c))
        return c;

    if (n >= 26)
        n %= 26;
    if (isupper(c)) {
        if ((c - n) < 65)
            n -= 26;

        return c - n;
    }

    if ((c - n) < 97)
        n -= 26;

    return c - n;
}

int main() {
    char c;
    int m;
    long long int s;
    scanf("%d %lld", &m, &s);
    
    switch (m) {
        case 1:
            while (1) {
                c = getchar();
                if (c == EOF)
                    return 0;
                printf("%c", caesarEncrypt(c, s));
            }
            break;

        case 2:
            while (1) {
                c = getchar();
                if (c == EOF)
                    return 0;
                printf("%c", caesarDecrypt(c, s));
            }
            break;
    }

    return 0;
}