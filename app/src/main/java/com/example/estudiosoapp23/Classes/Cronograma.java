package com.example.estudiosoapp23.Classes;

public class Cronograma {
    public String diaSemana;
    public String materia;
    public String horaInicio;
    public String horaFinal;

    public Cronograma(){

    }
    public Cronograma(String diaSemana, String materia, String horaInicio, String horaFinal) {
        this.diaSemana = diaSemana;
        this.materia = materia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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
}
