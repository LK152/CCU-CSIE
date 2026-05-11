ANTLR_JAR  = antlr-4.13.2-complete.jar
GRAMMAR    = myChecker.g4
DRIVER    = myChecker_test_g4.java
CP         = .:$(ANTLR_JAR)

all: compile

generate:
	java -jar $(ANTLR_JAR) -no-listener -no-visitor $(GRAMMAR)

compile: generate
	javac -cp $(CP) *.java

run:
	java -cp $(CP) myChecker_test_g4 $(FILE)

run-all: compile
	@echo "========== test1 =========="
	java -cp $(CP) myChecker_test_g4 test_programs/test1.c
	@echo "========== test2 =========="
	java -cp $(CP) myChecker_test_g4 test_programs/test2.c
	@echo "========== test3 =========="
	java -cp $(CP) myChecker_test_g4 test_programs/test3.c
	@echo "========== test4 =========="
	java -cp $(CP) myChecker_test_g4 test_programs/test4.c
	@echo "========== Correct Test =========="
	java -cp $(CP) myChecker_test_g4 test_programs/correct.c

clean:
	rm -f myCheckerLexer.java myCheckerParser.java \
	      *.tokens myChecker.interp \
	      myCheckerLexer.interp *.class