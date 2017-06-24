package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by Geraldo on 22/06/2017.
 */

@DatabaseTable(tableName = "ingresso")
public class Ingresso {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private  String sexo;

    @DatabaseField(canBeNull = false)
    private  int lote;

    @DatabaseField(canBeNull = false)
    private double preco;

    @DatabaseField(canBeNull = false)
    private int qtdDisponivel;

    @DatabaseField(foreign = true)
    private Eventos evento;

    @DatabaseField(foreign = true)
    private Organizador organizador;

    @ForeignCollectionField
    private Collection<ItemDeCompra> itemDeCompraCollection;


    public Ingresso(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Collection<ItemDeCompra> getItemDeCompraCollection() {
        return itemDeCompraCollection;
    }

    public void setItemDeCompraCollection(Collection<ItemDeCompra> itemDeCompraCollection) {
        this.itemDeCompraCollection = itemDeCompraCollection;
    }
}
