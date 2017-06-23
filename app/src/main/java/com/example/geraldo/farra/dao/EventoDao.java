package com.example.geraldo.farra.dao;

import android.content.Context;

import com.example.geraldo.farra.model.CompraVenda;
import com.example.geraldo.farra.model.Eventos;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Geraldo on 23/06/2017.
 */

public class EventoDao  extends BaseDaoImpl<Eventos, Integer> {
    public EventoDao(ConnectionSource cs) throws SQLException {
        super(Eventos.class);
        setConnectionSource(cs);
        initialize();
    }
}
