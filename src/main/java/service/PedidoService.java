package service;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private ProdutoService produtoService;

    public PedidoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void cadastrarPedido(Pedido pedido) {
        double total = 0;
        for (ItemPedido item : pedido.getItens()) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        pedido.setValorTotal(total);
        pedido.setData(LocalDate.now());
        pedidos.add(pedido);
    }

    public List<Pedido> consultarPedidosPorDia(LocalDate data) {
        return pedidos.stream()
                .filter(p -> p.getData().equals(data))
                .collect(Collectors.toList());
    }

    public double calcularFaturamentoPorDia(LocalDate data) {
        return consultarPedidosPorDia(data).stream()
                .mapToDouble(Pedido::getValorTotal)
                .sum();
    }
}
