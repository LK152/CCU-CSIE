ANTLR_JAR  = antlr-4.13.2-complete.jar
GRAMMAR    = myChecker.g4
DRIVER    = myChecker_test_g4.java
CP         = .:$(ANTLR_JAR)

all: compile

generate:
	java -jar $(ANTLR_JAR) -no-listener -no-visitor $(GRAMMAR)

compile: generate
	javac -cp $(CP) myChecker_test_g4 $(FILE)

clean:
	rm -f myCheckerLexer.java myCheckerParser.java \
	      myChecker.tokens myChecker.interp \
	      myCheckerLexer.interp *.class