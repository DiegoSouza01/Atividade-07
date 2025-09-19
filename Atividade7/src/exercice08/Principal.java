package exercice08;

import java.math.BigDecimal;


public class Principal {
        public static void main(String[] args) {
            Pedido pedido1 = new Pedido("12345000", "98765000", new BigDecimal("50.00"));

            Pedido pedido2 = new Pedido("12345000", "98765000", new BigDecimal("150.00"));

            System.out.println("--- Estratégia Inicial: Sedex ---");
            pedido1.setCalculadoraFrete(new Sedex());
            System.out.println("Frete para pedido 1 (Sedex): R$ " + pedido1.calcularFrete());

            System.out.println("\n--- Trocando para Estratégia: PAC ---");
            pedido1.setCalculadoraFrete(new Pac());
            System.out.println("Frete para pedido 1 (PAC): R$ " + pedido1.calcularFrete());

            System.out.println("\n--- Estratégia Promocional (via Lambda) ---");
            CalculadoraFrete freteGratis = p -> {
                if (p.getValorTotal().compareTo(new BigDecimal("100.00")) > 0) {
                    return BigDecimal.ZERO;
                } else {
                    return new BigDecimal("10.00"); // Frete padrão promocional
                }
            };

            pedido1.setCalculadoraFrete(freteGratis);
            System.out.println("Frete para pedido 1 (promoção): R$ " + pedido1.calcularFrete());

            pedido2.setCalculadoraFrete(freteGratis);
            System.out.println("Frete para pedido 2 (promoção): R$ " + pedido2.calcularFrete());

            Pedido pedidoInvalido = new Pedido("12345000", "98765", new BigDecimal("30.00"));
            System.out.println("\n--- Tentando calcular frete com CEP inválido ---");
            try {
                pedidoInvalido.setCalculadoraFrete(new Sedex());
                pedidoInvalido.calcularFrete();
            } catch (FreteInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
}
