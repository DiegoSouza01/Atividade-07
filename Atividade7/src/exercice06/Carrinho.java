package exercice06;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal descontoPorcentagem;

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.descontoPorcentagem = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal descontoPorcentagem) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.add(item);
        return new Carrinho(novaLista, this.descontoPorcentagem);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itens);
        novaLista.remove(item);
        return new Carrinho(novaLista, this.descontoPorcentagem);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem == null || porcentagem.compareTo(new BigDecimal("0.30")) > 0 || porcentagem.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValorInvalidoException("A porcentagem do cupom deve ser entre 0% e 30%.");
        }
        return new Carrinho(this.itens, porcentagem);
    }

    public Dinheiro getValorTotal() {
        if (itens.isEmpty()) {
            return new Dinheiro("0", Moeda.BRL);
        }

        // Inicializa o total com o primeiro item para evitar problemas de moeda
        Dinheiro total = itens.get(0).getSubtotal();

        // Soma os subtotais dos itens restantes
        for (int i = 1; i < itens.size(); i++) {
            total = total.somar(itens.get(i).getSubtotal());
        }

        if (descontoPorcentagem.compareTo(BigDecimal.ZERO) > 0) {
            return total.aplicarDesconto(descontoPorcentagem);
        }

        return total;
    }

    public void exibirItens() {
        System.out.println("--- Conteúdo do Carrinho ---");
        itens.forEach(item -> {
            System.out.println("Produto: " + item.getProduto().getNome() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço Unitário: " + item.getProduto().getPreco());
        });
        System.out.println("--------------------------");
        System.out.println("Total: " + getValorTotal());
    }
}
