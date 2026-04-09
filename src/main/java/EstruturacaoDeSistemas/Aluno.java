package EstruturacaoDeSistemas;

public class Aluno {
    private int id;
    private String nome;

    private static int proximoId = 1;

    public Aluno(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio!");
        }

        this.id = proximoId++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio!");
        }
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
