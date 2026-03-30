void swap(int arr[], int i, int j) {
    int tmp;
    tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

int main(void) {
    int arr[5];
    int i;
    int j;

    arr[0] = 64;
    arr[1] = 25;
    arr[2] = 12;
    arr[3] = 22;
    arr[4] = 11;
    i = 0;

    while (i < 5) {
        j = 0;
        while (j < 4 - i) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
            j = j + 1;
        }
        i = i + 1;
    }
    
    return 0;
}