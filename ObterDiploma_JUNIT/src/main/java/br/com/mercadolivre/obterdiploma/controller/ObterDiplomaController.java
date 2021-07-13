package br.com.mercadolivre.obterdiploma.controller;

import br.com.mercadolivre.obterdiploma.model.DTO.ResponseDTO;
import br.com.mercadolivre.obterdiploma.model.entities.Aluno;
import br.com.mercadolivre.obterdiploma.model.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObterDiplomaController {

    private DiplomaService diplomaService;

    @Autowired
    public ObterDiplomaController(DiplomaService diplomaService){
        this.diplomaService = diplomaService;
    }

    @PostMapping("/analyzeNotes")
    public ResponseDTO obterDiploma(@RequestBody Aluno aluno){
        return diplomaService.getDiploma(aluno);
    }
}
