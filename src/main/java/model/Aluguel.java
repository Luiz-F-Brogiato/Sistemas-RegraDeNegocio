package model;

import java.time.LocalDate;

public class Aluguel {
    private int id;
    private Cliente cliente;
    private Horario horario;
    private LocalDate data;
    private double valorCobrado;

    public Aluguel(int id, Cliente cliente, Horario horario, LocalDate data, double valorCobrado) {
        this.id = id;
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
        this.valorCobrado = valorCobrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", horario=" + horario +
                ", data=" + data +
                ", valorCobrado=" + valorCobrado +
                '}';
    }
}

