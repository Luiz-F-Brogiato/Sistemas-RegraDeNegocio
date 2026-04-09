package EstruturacaoDeSistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();

        Produto hamburguer = new Produto("Hambúrguer", "Hambúrguer artesanal", 25.00);
        Produto refrigerante = new Produto("Refrigerante", "Refrigerante gelado", 8.00);
        Produto batataFrita = new Produto("Batata Frita", "Porção de batata frita", 15.00);

        LocalDate dataHoje = LocalDate.now();
        Pedido pedido1 = new Pedido(dataHoje);

        ItemPedido item1 = new ItemPedido(hamburguer, 2);
        ItemPedido item2 = new ItemPedido(refrigerante, 2);
        ItemPedido item3 = new ItemPedido(batataFrita, 1);

        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        pedido1.adicionarItem(item3);

        pedidos.add(pedido1);

        System.out.println("=== SISTEMA DE PEDIDOS DE LANCHONETE ===");
        System.out.println();
        System.out.println("Pedido realizado em: " + pedido1.getData());
        System.out.println("Itens do pedido:");

        for (ItemPedido item : pedido1.getItens()) {
            System.out.println("  - " + item.getProduto().getNome() +
                             " (Quantidade: " + item.getQuantidade() +
                             ") - Subtotal: R$ " + String.format("%.2f", item.calcularSubtotal()));
        }

        System.out.println();
        System.out.println("Valor Total do Pedido: R$ " + String.format("%.2f", pedido1.getValorTotal()));
        System.out.println();

        double faturamentoDia = consultarFaturamentoPorDia(pedidos, dataHoje);
        System.out.println("Faturamento total do dia " + dataHoje + ": R$ " + String.format("%.2f", faturamentoDia));
    }

    private static double consultarFaturamentoPorDia(List<Pedido> pedidos, LocalDate data) {
        double faturamento = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getData().equals(data)) {
                faturamento += pedido.getValorTotal();
            }
        }
        return faturamento;
    }
}