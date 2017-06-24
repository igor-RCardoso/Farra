package com.example.geraldo.farra.dao;

import android.content.Context;

import com.example.geraldo.farra.model.CompraVenda;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Organizador;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Geraldo on 23/06/2017.
 */

public class OrganizadorDao  extends BaseDaoImpl<Organizador, Integer>  {

    public OrganizadorDao(ConnectionSource cs) throws SQLException{
        super(Organizador.class);
        setConnectionSource(cs);
        initialize();
    }

}
