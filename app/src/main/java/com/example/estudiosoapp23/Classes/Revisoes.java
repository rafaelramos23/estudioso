package com.example.estudiosoapp23.Classes;

public class Revisoes {
    public String materia;
    public String data;
    public String descricao;
    public boolean realizada;

    public Revisoes(){

    }

    public Revisoes(String materia, String data, String descricao, boolean realizada) {
        this.materia = materia;
        this.data = data;
        this.descricao = descricao;
        this.realizada = realizada;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}
