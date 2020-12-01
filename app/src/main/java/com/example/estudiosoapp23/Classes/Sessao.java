package com.example.estudiosoapp23.Classes;

public class Sessao {
    public String materia;
    public String tema;
    public String topico;
    public String data;
    public String tempoEstudado;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempoEstudado() {
        return tempoEstudado;
    }

    public void setTempoEstudado(String tempoEstudado) {
        this.tempoEstudado = tempoEstudado;
    }

    public Sessao(){

    }

    public Sessao(String materia, String tema, String topico, String data, String tempoEstudado) {
        this.materia = materia;
        this.tema = tema;
        this.topico = topico;
        this.data = data;
        this.tempoEstudado = tempoEstudado;
    }
}
