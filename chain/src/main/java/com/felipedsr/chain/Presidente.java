package com.felipedsr.chain;

public class Presidente extends Gestor {
    public Presidente(long limite, Gestor sucessor, String cargo) {
        super(limite, sucessor, cargo);
    }
}
