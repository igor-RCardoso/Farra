package com.example.geraldo.farra.controller;

import com.example.geraldo.farra.model.Ingresso;

import java.io.Serializable;

/**
 * Created by Fábio on 25/06/2017.
 */

public class ListaIngressos implements Serializable {
    private Ingresso[] listaIngresso;
    private int[] listaQtd;
    private int n;

    public ListaIngressos(Ingresso[] listaIngresso, int[] listaQtd, int n) {
        this.listaIngresso = listaIngresso;
        this.listaQtd = listaQtd;
        this.n = n;
    }

    public Ingresso[] getListaIngresso() {
        return listaIngresso;
    }

    public int[] getListaQtd() {
        return listaQtd;
    }

    public int getN() {
        return n;
    }
}
