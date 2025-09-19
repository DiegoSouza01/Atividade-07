package exercice05;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {
    private String numeroCartao;
    private String titular;

    public CartaoCredito(String numeroCartao, String titular) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        // Valida se o número do cartão tem 16 dígitos
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new PagamentoInvalidoException("Número de cartão de crédito inválido. Deve conter 16 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " com Cartão de Crédito para o titular " + titular + ".");
        // Lógica real de processamento de cartão de crédito (simulação)
        System.out.println("Pagamento com Cartão de Crédito concluído com sucesso.");
    }
}
