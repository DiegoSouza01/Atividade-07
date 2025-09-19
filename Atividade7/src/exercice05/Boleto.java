package exercice05;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        // Exemplo de validação simples para código de barras de 47 dígitos
        if (codigoBarras == null || !codigoBarras.matches("\\d{47}")) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido. Deve conter 47 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        System.out.println("Processando pagamento de R$" + valor + " com Boleto.");
        // Lógica real de processamento de boleto
        System.out.println("Boleto gerado com sucesso. Aguardando o pagamento.");
    }
}
