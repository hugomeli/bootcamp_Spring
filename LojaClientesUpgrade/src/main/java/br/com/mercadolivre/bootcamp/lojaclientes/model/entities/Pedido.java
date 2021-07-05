package br.com.mercadolivre.bootcamp.lojaclientes.model.entities;

import br.com.mercadolivre.bootcamp.lojaclientes.model.service.PedidoService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Long id;
    private List<Produto> listaDeProdutos;
    private double valorTotalPedido;
    private LocalDateTime dataPedido;

    public Pedido() {
    }

    public Pedido(Long id, List<Produto> listaDeProdutos) {
        this.id = id;
        this.listaDeProdutos = listaDeProdutos;
        this.valorTotalPedido = PedidoService.calculaValorTotal(this.listaDeProdutos);
        this.dataPedido = LocalDateTime.now();
    }


    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
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
