package com.example.geraldo.farra.model;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.geraldo.farra.dao.EventoDao;
import com.example.geraldo.farra.dao.OrganizadorDao;
import com.example.geraldo.farra.dao.UsuarioDao;
import com.example.geraldo.farra.util.DatabaseHelper;
import com.example.geraldo.farra.util.MyApp;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Geraldo on 22/06/2017.
 */

public final class ControladoraFachadaSingleton implements Serializable{
    Usuario usuario;
    DatabaseHelper db;
    List<Eventos> eventos;

    private static final ControladoraFachadaSingleton ourInstance = new ControladoraFachadaSingleton();

    static ControladoraFachadaSingleton getInstance() {
        return ourInstance;
    }

    public static ControladoraFachadaSingleton getOurInstance() {
        return ourInstance;
    }

    private ControladoraFachadaSingleton() {
        db = new DatabaseHelper(MyApp.getContext());
        try {
            List<Usuario> aux = db.getUsuarioDao().queryForAll();
            for(Usuario a : aux) {
                Log.i("Cadastrado", a.getId() + " " + a.getNome());
            }
            List<Organizador> aux1 = db.getOrganizadorDao().queryForAll();
            for(Organizador a : aux1) {
                Log.i("Cadastrado", a.getId() + " " + a.getNoeFantasia());
            }
            List<Eventos> aux2 = db.getEventosDao().queryForAll();
            for(Eventos a : aux2) {
                Log.i("Cadastrado", a.getId() + " " + a.getNomeEvento());
            }
            List<Ingresso> aux3 = db.getIngressoDao().queryForAll();
            for(Ingresso a : aux3) {
                Log.i("Cadastrado", a.getId() + " " + a.getQtdDisponivel());
            }
            List<ItemDeCompra> aux4 = db.getItemDeCompraDao().queryForAll();
            for(ItemDeCompra a : aux4) {
                Log.i("Cadastrado", a.getId() + " ");
            }
            List<CompraVenda> aux5 = db.getCompraVendaDao().queryForAll();
            for(CompraVenda a : aux5){
                Log.i("Cadastrado", a.getId() + " " + a.getAvalicao());
            }
            daoEventos();
        } catch (SQLException e) {
            Log.e("Cadastrado", "erro_CFS construtor", e);
            e.printStackTrace();
        }
    }

    private void daoEventos() throws SQLException {
        eventos = db.getEventosDao().queryForAll();
    }

    public List<Eventos> getEventos() throws SQLException {
        return eventos;
    }

}
