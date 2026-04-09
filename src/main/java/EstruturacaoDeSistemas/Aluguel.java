package EstruturacaoDeSistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aluguel {
    private static List<Aluguel> aluguels = new ArrayList<>();

    private Cliente cliente;
    private List<Horario> horarios;
    private LocalDate data;
    private double valorCobrado;

    public Aluguel(Cliente cliente, List<Horario> horarios, LocalDate data) {
        this.cliente = cliente;
        this.horarios = new ArrayList<>(horarios);
        this.data = data;
        this.valorCobrado = horarios.stream().mapToDouble(Horario::getValor).sum();

        for (Horario h : horarios) {
            for (Aluguel a : aluguels) {
                if (a.data.equals(data) && a.horarios.contains(h)) {
                    throw new IllegalArgumentException("Horário já ocupado: " + h.getHoraInicio() + " - " + h.getHoraFim());
                }
            }
        }

        aluguels.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Horario> getHorarios() {
        return new ArrayList<>(horarios);
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public static List<Aluguel> getAluguelsByData(LocalDate data) {
        return aluguels.stream().filter(a -> a.data.equals(data)).collect(Collectors.toList());
    }
}
