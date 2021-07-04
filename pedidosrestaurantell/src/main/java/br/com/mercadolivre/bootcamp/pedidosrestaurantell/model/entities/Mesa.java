package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.service.mesaService;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private static long counterId = 1;
    private List<Pedido> listaPedidos;
    private double valorTotalConsumido;
    private long id;

    public Mesa(){
        this.id = counterId;
        this.listaPedidos = null;
        this.valorTotalConsumido = 0.0;
        counterId += 1;
    }

    public Mesa(List<Pedido> listaPedidos) {
        this.id = counterId;
        this.listaPedidos = listaPedidos;
        this.valorTotalConsumido = mesaService.calculaTotal(listaPedidos);
        counterId += 1;
    }

    public long getId() {
        return id;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public void adicionaPedido(Pedido pedido){
        if (this.listaPedidos == null){
            this.listaPedidos = new ArrayList<Pedido>();
        }
        this.listaPedidos.add(pedido);
        this.valorTotalConsumido += pedido.getValorTotal();
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "listaPedidos=" + listaPedidos +
                ", valorTotalConsumido=" + valorTotalConsumido +
                ", id=" + id +
                '}';
    }
}
