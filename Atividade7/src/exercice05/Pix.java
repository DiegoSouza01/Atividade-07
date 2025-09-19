package exercice05;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        // Exemplo de validação simples para a chave Pix
        if (chavePix == null || chavePix.isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix não pode ser nula ou vazia.");
        }
        // Validações mais complexas poderiam ser adicionadas aqui (ex.: formato de CPF, e-mail)
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " com Pix para a chave " + chavePix + ".");
        // Lógica real de processamento de Pix
        System.out.println("Transferência Pix realizada com sucesso.");
    }
}
