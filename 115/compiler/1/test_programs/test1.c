// Test Program 1: Basic arithmetic, variables, and control flow
int main() {
    int a = 10;
    int b = 20;
    float c = 3.14;

    // Arithmetic
    int sum = a + b;
    int diff = b - a;
    int product = a * b;
    float quotient = (float)a / b;
    int remainder = b % a;

    // Relational and logical
    if (a <= b && b >= a) {
        sum += 1;
    }

    // Increment / decrement
    a++;
    b--;

    return 0;
}
