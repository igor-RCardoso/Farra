package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by Geraldo on 22/06/2017.
 */
@DatabaseTable(tableName = "compraVenda")
public class CompraVenda {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String avaliacao;

    @DatabaseField(canBeNull = false)
    private String comentario;

    public CompraVenda(String avaliacao, String comentario, Usuario usuario) {
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    @DatabaseField(foreign = true, foreignAutoCreate = true)

    private Usuario usuario;

    @ForeignCollectionField
    private Collection<ItemDeCompra> itemDeCompraCollection;

    public CompraVenda(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvalicao() {
        return avaliacao;
    }

    public void setAvalicao(String avalicao) {
        this.avaliacao = avalicao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<ItemDeCompra> getItemDeCompraCollection() {
        return itemDeCompraCollection;
    }

    public void setItemDeCompraCollection(Collection<ItemDeCompra> itemDeCompraCollection) {
        this.itemDeCompraCollection = itemDeCompraCollection;
    }
}
