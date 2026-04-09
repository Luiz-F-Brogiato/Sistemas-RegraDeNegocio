package EstruturacaoDeSistemas;

import java.time.LocalTime;
import java.util.Objects;

public class Horario {
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private double valor;

    public Horario(LocalTime horaInicio, LocalTime horaFim, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valor = valor;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horario horario = (Horario) o;
        return horaInicio.equals(horario.horaInicio) && horaFim.equals(horario.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaInicio, horaFim);
    }
}
