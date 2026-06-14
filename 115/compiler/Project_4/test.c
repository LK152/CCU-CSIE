int computeGCD(int a, int b) {
    int temp;
    while (b > 0) {
        temp = a;
        a = b;
        b = temp % b; 
    }
    return a;
}

void printGreeting() {
    printf("--- Compiler Ultimate Stress Test ---\n");
}

int main() {
    int i, j, k;
    float x, y, z;

    printGreeting();

    printf("Enter a positive integer: ");
    scanf("%d", &i);
    printf("Enter a float: ");
    scanf("%f", &x);

    y = i + 2.5;         
    
    j = y;               
    printf("Implicit Conversion: y (float) = %f, j (truncated to int) = %d\n", y, j);

    k = (int)(x * 2.0);
    printf("Explicit Cast: k = %d\n", k);

    z = x ## 3.0; 
    printf("Custom Operator (x ## 3.0) = %f\n", z);

    if (i > j) {
        printf("%d is greater than %d\n", i, j);
    } else {
        if (i == j) {
            printf("%d is exactly equal to %d\n", i, j);
        } else {
            printf("%d is less than %d\n", i, j);
        }
    }

    printf("Counting down from %d:\n", i);
    while (i > 0) {
        if (i != 3) {
            printf("Tick: %d\n", i);
        } else {
            printf("Tick: %d (Skipping number 3 logic!)\n", i);
        }
        i -= 1;
    }

    i = 48;
    j = 18;
    k = computeGCD(i, j);
    printf("GCD of %d and %d is %d\n", i, j, k);

    return 0;
}