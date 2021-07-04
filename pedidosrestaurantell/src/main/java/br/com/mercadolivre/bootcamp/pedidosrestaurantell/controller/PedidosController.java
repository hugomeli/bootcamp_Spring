package br.com.mercadolivre.bootcamp.pedidosrestaurantell.controller;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidosController {

    MesaRepository mesaRepository;

    public PedidosController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Sucesso no teste de pedidos";
    }

    @GetMapping("/{id}")
    public List<Pedido> pedidosDaquelaMesa(@PathVariable Long id){
        return mesaRepository.findPedidoNaMesa(id);
    }

    @PostMapping("/post")
    public Mesa adicionaPedidosNaMesa(@RequestBody Pedido pedido){
        return mesaRepository.savePedido(pedido, pedido.getidMesa());
    }

}
