float averg(int arr[], int size) {
    int i;
    int sum;
    float result;
    i = 0;
    sum = 0;
    while (i < size) {
        sum = sum + arr[i];
        i = i + 1;
    }
    result = sum / size;
    return result;
}

int fac(int n) {
    if (n <= 1)
        return 1;
    else
        return n * fac(n - 1);
}

void swp(int arr[], int i, int j) {
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void main(void) {
    int nums[5];
    float avg;
    int f;
    nums[0] = 10;
    nums[1] = 20;
    nums[2] = 30;
    nums[3] = 40;
    nums[4] = 50;
    avg = averg(nums, 5);
    f = fac(6);
    swp(nums, 0, 4);
    ;
}