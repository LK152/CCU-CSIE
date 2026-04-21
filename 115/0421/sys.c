#include "stdio.h"
#include "string.h"

struct path {
    char dir[101];
};

int main() {
    int n, idx = 1;
    char ins[101];
    struct path arr[101];

    strcpy(arr[0].dir, "~");
    scanf("%d", &n);
    while (n--) {
        scanf("%s", ins);

        if (strcmp(ins, "..") == 0 && idx > 1) {
            strcpy(arr[idx].dir, "");
            idx--;
        } 
        if (strcmp(ins, "..")) {
            strcpy(arr[idx++].dir, ins);
        }
        
    }

    for (int i = 0;i<idx;i++) {
        printf("%s", arr[i].dir);
        if (i != idx - 1) printf("/");
    }


    return 0;
}