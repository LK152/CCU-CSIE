ANTLR4_JAR = antlr-4.13.2-complete.jar
JAVAC       = javac
JAVA        = java
ANTLR4      = $(JAVA) -jar $(ANTLR4_JAR)
CLASSPATH   = .:$(ANTLR4_JAR)

GRAMMAR     = mylexer.g4
DRIVER      = testLexer.java
TEST_DIR    = test_programs
TESTS       = $(wildcard $(TEST_DIR)/*.c)

generate:
	$(ANTLR4) $(GRAMMAR)

compile: generate
	$(JAVAC) -cp $(CLASSPATH) *.java

run-all: compile
	@for f in $(TESTS); do \
		echo "=== $$f ==="; \
		$(JAVA) -cp $(CLASSPATH) testLexer $$f; \
		echo ""; \
	done

run: compile
	$(JAVA) -cp $(CLASSPATH) testLexer $(FILE)