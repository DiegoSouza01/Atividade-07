package exercice04;

public class Trem implements IMeioTransporte {
    private int velocidade;
    private final int limiteVelocidade;

    public Trem() {
        this.velocidade = 0;
        this.limiteVelocidade = 120;
    }

    @Override
    public void acelerar() throws IllegalStateException {
        if (this.velocidade < this.limiteVelocidade) {
            this.velocidade += 20;
            System.out.println("Trem acelerando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalStateException("Trem atingiu o limite de velocidade!");
        }
    }

    @Override
    public void frear() throws IllegalStateException {
        if (this.velocidade > 0) {
            this.velocidade -= 20;
            System.out.println("Trem freando, velocidade atual: " + this.velocidade);
        } else {
            throw new IllegalStateException("Trem já está parado!");
        }
    }
}