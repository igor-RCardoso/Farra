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


    private static final ControladoraFachadaSingleton ourInstance = new ControladoraFachadaSingleton();

    static ControladoraFachadaSingleton getInstance() {
        return ourInstance;
    }

    public static ControladoraFachadaSingleton getOurInstance() {
        return ourInstance;
    }

    private ControladoraFachadaSingleton() {
        db = new DatabaseHelper(MyApp.getContext());

        Log.i("Cadastrado", "oi");
//        try {
//            // UsuarioDao usuarioDao= new UsuarioDao(dh.getConnectionSource());
//            UsuarioDao usuarioDao = new UsuarioDao(db.getConnectionSource());
//            List<Usuario> aux3 = usuarioDao.queryForAll();
//            for(Usuario o : aux3) {
//                Log.i("Cadastrado", o.getId()+" "+o.getNome()+" "+o.getCpf());
//            }
//            OrganizadorDao organizadorDao = new OrganizadorDao(db.getConnectionSource());
//            List<Organizador> aux = organizadorDao.queryForAll();
//            for(Organizador o : aux) {
//                Log.i("Cadastrado", o.getId()+" "+o.getCnpj()+" "+o.getEndereco());
//            }
//            EventoDao eventoDao = new EventoDao(db.getConnectionSource());
//            List<Eventos> aux2 = eventoDao.queryForAll();
//            for(Eventos o : aux2) {
//                Log.i("Cadastrado", o.getId()+" "+o.getOrganizador().getNoeFantasia()+" "+o.getEndereco());
//            }
//        } catch (SQLException e) {
//            Log.e("Cadastrado", "erro", e);
//            e.printStackTrace();
//        }

    }
}
