#include <setjmp.h>
#include <string.h>
#include "apue.h"

#define FILENAME "emailTest.txt"

jmp_buf jmpbuffer;

void do_line(char*);            // start to measure email
void compare_at(char*);         //@
void compare_sharp(char*);      // #
void compare_asterisk(char*);   //*
void compare_doubleDot(char*);  //..
void compare_dot(char*);        //___@___.___
void print_error(char*);

int main(void) {
    char line[MAXLINE];
    FILE* fp;
    fp = fopen(FILENAME, "r");

    int i;
    if ((i = setjmp(jmpbuffer)) != 0) {
        switch (i) {
            case 1:
                print_error("at least 1 @");
                break;

            case 2:
                print_error("more than 1 @");
                break;

            case 3:
                print_error("# is not allowed");
                break;

            case 4:
                print_error("* is not allowed");
                break;

            case 5:
                print_error(".. is not allowed");
                break;

            case 6:
                print_error("at least 1 . after @");
                break;

            default:
                print_error("");
                break;
        }
    }
    
    while (fgets(line, MAXLINE, fp) != NULL) {
        printf("------------------------------------------------\n");
        printf("%s", line);
        do_line(line);
    }

    exit(0);
}

void print_error(char* str) {
    printf("Email format error: %s\n", str);
}

void do_line(char* str) {
    compare_at(str);
    printf("valid email address!\n");
    return;
}

void compare_at(char* str) {
    int counter = 0;
    char* cptr;
    char* temp;

    if ((cptr = strchr(str, '@')) == NULL)
        longjmp(jmpbuffer, 1);  // at least one @

    temp = cptr;
    while ((cptr = strchr(temp, '@')) != NULL) {
        printf("@ found at %ld\n", cptr - str + 1);
        counter++;
        temp = cptr + 1;
    }

    if (counter > 1)
        longjmp(jmpbuffer, 2);  // more than one @

    compare_sharp(str);
    return;
}

void compare_sharp(char* str) {
    char* cptr;

    if ((cptr = strchr(str, '#')) != NULL) {
        printf("# found at %ld\n", cptr - str + 1);
        longjmp(jmpbuffer, 3);
    }

    compare_asterisk(str);
    return;
}

void compare_asterisk(char* str) {
    char* cptr;

    if ((cptr = strchr(str, '*')) != NULL) {
        printf("* found at %ld\n", cptr - str + 1);
        longjmp(jmpbuffer, 4);
    }

    compare_doubleDot(str);
    return;
}

void compare_doubleDot(char* str) {
    char* cptr;

    if ((cptr = strstr(str, "..")) != NULL) {
        printf(".. found at %ld\n", cptr - str + 1);
        longjmp(jmpbuffer, 5);
    }

    compare_dot(str);
    return;
}

void compare_dot(char* str) {
    char* atptr;
    char* dotptr;

    atptr = strchr(str, '@');
    dotptr = strchr(atptr, '.');

    if (dotptr == NULL) longjmp(jmpbuffer, 6);

    return;
}
