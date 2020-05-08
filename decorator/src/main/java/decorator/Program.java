package decorator;

public class Program {

    public static void main(String[] args) {

        //Arma completa;
        Arma armaCompleta = new Silenciador(new Mira(new ArmaBase()));
        armaCompleta.montar();

        System.out.println("=======================================");
        //Esta é uma arma sem acessórios;
        Arma armaSemAcessorios = new ArmaBase();
        armaSemAcessorios.montar();

        System.out.println("=======================================");
        //Esta é uma arma com silenciador;
        Arma armaComSilenciador = new Silenciador(armaSemAcessorios);
        armaComSilenciador.montar();

        System.out.println("=======================================");
        /* Monta uma arma com mira */
        Arma armaComMira = new Mira(armaSemAcessorios);
        armaComMira.montar();
    }
}
