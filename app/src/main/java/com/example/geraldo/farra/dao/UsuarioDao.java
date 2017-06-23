package com.example.geraldo.farra.dao;

import com.example.geraldo.farra.model.Organizador;
import com.example.geraldo.farra.model.Usuario;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by usuario on 23/06/2017.
 */

public class UsuarioDao extends BaseDaoImpl<Usuario, Integer> {
    public UsuarioDao(ConnectionSource cs) throws SQLException {
        super(Usuario.class);
        setConnectionSource(cs);
        initialize();
    }
}
