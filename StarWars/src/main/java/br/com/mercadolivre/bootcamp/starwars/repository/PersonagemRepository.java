package br.com.mercadolivre.bootcamp.starwars.repository;

import br.com.mercadolivre.bootcamp.starwars.entities.Personagem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonagemRepository {

    private static final File FILE = new File("src/starwars.json");

    private final ObjectMapper mapper;

    @Autowired
    public PersonagemRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Personagem> pesquisa(String parteNome){
        List<Personagem> personagens = new ArrayList<>();
        try{
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Personagem>> typeReference = new TypeReference<List<Personagem>>() {};
            personagens = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        List<Personagem> personagemsCorrespondentes = new ArrayList<>();
        for(Personagem personagem: personagens){
            if (personagem.getName().toLowerCase().contains(parteNome)){
                personagemsCorrespondentes.add(personagem);
            }
        }
        return personagemsCorrespondentes;
    }
}
