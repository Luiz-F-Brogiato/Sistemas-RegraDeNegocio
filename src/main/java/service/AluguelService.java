package service;

import model.Aluguel;
import model.Cliente;
import model.Horario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelService {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Horario> horariosDisponiveis = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();
    private int proximoIdCliente = 1;
    private int proximoIdHorario = 1;
    private int proximoIdAluguel = 1;

    /**
     * Cadastra um novo cliente
     * Regra de Negócio: Não pode ser possível cadastrar clientes com nome vazio
     */
    public boolean cadastrarCliente(String nome, String telefone) {
        // Validação: nome não pode ser vazio
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome do cliente não pode ser vazio!");
            return false;
        }

        Cliente cliente = new Cliente(proximoIdCliente++, nome.trim(), telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente);
        return true;
    }

    /**
     * Cadastra um novo horário disponível
     * Regra de Negócio: Não ser possível cadastrar horários com valor negativo
     */
    public boolean cadastrarHorario(java.time.LocalTime horaInicio, java.time.LocalTime horaFim, double valor) {
        // Validação: valor não pode ser negativo
        if (valor < 0) {
            System.out.println("Erro: O valor do horário não pode ser negativo!");
            return false;
        }

        Horario horario = new Horario(proximoIdHorario++, horaInicio, horaFim, valor);
        horariosDisponiveis.add(horario);
        System.out.println("Horário cadastrado com sucesso: " + horario);
        return true;
    }

    /**
     * Registra um aluguel
     * Regra de Negócio: Não reservar um horário já ocupado
     * Regra de Negócio: Calcular automaticamente o valor total se houver mais de um horário no mesmo dia
     */
    public boolean registrarAluguel(int idCliente, int idHorario, LocalDate data) {
        // Validar se cliente existe
        Cliente cliente = clientes.stream()
                .filter(c -> c.getId() == idCliente)
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Erro: Cliente com ID " + idCliente + " não encontrado!");
            return false;
        }

        // Validar se horário existe
        Horario horario = horariosDisponiveis.stream()
                .filter(h -> h.getId() == idHorario)
                .findFirst()
                .orElse(null);

        if (horario == null) {
            System.out.println("Erro: Horário com ID " + idHorario + " não encontrado!");
            return false;
        }

        // Regra de Negócio: Não reservar um horário já ocupado
        if (horarioOcupado(idHorario, data)) {
            System.out.println("Erro: O horário já está ocupado nesta data!");
            return false;
        }

        // Calcular valor: se houver mais aluguéis do mesmo cliente no mesmo dia, somar valores
        double valorTotal = calcularValorTotal(idCliente, data, horario.getValor());

        Aluguel aluguel = new Aluguel(proximoIdAluguel++, cliente, horario, data, valorTotal);
        alugueis.add(aluguel);
        System.out.println("Aluguel registrado com sucesso: " + aluguel);
        return true;
    }

    /**
     * Regra de Negócio: Não reservar um horário já ocupado
     */
    private boolean horarioOcupado(int idHorario, LocalDate data) {
        return alugueis.stream()
                .anyMatch(a -> a.getHorario().getId() == idHorario && a.getData().equals(data));
    }

    /**
     * Regra de Negócio: Calcular automaticamente o valor total se houver mais de um horário no mesmo dia
     */
    private double calcularValorTotal(int idCliente, LocalDate data, double valorHorario) {
        // Contar quantos aluguéis o cliente tem no mesmo dia
        long quantidadeAlugueis = alugueis.stream()
                .filter(a -> a.getCliente().getId() == idCliente && a.getData().equals(data))
                .count();

        // Se houver mais de um aluguel no mesmo dia, aplicar desconto de 10% por aluguel adicional
        double desconto = quantidadeAlugueis > 0 ? (quantidadeAlugueis * 0.10) : 0;
        double valorComDesconto = valorHorario * (1 - desconto);

        return Math.max(valorComDesconto, 0); // Garante que não seja negativo
    }

    /**
     * Regra de Negócio: Ser possível consultar todos os aluguéis realizados em um determinado dia
     */
    public List<Aluguel> consultarAlugueisPorDia(LocalDate data) {
        List<Aluguel> alugueisDia = alugueis.stream()
                .filter(a -> a.getData().equals(data))
                .collect(Collectors.toList());

        if (alugueisDia.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado para a data: " + data);
        } else {
            System.out.println("Aluguéis do dia " + data + ":");
            alugueisDia.forEach(System.out::println);
        }

        return alugueisDia;
    }

    /**
     * Listar todos os clientes cadastrados
     */
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("Clientes cadastrados:");
        clientes.forEach(System.out::println);
    }

    /**
     * Listar todos os horários disponíveis
     */
    public void listarHorarios() {
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("Nenhum horário disponível.");
            return;
        }
        System.out.println("Horários disponíveis:");
        horariosDisponiveis.forEach(System.out::println);
    }

    /**
     * Listar todos os aluguéis registrados
     */
    public void listarAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
            return;
        }
        System.out.println("Aluguéis registrados:");
        alugueis.forEach(System.out::println);
    }

    // Getters para facilitar testes
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

