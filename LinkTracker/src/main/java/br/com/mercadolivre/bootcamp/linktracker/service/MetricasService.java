package br.com.mercadolivre.bootcamp.linktracker.service;

import br.com.mercadolivre.bootcamp.linktracker.validations.exceptions.LinkInvalidoException;
import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import br.com.mercadolivre.bootcamp.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricasService {

    private LinkRepository linkRepository;

    @Autowired
    public MetricasService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String execute(String mascara){
        for (Link link:
                this.linkRepository.getLinks()) {
            if (link.isValid() && link.getEnderecoMascarado().equals(mascara)){;
                return "Quantidade de acessos: " + link.getQuantidadeVisitas();
            }
        }
        throw new LinkInvalidoException();
    }
}
