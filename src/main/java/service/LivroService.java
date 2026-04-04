package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(String titulo, String autor, int quantidade) throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        Livro livro = new Livro(titulo, autor, quantidade);
        livros.add(livro);
    }

    public List<Livro> getTodosLivros() {
        return new ArrayList<>(livros);
    }

    public Livro encontrarLivroPorTitulo(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }
}
