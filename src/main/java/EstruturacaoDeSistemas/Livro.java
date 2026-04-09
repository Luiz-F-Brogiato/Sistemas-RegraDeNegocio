package EstruturacaoDeSistemas;

/**
 * Entidade que representa um Livro na biblioteca
 */
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    // Contador estático para gerar IDs únicos
    private static int proximoId = 1;

    /**
     * Construtor do Livro
     * @param titulo Título do livro
     * @param autor Autor do livro
     * @param quantidadeDisponivel Quantidade disponível
     * @throws IllegalArgumentException se título vazio ou quantidade negativa
     */
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

    // Getters e Setters
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

    /**
     * Empresta um livro (decrementa a quantidade disponível)
     * @return true se conseguiu emprestar, false se não há quantidade disponível
     */
    public boolean emprestar() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
            return true;
        }
        return false;
    }

    /**
     * Devolve um livro (incrementa a quantidade disponível)
     */
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

