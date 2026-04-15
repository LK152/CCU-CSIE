# Makefile for Project 1 — Lexical Analyzer
# Requires: Java (JDK), ANTLR4 jar in current directory or ANTLR4_JAR env variable

ANTLR4_JAR ?= antlr-4.13.2-complete.jar
JAVAC       = javac
JAVA        = java
ANTLR4      = $(JAVA) -jar $(ANTLR4_JAR)
CLASSPATH   = .:$(ANTLR4_JAR)

GRAMMAR     = test1.g4
DRIVER      = testLexer.java
TEST_DIR    = test_programs
TESTS       = $(wildcard $(TEST_DIR)/*.c)

.PHONY: all clean run-tests generate compile

all: generate compile

# Step 1: Run ANTLR to generate Java source from the grammar
generate:
	$(ANTLR4) $(GRAMMAR)

# Step 2: Compile generated sources + test driver
compile: generate
	$(JAVAC) -cp $(CLASSPATH) *.java

# Run all test programs through the lexer
run-tests: compile
	@for f in $(TESTS); do \
		echo "=== $$f ==="; \
		$(JAVA) -cp $(CLASSPATH) testLexer $$f; \
		echo ""; \
	done

# Run a single test: make run FILE=test_programs/test1.c
run: compile
	$(JAVA) -cp $(CLASSPATH) testLexer $(FILE)

clean:
	rm -f *.class mylexerLexer.java mylexerLexer.tokens \
	      mylexer.tokens mylexer.interp mylexerLexer.interp
