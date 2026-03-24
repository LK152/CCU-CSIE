#include "stdio.h"

char maze[100][100];
int visited[100][100] = {0};

struct coord {
    int x, y;
} start, dest, dir[4];

int dfs(int x, int y, int m, int n) {
    if (x == dest.x && y == dest.y)
        return 1;

    for (int i = 0; i < 4; i++) {
        int dirx = x + dir[i].x;
        int diry = y + dir[i].y;

        if (dirx >= 0 && dirx < n && diry >= 0 && diry < m && !visited[dirx][diry] && maze[dirx][diry] == '.') {
            visited[dirx][diry] = 1;
            if (dfs(dirx, diry, m, n))
                return 1;
        }
    }

    return 0;
}

int main() {
    int m, n;

    dir[0] = (struct coord){0, -1};
    dir[1] = (struct coord){0, 1};
    dir[2] = (struct coord){-1, 0};
    dir[3] = (struct coord){1, 0};

    scanf("%d %d", &m, &n);
    scanf("%d %d %d %d", &start.y, &start.x, &dest.y, &dest.x);
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            scanf(" %c", &maze[j][i]);
        }
    }

    printf("%s", dfs(start.x, start.y, m, n) ? "YES" : "NO");

    return 0;
}