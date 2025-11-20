#include <stdio.h>

long long coins[200005];
long long dp[200005];

long long max(long long a, long long b) {
    return (a > b) ? a : b;
}

int main() {
    int n;

    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        scanf("%lld", &coins[i]);
    }

    if (n == 0) {
        printf("0\n");
        return 0;
    }

    dp[0] = 0;
    dp[1] = coins[1];

    for (int i = 2; i <= n; i++) {
        dp[i] = max(dp[i - 1], coins[i] + dp[i - 2]);
    }

    printf("%lld\n", dp[n]);

    return 0;
}