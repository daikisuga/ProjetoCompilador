
//Main.java
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainParser{
	public static void main(String[] args) throws IOException {
		List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("reservada_if","if"));
        tokens.add(new Token("id","soma"));
        tokens.add(new Token("operador_condicional",">"));
        tokens.add(new Token("num","5"));
        tokens.add(new Token("reservada_then","then"));
        tokens.add(new Token("id","soma"));
        tokens.add(new Token("operador_atribuicao","="));
        tokens.add(new Token("num","3"));
        tokens.add(new Token("reservada_else","else"));
        tokens.add(new Token("id","soma"));
        tokens.add(new Token("operador_atribuicao","="));
        tokens.add(new Token("num","2"));
        tokens.add(new Token("EOF","$"));
        Parser parser = new Parser(tokens);
        parser.main();
        //List<Token> tokens = null;
		/*String data = "4.0 + 2";
		Lexer lexer = new Lexer(data);
		tokens = lexer.getTokens();
		for(Token token : tokens) {
			System.out.println(token);
		}*/
	}
}