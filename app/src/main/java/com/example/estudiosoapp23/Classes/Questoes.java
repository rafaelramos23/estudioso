package com.example.estudiosoapp23.Classes;

public class Questoes {

    public String materia;
    public int resolvidas;
    public int corretas;

    public Questoes(){

    }

    public Questoes(String materia, int resolvidas, int corretas, int aproveitamento) {
        this.materia = materia;
        this.resolvidas = resolvidas;
        this.corretas = corretas;
        this.aproveitamento = aproveitamento;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getResolvidas() {
        return resolvidas;
    }

    public void setResolvidas(int resolvidas) {
        this.resolvidas = resolvidas;
    }

    public int getCorretas() {
        return corretas;
    }

    public void setCorretas(int corretas) {
        this.corretas = corretas;
    }

    public int getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(int aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

    public int aproveitamento;
}
