#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#ifndef BUFFSIZE
#define BUFFSIZE 4096
#endif

int main(void) {
    int n;
    char buf[BUFFSIZE];
    
    int out_fd = open("/dev/null", O_WRONLY);
    if (out_fd < 0) {
        perror("open /dev/null error");
        exit(1);
    }

    while ((n = read(STDIN_FILENO, buf, BUFFSIZE)) > 0) {
        if (write(out_fd, buf, n) != n) {
            perror("write error");
            exit(1);
        }
        
        fsync(out_fd); 
    }

    if (n < 0) {
        perror("read error");
        exit(1);
    }

    close(out_fd);
    exit(0);
}