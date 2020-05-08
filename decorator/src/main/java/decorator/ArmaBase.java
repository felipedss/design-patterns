package decorator;

public class ArmaBase implements Arma {
    @Override
    public void montar() {
        System.out.println("Esta é uma arma base");
    }
}
