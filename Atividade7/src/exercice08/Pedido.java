package exercice08;

import java.math.BigDecimal;

public class Pedido {
    private final String cepOrigem;
    private final String cepDestino;
    private final BigDecimal valorTotal;
    private CalculadoraFrete calculadoraFrete;

    public Pedido(String cepOrigem, String cepDestino, BigDecimal valorTotal) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.valorTotal = valorTotal;
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public BigDecimal calcularFrete() {
        if (calculadoraFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete foi definida.");
        }
        return calculadoraFrete.calcular(this);
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
