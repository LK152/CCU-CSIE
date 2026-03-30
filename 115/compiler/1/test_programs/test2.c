// Test Program 2: Loops, strings, and char literals
int strlen(char *s);

int main() {
    char msg[] = "Hello, World!";
    char ch = 'A';
    int i;
    int len = strlen(msg);

    // For loop
    for (i = 0; i < len; i++) {
        ch = msg[i];
    }

    // While loop with compound assignment
    int count = 10;
    while (count > 0) {
        count -= 2;
    }

    // Nested if-else
    if (count == 0) {
        count = 1;
    } else if (count < 0) {
        count = 0;
    } else {
        count++;
    }

    return 0;
}
