package exercice04;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<IMeioTransporte> meiosDeTransporte = new ArrayList<>();

        meiosDeTransporte.add(new Carro());
        meiosDeTransporte.add(new Bicicleta());
        meiosDeTransporte.add(new Trem());

        for (IMeioTransporte meioTransporte : meiosDeTransporte) {
            System.out.println("\n--- Acelerando um " + meioTransporte.getClass().getSimpleName() + " ---");
            try {
                // Acelera 3 vezes para demonstrar a mudança de velocidade
                meioTransporte.acelerar();
                meioTransporte.acelerar();
                meioTransporte.acelerar();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("--- Freando um " + meioTransporte.getClass().getSimpleName() + " ---");
            try {
                meioTransporte.frear();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}