#include "stdio.h"

int sumDigits(int n) {
    int sum = 0;
    while (n) {
        sum += n % 10;
        n /= 10;
    }

    return sum;
}

int oddDigitCount(int n) {
    int count = 0;
    while (n) {
        int x = n % 10;
        if (x % 2)
            count++;
        n /= 10;
    }

    return count;
}

int main() {
    int n;
    scanf("%d", &n);
    int digitSum = sumDigits(n);
    int oddDigits = oddDigitCount(n);

    printf("[SumOfDigit:%03d]_[OddDigitCount:%03d] -> ", digitSum, oddDigits);
    printf(!(oddDigits % 3) && digitSum % 5 ? "Jackpot!\n" : "No match.\n");

    return 0;
}