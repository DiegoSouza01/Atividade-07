package exercice06;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        // 1. Criação de produtos
        Produto arroz = new Produto("Arroz", new Dinheiro("25.50", Moeda.BRL));
        Produto feijao = new Produto("Feijao", new Dinheiro("15.00", Moeda.BRL));

        // 2. Criação do carrinho inicial
        Carrinho carrinho1 = new Carrinho();
        carrinho1.exibirItens();

        // 3. Adicionando itens - retorna um NOVO carrinho
        System.out.println("\nAdicionando itens ao carrinho...");
        Carrinho carrinho2 = carrinho1.adicionarItem(new ItemCarrinho(arroz, 2));
        Carrinho carrinho3 = carrinho2.adicionarItem(new ItemCarrinho(feijao, 1));
        carrinho3.exibirItens();

        // 4. Aplicando cupom - retorna um NOVO carrinho
        System.out.println("\nAplicando cupom de 10%...");
        Carrinho carrinhoComDesconto = carrinho3.aplicarCupom(new BigDecimal("0.10"));
        carrinhoComDesconto.exibirItens();

        // 5. Tentativa de operação inválida (quantidade negativa)
        System.out.println("\nTentando adicionar item com quantidade inválida...");
        try {
            carrinho1.adicionarItem(new ItemCarrinho(arroz, -1));
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 6. Tentativa de cupom inválido (maior que 30%)
        System.out.println("\nTentando aplicar cupom com porcentagem inválida (50%)...");
        try {
            carrinho3.aplicarCupom(new BigDecimal("0.50"));
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 7. Demonstração de que os objetos originais não foram modificados
        System.out.println("\nVerificando o carrinho original (carrinho1)...");
        carrinho1.exibirItens();
    }
}
