package com.example.geraldo.farra.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by Geraldo on 22/06/2017.
 */
@DatabaseTable(tableName = "organizador")
public class Organizador {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String noeFantasia;

    @DatabaseField(canBeNull = false)
    private String nomeReal;

    @DatabaseField(canBeNull = false)
    private String nomeResponsavel;

    @DatabaseField(canBeNull = false)
    private String emailOrg;

    @DatabaseField(canBeNull = false)
    private String senhaOrg;

    @DatabaseField(canBeNull = false)
    private String endereco;

    @DatabaseField(canBeNull = false)
    private String telefone;

    @DatabaseField(canBeNull = false)
    private String cnpj;

    @ForeignCollectionField
    private Collection<Eventos> eventosCollection;

    @ForeignCollectionField
    private Collection<Ingresso> ingressoCollection;


    public Organizador(){}


    public Organizador(int id, String noeFantasia, String nomeReal, String nomeResponsavel, String emailOrg, String senhaOrg, String endereco, String telefone, String cnpj) {
        this.id = id;
        this.noeFantasia = noeFantasia;
        this.nomeReal = nomeReal;
        this.nomeResponsavel = nomeResponsavel;
        this.emailOrg = emailOrg;
        this.senhaOrg = senhaOrg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoeFantasia() {
        return noeFantasia;
    }

    public void setNoeFantasia(String noeFantasia) {
        this.noeFantasia = noeFantasia;
    }

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEmailOrg() {
        return emailOrg;
    }

    public void setEmailOrg(String emailOrg) {
        this.emailOrg = emailOrg;
    }

    public String getSenhaOrg() {
        return senhaOrg;
    }

    public void setSenhaOrg(String senhaOrg) {
        this.senhaOrg = senhaOrg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Collection<Eventos> getEventosCollection() {
        return eventosCollection;
    }

    public void setEventosCollection(Collection<Eventos> eventosCollection) {
        this.eventosCollection = eventosCollection;
    }

    public Collection<Ingresso> getIngressoCollection() {
        return ingressoCollection;
    }

    public void setIngressoCollection(Collection<Ingresso> ingressoCollection) {
        this.ingressoCollection = ingressoCollection;
    }
}
