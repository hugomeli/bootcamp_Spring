package br.com.mercadolivre.obterdiploma.model.service;

import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.utils.CalculoMedia;
import br.com.mercadolivre.obterdiploma.model.DTO.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public ResponseDTO getDiploma(Student student){
        double average = CalculoMedia.calculaMediaAluno(student);
        String message = formulaMensagem(average);
        return new ResponseDTO(
                message, average, student
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
