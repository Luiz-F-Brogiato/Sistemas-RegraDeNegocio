package service;

import model.Aluguel;
import model.Cliente;
import model.Horario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AluguelService {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Horario> horariosDisponiveis = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();
    private int proximoIdCliente = 1;
    private int proximoIdHorario = 1;
    private int proximoIdAluguel = 1;

    public boolean cadastrarCliente(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome do cliente não pode ser vazio!");
            return false;
        }

        Cliente cliente = new Cliente(proximoIdCliente++, nome.trim(), telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
        return true;
    }

    public boolean cadastrarHorario(java.time.LocalTime horaInicio, java.time.LocalTime horaFim, double valor) {
        if (valor < 0) {
            System.out.println("Erro: O valor do horário não pode ser negativo!");
            return false;
        }

        Horario horario = new Horario(proximoIdHorario++, horaInicio, horaFim, valor);
        horariosDisponiveis.add(horario);
        System.out.println("Horário cadastrado com sucesso: " + horario);
        return true;
    }

    public boolean registrarAluguel(int idCliente, int idHorario, LocalDate data) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Erro: Cliente com ID " + idCliente + " não encontrado!");
            return false;
        }

        Horario horario = null;
        for (Horario h : horariosDisponiveis) {
            if (h.getId() == idHorario) {
                horario = h;
                break;
            }
        }

        if (horario == null) {
            System.out.println("Erro: Horário com ID " + idHorario + " não encontrado!");
            return false;
        }

        if (horarioOcupado(idHorario, data)) {
            System.out.println("Erro: O horário já está ocupado nesta data!");
            return false;
        }

        double valorTotal = calcularValorTotal(idCliente, data, horario.getValor());

        Aluguel aluguel = new Aluguel(proximoIdAluguel++, cliente, horario, data, valorTotal);
        alugueis.add(aluguel);
        System.out.println("Aluguel registrado com sucesso: " + aluguel);
        return true;
    }

    private boolean horarioOcupado(int idHorario, LocalDate data) {
        for (Aluguel a : alugueis) {
            if (a.getHorario().getId() == idHorario && a.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    private double calcularValorTotal(int idCliente, LocalDate data, double valorHorario) {
        long quantidadeAlugueis = 0;
        for (Aluguel a : alugueis) {
            if (a.getCliente().getId() == idCliente && a.getData().equals(data)) {
                quantidadeAlugueis++;
            }
        }

        double desconto = quantidadeAlugueis > 0 ? (quantidadeAlugueis * 0.10) : 0;
        double valorComDesconto = valorHorario * (1 - desconto);

        return Math.max(valorComDesconto, 0);
    }

    public List<Aluguel> consultarAlugueisPorDia(LocalDate data) {
        List<Aluguel> alugueisDia = new ArrayList<>();
        for (Aluguel a : alugueis) {
            if (a.getData().equals(data)) {
                alugueisDia.add(a);
            }
        }

        if (alugueisDia.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado para a data: " + data);
        } else {
            System.out.println("Aluguéis do dia " + data + ":");
            alugueisDia.forEach(System.out::println);
        }

        return alugueisDia;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("Clientes cadastrados:");
        clientes.forEach(System.out::println);
    }

    public void listarHorarios() {
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("Nenhum horário disponível.");
            return;
        }
        System.out.println("Horários disponíveis:");
        horariosDisponiveis.forEach(System.out::println);
    }

    public void listarAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
            return;
        }
        System.out.println("Aluguéis registrados:");
        alugueis.forEach(System.out::println);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Horario> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }
}
