#include "stdio.h"
#include "string.h"

void Swap(int* ptr1, int* ptr2) {
    *ptr1 ^= *ptr2;
    *ptr2 ^= *ptr1;
    *ptr1 ^= *ptr2;
}

void Reverse(int* arr_ptr, int L, int R) {
    int* lft = arr_ptr + L;
    int* rgt = arr_ptr + R;

    while (rgt > lft) {
        Swap(lft, rgt);
        lft++;
        rgt--;
    }
}

void Rotation(int* arr_ptr, int k, int N) {
    Reverse(arr_ptr, 0, N);
    int rot = k % N;
    Reverse(arr_ptr, 0, rot);
    Reverse(arr_ptr, rot, N);
}

int main() {
    int arr[1000], idx = 0, l, r, k;

    while (1) {
        int x;
        scanf("%d", &x);
        if (x == -1)
            break;
        arr[idx++] = x;
    }
    scanf("%d %d %d", &l, &r, &k);
    Reverse(arr, l, r);
    for (int i = 0; i < idx; i++)
        printf("%d ", arr[i]);

    printf("\n");
    Rotation(arr, k, idx);
    for (int i = 0; i < idx; i++)
        printf("%d ", arr[i]);

    return 0;
}