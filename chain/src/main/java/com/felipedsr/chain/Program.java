package com.felipedsr.chain;

public class Program {

    public static void main(String[] args) {
        Presidente presidente = new Presidente(300, null, "Presidente");
        VicePresidente vicePresidente = new VicePresidente(200, presidente, "Vice Presidente");
        Diretor diretor = new Diretor(100, vicePresidente, "Diretor");
        RequisicaoCompra compra = new RequisicaoCompra(350, "Computador");
        diretor.processar(compra);
    }
}
