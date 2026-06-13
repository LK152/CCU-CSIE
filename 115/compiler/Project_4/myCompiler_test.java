import org.antlr.v4.runtime.*;

public class myCompiler_test {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.err.println("Usage: java myCompiler_test <input_file.c>");
            return;
        }

        CharStream input = CharStreams.fromFileName(args[0]);
        myCompilerLexer lexer = new myCompilerLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        myCompilerParser parser = new myCompilerParser(tokens);

        // Kick off the parser
        parser.program();

        // Output the complete LLVM IR module
        System.out.println(parser.getModule());
    }
}