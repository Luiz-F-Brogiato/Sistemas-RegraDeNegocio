package service;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();

    public void cadastrarAluno(String id, String nome) {
        Aluno aluno = new Aluno(id, nome);
        alunos.add(aluno);
    }

    public List<Aluno> getTodosAlunos() {
        return new ArrayList<>(alunos);
    }

    public Aluno encontrarAlunoPorId(String id) {
        for (Aluno a : alunos) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}
