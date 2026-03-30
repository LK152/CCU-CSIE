import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStreams;

public class testLexer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            CharStream input = CharStreams.fromFileName(args[0]);
            mylexer lexer = new mylexer(input);
            Token token = lexer.nextToken();
            while (token.getType() != -1) {
                System.out.println("Token: " + token.getType() + " " + token.getText());
                token = lexer.nextToken();
            }
        } catch (Throwable t) {
            System.out.println("Exception: " + t);
            t.printStackTrace();
        }
    }

}
