import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class testParser {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java testParser <source_file>");
            System.exit(1);
        }

        String sourceFile = args[0];
        System.out.println("===========================================");
        System.out.println(" Parsing: " + sourceFile);
        System.out.println("===========================================");

        CharStream input = CharStreams.fromFileName(sourceFile);

        myparserLexer lexer = new myparserLexer(input);
        lexer.removeErrorListeners(); // remove default console listener
        SyntaxErrorListener lexerErrorListener = new SyntaxErrorListener();
        lexer.addErrorListener(lexerErrorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        myparserParser parser = new myparserParser(tokens);
        parser.removeErrorListeners();
        SyntaxErrorListener parserErrorListener = new SyntaxErrorListener();
        parser.addErrorListener(parserErrorListener);

        ParseTree tree = parser.program();

        System.out.println("===========================================");

        int lexerErrors = lexerErrorListener.getErrorCount();
        int parserErrors = parserErrorListener.getErrorCount();

        if (lexerErrors == 0 && parserErrors == 0) {
            System.out.println(" RESULT : Parse SUCCESSFUL (no errors)");
        } else {
            if (lexerErrors > 0)
                System.out.println(" Lexer  errors : " + lexerErrors);
            if (parserErrors > 0)
                System.out.println(" Parser errors : " + parserErrors);
            System.out.println(" RESULT : Parse FAILED");
        }
        System.out.println("===========================================");

        System.out.println("\nParse Tree:");
        System.out.println(tree.toStringTree(parser));
    }

    static class SyntaxErrorListener extends BaseErrorListener {

        private int errorCount = 0;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line,
                int charPositionInLine,
                String msg,
                RecognitionException e) {
            errorCount++;
            System.err.println("[Syntax Error] line " + line
                    + ":" + charPositionInLine + " – " + msg);
        }

        public int getErrorCount() {
            return errorCount;
        }
    }
}