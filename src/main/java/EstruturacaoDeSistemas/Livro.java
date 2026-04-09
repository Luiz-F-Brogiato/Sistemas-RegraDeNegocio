package EstruturacaoDeSistemas;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    private static int proximoId = 1;

    public Livro(String titulo, String autor, int quantidadeDisponivel) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título do livro não pode ser vazio!");
        }
        if (quantidadeDisponivel < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        }

        this.id = proximoId++;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        }
        this.quantidadeDisponivel = quantidade;
    }

    public boolean emprestar() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
            return true;
        }
        return false;
    }

    public void devolver() {
        quantidadeDisponivel++;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
