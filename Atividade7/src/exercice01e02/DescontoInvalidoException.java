package exercice01e02;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
