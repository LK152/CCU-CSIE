CC = gcc
CFLAGS = -Wall
TARGETS = buffsize100 buffsize4096 buffsize8192 buffsize16384

all: $(TARGETS)

buffsize100: fig3_5.c error.c
	$(CC) $(CFLAGS) -DBUFFSIZE=100 fig3_5.c error.c -o buffsize100

buffsize4096: fig3_5.c error.c
	$(CC) $(CFLAGS) -DBUFFSIZE=4096 fig3_5.c error.c -o buffsize4096

buffsize8192: fig3_5.c error.c
	$(CC) $(CFLAGS) -DBUFFSIZE=8192 fig3_5.c error.c -o buffsize8192

buffsize16384: fig3_5.c error.c
	$(CC) $(CFLAGS) -DBUFFSIZE=16384 fig3_5.c error.c -o buffsize16384

clean:
	rm -f $(TARGETS) *.o