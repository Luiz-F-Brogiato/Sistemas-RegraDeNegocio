package service;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmprestimoService {
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private LivroService livroService;
    private AlunoService alunoService;

    public EmprestimoService(LivroService livroService, AlunoService alunoService) {
        this.livroService = livroService;
        this.alunoService = alunoService;
    }

    public void emprestarLivro(String idAluno, String tituloLivro) throws IllegalArgumentException {
        Aluno aluno = alunoService.encontrarAlunoPorId(idAluno);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
        Livro livro = livroService.encontrarLivroPorTitulo(tituloLivro);
        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }
        if (livro.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Livro não disponível");
        }
        Emprestimo emprestimo = new Emprestimo(aluno, livro, LocalDate.now());
        emprestimos.add(emprestimo);
        livro.setQuantidade(livro.getQuantidade() - 1);
    }

    public void devolverLivro(String idAluno, String tituloLivro) throws IllegalArgumentException {
        for (Emprestimo e : emprestimos) {
            if (e.getAluno().getId().equals(idAluno) && e.getLivro().getTitulo().equalsIgnoreCase(tituloLivro) && e.isAberto()) {
                e.setDataDevolucao(LocalDate.now());
                e.getLivro().setQuantidade(e.getLivro().getQuantidade() + 1);
                return;
            }
        }
        throw new IllegalArgumentException("Empréstimo não encontrado ou já devolvido");
    }

    public List<Livro> getLivrosEmprestados() {
        Set<Livro> livrosEmprestados = new HashSet<>();
        for (Emprestimo e : emprestimos) {
            if (e.isAberto()) {
                livrosEmprestados.add(e.getLivro());
            }
        }
        return new ArrayList<>(livrosEmprestados);
    }

    public List<Aluno> getAlunosComEmprestimosAbertos() {
        Set<Aluno> alunosComEmprestimos = new HashSet<>();
        for (Emprestimo e : emprestimos) {
            if (e.isAberto()) {
                alunosComEmprestimos.add(e.getAluno());
            }
        }
        return new ArrayList<>(alunosComEmprestimos);
    }

    public List<Emprestimo> getTodosEmprestimos() {
        return new ArrayList<>(emprestimos);
    }
}
