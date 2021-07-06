package br.com.mercadolivre.bootcamp.linktracker.model.service;


import br.com.mercadolivre.bootcamp.linktracker.validations.exceptions.LinkInvalidoException;
import br.com.mercadolivre.bootcamp.linktracker.validations.exceptions.SenhaInvalidaException;
import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import br.com.mercadolivre.bootcamp.linktracker.model.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirecionamentoService {

    private LinkRepository linkRepository;

    @Autowired
    public RedirecionamentoService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String execute(String mascara, String senha){
        for (Link link:
                this.linkRepository.getLinks()) {
            if (link.isValid() && link.getEnderecoMascarado().equals(mascara)){
                if (link.getSenha().equals(senha)){
                    link.setQuantidadeVisitas(link.getQuantidadeVisitas() + 1);
                    return link.getEndereco();
                } else {
                    throw new SenhaInvalidaException();
                }
            }
        }
        throw new LinkInvalidoException();
    }
}
