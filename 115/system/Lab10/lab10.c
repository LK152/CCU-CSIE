#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include "apue.h"

void put_pull_rod(int signum);
void fish_eating(int signum);
void exit_game(int signum);

int fishNum = 0;
int rodInWater = 0;
int fishBiting = 0;
int baitEaten = 0;

int main(void) {
    struct sigaction sig_put_pull_rod;
    sig_put_pull_rod.sa_handler = put_pull_rod;
    sigemptyset(&sig_put_pull_rod.sa_mask);
    sig_put_pull_rod.sa_flags = 0;

    struct sigaction sig_exit_game;
    sig_exit_game.sa_handler = exit_game;
    sigemptyset(&sig_exit_game.sa_mask);
    sig_exit_game.sa_flags = 0;

    struct sigaction sig_fish_eating;
    sig_fish_eating.sa_handler = fish_eating;
    sigemptyset(&sig_fish_eating.sa_mask);
    sig_fish_eating.sa_flags = 0;

    sigaction(SIGINT, &sig_put_pull_rod, NULL);
    sigaction(SIGTSTP, &sig_exit_game, NULL);
    sigaction(SIGALRM, &sig_fish_eating, NULL);

    srand(time(NULL));

    printf("Fishing rod is ready!\n");

    while (1)
        pause();

    return 0;
}

void put_pull_rod(int signum) {
    if (rodInWater == 0) {
        printf("\nPut the fishing rod\n");
        printf("Bait into water, waiting fish...\n");
        rodInWater = 1;
        fishBiting = 0;
        baitEaten = 0;
        alarm(rand() % 2 + 1);
    } else {
        alarm(0);
        printf("\nPull the fishing rod\n");
        if (fishBiting) {
            fishNum++;
            printf("Catch a Fish!!\n");
            printf("Totally caught fishes : %d\n", fishNum);
        } else if (baitEaten) {
            printf("The bait was eaten!!\n");
        }
        rodInWater = 0;
        fishBiting = 0;
        baitEaten = 0;
        printf("Fishing rod is ready!\n");
    }
}

void fish_eating(int signum) {
    if (rodInWater == 0)
        return;

    if (fishBiting == 0) {
        if (rand() % 2 == 0) {
            printf("A fish is biting,pull the fishing rod\n");
            fishBiting = 1;
            alarm(2);
        }
    } else {
        printf("The fish was escaped!!\n");
        fishBiting = 0;
        baitEaten = 1;
    }
}

void exit_game(int signum) {
    printf("\nTotally caught fishes: %d\n", fishNum);
    exit(0);
}
