package br.com.mercadolivre.obterdiploma.controller;

import br.com.mercadolivre.obterdiploma.model.DTO.ResponseDTO;
import br.com.mercadolivre.obterdiploma.model.forms.StudentDTO;
import br.com.mercadolivre.obterdiploma.model.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ObterDiplomaController {

    private DiplomaService diplomaService;

    @Autowired
    public ObterDiplomaController(DiplomaService diplomaService){
        this.diplomaService = diplomaService;
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<ResponseDTO> obterDiploma(@Valid @RequestBody StudentDTO studentDTO){
        ResponseDTO responseDTO = diplomaService.getDiploma(StudentDTO.converteDTOparaAluno(studentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
