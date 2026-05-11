import org.antlr.v4.runtime.*;

public class myChecker_test_g4 {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java myChecker_test_g4 <source_file>");
            System.exit(1);
        }

        CharStream input = CharStreams.fromFileName(args[0]);

        myCheckerLexer lexer = new myCheckerLexer(input);
        lexer.removeErrorListeners();

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        myCheckerParser parser = new myCheckerParser(tokens);
        parser.removeErrorListeners();

        parser.program();
    }
}
