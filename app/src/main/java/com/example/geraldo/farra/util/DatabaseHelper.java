package com.example.geraldo.farra.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.dao.OrganizadorDao;
import com.example.geraldo.farra.model.CompraVenda;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Ingresso;
import com.example.geraldo.farra.model.ItemDeCompra;
import com.example.geraldo.farra.model.Organizador;
import com.example.geraldo.farra.model.Tags;
import com.example.geraldo.farra.model.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Geraldo on 22/06/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String databaseName = "farrago.db";
    private static final int databaseVersion =  30;

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

            getUsuarioDao().updateRaw("INSERT INTO Usuario(id,nome,user,senhaUser,emailUser,telefone,cpf,dataNascimento,tipo) VALUES" +
                            "(0,'Fabio','Fabio','1234','fabio.godoy@ufv.br','9999999999','99999999999','05/11/1996',0)," +
                            "(1,'Igor','Igor','1234','igor.cardoso@ufv.br','9999999999','99999999999','24/04/1994',0)," +
                            "(2,'Julio','Julio','1234','julio.pinheiro@ufv.br','9999999999','99999999999','17/10/1996',0);");
            getOrganizadorDao().updateRaw("INSERT INTO Organizador(id,noeFantasia,nomeReal,nomeResponsavel,emailOrg,senhaOrg,endereco,telefone,cnpj) VALUES" +
                    "(0, 'Eventos Legais S/A', 'Evento Legais S/A', 'Joesley', 'eventoslegais@gmail.com', '1234', 'Brasil', '9999999999', '99999999999')," +
                    "(1, 'Eventos Bacanas S/A', 'Eventos Bacanas S/A', 'Wesley', 'eventosbacanas@gmail.com', '1234', 'Brasil', '9999999999', '99999999999');");

            Log.i("Cadastrado","olar");
            getEventosDao().updateRaw("INSERT INTO Evento(id,organizador_id,nomeEvento,endereco,horario,dataEvento,faixaEtaria,tema) VALUES" +
                    "(0,0,'Evento muito legal', 'Brasil', '20:00', '08/07/2017', '16', 'Legal')," +
                    "(1,0,'Evento super legal', 'Brasil', '20:00', '21/10/2017', '16', 'Super Legal')," +
                    "(2,1,'Evento ultra legal', 'Brasil', '20:00', '30/11/2017', '16', 'Ultra Legal');");
            getIngressoDao().updateRaw("INSERT INTO Ingresso(id,sexo,lote,preco,qtdDisponivel,evento_id) VALUES" +
                    "(0,'Masculino',1,40.0,213,0)," +
                    "(1,'Feminino',2,45.0,320,1)," +
                    "(2,'Unissex',2,35.0,230,2);");
            getItemDeCompraDao().updateRaw("INSERT INTO itemDeCompra(id,compraVenda_id,usuario_id,ingresso_id) VALUES" +
                    "(0,0,0,0)," +
                    "(1,0,0,1)," +
                    "(2,0,0,2)," +
                    "(3,1,1,0)," +
                    "(4,1,1,1)," +
                    "(5,2,2,2);");
            getCompraVendaDao().updateRaw("INSERT INTO compraVenda(id,avaliacao,comentario,usuario_id) VALUES" +
                    "(0,'muito bom', 'muito bom', 0)," +
                    "(1,'muito bom', 'muito bom', 1)," +
                    "(2,'muito bom', 'muito bom', 2);");
        } catch (SQLException e) {
            Log.e("Cadastrado", "erro", e);
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

    public Dao<Usuario, Integer> getUsuarioDao() throws SQLException {
        if(usuarioDao == null) usuarioDao = getDao(Usuario.class);
        return usuarioDao;
    }

    public RuntimeExceptionDao<Usuario, Integer> getUsuarioRuntimeDao() {
        if(usuarioRuntimeDao == null) usuarioRuntimeDao = getRuntimeExceptionDao(Usuario.class);
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
