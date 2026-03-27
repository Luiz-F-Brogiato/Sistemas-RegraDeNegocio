package EstruturacaoDeSistemas;

import controller.AluguelController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    private static AluguelController controller = new AluguelController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  Sistema de Controle de Aluguel de Quadra     ║");
        System.out.println("║  Esportiva                                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        boolean rodando = true;
        while (rodando) {
            exibirMenuPrincipal();
            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarHorario();
                    break;
                case 3:
                    registrarAluguel();
                    break;
                case 4:
                    consultarAlugueisPorDia();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    listarHorarios();
                    break;
                case 7:
                    listarAlugueis();
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                   MENU PRINCIPAL               ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1 - Cadastrar Cliente                          ║");
        System.out.println("║ 2 - Cadastrar Horário Disponível               ║");
        System.out.println("║ 3 - Registrar Aluguel                          ║");
        System.out.println("║ 4 - Consultar Aluguéis por Data               ║");
        System.out.println("║ 5 - Listar Clientes                            ║");
        System.out.println("║ 6 - Listar Horários Disponíveis                ║");
        System.out.println("║ 7 - Listar Aluguéis Registrados                ║");
        System.out.println("║ 0 - Sair                                       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- CADASTRAR CLIENTE ---");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        controller.cadastrarCliente(nome, telefone);
    }

    private static void cadastrarHorario() {
        System.out.println("\n--- CADASTRAR HORÁRIO DISPONÍVEL ---");
        System.out.print("Digite a hora de início (HH:mm): ");
        String horaInicio = scanner.nextLine();

        System.out.print("Digite a hora de fim (HH:mm): ");
        String horaFim = scanner.nextLine();

        System.out.print("Digite o valor do horário (R$): ");
        double valor = 0;
        try {
            valor = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Valor inválido!");
            return;
        }

        try {
            LocalTime inicio = LocalTime.parse(horaInicio);
            LocalTime fim = LocalTime.parse(horaFim);
            controller.cadastrarHorario(inicio, fim, valor);
        } catch (Exception e) {
            System.out.println("Erro: Formato de hora inválido! Use HH:mm");
        }
    }

    private static void registrarAluguel() {
        System.out.println("\n--- REGISTRAR ALUGUEL ---");
        System.out.print("Digite o ID do cliente: ");
        int idCliente = 0;
        try {
            idCliente = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido!");
            return;
        }

        System.out.print("Digite o ID do horário: ");
        int idHorario = 0;
        try {
            idHorario = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido!");
            return;
        }

        System.out.print("Digite a data do aluguel (yyyy-MM-dd): ");
        String dataStr = scanner.nextLine();

        try {
            LocalDate data = LocalDate.parse(dataStr);
            controller.registrarAluguel(idCliente, idHorario, data);
        } catch (Exception e) {
            System.out.println("Erro: Formato de data inválido! Use yyyy-MM-dd");
        }
    }

    private static void consultarAlugueisPorDia() {
        System.out.println("\n--- CONSULTAR ALUGUÉIS POR DIA ---");
        System.out.print("Digite a data (yyyy-MM-dd): ");
        String dataStr = scanner.nextLine();

        try {
            LocalDate data = LocalDate.parse(dataStr);
            controller.consultarAlugueisPorDia(data);
        } catch (Exception e) {
            System.out.println("Erro: Formato de data inválido! Use yyyy-MM-dd");
        }
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTAR CLIENTES ---");
        controller.listarClientes();
    }

    private static void listarHorarios() {
        System.out.println("\n--- LISTAR HORÁRIOS DISPONÍVEIS ---");
        controller.listarHorarios();
    }

    private static void listarAlugueis() {
        System.out.println("\n--- LISTAR ALUGUÉIS REGISTRADOS ---");
        controller.listarAlugueis();
    }
}