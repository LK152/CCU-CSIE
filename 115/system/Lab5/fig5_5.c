#include "apue.h"

#define ll long long

int main(void) {
    char buf[MAXLINE];
    ll counter = 0;

#ifndef BUF_MODE
#define BUF_MODE _IONBF
#endif

    if (setvbuf(stdin, NULL, BUF_MODE, MAXLINE) != 0)
        err_sys("setvbuf std error");
    if (setvbuf(stdout, NULL, BUF_MODE, MAXLINE) != 0)
        err_sys("setvbuf stdout error");

#if BUF_MODE == _IOFBF
    fprintf(stderr, "Fully Buffered\n");
#elif BUF_MODE == _IOLBF
    fprintf(stderr, "Line Buffered\n");
#elif BUF_MODE == _IONBF
    fprintf(stderr, "Unbuffered\n");
#endif

    while (fgets(buf, MAXLINE, stdin) != NULL) {
        counter++;
        if (fputs(buf, stdout) == EOF)
            err_sys("output error");
    }
    if (ferror(stdin))
        err_sys("input error");

    fprintf(stderr, "Loop iterations: %lld\n", counter);

    exit(0);
}