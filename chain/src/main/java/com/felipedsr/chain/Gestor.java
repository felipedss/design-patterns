package com.felipedsr.chain;

public abstract class Gestor {

    private final long limite;
    private final Gestor sucessor;
    private final String cargo;

    public Gestor(long limite, Gestor sucessor, String cargo) {
        this.limite = limite;
        this.sucessor = sucessor;
        this.cargo = cargo;
    }

    public void processar(RequisicaoCompra compra) {
        if (compra.getValor() <= limite) {
            System.out.println(String.format("%s aprovou a compra no valor de %d", cargo, compra.getValor()));
        } else if (sucessor != null) {
            sucessor.processar(compra);
        } else {
            throw new CompraNaoAprovadaException("Compra não aprovada");
        }
    }
}
