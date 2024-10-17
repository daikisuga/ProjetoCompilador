import java.util.List;

public class Parser {
    List<Token> tokens;
    Token token;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }
    public Token nextToken(){
        return (tokens.size() > 0) ? tokens.remove(0) : null; //Operador ternário
    }
    private void erro(String regra){
        System.out.println("Regra: " + regra);
        System.out.println("token inválido: " + token.getLexema());
        System.exit(0); //encerra o parser
    }
    
    public void main(){
        token = nextToken();
        if(verifica()){
            if(token.getTipo().equals("EOF")){
                System.out.println("Sintaticamente correto");
            }else{
                erro("EOF");
            }
        }else{
            erro("fim do ifelse");
        }
    }

    public boolean verifica(){
        if(token.getLexema().equals("if")){
            if(ifelse()) return true;
        }else if(token.getLexema().equals("while")){
            if(whilee()) return true;
        }
        erro("verifica");
        return false;
    }

    public boolean ifelse(){
        if(matchL("if") && condicao() && matchL(":") && expressao() && matchL("else") && matchL(":") && expressao()){
            return true;
        }
        erro("ifelse");
        return false;
    }

    public boolean whilee(){
        if(matchL("while") && condicao() && matchL(":") && expressao()){
            return true;
        }
        erro("whilee");
        return false;
    }

    public boolean condicao(){
        if(matchT("VAR") && operador() && (matchT("INT") || matchT("FLT"))){
            return true;
        }
        erro("condicao");
        return false;
    }

    public boolean expressao(){
        if(matchT("VAR") && matchL("=") && (matchT("INT") || matchT("FLT"))){
            return true;
        }
        erro("expressao");
        return false;
    }

    public boolean operador(){
        if(matchL(">") || matchL("<") || matchL("==")){
            return true;
        }
        erro("operador");
        return false;
    }

    private boolean matchL(String lexema){
        if(token.getLexema().equals(lexema)){
            token = nextToken();
            return true;
        }
        return false;
    }

    private boolean matchT(String tipo){
        if(token.getTipo().equals(tipo)){
            token = nextToken();
            return true;
        }
        return false;
    }

}