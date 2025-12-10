#include "stdio.h"
#include "stdlib.h"

int StrLen(char* s);
void SwapStr(char** a, char** b);
void SortNames(char** arr, int N);

int main() {
    int N;
    scanf("%d", &N);

    char* names[N];

    for (int i = 0; i < N; i++)
        names[i] = malloc(sizeof(char) * 256);

    for (int i = 0; i < N; i++) {
        scanf("%s", names[i]);
    }

    SortNames(names, N);

    for (int i = 0; i < N; i++) {
        printf("%s\n", names[i]);
    }

    for (int i = 0; i < N; i++)
        free(names[i]);

    return 0;
}

int StrLen(char* s) {
    int len = 0;
    while (*s != '\0') {
        s++;
        len++;
    }

    return len;
}

void SwapStr(char** a, char** b) {
    char* temp = *a;
    *a = *b;
    *b = temp;
}

void SortNames(char** arr, int N) {
    for (int j = 0; j < N - 1; j++) {
        for (int i = 0; i < N - 1; i++) {
            if (StrLen(arr[i]) > StrLen(arr[i + 1]))
                SwapStr(arr + i, arr + i + 1);
        }
    }
}