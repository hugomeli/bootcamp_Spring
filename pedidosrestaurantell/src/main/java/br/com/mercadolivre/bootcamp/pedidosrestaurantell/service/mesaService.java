package br.com.mercadolivre.bootcamp.pedidosrestaurantell.service;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;

import java.util.List;

public class mesaService {

    public static Double calculaTotal(List<Pedido> listaDePedidos){
        double valorTotal = 0;
        for(Pedido pedido : listaDePedidos){
            valorTotal += pedido.getValorTotal();
        }
        return valorTotal;
    }
}
