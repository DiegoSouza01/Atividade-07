package exercice05;

public class PagamentoInvalidoException extends IllegalArgumentException {
    public PagamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}