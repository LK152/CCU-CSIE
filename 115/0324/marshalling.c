#include "stdio.h"

int prev[300000], nxt[300000];

void conn(int p, int n) {
    if (p != -1)
        nxt[p] = n;
    if (n != -1)
        prev[n] = p;
}

void a(int x, int y) {
    if (x == y || nxt[y] == x)
        return;

    conn(prev[x], nxt[x]);

    int temp = nxt[y];
    conn(y, x);
    conn(x, temp);
}

int main() {
    int n, q;
    scanf("%d %d", &n, &q);

    for (int i = 0; i <= n; i++) {
        nxt[i] = i + 1;
        prev[i + 1] = i;
    }

    nxt[n + 1] = -1;

    while (q--) {
        char c;
        int x, y;
        scanf(" %c", &c);

        if (c == 'A') {
            scanf("%d %d", &x, &y);
            a(x, y);
        } else if (c == 'F') {
            scanf("%d", &x);
            a(x, 0);
        } else if (c == 'B') {
            scanf("%d", &x);
            a(x, prev[n + 1]);
        }
    }

    int curr = nxt[0];
    while (curr != n + 1) {
        printf("%d%c", curr, (nxt[curr] == n + 1 ? '\n' : ' '));
        curr = nxt[curr];
    }

    return 0;
}