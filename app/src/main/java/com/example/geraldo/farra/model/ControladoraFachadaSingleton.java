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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Geraldo on 22/06/2017.
 */

public final class ControladoraFachadaSingleton implements Serializable{
    private Usuario usuario;
    private DatabaseHelper db;
    private List<Eventos> eventos;

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
//            List<Usuario> aux = db.getUsuarioDao().queryForAll();
//            for(Usuario a : aux) {
//                Log.i("Cadastrado", a.getId() + " " + a.getNome());
//            }
//            List<Organizador> aux1 = db.getOrganizadorDao().queryForAll();
//            for(Organizador a : aux1) {
//                Log.i("Cadastrado", a.getId() + " " + a.getNoeFantasia());
//                for(Eventos b : a.getEventosCollection()) {
//                    Log.i("Cadastrado", "   " + b.getId() + " " + b.getNomeEvento());
//                }
//            }
            List<Ingresso> aux3 = db.getIngressoDao().queryForAll();
            for(Ingresso a : aux3) {
                Log.i("Cadastrado", a.getId() + " " + a.getEvento().getNomeEvento());
            }
            List<ItemDeCompra> aux4 = db.getItemDeCompraDao().queryForAll();
            for(ItemDeCompra a : aux4) {
                Log.i("Cadastrado", a.getId() + " " + a.getUsuario().getNome());
            }
            List<CompraVenda> aux5 = db.getCompraVendaDao().queryForAll();
            for(CompraVenda a : aux5){
                Log.i("Cadastrado", a.getId() + " " + a.getAvalicao());
            }
            daoEventos();
            daoUsuario();
        } catch (SQLException e) {
            Log.e("Cadastrado", "erro_CFS construtor", e);
            e.printStackTrace();
        }
    }

    private void daoUsuario() throws SQLException {
        usuario = db.getUsuarioDao().queryForId(2);
    }

    public Usuario getUsuario(){
        return usuario;
    }


    private void daoEventos() throws SQLException {
        eventos = db.getEventosDao().queryForAll();
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public boolean comprarIngresso(Usuario u, Ingresso i[], int qtd[], int n) {
        for(int j = 0; j < n; j++) {
            if (qtd[j] > i[j].getQtdDisponivel()) {
                return false;
            }
        }

        for(ItemDeCompra it : u.getItemDeCompraCollection()) {
            for(int j = 0; j < n; j++) {
                if (it.getIngresso().getId() == i[j].getId()) {
                    return false;
                }
            }
        }

        CompraVenda cv = new CompraVenda(" ", " ",u);

        try {
            db.getCompraVendaDao().create(cv);
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < qtd[j]; k++) {
                    if (qtd[k] > 0) {
                        Log.i("Pagamento", "caiu aqui");
                        ItemDeCompra item = new ItemDeCompra(cv,u,i[j]," ");
                        db.getItemDeCompraDao().updateRaw("INSERT INTO itemDeCompra(compraVenda_id,usuario_id,ingresso_id) VALUES" +
                                "("+ cv.getId() +","+u.getId()+","+i[j].getId()+");");
                    }
                }
                Log.i("Pagamento", "caiu aqui2");
                i[j].setQtdDisponivel(i[j].getQtdDisponivel()-qtd[j]);
                db.getIngressoDao().updateId(i[j],i[j].getId());
                Log.i("Pagamento", "caiu aqui3");
            }
            List<ItemDeCompra> aux4 = db.getItemDeCompraDao().queryForAll();
            for(ItemDeCompra a : aux4) {
                Log.i("Pagamento", a.getId() + " " + a.getUsuario().getNome() + " " + a.getIngresso().getEvento().getNomeEvento());
            }
        } catch (SQLException e) {
            Log.e("Pagamento", "erro", e);
            e.printStackTrace();
        }
        return true;
    }


}
