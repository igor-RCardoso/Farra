package com.example.geraldo.farra.model;

import java.io.Serializable;

/**
 * Created by Geraldo on 22/06/2017.
 */

class ControladoraFachadaSingleton implements Serializable{
    Usuario usuario;

    private static final ControladoraFachadaSingleton ourInstance = new ControladoraFachadaSingleton();

    static ControladoraFachadaSingleton getInstance() {
        return ourInstance;
    }

    private ControladoraFachadaSingleton() {
    }

    private void CompraVendaDao(){

    }
}
