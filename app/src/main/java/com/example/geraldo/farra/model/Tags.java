package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Geraldo on 22/06/2017.
 */

@DatabaseTable(tableName = "tags")
public class Tags {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String descricao;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(foreign = true, foreignAutoCreate = true)
    private Eventos evento;

    public Tags(){}

    public Tags(int id, String descricao, String nome, Eventos evento) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }
}
