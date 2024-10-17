//Letter.java
import java.text.CharacterIterator;
import java.util.ArrayList;


public class Letter extends AFD {
	@Override
	public Token evaluate(CharacterIterator code) {
		//palavras reservadas
		ArrayList<String> reservadas = new ArrayList<>();
		reservadas.add("if");//if
		reservadas.add("else");//else
		reservadas.add("for");//for
		reservadas.add("while");//while
		reservadas.add("int");//int
		reservadas.add("float");//float
		reservadas.add("String");//String
		reservadas.add("char");//char
		reservadas.add("return");//return
		reservadas.add("break");//break
		reservadas.add("continue");//continue
		reservadas.add("boolean");//boolean
		reservadas.add("print");//print

		if(Character.isLetter(code.current())) {
			String letter = readLetter(code);

			if (reservadas.contains(letter)){
				return new Token("RES", letter);
			}

			else if (endLetter(code)) {
				return new Token("VAR", letter);
			}
		}
		return null;
	}
	private String readLetter(CharacterIterator code) {
		String letter="";
		while (Character.isLetter(code.current())){
			letter += code.current();
			code.next();
		}
		return letter;
	}

	private boolean endLetter(CharacterIterator code){
		return code.current() == ' ' ||
		code.current() == '+' ||
		code.current() == '-' ||
		code.current() == '*' ||
		code.current() == '/' ||
		code.current() == '%' ||
		code.current() == '\n' ||
		code.current() == '(' ||
		code.current() == ')' ||
		code.current() == CharacterIterator.DONE;
	}
}