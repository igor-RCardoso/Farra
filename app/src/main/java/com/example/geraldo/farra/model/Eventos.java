package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Geraldo on 22/06/2017.
 */

@DatabaseTable(tableName = "evento")
public class Eventos implements Serializable{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String nomeEvento;

    @DatabaseField(canBeNull = false)
    private String endereco;

    @DatabaseField(canBeNull = false)
    private String horario;

    @DatabaseField(canBeNull = false)
    private String dataEvento;

    @DatabaseField(canBeNull = false)
    private int faixaEtaria;

    @DatabaseField(canBeNull = false)
    private String tema;

    @DatabaseField(canBeNull = true)
    private String tipo;

    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Organizador organizador;

    @ForeignCollectionField
    private Collection<Tags> tagsCollection;

    @ForeignCollectionField
    private Collection<Ingresso> ingressoCollection;

    public Eventos(){}

    public Eventos(int id, String nomeEvento, String endereco, String horario, String dataEvento, int faixaEtaria, String tema, String tipo, Organizador organizador) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.endereco = endereco;
        this.horario = horario;
        this.dataEvento = dataEvento;
        this.faixaEtaria = faixaEtaria;
        this.tema = tema;
        this.tipo = tipo;
        this.organizador = organizador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    public Collection<Ingresso> getIngressoCollection() {
        return ingressoCollection;
    }

    public void setIngressoCollection(Collection<Ingresso> ingressoCollection) {
        this.ingressoCollection = ingressoCollection;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "nomeEvento='" + nomeEvento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", horario='" + horario + '\'' +
                ", dataEvento=" + dataEvento +
                '}';
    }
}
