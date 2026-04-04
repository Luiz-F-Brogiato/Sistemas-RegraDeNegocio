package EstruturacaoDeSistemas;

import controller.BibliotecaController;
import model.Aluno;
import model.Emprestimo;
import model.Livro;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistema de Controle de Biblioteca Escolar ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Registrar Empréstimo");
            System.out.println("4. Registrar Devolução");
            System.out.println("5. Consultar Livros Emprestados");
            System.out.println("6. Consultar Alunos com Empréstimos em Aberto");
            System.out.println("7. Listar Todos os Livros");
            System.out.println("8. Listar Todos os Alunos");
            System.out.println("9. Listar Todos os Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        controller.cadastrarLivro(titulo, autor, quantidade);
                        System.out.println("Livro cadastrado com sucesso!");
                        break;
                    case 2:
                        System.out.print("ID do Aluno: ");
                        String id = scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        controller.cadastrarAluno(id, nome);
                        System.out.println("Aluno cadastrado com sucesso!");
                        break;
                    case 3:
                        System.out.print("ID do Aluno: ");
                        String idAluno = scanner.nextLine();
                        System.out.print("Título do Livro: ");
                        String tituloLivro = scanner.nextLine();
                        controller.emprestarLivro(idAluno, tituloLivro);
                        System.out.println("Empréstimo registrado com sucesso!");
                        break;
                    case 4:
                        System.out.print("ID do Aluno: ");
                        String retIdAluno = scanner.nextLine();
                        System.out.print("Título do Livro: ");
                        String retTituloLivro = scanner.nextLine();
                        controller.devolverLivro(retIdAluno, retTituloLivro);
                        System.out.println("Devolução registrada com sucesso!");
                        break;
                    case 5:
                        List<Livro> livrosEmprestados = controller.getLivrosEmprestados();
                        System.out.println("Livros Emprestados:");
                        for (Livro livro : livrosEmprestados) {
                            System.out.println(livro);
                        }
                        break;
                    case 6:
                        List<Aluno> alunosComEmprestimos = controller.getAlunosComEmprestimosAbertos();
                        System.out.println("Alunos com Empréstimos em Aberto:");
                        for (Aluno aluno : alunosComEmprestimos) {
                            System.out.println(aluno);
                        }
                        break;
                    case 7:
                        List<Livro> todosLivros = controller.getTodosLivros();
                        System.out.println("Todos os Livros:");
                        for (Livro livro : todosLivros) {
                            System.out.println(livro);
                        }
                        break;
                    case 8:
                        List<Aluno> todosAlunos = controller.getTodosAlunos();
                        System.out.println("Todos os Alunos:");
                        for (Aluno aluno : todosAlunos) {
                            System.out.println(aluno);
                        }
                        break;
                    case 9:
                        List<Emprestimo> todosEmprestimos = controller.getTodosEmprestimos();
                        System.out.println("Todos os Empréstimos:");
                        for (Emprestimo emprestimo : todosEmprestimos) {
                            System.out.println(emprestimo);
                        }
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}