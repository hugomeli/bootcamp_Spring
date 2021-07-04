package br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.dto.MesaDto;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MesaRepository {

    private final List<Mesa> listaMesas;


    MesaRepository(){
        // Criacao de 3 mesas iniciais
        this.listaMesas = new ArrayList<>(Arrays.asList(
                new Mesa(),
                new Mesa(),
                new Mesa()
        ));
    }

    private int findIndex(Long id){
        int arrayIndex = -1;
        for(int index = 0; index < this.listaMesas.size(); index ++){
            if(this.listaMesas.get(index).getId() == id){
                arrayIndex = index;
            }
        }
        return arrayIndex;
    }

    public List<Mesa> findAll(){
        return listaMesas;
    }

    public List<MesaDto> findAllDto(){
        List<MesaDto> listaMesaDto = new ArrayList<>();
        for (Mesa mesa:
             listaMesas) {
            listaMesaDto.add(MesaDto.converter(mesa));
        }
        return listaMesaDto;
//        return listaMesas.stream().map(mesa -> new MesaDto(mesa.getId(),
//                mesa.getListaPedidos(), mesa.getValorTotalConsumido()));
    }

    public Mesa findById(Long id) {
        return this.listaMesas.stream()
                .filter(mesa -> mesa.getId()==(id))
                .findFirst()
                .orElse(null);
    }

    public List<Pedido> findPedidoNaMesa(Long id){
        Mesa mesaEncontrada = this.listaMesas.stream()
                .filter(mesa -> mesa.getId() == (id))
                .findFirst()
                .orElse(null);
        assert mesaEncontrada != null;
        return mesaEncontrada.getListaPedidos();
    }

    public Mesa savePedido(Pedido pedido, Long idMesa){
        Mesa mesaEncontrada = this.listaMesas.stream()
                .filter(mesa -> mesa.getId() == (idMesa))
                .findFirst()
                .orElse(null);
        assert mesaEncontrada != null;
        mesaEncontrada.adicionaPedido(pedido);
        return mesaEncontrada;
    }

}
