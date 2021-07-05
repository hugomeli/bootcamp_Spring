package br.com.mercadolivre.bootcamp.lojaclientes.model.service;

import br.com.mercadolivre.bootcamp.lojaclientes.model.entities.Produto;

import java.util.List;

public class PedidoService {

    public static double calculaValorTotal(List<Produto> listaProdutos){
        double valorTotal = 0;
        for (Produto produto:
             listaProdutos) {
            valorTotal += produto.getPreco() * produto.getQuantidade();
        }
        return valorTotal;
    }
}
