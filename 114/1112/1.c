#include "stdio.h"
#include "math.h"

int validTriangle(float a, float b, float c) {
    if (a+b>c && a+c>b && b+c>a) return 1;

    return 0;
}

int type(float a, float b, float c) {
    if (a == b && b == c) return 1;
    if (a*a + b*b == c*c || a*a + c*c == b*b || c*c + b*b == a*a) return 2;
    if (a == b || b == c || a == c) return 3;

    return 0;
}

int main() {
    float a, b, c;
    for (int i = 0;i<3;i++) {
        scanf("%f %f %f", &a, &b, &c);
        printf("(%.0f,%.0f,%.0f):", a, b, c);
        if (!validTriangle(a, b, c)) {
            printf("[Not a triangle]\n");
            continue;
        }
        switch (type(a, b, c)) {
            case 1:
                printf("[Equilateral]");
                break;
            
            case 2:
                printf("[Right-angled]");
                break;

            case 3:
                printf("[Isosceles]");
                break;

            default:
                printf("[Scalene]");
                break;
        }

        float s = (a+b+c)/2;

        printf(",Area:%.2f\n", sqrt(s*(s-a)*(s-b)*(s-c)));
    }


    return 0;
}