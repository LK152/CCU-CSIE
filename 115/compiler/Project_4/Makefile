ANTLR_JAR = ./antlr-4.13.2-complete.jar
CLASSPATH = .:$(ANTLR_JAR):$$CLASSPATH

TESTS = test testAll test_control test_extra test_new test_str test_switch test_types

.PHONY: all build antlr compile clean clean-all run run-all gen-ll gen-ll-all

# Default target
all: build

# Generate ANTLR files and compile Java source
build: antlr compile

# Generate the Lexer and Parser from your grammar
antlr: myCompiler.g4
	java -cp $(CLASSPATH) org.antlr.v4.Tool myCompiler.g4

# Compile all Java files
compile: antlr
	javac -cp $(CLASSPATH) *.java

# Clean up generated Java and ANTLR files
clean:
	rm -f *.class *.tokens *.interp myCompilerLexer.java myCompilerParser.java myCompilerBaseListener.java myCompilerListener.java

# Run a specific test file (e.g., make run TEST=test)
run: build
	java -cp $(CLASSPATH) myCompiler_test $(TEST).c > $(TEST).ll
	clang $(TEST).ll myRuntime.c -o $(TEST) -lm
	./$(TEST)

# Run all test files sequentially
run-all: build
	@for t in $(TESTS); do \
		echo "========== $$t =========="; \
		java -cp $(CLASSPATH) myCompiler_test $$t.c > $$t.ll; \
		clang $$t.ll myRuntime.c -o $$t -lm; \
		./$$t; \
		echo; \
	done

# Generate .ll for a single file (e.g., make gen-ll TEST=test)
gen-ll: build
	java -cp $(CLASSPATH) myCompiler_test $(TEST).c > $(TEST).ll

# Generate .ll for all test files
gen-ll-all: build
	@for t in $(TESTS); do \
		echo "Generating $$t.ll ..."; \
		java -cp $(CLASSPATH) myCompiler_test $$t.c > $$t.ll; \
	done