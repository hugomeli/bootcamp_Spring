package br.com.mercadolivre.bootcamp.linktracker.model.repository;


import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {

    public List<Link> links;

    @Autowired
    public LinkRepository() {
        links = new ArrayList<>();
    }

    public String criarLink(Link link){
        links.add(link);
        return link.getEnderecoMascarado();
    }

    public List<Link> getLinks() {
        return links;
    }
}
