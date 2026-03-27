package controller;

import model.Aluguel;
import service.AluguelService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AluguelController {
    private AluguelService service;

    public AluguelController() {
        this.service = new AluguelService();
    }

    public AluguelService getService() {
        return service;
    }

    public boolean cadastrarCliente(String nome, String telefone) {
        return service.cadastrarCliente(nome, telefone);
    }

    public boolean cadastrarHorario(LocalTime horaInicio, LocalTime horaFim, double valor) {
        return service.cadastrarHorario(horaInicio, horaFim, valor);
    }

    public boolean registrarAluguel(int idCliente, int idHorario, LocalDate data) {
        return service.registrarAluguel(idCliente, idHorario, data);
    }

    public List<Aluguel> consultarAlugueisPorDia(LocalDate data) {
        return service.consultarAlugueisPorDia(data);
    }

    public void listarClientes() {
        service.listarClientes();
    }

    public void listarHorarios() {
        service.listarHorarios();
    }

    public void listarAlugueis() {
        service.listarAlugueis();
    }
}

