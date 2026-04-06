package controler;

import model.*;
import service.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoController {
    private PedidoService pedidoService;
    private ProdutoService produtoService;
    private Scanner scanner;

    public PedidoController(PedidoService pedidoService, ProdutoService produtoService, Scanner scanner) {
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
        this.scanner = scanner;
    }

    public void cadastrarPedido() {
        List<ItemPedido> itens = new ArrayList<>();
        while (true) {
            listarProdutos();
            System.out.print("Digite o nome do produto (ou 'fim' para terminar): ");
            String nome = scanner.nextLine();
            if (nome.equals("fim")) break;
            Produto produto = produtoService.listarProdutos().stream()
                    .filter(p -> p.getNome().equalsIgnoreCase(nome))
                    .findFirst().orElse(null);
            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            itens.add(item);
        }
        if (itens.isEmpty()) {
            System.out.println("Pedido deve ter pelo menos um item.");
            return;
        }
        Pedido pedido = new Pedido();
        pedido.setItens(itens);
        pedidoService.cadastrarPedido(pedido);
        System.out.println("Pedido cadastrado com sucesso! Total: R$ " + pedido.getValorTotal());
    }

    public void consultarPedidosPorDia() {
        System.out.print("Digite a data (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("d/M/yyyy"));
        var pedidos = pedidoService.consultarPedidosPorDia(data);
        double faturamento = pedidoService.calcularFaturamentoPorDia(data);
        System.out.println("Pedidos do dia " + dataStr + ":");
        for (Pedido p : pedidos) {
            System.out.println("Pedido: " + p.getValorTotal());
            for (ItemPedido item : p.getItens()) {
                System.out.println("  " + item.getProduto().getNome() + " x" + item.getQuantidade());
            }
        }
        System.out.println("Faturamento total: R$ " + faturamento);
    }

    private void listarProdutos() {
        var produtos = produtoService.listarProdutos();
        System.out.println("Produtos disponíveis:");
        for (Produto p : produtos) {
            System.out.println("- " + p.getNome());
        }
    }
}
