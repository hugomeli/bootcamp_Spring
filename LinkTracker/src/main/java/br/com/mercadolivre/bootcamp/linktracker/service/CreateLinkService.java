package br.com.mercadolivre.bootcamp.linktracker.service;


import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import br.com.mercadolivre.bootcamp.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLinkService {

    private LinkRepository linkRepository;

    @Autowired
    public CreateLinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public String execute(Link link){
        return linkRepository.criarLink(link);
    }
}
