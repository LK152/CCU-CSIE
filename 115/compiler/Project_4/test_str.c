// Test: char arrays and string operations

int main() {
    char greeting[32];
    char name[16];
    char buf[64];

    // string literal assignment
    greeting = "Hello, World!";
    printf("%s\n", greeting);

    // scanf then printf with %s
    printf("Enter your name: ");
    scanf("%s", &name);
    printf("Hi, %s!\n", name);

    // another assignment
    buf = "Compiler supports strings!";
    printf("%s\n", buf);

    return 0;
}
