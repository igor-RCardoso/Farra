package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Geraldo on 22/06/2017.
 */

@DatabaseTable(tableName = "usuario")
public class Usuario {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String nome;

    @DatabaseField(canBeNull = false)
    private String user;

    @DatabaseField(canBeNull = false)
    private String senhaUser;

    @DatabaseField(canBeNull = false)
    private String emailUser;

    @DatabaseField(canBeNull = false)
    private String telefone;

    @DatabaseField(canBeNull = false)
    private String cpf;

    @DatabaseField(canBeNull = false)
    private Date dataNascimento;

    @DatabaseField(canBeNull = false)
    private boolean tipo;

    @DatabaseField(canBeNull = false)
    private int reputacao;

    @ForeignCollectionField
    private Collection<CompraVenda> compraVendaCollection;

    @ForeignCollectionField
    private Collection<ItemDeCompra> itemDeCompraCollection;


    public Usuario(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public int getReputacao() {
        return reputacao;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }

    public Collection<CompraVenda> getCompraVendaCollection() {
        return compraVendaCollection;
    }

    public void setCompraVendaCollection(Collection<CompraVenda> compraVendaCollection) {
        this.compraVendaCollection = compraVendaCollection;
    }

    public Collection<ItemDeCompra> getItemDeCompraCollection() {
        return itemDeCompraCollection;
    }

    public void setItemDeCompraCollection(Collection<ItemDeCompra> itemDeCompraCollection) {
        this.itemDeCompraCollection = itemDeCompraCollection;
    }
}
