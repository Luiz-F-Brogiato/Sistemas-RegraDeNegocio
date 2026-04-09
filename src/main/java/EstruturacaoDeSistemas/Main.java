package EstruturacaoDeSistemas;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== SISTEMA DE BIBLIOTECA ESCOLAR ==========\n");

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("--- CADASTRANDO LIVROS ---");
        Livro livro1 = biblioteca.cadastrarLivro("Clean Code", "Robert C. Martin", 3);
        Livro livro2 = biblioteca.cadastrarLivro("Design Patterns", "Gang of Four", 2);
        Livro livro3 = biblioteca.cadastrarLivro("Java Efetivo", "Joshua Bloch", 1);
        System.out.println("✓ Livro cadastrado: " + livro1);
        System.out.println("✓ Livro cadastrado: " + livro2);
        System.out.println("✓ Livro cadastrado: " + livro3);

        System.out.println("\n--- CADASTRANDO ALUNOS ---");
        Aluno aluno1 = biblioteca.cadastrarAluno("João Silva");
        Aluno aluno2 = biblioteca.cadastrarAluno("Maria Santos");
        Aluno aluno3 = biblioteca.cadastrarAluno("Pedro Oliveira");
        System.out.println("✓ Aluno cadastrado: " + aluno1);
        System.out.println("✓ Aluno cadastrado: " + aluno2);
        System.out.println("✓ Aluno cadastrado: " + aluno3);

        System.out.println("\n--- REGISTRANDO EMPRÉSTIMOS ---");
        Emprestimo emp1 = biblioteca.registrarEmprestimo(aluno1, livro1);
        System.out.println("✓ Empréstimo registrado: " + emp1);

        Emprestimo emp2 = biblioteca.registrarEmprestimo(aluno2, livro2);
        System.out.println("✓ Empréstimo registrado: " + emp2);

        Emprestimo emp3 = biblioteca.registrarEmprestimo(aluno3, livro1);
        System.out.println("✓ Empréstimo registrado: " + emp3);

        Emprestimo emp4 = biblioteca.registrarEmprestimo(aluno1, livro3);
        System.out.println("✓ Empréstimo registrado: " + emp4);

        biblioteca.exibirInfoBiblioteca();

        System.out.println("\n--- LIVROS EMPRESTADOS (ABERTOS) ---");
        for (Emprestimo emp : biblioteca.consultarLivrosEmprestados()) {
            System.out.println("• " + emp);
        }

        System.out.println("\n--- ALUNOS COM LIVROS EM ABERTO ---");
        for (Aluno aluno : biblioteca.consultarAlunosComLivrosEmAberto()) {
            System.out.println("• " + aluno);
        }

        System.out.println("\n--- REGISTRANDO DEVOLUÇÃO ---");
        biblioteca.registrarDevolucao(emp1);
        System.out.println("✓ Devolução registrada para empréstimo #" + emp1.getId());
        System.out.println("  Estado do empréstimo: " + emp1);

        biblioteca.exibirInfoBiblioteca();

        System.out.println("\n--- LIVROS EMPRESTADOS APÓS DEVOLUÇÃO ---");
        for (Emprestimo emp : biblioteca.consultarLivrosEmprestados()) {
            System.out.println("• " + emp);
        }

        System.out.println("\n--- TESTANDO REGRA: SEM QUANTIDADE DISPONÍVEL ---");
        try {
            biblioteca.registrarEmprestimo(aluno1, livro3);
            System.out.println("✗ Isso não deveria acontecer!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Regra aplicada: " + e.getMessage());
        }

        System.out.println("\n--- TESTANDO REGRA: TÍTULO VAZIO ---");
        try {
            biblioteca.cadastrarLivro("", "Autor Desconhecido", 5);
            System.out.println("✗ Isso não deveria acontecer!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Regra aplicada: " + e.getMessage());
        }

        System.out.println("\n--- TESTANDO REGRA: QUANTIDADE NEGATIVA ---");
        try {
            biblioteca.cadastrarLivro("Outro Livro", "Autor X", -5);
            System.out.println("✗ Isso não deveria acontecer!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Regra aplicada: " + e.getMessage());
        }

        System.out.println("\n========== FIM DA SIMULAÇÃO ==========");
    }
}