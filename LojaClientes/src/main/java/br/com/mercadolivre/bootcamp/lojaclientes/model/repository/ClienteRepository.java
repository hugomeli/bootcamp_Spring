package br.com.mercadolivre.bootcamp.lojaclientes.model.repository;


import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Cliente;
import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Pedido;
import br.com.mercadolivre.bootcamp.lojaclientes.model.service.ClienteService;
import br.com.mercadolivre.bootcamp.lojaclientes.model.service.PedidoService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClienteRepository {

    private final List<Cliente> listaClientes;

    ClienteRepository(){
        // Criando 3 clientes
        this.listaClientes = new ArrayList<>(Arrays.asList(
                new Cliente("Carlos",
                            "999.321.456-00",
                            "carlos@ig.com.br",
                             "(99) 96921-99999",
                            null),
                new Cliente("Joao",
                        "998.312.414-00",
                        "joao@ig.com.br",
                        "(99) 92421-912313",
                        null),
                new Cliente("Joana",
                        "997.531.643-00",
                        "joana@bol.com.br",
                        "(99) 93123-999312",
                        null)
        ));
    }

    public List<Cliente> getAll(){
        return listaClientes;
    }

    public Cliente savePedido(Pedido pedido, Long idCliente){
        Cliente clienteEncontrado = this.listaClientes.stream()
                .filter(cliente -> cliente.getId() == (idCliente))
                .findFirst()
                .orElse(null);
        assert clienteEncontrado != null;
        pedido.setValorTotalPedido(PedidoService.calculaValorTotal(pedido.getListaDeProdutos()));
        ClienteService.adicionaPedido(pedido, clienteEncontrado);
        return clienteEncontrado;
    }

    public Cliente getClienteById(long idCliente) {
        return this.listaClientes.stream()
                .filter(cliente -> cliente.getId() == (idCliente))
                .findFirst()
                .orElse(null);
    }
}
