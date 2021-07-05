package br.com.mercadolivre.bootcamp.lojaclientes.controller;

import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Cliente;
import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.lojaclientes.model.repository.ClienteRepository;
import br.com.mercadolivre.bootcamp.lojaclientes.model.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste realizado com sucesso";
    }

    @GetMapping("/mostratodos")
    public List<Cliente> mostraTodosClientes(){
        return clienteRepository.getAll();
    }

    @PostMapping("/{idCliente}adicionapedido")
    public Cliente adicionaPedido(@PathVariable long idCliente, @RequestBody Pedido pedido){
        return clienteRepository.savePedido(pedido, idCliente);
    }

    @GetMapping("/consulta/{idCliente}")
    public Cliente consultaCliente(@PathVariable long idCliente){
        return clienteRepository.getClienteById(idCliente);
    }

}
