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
