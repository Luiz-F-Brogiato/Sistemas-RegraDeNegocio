package EstruturacaoDeSistemas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Silva", "123456789");

        Horario horario1 = new Horario(LocalTime.of(10, 0), LocalTime.of(11, 0), 50.0);
        Horario horario2 = new Horario(LocalTime.of(11, 0), LocalTime.of(12, 0), 50.0);

        List<Horario> horarios = Arrays.asList(horario1, horario2);
        LocalDate data = LocalDate.now();

        Aluguel aluguel = new Aluguel(cliente, horarios, data);

        System.out.println("Aluguel criado para " + cliente.getNome() + " no dia " + data);
        System.out.println("Horários: " + horario1.getHoraInicio() + "-" + horario1.getHoraFim() + " e " + horario2.getHoraInicio() + "-" + horario2.getHoraFim());
        System.out.println("Valor cobrado: R$ " + aluguel.getValorCobrado());
    }
}