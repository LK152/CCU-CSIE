#include "stdio.h"

int step(int n) {
    if (n == -2) return 1;
    if (n == -1) return 0;
}

void rec(int remain) {

}

int main() {
    int b, s, stp = 0;
    scanf("%d %d", &b, &s);
    int rst = s-b;
    while (rst%b > 1) {
        int cnt = rst/b;
        int remainder = b;
        b = rst%b;
        rst = remainder;

        printf("%d %d", remainder, cnt);
        stp++;
    }



    return 0;
}