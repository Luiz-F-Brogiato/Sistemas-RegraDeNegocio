package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import service.AlunoService;
import service.EmprestimoService;
import service.LivroService;
import java.util.List;

public class BibliotecaController {
    private LivroService livroService;
    private AlunoService alunoService;
    private EmprestimoService emprestimoService;

    public BibliotecaController() {
        this.livroService = new LivroService();
        this.alunoService = new AlunoService();
        this.emprestimoService = new EmprestimoService(livroService, alunoService);
    }

    public void cadastrarLivro(String titulo, String autor, int quantidade) throws IllegalArgumentException {
        livroService.cadastrarLivro(titulo, autor, quantidade);
    }

    public void cadastrarAluno(String id, String nome) {
        alunoService.cadastrarAluno(id, nome);
    }

    public void emprestarLivro(String idAluno, String tituloLivro) throws IllegalArgumentException {
        emprestimoService.emprestarLivro(idAluno, tituloLivro);
    }

    public void devolverLivro(String idAluno, String tituloLivro) throws IllegalArgumentException {
        emprestimoService.devolverLivro(idAluno, tituloLivro);
    }

    public List<Livro> getLivrosEmprestados() {
        return emprestimoService.getLivrosEmprestados();
    }

    public List<Aluno> getAlunosComEmprestimosAbertos() {
        return emprestimoService.getAlunosComEmprestimosAbertos();
    }

    public List<Livro> getTodosLivros() {
        return livroService.getTodosLivros();
    }

    public List<Aluno> getTodosAlunos() {
        return alunoService.getTodosAlunos();
    }

    public List<Emprestimo> getTodosEmprestimos() {
        return emprestimoService.getTodosEmprestimos();
    }
}
