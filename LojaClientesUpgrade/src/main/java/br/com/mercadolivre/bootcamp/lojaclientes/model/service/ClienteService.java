package br.com.mercadolivre.bootcamp.lojaclientes.model.service;

import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Cliente;
import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    public static void adicionaPedido(Pedido pedido, Cliente cliente){
        if (cliente.getPedidosRegistrados() == null){
            cliente.setPedidosRegistrados(new ArrayList<Pedido>());
        }
        List<Pedido> listaPedidos = cliente.getPedidosRegistrados();
        pedido.setDataPedido(LocalDateTime.now());
        listaPedidos.add(pedido);
        cliente.setPedidosRegistrados(listaPedidos);
    }
}
