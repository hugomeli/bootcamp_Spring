package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.dto;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Prato;

import java.util.List;

public class MesaDto {

    private long idMesa;
    private List<Pedido> listaPedido;
    private double valorTotalConsumido;


    public MesaDto(long idMesa, List<Pedido> listaPedido, double valorTotalConsumido) {
        this.idMesa = idMesa;
        this.listaPedido = listaPedido;
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public static MesaDto converter(Mesa mesa){
        return new MesaDto(
                mesa.getId(),
                mesa.getListaPedidos(),
                mesa.getValorTotalConsumido()
        );
    }

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }

    public List<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }
}
