package exercice05;

import java.math.BigDecimal;

public abstract class FormaPagamento {

    // Metodo abstrato para validar os dados do pagamento (ex.: número do cartão, chave Pix)
    public abstract void validarPagamento() throws PagamentoInvalidoException;

    // Metodo abstrato para processar o pagamento
    public abstract void processarPagamento(BigDecimal valor);
}
