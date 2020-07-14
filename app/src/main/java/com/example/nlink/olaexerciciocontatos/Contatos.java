package com.example.nlink.olaexerciciocontatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contatos implements Serializable {

    private String id;
    private String nome;
    private String email;
    private String endereco;
    private String sexo;
    private String telCel;
    private String telRes;
    private String telCom;

    private static List<Contatos> contatos = new ArrayList();

    public Contatos(){

    }

    public Contatos(String id, String nome, String email, String endereco, String sexo, String telCel, String telRes, String telCom) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.sexo = sexo;
        this.telCel = telCel;
        this.telRes = telRes;
        this.telCom = telCom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getTelRes() {
        return telRes;
    }

    public void setTelRes(String telRes) {
        this.telRes = telRes;
    }

    public String getTelCom() {
        return telCom;
    }

    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }

    public static List<Contatos> getContatos() {
        return contatos;
    }

    public static void setContatos(List<Contatos> contatos) {
        Contatos.contatos = contatos;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - Nome: " + getNome();
    }
}
