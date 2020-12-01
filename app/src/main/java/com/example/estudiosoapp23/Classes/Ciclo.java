package com.example.estudiosoapp23.Classes;

public class Ciclo {
    public String materia;
    public String horaInicio;
    public String horaFinal;

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
    public Ciclo(String materia, String horaInicio, String horaFinal) {
        this.materia = materia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
}
