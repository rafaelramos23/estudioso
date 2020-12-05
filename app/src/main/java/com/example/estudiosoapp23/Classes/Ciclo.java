package com.example.estudiosoapp23.Classes;

public class Ciclo {
    public String materia;
    public String horaInicio;
    public String horaFinal;
    public String id;
    public String realizado;

    public Ciclo(String materia, String horaInicio, String horaFinal, String id, String realizado) {
        this.materia = materia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.id = id;
        this.realizado = realizado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Ciclo(){

    }

}
