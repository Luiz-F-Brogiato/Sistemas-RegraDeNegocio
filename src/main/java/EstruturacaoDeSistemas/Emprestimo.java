package EstruturacaoDeSistemas;

import java.time.LocalDate;

/**
 * Entidade que representa um Empréstimo de livro
 */
public class Emprestimo {
    private int id;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // Contador estático para gerar IDs únicos
    private static int proximoId = 1;

    /**
     * Construtor do Empréstimo
     * @param aluno Aluno que está pegando emprestado
     * @param livro Livro sendo emprestado
     */
    public Emprestimo(Aluno aluno, Livro livro) {
        if (aluno == null || livro == null) {
            throw new IllegalArgumentException("Aluno e Livro não podem ser nulos!");
        }

        this.id = proximoId++;
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null; // Ainda não foi devolvido
    }

    // Getters
    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Registra a devolução do livro
     */
    public void registrarDevolucao() {
        if (dataDevolucao != null) {
            throw new IllegalStateException("Este empréstimo já foi devolvido!");
        }
        this.dataDevolucao = LocalDate.now();
    }

    /**
     * Verifica se o empréstimo está aberto (não foi devolvido)
     * @return true se o empréstimo está aberto
     */
    public boolean estaAberto() {
        return dataDevolucao == null;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", aluno=" + aluno.getNome() +
                ", livro='" + livro.getTitulo() + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + (dataDevolucao != null ? dataDevolucao : "Em aberto") +
                '}';
    }
}

