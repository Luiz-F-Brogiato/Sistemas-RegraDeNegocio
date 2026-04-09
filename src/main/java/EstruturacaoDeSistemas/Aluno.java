package EstruturacaoDeSistemas;

/**
 * Entidade que representa um Aluno da escola
 */
public class Aluno {
    private int id;
    private String nome;

    // Contador estático para gerar IDs únicos
    private static int proximoId = 1;

    /**
     * Construtor do Aluno
     * @param nome Nome do aluno
     * @throws IllegalArgumentException se nome vazio
     */
    public Aluno(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio!");
        }

        this.id = proximoId++;
        this.nome = nome;
    }

    // Getters
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

