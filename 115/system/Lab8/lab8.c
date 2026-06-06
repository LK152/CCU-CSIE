#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include "apue.h"

void accumulation(int d_sum);

int main() {
    FILE* sum;
    int total_sum = 0;
    pid_t pid[5];
    int year = 5, week = 52, day = 7;

    sum = fopen("sum.txt", "w");
    fprintf(sum, "%d\n", 0);
    fclose(sum);

    TELL_WAIT();

    for (int i = 0; i < year; ++i) {
        pid[i] = fork();
        if (pid[i] < 0)
            err_sys("fork error");
        else if (pid[i] == 0) {
            for (int w = 1; w <= week; ++w) {
                char fileName[64];
                sprintf(fileName, "tests/%d-%02d.txt", i + 1, w);

                FILE* fp = fopen(fileName, "r");
                if (fp == NULL)
                    err_sys("fork error: %s", fileName);

                for (int d = 0; d < day; ++d) {
                    int d_sum = 0;
                    int val;

                    for (int slot = 0; slot < 96; ++slot) {
                        fscanf(fp, "%d", &val);
                        d_sum += val;
                    }

                    WAIT_PARENT();
                    accumulation(d_sum);
                    TELL_PARENT(getppid());
                }

                fclose(fp);
            }
            exit(0);
        }
    }

    for (int w = 0; w < week; ++w) {
        for (int d = 0; d < day; ++d) {
            for (int i = 0; i < year; ++i) {
                TELL_CHILD(pid[i]);
                WAIT_CHILD();
            }
        }
    }

    for (int i = 0; i < year; ++i)
        wait(NULL);

    sum = fopen("sum.txt", "r");
    fscanf(sum, "%d", &total_sum);
    printf("Day_Average = %d\n", total_sum / (year * week * day));
    fclose(sum);

    return 0;
}

void accumulation(int d_sum) {
    FILE* sum;
    int tmp = 0;

    sum = fopen("sum.txt", "r+");
    fscanf(sum, "%d", &tmp);

    tmp += d_sum;

    rewind(sum);
    fprintf(sum, "%d", tmp);
    fclose(sum);

    return;
}
