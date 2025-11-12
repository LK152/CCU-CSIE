#include "stdio.h"

int getDay(int n) {
    int day = 0;
    day += n % 10;
    n /= 10;
    day += (n % 10) * 10;

    return day;
}

int getMonth(int n) {
    int month = 0;
    n /= 100;
    month += n % 10;
    n /= 10;
    month += (n % 10) * 10;

    return month;
}

void output(int n) {
    int dig = 0, sum = 0;
    while (n) {
        dig++;
        sum += n % 10;
        n /= 10;
    }

    printf("Digits=%d Sum=%d ", dig, sum);

    int ln = 0;
    while (sum) {
        ln += sum % 10;
        sum /= 10;
    }

    printf("LifeNum=%d\n", ln);
}

int main() {
    int n;
    scanf("%d", &n);

    int day = getDay(n);
    int month = getMonth(n);

    if (day > 31 || day < 1 || month > 12 || month < 1) {
        printf("Invalid\n");

        return 0;
    }
    output(n);

    return 0;
}