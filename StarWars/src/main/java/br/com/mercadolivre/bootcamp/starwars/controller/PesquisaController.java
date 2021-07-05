package br.com.mercadolivre.bootcamp.starwars.controller;


import br.com.mercadolivre.bootcamp.starwars.services.PesquisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class PesquisaController {

    @Autowired
    PesquisaService pesquisaService;

    @GetMapping("/teste")
    public String testando(){
        return "Teste efetuado com sucesso";
    }

    @GetMapping("/localiza/{parteNome}")
    public List<String> localizaNome(@PathVariable String parteNome){
        return pesquisaService.montaListaNomes(parteNome.toLowerCase());
    }

}
