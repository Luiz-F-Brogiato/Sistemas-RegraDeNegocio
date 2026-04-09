package EstruturacaoDeSistemas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate data;
    private List<ItemPedido> itens;
    private double valorTotal;

    public Pedido(LocalDate data) {
        this.data = data;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        valorTotal = 0;
        for (ItemPedido item : itens) {
            valorTotal += item.calcularSubtotal();
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }
}

