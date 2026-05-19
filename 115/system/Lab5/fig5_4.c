#include "apue.h"

#define ll long long

int main(void) {
    int c;
    ll counter = 0;

    while ((c = getc(stdin)) != EOF) {
        counter++;
    
        if (putc(c, stdout) == EOF)
            err_sys("output error");
    }

    if (ferror(stdin))
        err_sys("input error");

    fprintf(stderr, "Loop iterations (getc/putc): %lld", counter);

    exit(0);
}
