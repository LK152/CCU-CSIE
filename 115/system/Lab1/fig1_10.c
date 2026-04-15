#include <sys/wait.h>
#include "apue.h"
#include "fcntl.h"
#include "string.h"

#define MAXARGS 1000

static void sig_int(int);
int main(void) {
    char buf[MAXLINE];
    pid_t pid;
    int status;
    char* args[MAXARGS];

    if (signal(SIGINT, sig_int) == SIG_ERR)
        err_sys("signal error");

    printf("## ");
    while (fgets(buf, MAXLINE, stdin) != NULL) {
        printf("## ");
        int i = 0;
        args[i] = strtok(buf, " \t\n\r");

        while (args[i] != NULL && i < MAXARGS - 1) {
            i++;
            args[i] = strtok(NULL, " \t\n\r");
        }

        if (buf[strlen(buf) - 1] == '\n')
            buf[strlen(buf) - 1] = 0;

        if (strcmp(args[0], "cd") == 0) {
            char* path = args[1] ? args[1] : getenv("HOME");

            if (chdir(path) < 0)
                perror(path);

            continue;
        }

        if (strcmp(args[0], "mkdir") == 0) {
            if (args[1] == NULL)
                fprintf(stderr, "mkdir: missing operand\n");
            if (mkdir(args[1], 0777) < 0)
                perror("mkdir error");
            continue;
        }

        if (strcmp(args[0], "cp") == 0) {
            if (args[1] == NULL || args[2] == NULL) {
                fprintf(stderr, "cp: missing file operand\n");
                continue;
            }

            int file_in = open(args[1], O_RDONLY);
            if (file_in < 0) {
                perror("cp: cannot open source file");
                continue;
            }

            struct stat statbuf;
            char dest_path[MAXLINE];

            strncpy(dest_path, args[2], sizeof(dest_path) - 1);
            dest_path[sizeof(dest_path) - 1] = '\0';

            if (stat(args[2], &statbuf) == 0 && S_ISDIR(statbuf.st_mode)) {
                char* filename = strrchr(args[1], '/');
                if (filename != NULL) {
                    filename++;
                } else {
                    filename = args[1];
                }

                snprintf(dest_path, sizeof(dest_path), "%s/%s", args[2], filename);
            }

            int file_out = open(dest_path, O_WRONLY | O_CREAT | O_TRUNC, 0666);
            if (file_out < 0) {
                perror("cp: cannot create destination file");
                close(file_in);
                continue;
            }

            char copy_buf[4096];
            ssize_t n_read;

            while ((n_read = read(file_in, copy_buf, sizeof(copy_buf))) > 0) {
                if (write(file_out, copy_buf, n_read) != n_read) {
                    perror("cp: write error");
                    break;
                }
            }

            if (n_read < 0) {
                perror("cp: read error");
            }

            close(file_in);
            close(file_out);
            continue;
        }

        if (strcmp(args[0], "exit") == 0)
            break;

        if ((pid = fork()) < 0) {
            err_sys("fork error");
        } else if (pid == 0) {
            execvp(args[0], args);
            err_ret("couldn't execute: %s", buf);
            exit(127);
        }

        if ((pid = waitpid(pid, &status, 0)) < 0)
            err_sys("waitpid error");
    }
    exit(0);
}

void sig_int(int signo) {
    printf("interrupt\nType exit to exit\n## ");
}
