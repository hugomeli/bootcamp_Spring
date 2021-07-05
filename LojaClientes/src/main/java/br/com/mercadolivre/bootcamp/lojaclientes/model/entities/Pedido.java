package br.com.mercadolivre.bootcamp.lojaclientes.model.entities;

import br.com.mercadolivre.bootcamp.lojaclientes.model.service.PedidoService;

import java.util.List;

public class Pedido {

    private Long id;
    private List<Produto> listaDeProdutos;
    private double valorTotalPedido;

    public Pedido() {
    }

    public Pedido(Long id, List<Produto> listaDeProdutos) {
        this.id = id;
        this.listaDeProdutos = listaDeProdutos;
        this.valorTotalPedido = PedidoService.calculaValorTotal(this.listaDeProdutos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }
}
