package com.example.estudiosoapp23.Classes;

public class Materia {
    public String nomeMateria;
    public String tema;

    public Materia(){

    }
    public Materia(String nomeMateria, String tema, String topico) {
        this.nomeMateria = nomeMateria;
        this.tema = tema;
        this.topico = topico;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
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

    public String topico;


}
