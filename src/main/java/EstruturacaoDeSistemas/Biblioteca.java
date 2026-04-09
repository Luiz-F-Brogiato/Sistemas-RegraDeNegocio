package EstruturacaoDeSistemas;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que gerencia a biblioteca (empréstimos, livros e alunos)
 */
public class Biblioteca {
    private List<Livro> livros;
    private List<Aluno> alunos;
    private List<Emprestimo> emprestimos;

    /**
     * Construtor da Biblioteca
     */
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    /**
     * Cadastra um novo livro na biblioteca
     * @param titulo Título do livro
     * @param autor Autor do livro
     * @param quantidade Quantidade disponível
     * @return O livro cadastrado
     * @throws IllegalArgumentException se título vazio ou quantidade negativa
     */
    public Livro cadastrarLivro(String titulo, String autor, int quantidade) {
        Livro livro = new Livro(titulo, autor, quantidade);
        livros.add(livro);
        return livro;
    }

    /**
     * Cadastra um novo aluno na biblioteca
     * @param nome Nome do aluno
     * @return O aluno cadastrado
     * @throws IllegalArgumentException se nome vazio
     */
    public Aluno cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
        return aluno;
    }

    /**
     * Registra um empréstimo de livro para um aluno
     * @param aluno Aluno que está pegando emprestado
     * @param livro Livro sendo emprestado
     * @return O empréstimo registrado
     * @throws IllegalArgumentException se não há quantidade disponível
     */
    public Emprestimo registrarEmprestimo(Aluno aluno, Livro livro) {
        // Verifica se o livro tem quantidade disponível
        if (!livro.emprestar()) {
            throw new IllegalArgumentException("Não há quantidade disponível de: " + livro.getTitulo());
        }

        // Cria e registra o empréstimo
        Emprestimo emprestimo = new Emprestimo(aluno, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    /**
     * Registra a devolução de um livro
     * @param emprestimo O empréstimo a ser devolvido
     */
    public void registrarDevolucao(Emprestimo emprestimo) {
        if (!emprestimo.estaAberto()) {
            throw new IllegalStateException("Este empréstimo já foi devolvido!");
        }

        emprestimo.registrarDevolucao();
        emprestimo.getLivro().devolver();
    }

    /**
     * Consulta todos os livros emprestados (empréstimos abertos)
     * @return Lista de livros em empréstimo
     */
    public List<Emprestimo> consultarLivrosEmprestados() {
        List<Emprestimo> livrosEmAberto = new ArrayList<>();
        for (Emprestimo emp : emprestimos) {
            if (emp.estaAberto()) {
                livrosEmAberto.add(emp);
            }
        }
        return livrosEmAberto;
    }

    /**
     * Consulta quais alunos estão com livros em aberto
     * @return Lista de alunos com empréstimos abertos
     */
    public List<Aluno> consultarAlunosComLivrosEmAberto() {
        List<Aluno> alunosComLivros = new ArrayList<>();
        List<Emprestimo> livrosAbertos = consultarLivrosEmprestados();

        for (Emprestimo emp : livrosAbertos) {
            if (!alunosComLivros.contains(emp.getAluno())) {
                alunosComLivros.add(emp.getAluno());
            }
        }

        return alunosComLivros;
    }

    /**
     * Busca um livro pelo ID
     * @param id ID do livro
     * @return O livro encontrado ou null
     */
    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    /**
     * Busca um aluno pelo ID
     * @param id ID do aluno
     * @return O aluno encontrado ou null
     */
    public Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    /**
     * Busca um empréstimo pelo ID
     * @param id ID do empréstimo
     * @return O empréstimo encontrado ou null
     */
    public Emprestimo buscarEmprestimoPorId(int id) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Getters
    public List<Livro> getLivros() {
        return new ArrayList<>(livros);
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public List<Emprestimo> getEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    /**
     * Exibe informações gerais da biblioteca
     */
    public void exibirInfoBiblioteca() {
        System.out.println("\n========== INFORMAÇÕES DA BIBLIOTECA ==========");
        System.out.println("Total de livros: " + livros.size());
        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("Total de empréstimos: " + emprestimos.size());
        System.out.println("Empréstimos em aberto: " + consultarLivrosEmprestados().size());
        System.out.println("=".repeat(45));
    }
}

