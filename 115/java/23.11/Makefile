# 這一行填「你自己電腦上」JavaFX 的 lib 路徑；助教批改時會用環境變數自動覆蓋，你不用改
PATH_TO_FX ?= C:/javafx-sdk-26.0.1/lib

MODULES = javafx.controls,javafx.graphics
MAIN    = BouncingBalls

all:
	javac -encoding UTF-8 --module-path "$(PATH_TO_FX)" --add-modules $(MODULES) *.java

run: all
	java --module-path "$(PATH_TO_FX)" --add-modules $(MODULES) $(MAIN)

clean:
	rm -f *.class

.PHONY: all run clean