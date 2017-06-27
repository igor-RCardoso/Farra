package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Geraldo on 22/06/2017.
 */
@DatabaseTable(tableName = "itemDeCompra")
public class ItemDeCompra implements Serializable {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = true)
    private String marcador;

    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private CompraVenda compraVenda;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignColumnName = "id")
    private Usuario usuario;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignColumnName = "id")
    private Ingresso ingresso;

    public ItemDeCompra(){}

    public ItemDeCompra(CompraVenda compraVenda, Usuario usuario, Ingresso ingresso, String marcador) {
        this.compraVenda = compraVenda;
        this.usuario = usuario;
        this.ingresso = ingresso;
        this.marcador = marcador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompraVenda getCompraVenda() {
        return compraVenda;
    }

    public void setCompraVenda(CompraVenda compraVenda) {
        this.compraVenda = compraVenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}
