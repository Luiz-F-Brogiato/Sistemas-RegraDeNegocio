package EstruturacaoDeSistemas;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Aluno> alunos;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Livro cadastrarLivro(String titulo, String autor, int quantidade) {
        Livro livro = new Livro(titulo, autor, quantidade);
        livros.add(livro);
        return livro;
    }

    public Aluno cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
        return aluno;
    }

    public Emprestimo registrarEmprestimo(Aluno aluno, Livro livro) {
        if (!livro.emprestar()) {
            throw new IllegalArgumentException("Não há quantidade disponível de: " + livro.getTitulo());
        }

        Emprestimo emprestimo = new Emprestimo(aluno, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void registrarDevolucao(Emprestimo emprestimo) {
        if (!emprestimo.estaAberto()) {
            throw new IllegalStateException("Este empréstimo já foi devolvido!");
        }

        emprestimo.registrarDevolucao();
        emprestimo.getLivro().devolver();
    }

    public List<Emprestimo> consultarLivrosEmprestados() {
        List<Emprestimo> livrosEmAberto = new ArrayList<>();
        for (Emprestimo emp : emprestimos) {
            if (emp.estaAberto()) {
                livrosEmAberto.add(emp);
            }
        }
        return livrosEmAberto;
    }

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

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public List<Livro> getLivros() {
        return new ArrayList<>(livros);
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public List<Emprestimo> getEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public void exibirInfoBiblioteca() {
        System.out.println("\n========== INFORMAÇÕES DA BIBLIOTECA ==========");
        System.out.println("Total de livros: " + livros.size());
        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("Total de empréstimos: " + emprestimos.size());
        System.out.println("Empréstimos em aberto: " + consultarLivrosEmprestados().size());
        System.out.println("=".repeat(45));
    }
}
