#include "stdio.h"
#include "stdlib.h"

typedef struct item {
    char name[101];
    int price;
} item_t;

int comp(const void* vx, const void* vy) {
    item_t x = *(item_t*) vx, y = *(item_t*) vy;

    return y.price - x.price;
}

int main() {
    int n;
    item_t arr[101];

    scanf("%d", &n);
    
    for (int i = 0;i<n;i++) {
        int x;

        scanf("%s %d", arr[i].name, &x);

        if (x >= 5500 && x < 10000) arr[i].price = x * 0.9;
        else if (x >= 10000) arr[i].price = x * 0.83;
        else arr[i].price = x;
    }

    qsort(arr, n, sizeof(item_t), comp);

    for (int i = 0;i<n;i++) printf("%s %d\n", arr[i].name, arr[i].price);
    

    return 0;
}