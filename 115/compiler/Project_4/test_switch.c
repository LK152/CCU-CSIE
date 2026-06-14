// Test: switch-case statement

enum Day { MON, TUE, WED, THU, FRI, SAT, SUN };

int classify(int n) {
    int result;
    switch (n) {
        case 1:
            result = 10;
            break;
        case 2:
            result = 20;
            break;
        case 3:
            result = 30;
            break;
        default:
            result = -1;
            break;
    }
    return result;
}

int main() {
    int i, d;
    char label[16];

    // Basic integer switch
    i = 1;
    while (i <= 4) {
        printf("classify(%d) = %d\n", i, classify(i));
        i++;
    }

    // Switch on enum value
    d = WED;
    switch (d) {
        case MON:
            label = "Monday";
            break;
        case TUE:
            label = "Tuesday";
            break;
        case WED:
            label = "Wednesday";
            break;
        case THU:
            label = "Thursday";
            break;
        case FRI:
            label = "Friday";
            break;
        default:
            label = "Weekend";
            break;
    }
    printf("Day %d is %s\n", d, label);

    // Break inside while loop
    i = 0;
    while (i < 10) {
        if (i == 5) {
            break;
        }
        i++;
    }
    printf("while-break stopped at i=%d\n", i);

    // Switch with no default
    i = 7;
    switch (i) {
        case 7:
            printf("lucky seven!\n");
            break;
        case 13:
            printf("unlucky thirteen\n");
            break;
    }

    return 0;
}
