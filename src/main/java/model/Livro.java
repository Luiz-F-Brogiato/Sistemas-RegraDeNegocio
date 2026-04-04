package model;

public class Livro {
    private String titulo;
    private String autor;
    private int quantidade;

    public Livro(String titulo, String autor, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
