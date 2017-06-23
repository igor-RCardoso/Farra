package com.example.geraldo.farra.dao;

import android.content.Context;

import com.example.geraldo.farra.model.CompraVenda;
import com.example.geraldo.farra.model.ItemDeCompra;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Geraldo on 23/06/2017.
 */

public class ItemDeCompraDao  extends BaseDaoImpl<ItemDeCompra, Integer> {
    public ItemDeCompraDao(ConnectionSource cs) throws SQLException {
        super(ItemDeCompra.class);
        setConnectionSource(cs);
        initialize();
    }

}
