package exercice06;

import java.math.BigDecimal;

public class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new ValorInvalidoException("A quantidade do item deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Corrigido: Agora retorna um objeto Dinheiro
    public Dinheiro getSubtotal() {
        return new Dinheiro(produto.getPreco().getValor().multiply(BigDecimal.valueOf(quantidade)), produto.getPreco().getMoeda());
    }
}
