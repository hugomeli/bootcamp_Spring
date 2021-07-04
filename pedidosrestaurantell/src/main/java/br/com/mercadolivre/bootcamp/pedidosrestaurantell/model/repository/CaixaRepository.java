package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Caixa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class CaixaRepository {

    private final Caixa caixa;


    CaixaRepository(){
        // Criacao de 3 mesas iniciais
        this.caixa = new Caixa(0.0);
    }

    public Caixa retornaCaixa(){
        return this.caixa;
    }
}
