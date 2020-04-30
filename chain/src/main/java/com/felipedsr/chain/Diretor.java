package com.felipedsr.chain;

public class Diretor extends Gestor {
    public Diretor(long limite, Gestor sucessor, String cargo) {
        super(limite, sucessor, cargo);
    }
}
