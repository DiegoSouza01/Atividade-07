package exercice06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValorInvalidoException("O valor do dinheiro não pode ser nulo ou negativo.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = Objects.requireNonNull(moeda, "A moeda não pode ser nula.");
    }

    public Dinheiro(String valor, Moeda moeda) {
        this(new BigDecimal(valor), moeda);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro somar(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new ValorInvalidoException("Não é possível somar moedas diferentes.");
        }
        return new Dinheiro(this.valor.add(outro.valor), this.moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new ValorInvalidoException("Não é possível subtrair moedas diferentes.");
        }
        return new Dinheiro(this.valor.subtract(outro.valor), this.moeda);
    }

    // Método para aplicar desconto
    public Dinheiro aplicarDesconto(BigDecimal porcentagem) {
        if (porcentagem == null || porcentagem.compareTo(new BigDecimal("0.30")) > 0 || porcentagem.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValorInvalidoException("A porcentagem do cupom deve ser entre 0% e 30%.");
        }
        BigDecimal valorDesconto = this.valor.multiply(porcentagem);
        return new Dinheiro(this.valor.subtract(valorDesconto), this.moeda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return Objects.equals(valor, dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return moeda + " " + valor;
    }
}
