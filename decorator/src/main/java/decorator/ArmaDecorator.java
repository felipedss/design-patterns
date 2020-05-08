package decorator;

public class ArmaDecorator implements Arma {

    private final Arma arma;

    public ArmaDecorator(Arma arma) {
        this.arma = arma;
    }

    @Override
    public void montar() {
        this.arma.montar();
    }
    
}
