package br.com.mercadolivre.bootcamp.pedidosrestaurantell.service;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Caixa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class caixaService {

    private static Caixa caixa = new Caixa(0);

    public static double consultaValorCaixa(Caixa caixa){
        return caixa.getValorTotal();
    }

    public static double fecharMesa(Mesa mesa){
        double valorParaAdicionar = 0;
        valorParaAdicionar += mesa.getValorTotalConsumido();
        mesa.setListaPedidos(null);
        mesa.setValorTotalConsumido(0.0);
        return valorParaAdicionar;
    }

}
