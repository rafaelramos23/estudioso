package com.example.estudiosoapp23.Classes;

import java.util.Date;

public class Revisoes {
    public String materia;
    public Date data;
    public String descricao;
    public boolean realizada;

    public Revisoes(){

    }

    public Revisoes(String materia, Date data, String descricao, boolean realizada) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
