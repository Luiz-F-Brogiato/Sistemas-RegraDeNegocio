package controler;

import model.Produto;
import service.ProdutoService;
import java.util.Scanner;

public class ProdutoController {
    private ProdutoService produtoService;
    private Scanner scanner;

    public ProdutoController(ProdutoService produtoService, Scanner scanner) {
        this.produtoService = produtoService;
        this.scanner = scanner;
    }

    public void cadastrarProduto() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        try {
            produtoService.cadastrarProduto(produto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarProdutos() {
        var produtos = produtoService.listarProdutos();
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - " + p.getDescricao() + " - R$ " + p.getPreco());
        }
    }
}
