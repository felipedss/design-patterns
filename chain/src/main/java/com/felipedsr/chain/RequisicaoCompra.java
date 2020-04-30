package com.felipedsr.chain;

public class RequisicaoCompra {

    private final long valor;
    private final String descricao;

    public RequisicaoCompra(long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public long getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
