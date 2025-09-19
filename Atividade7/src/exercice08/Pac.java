package exercice08;

import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        if (pedido.getCepDestino().length() != 8) {
            throw new FreteInvalidoException("CEP de destino inválido para PAC.");
        }
        return new BigDecimal("15.00");
    }
}
