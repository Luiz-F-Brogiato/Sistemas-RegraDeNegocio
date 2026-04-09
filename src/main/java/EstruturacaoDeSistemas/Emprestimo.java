package EstruturacaoDeSistemas;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    private static int proximoId = 1;

    public Emprestimo(Aluno aluno, Livro livro) {
        if (aluno == null || livro == null) {
            throw new IllegalArgumentException("Aluno e Livro não podem ser nulos!");
        }

        this.id = proximoId++;
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

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

    public void registrarDevolucao() {
        if (dataDevolucao != null) {
            throw new IllegalStateException("Este empréstimo já foi devolvido!");
        }
        this.dataDevolucao = LocalDate.now();
    }

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
