ANTLR_JAR = ./antlr-4.13.2-complete.jar
CLASSPATH = .:$(ANTLR_JAR):$$CLASSPATH

.PHONY: all build antlr compile clean clean-all run

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

# Run a specific test file (e.g., make run TEST=test1)
run: build
	java -cp $(CLASSPATH) myCompiler_test $(TEST).c > $(TEST).ll
	clang $(TEST).ll myRuntime.c -o $(TEST) -lm
	./$(TEST)