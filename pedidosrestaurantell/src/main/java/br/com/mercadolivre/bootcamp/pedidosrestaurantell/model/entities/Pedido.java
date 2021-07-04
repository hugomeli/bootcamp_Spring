package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.service.pedidoService;

import java.util.List;

public class Pedido {

    private final Long id;
    private Long idMesa;
    private List<Prato> listaPratosSolicitados;
    private double valorTotal;

    public Pedido(Long id, Long mesa, List<Prato> listaPratosSolicitados) {
        this.id = id;
        this.idMesa = mesa;
        this.listaPratosSolicitados = listaPratosSolicitados;
        this.valorTotal = pedidoService.calculaValorTotal(listaPratosSolicitados);
    }

    public Long getId() {
        return id;
    }

    public Long getidMesa() {
        return idMesa;
    }

    public void setMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public List<Prato> getListaPratosSolicitados() {
        return listaPratosSolicitados;
    }

    public void setListaPratosSolicitados(List<Prato> listaPratosSolicitados) {
        this.listaPratosSolicitados = listaPratosSolicitados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionaPrato(Prato prato){
        this.listaPratosSolicitados.add(prato);
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idMesa=" + idMesa +
                ", listaPratosSolicitados=" + listaPratosSolicitados +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
