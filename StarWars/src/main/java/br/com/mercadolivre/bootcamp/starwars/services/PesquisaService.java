package br.com.mercadolivre.bootcamp.starwars.services;

import br.com.mercadolivre.bootcamp.starwars.entities.Personagem;
import br.com.mercadolivre.bootcamp.starwars.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PesquisaService {

    PersonagemRepository repository;

    @Autowired
    public PesquisaService(PersonagemRepository repository){
        this.repository = repository;
    }

    public List<String> montaListaNomes(String parteNome){
       List<Personagem> listaPersonagens = this.repository.pesquisa(parteNome);
       List<String> listaNomes = new ArrayList<>();
        for (Personagem personagem:
             listaPersonagens) {
            listaNomes.add(personagem.getName());
        }
        return listaNomes;
    }
}
