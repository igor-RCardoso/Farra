package com.example.geraldo.farra.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.CompraVenda;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Ingresso;
import com.example.geraldo.farra.model.ItemDeCompra;
import com.example.geraldo.farra.model.Organizador;
import com.example.geraldo.farra.model.Tags;
import com.example.geraldo.farra.model.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Geraldo on 22/06/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String databaseName = "farrago.db";
    private static final int databaseVersion =  2;

    private Dao<Usuario, Integer> usuarioDao = null;
    private RuntimeExceptionDao<Usuario, Integer> usuarioRuntimeDao = null;

    private Dao<CompraVenda, Integer> compraVendaDao = null;
    private RuntimeExceptionDao<CompraVenda, Integer> compraVendaRuntimeDao = null;

    private Dao<Eventos, Integer> eventosDao = null;
    private RuntimeExceptionDao<Eventos, Integer> eventosRuntimeDao = null;

    private Dao<Ingresso, Integer> ingressoDao = null;
    private RuntimeExceptionDao<Ingresso, Integer> ingressoRuntimeDao = null;

    private Dao<ItemDeCompra, Integer> itemDeCompraDao = null;
    private RuntimeExceptionDao<ItemDeCompra, Integer> itemDeCompraRuntimeDao = null;

    private Dao<Organizador, Integer> organizadorDao = null;
    private RuntimeExceptionDao<Organizador, Integer> organizadorRuntimeDao = null;

    private Dao<Tags, Integer> tagsDao = null;
    private RuntimeExceptionDao<Tags, Integer> tagsRuntimeDao = null;


    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Usuario.class);
            TableUtils.createTable(connectionSource, CompraVenda.class);
            TableUtils.createTable(connectionSource, Eventos.class);
            TableUtils.createTable(connectionSource, Ingresso.class);
            TableUtils.createTable(connectionSource, ItemDeCompra.class);
            TableUtils.createTable(connectionSource, Organizador.class);
            TableUtils.createTable(connectionSource, Tags.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Usuario.class, true);
            TableUtils.dropTable(connectionSource, CompraVenda.class, true);
            TableUtils.dropTable(connectionSource, Eventos.class, true);
            TableUtils.dropTable(connectionSource, Ingresso.class, true);
            TableUtils.dropTable(connectionSource, ItemDeCompra.class, true);
            TableUtils.dropTable(connectionSource, Organizador.class, true);
            TableUtils.dropTable(connectionSource, Tags.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Usuario, Integer> getUsuarioDao() {
        return usuarioDao;
    }

    public RuntimeExceptionDao<Usuario, Integer> getUsuarioRuntimeDao() {
        return usuarioRuntimeDao;
    }

    public Dao<CompraVenda, Integer> getCompraVendaDao() throws SQLException {
        if(compraVendaDao == null) compraVendaDao = getDao(CompraVenda.class);
        return compraVendaDao;
    }

    public RuntimeExceptionDao<CompraVenda, Integer> getCompraVendaRuntimeDao() {
        if(compraVendaRuntimeDao == null) compraVendaRuntimeDao = getRuntimeExceptionDao(CompraVenda.class);
        return compraVendaRuntimeDao;
    }

    public Dao<Eventos, Integer> getEventosDao() throws SQLException {
        if(eventosDao == null) eventosDao = getDao(Eventos.class);
        return eventosDao;
    }

    public RuntimeExceptionDao<Eventos, Integer> getEventosRuntimeDao() {
        if(eventosRuntimeDao == null) eventosRuntimeDao = getRuntimeExceptionDao(Eventos.class);
        return eventosRuntimeDao;
    }

    public Dao<Ingresso, Integer> getIngressoDao() throws SQLException {
        if(ingressoDao == null) ingressoDao = getDao(Ingresso.class);
        return ingressoDao;
    }

    public RuntimeExceptionDao<Ingresso, Integer> getIngressoRuntimeDao() throws SQLException {
        if(ingressoRuntimeDao == null) ingressoRuntimeDao = getRuntimeExceptionDao(Ingresso.class);
        return ingressoRuntimeDao;
    }

    public Dao<ItemDeCompra, Integer> getItemDeCompraDao() throws SQLException {
        if(itemDeCompraDao == null) itemDeCompraDao = getDao(ItemDeCompra.class);
        return itemDeCompraDao;
    }

    public RuntimeExceptionDao<ItemDeCompra, Integer> getItemDeCompraRuntimeDao() {
        if(itemDeCompraRuntimeDao == null) itemDeCompraRuntimeDao = getRuntimeExceptionDao(ItemDeCompra.class);
        return itemDeCompraRuntimeDao;
    }

    public Dao<Organizador, Integer> getOrganizadorDao() throws SQLException {
        if(organizadorDao == null) organizadorDao = getDao(Organizador.class);
        return organizadorDao;
    }

    public RuntimeExceptionDao<Organizador, Integer> getOrganizadorRuntimeDao() throws SQLException {
        if(organizadorRuntimeDao == null) organizadorRuntimeDao = getDao(Organizador.class);
        return organizadorRuntimeDao;
    }

    public Dao<Tags, Integer> getTagsDao() throws SQLException {
        if(tagsDao == null) tagsDao = getDao(Tags.class);
        return tagsDao;
    }

    public RuntimeExceptionDao<Tags, Integer> getTagsRuntimeDao() throws SQLException {
        if(tagsRuntimeDao == null) tagsRuntimeDao = getDao(Tags.class);
        return tagsRuntimeDao;
    }

    @Override
    public void close(){
        super.close();
        compraVendaDao = null;
        compraVendaRuntimeDao = null;
        eventosDao = null;
        eventosRuntimeDao = null;
        ingressoRuntimeDao = null;
        ingressoDao = null;
        itemDeCompraDao = null;
        itemDeCompraRuntimeDao = null;
        organizadorDao = null;
        organizadorRuntimeDao = null;
        tagsRuntimeDao = null;
        tagsDao = null;
        usuarioDao = null;
        usuarioRuntimeDao = null;
    }

}
