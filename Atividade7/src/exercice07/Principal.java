package exercice07;

public class Principal {
    public static void main(String[] args) {
        System.out.println("--- Repositório de Produtos ---");
        IRepository<Produto, Integer> produtoRepository = new InMemoryRepository<>();

        Produto produto1 = new Produto(1, "Caneta", 2.00);
        Produto produto2 = new Produto(2, "Caderno", 15.50);

        // Salvar produtos
        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        // Listar todos os produtos
        System.out.println("Listando todos os produtos:");
        produtoRepository.getAll().forEach(p -> System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome()));

        // Buscar por ID (existente)
        produtoRepository.getId(1).ifPresent(p -> System.out.println("\nProduto encontrado com ID 1: " + p.getNome()));

        // Remover um produto
        System.out.println("\nRemovendo produto com ID 2...");
        produtoRepository.remover(2);

        // Listar novamente para verificar a remoção
        System.out.println("Listando produtos após a remoção:");
        produtoRepository.getAll().forEach(p -> System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome()));

        // Tentar remover um produto inexistente (tratamento de exceção)
        try {
            System.out.println("\nTentando remover produto com ID 99 (inexistente)...");
            produtoRepository.remover(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\n--- Repositório de Funcionários ---");
        IRepository<Funcionario, String> funcionarioRepository = new InMemoryRepository<>();

        Funcionario func1 = new Funcionario("A123", "João Silva", 5000.00);
        Funcionario func2 = new Funcionario("B456", "Maria Oliveira", 7500.00);

        // Salvar funcionários
        funcionarioRepository.salvar(func1);
        funcionarioRepository.salvar(func2);

        // Listar todos os funcionários
        System.out.println("Listando todos os funcionários:");
        funcionarioRepository.getAll().forEach(f -> System.out.println("ID: " + f.getId() + ", Nome: " + f.getNome()));

        // Buscar por ID (existente)
        funcionarioRepository.getId("A123").ifPresent(f -> System.out.println("\nFuncionário encontrado com ID A123: " + f.getNome()));
    }
}
