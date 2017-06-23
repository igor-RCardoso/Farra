package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Geraldo on 22/06/2017.
 */
@DatabaseTable(tableName = "itemDeCompra")
public class ItemDeCompra {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true)
    private CompraVenda compraVenda;

    @DatabaseField(foreign = true)
    private Usuario usuario;

    @DatabaseField(foreign = true)
    private Ingresso ingresso;

    public ItemDeCompra(){}

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
