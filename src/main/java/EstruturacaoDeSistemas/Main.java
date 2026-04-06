package EstruturacaoDeSistemas;

import controler.*;
import service.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService(produtoService);
        ProdutoController produtoController = new ProdutoController(produtoService, scanner);
        PedidoController pedidoController = new PedidoController(pedidoService, produtoService, scanner);
        while (true) {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Cadastrar Pedido");
            System.out.println("4. Consultar Pedidos por Dia");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    produtoController.cadastrarProduto();
                    break;
                case 2:
                    produtoController.listarProdutos();
                    break;
                case 3:
                    pedidoController.cadastrarPedido();
                    break;
                case 4:
                    pedidoController.consultarPedidosPorDia();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}