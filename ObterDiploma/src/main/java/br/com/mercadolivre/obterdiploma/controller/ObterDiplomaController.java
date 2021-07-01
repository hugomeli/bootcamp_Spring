package br.com.mercadolivre.obterdiploma.controller;

import br.com.mercadolivre.obterdiploma.controller.utils.CalculoMedia;
import br.com.mercadolivre.obterdiploma.controller.utils.MontaMensagem;
import br.com.mercadolivre.obterdiploma.model.entities.Aluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObterDiplomaController {

    @PostMapping("/obter/diploma")
    public String obterDiploma(@RequestBody Aluno aluno){
        double media = CalculoMedia.calculaMediaAluno(aluno);
        if (media > 9){
            return MontaMensagem.montaMensagemMerito(media, aluno.getNome());
        } else{
            return MontaMensagem.montaMensagemSemMerito(media, aluno.getNome());
        }
    }
}
