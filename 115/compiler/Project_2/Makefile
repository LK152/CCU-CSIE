# ─────────────────────────────────────────────────────────────
#  Makefile for Project 2 – C Subset Parser (ANTLR 4)
#
#  Requirements:
#    - Java JDK 8+
#    - antlr4-4.13.2-complete.jar in this directory
#
#  Targets:
#    make          – generate, compile, run all tests
#    make generate – run ANTLR4 on myparser.g4
#    make compile  – compile all Java sources
#    make test1    – run parser on tests/test1.c
#    make test2    – run parser on tests/test2.c
#    make test3    – run parser on tests/test3.c
#    make clean    – remove generated files and class files
# ─────────────────────────────────────────────────────────────

ANTLR_JAR  = antlr-4.13.2-complete.jar
GRAMMAR    = myparser.g4
JAVA_FILES = *.java
CP         = .:$(ANTLR_JAR)
JAVAC      = javac
JAVA       = java

.PHONY: all generate compile test1 test2 test3 clean

all: generate compile test1 test2 test3

# ── Step 1: Generate Lexer & Parser from grammar ──────────────
generate: $(GRAMMAR)
	$(JAVA) -jar $(ANTLR_JAR) -no-listener -visitor $(GRAMMAR)
	@echo "[generate] ANTLR4 files generated."

# ── Step 2: Compile all Java sources ─────────────────────────
compile: generate
	$(JAVAC) -cp $(CP) $(JAVA_FILES)
	@echo "[compile] All Java sources compiled."

# ── Step 3: Run tests ─────────────────────────────────────────
test1: compile
	@echo ""
	@echo ">>> Running test1.c <<<"
	$(JAVA) -cp $(CP) testParser test_programs/test1.c

test2: compile
	@echo ""
	@echo ">>> Running test2.c <<<"
	$(JAVA) -cp $(CP) testParser test_programs/test2.c

test3: compile
	@echo ""
	@echo ">>> Running test3.c <<<"
	$(JAVA) -cp $(CP) testParser test_programs/test3.c

# ── Clean ─────────────────────────────────────────────────────
clean:
	rm -f myparserLexer.java myparserParser.java \
	      myparserListener.java myparserBaseListener.java \
	      myparserVisitor.java  myparserBaseVisitor.java
	rm -f *.class
	@echo "[clean] Done."