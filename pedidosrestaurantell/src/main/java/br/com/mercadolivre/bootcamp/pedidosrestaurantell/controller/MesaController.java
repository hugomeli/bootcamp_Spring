package br.com.mercadolivre.bootcamp.pedidosrestaurantell.controller;

import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.dto.MesaDto;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Mesa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    MesaRepository mesaRepository;

    public MesaController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Sucesso no teste";
    }

    @GetMapping("/consulta/{id}")
    public Mesa getId(@PathVariable long id){
        return mesaRepository.findById(id);
    }

    @GetMapping("/consulta/todas")
    public List<Mesa> mostraTodas(){
        return mesaRepository.findAll();
    }

    @GetMapping("/consulta/todasDto")
    public List<MesaDto> mostraTodasDto(){
        return mesaRepository.findAllDto();
    }



}
