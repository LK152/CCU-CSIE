ANTLR_JAR  = antlr-4.13.2-complete.jar
GRAMMAR    = myparser.g4
JAVA_FILES = *.java
CP         = .:$(ANTLR_JAR)
JAVAC      = javac
JAVA       = java

all: generate compile test1 test2 test3

generate: $(GRAMMAR)
	$(JAVA) -jar $(ANTLR_JAR) -no-listener -visitor $(GRAMMAR)

compile: generate
	$(JAVAC) -cp $(CP) $(JAVA_FILES)

test1: compile
	$(JAVA) -cp $(CP) testParser test_programs/test1.c

test2: compile
	$(JAVA) -cp $(CP) testParser test_programs/test2.c

test3: compile
	$(JAVA) -cp $(CP) testParser test_programs/test3.c

clean:
	rm -f myparserLexer.java myparserParser.java myparserListener.java myparserBaseListener.java myparserVisitor.java  myparserBaseVisitor.java
	rm -f myparser.interp myparser.tokens myparserLexer.interp myparserLexer.tokens
	rm -f *.class