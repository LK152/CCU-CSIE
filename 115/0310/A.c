#include "stdio.h"

int main() {
    int w[8] = {8, 7, 6, 5, 4, 3, 2, 1};
    int alp[26] = {1, 10, 19, 28, 37, 46, 55, 64, 39, 73, 82, 2, 11, 20, 48, 29, 38, 47, 56, 65, 74, 83, 21, 3, 12, 30};
    char s[11];
    int ck = 0;

    scanf("%s", s);
    ck += alp[(s[0] - 'A')];

    for (int i = 1;i<9;i++) ck += (s[i] - '0') * w[i-1];

    ck += s[9] - '0';

    printf("%s", ck % 10 ? "No" : "Yes");

    return 0;
}