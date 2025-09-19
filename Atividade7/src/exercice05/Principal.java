package exercice05;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Valor a ser pago
        BigDecimal valorCompra = new BigDecimal("150.75");

        // Lista para demonstrar o polimorfismo
        List<FormaPagamento> pagamentos = new ArrayList<>();

        // Adicionando instâncias válidas e inválidas
        pagamentos.add(new CartaoCredito("1234567890123456", "Maria da Silva"));
        pagamentos.add(new Boleto("12345678901234567890123456789012345678901234567"));
        pagamentos.add(new Pix("joao.souza@email.com"));

        // Exemplo de pagamento inválido para testar a exceção
        pagamentos.add(new CartaoCredito("12345", "Fulano de Tal"));

        for (FormaPagamento pagamento : pagamentos) {
            System.out.println("\n--- Tentando processar pagamento com " + pagamento.getClass().getSimpleName() + " ---");
            try {
                // Primeiro, valida o pagamento
                pagamento.validarPagamento();

                // Se a validação passar, processa o pagamento
                pagamento.processarPagamento(valorCompra);
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
