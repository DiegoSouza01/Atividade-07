package exercice08;

import java.math.BigDecimal;

public class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        if (pedido.getCepDestino().length() != 8) {
            throw new FreteInvalidoException("CEP de destino inválido para Sedex.");
        }
        return new BigDecimal("25.50");
    }
}
