#include "stdio.h"

int check_one_match(char* input_ptr, char* code_ptr) {
    return *input_ptr == *code_ptr;
}

void check_all_code(char* input_ptr, char* code_ptr) {
    int flg = 1;

    for (int i = 0; i < 10; i++) {
        int stat = check_one_match(input_ptr + i, code_ptr + i);
        printf("Character %d: %s\n", i + 1, stat ? "match" : "mismatch");

        if (!stat)
            flg = 0;
    }

    printf("%s\n", flg ? "Code Verified. Mother Box Activates." : "ERROR. Code Invalid.");
    printf("PING. Code Shifted. \nThe New Code Is: ");
}

int shift_value(char* input_ptr) {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        sum += *(input_ptr + i);
    }

    return sum % 5;
}

void new_code(int shift_value, char* code_ptr) {
    for (int i = 0; i < 10; i++) {
        *(code_ptr + i) += *(code_ptr + i) + shift_value > 90 ? (shift_value - 26) : shift_value;
        printf("%c", *(code_ptr + i));
    }
}

int main() {
    char code[] = "UUDDLRLRBA";
    char input[10];
    int flag = 1;

    for (int i = 0; i < 10; i++) {
        scanf("%c", &input[i]);
    }

    check_all_code(input, code);

    new_code(shift_value(input), code);

    return 0;
}