package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
    private int id;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private double valor;

    public Horario(int id, LocalTime horaInicio, LocalTime horaFim, double valor) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", valor=" + valor +
                '}';
    }
}

