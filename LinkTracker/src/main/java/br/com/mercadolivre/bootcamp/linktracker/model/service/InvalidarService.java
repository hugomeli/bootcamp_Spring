package br.com.mercadolivre.bootcamp.linktracker.model.service;

import br.com.mercadolivre.bootcamp.linktracker.validations.exceptions.LinkInvalidoException;
import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import br.com.mercadolivre.bootcamp.linktracker.model.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvalidarService {

    private LinkRepository linkRepository;

    @Autowired
    public InvalidarService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String execute(String mascara){
        for (Link link:
                this.linkRepository.getLinks()) {
            if (link.getEnderecoMascarado().equals(mascara)){
                link.setValid(false);
                link.setEnderecoMascarado(null);
                return "A máscara: " + mascara + " está inválida!";
            }
        }
        throw new LinkInvalidoException();
    }
}
