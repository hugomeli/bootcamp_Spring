package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.dto;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Prato;

import java.util.List;

public class PedidoDto {

    private Long idMesa;
    private List<Prato> listaPratosSolicitados;
    private double valorTotal;

    public PedidoDto(Long idMesa, List<Prato> listaPratosSolicitados, double valorTotal) {
        this.idMesa = idMesa;
        this.listaPratosSolicitados = listaPratosSolicitados;
        this.valorTotal = valorTotal;
    }

    public static PedidoDto converter(Pedido pedido){
        return new PedidoDto(pedido.getId(),
                pedido.getListaPratosSolicitados(),
                pedido.getValorTotal());
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
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
}
