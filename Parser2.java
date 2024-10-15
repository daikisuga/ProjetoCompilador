import java.util.List;

public class Parser2 {
    List<Token> tokens;
    Token token;

    public Parser2(List<Token> tokens){
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
        if( whilee()){
            if(token.getTipo() == "EOF"){
                System.out.println("Sintaticamente correto");
            }else{
                erro("EOF");
            }
        }else if(whilee()){
            if(token.getTipo() == "EOF"){
                System.out.println("Loopitamente correto");
            }
        }else{
            erro("fim do ifelse");
        }
    }

    public boolean ifelse(){
        if(matchL("if") && condicao() && matchL("then") && expressao() && matchL("else") && expressao()){
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
        if(matchT("id") && operador() && matchT("num")){
            return true;
        }
        erro("condicao");
        return false;
    }

    public boolean expressao(){
        if(matchT("id") && matchL("=") && matchT("num")){
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
        if(token.getLexema() == lexema){
            token = nextToken();
            return true;
        }
        return false;
    }

    private boolean matchT(String tipo){
        if(token.getTipo() == tipo){
            token = nextToken();
            return true;
        }
        return false;
    }

}