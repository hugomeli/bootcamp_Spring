package br.com.mercadolivre.bootcamp.pedidosrestaurantell.service;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Prato;

import java.util.List;

public class pedidoService {

    public static Double calculaValorTotal(List<Prato> listaPratos){
        double valorTotal = 0;
        for (Prato prato:
             listaPratos) {
            valorTotal += prato.getPreco() * prato.getQuantidade();
        }
        return valorTotal;
    }
}
