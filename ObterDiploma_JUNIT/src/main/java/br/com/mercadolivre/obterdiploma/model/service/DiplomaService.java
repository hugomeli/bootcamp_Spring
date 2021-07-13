package br.com.mercadolivre.obterdiploma.model.service;

import br.com.mercadolivre.obterdiploma.controller.utils.CalculoMedia;
import br.com.mercadolivre.obterdiploma.model.DTO.ResponseDTO;
import br.com.mercadolivre.obterdiploma.model.entities.Aluno;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public ResponseDTO getDiploma(Aluno aluno){
        double average = CalculoMedia.calculaMediaAluno(aluno);
        String message = formulaMensagem(average);
        return new ResponseDTO(
                message, average, aluno
        );
    }

    public String formulaMensagem(Double average){
        String message = "Sua média foi de " + average;
        if (average < 6.0){
            message += " REPROVADO!";
        } else if (average > 9.0){
            message += " APROVADO. PARABÉNS!";
        } else {
            message += " APROVADO";
        }
        return message;
    }
}
