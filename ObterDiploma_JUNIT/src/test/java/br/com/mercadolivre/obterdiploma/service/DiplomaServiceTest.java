package br.com.mercadolivre.obterdiploma.service;

import br.com.mercadolivre.obterdiploma.model.DTO.ResponseDTO;
import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;
import br.com.mercadolivre.obterdiploma.model.service.DiplomaService;
import br.com.mercadolivre.obterdiploma.utils.CalculoMedia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiplomaServiceTest {

    private DiplomaService diplomaService;

    @BeforeEach
    public void init(){
        this.diplomaService = new DiplomaService();
    }

    @Test
    void mensagemDeveriaSerREPROVADOCasoAMediaSejaMenorDoQueSeis(){
        String message = diplomaService.formulaMensagem(5.0);
        String expectedMessage = "Sua média foi de 5.0 REPROVADO!";
        Assertions.assertEquals(expectedMessage, message);
    }

    @Test
    void mensagemDeveriaSerAPROVADOCasoAMediaSejaMaiorOuIgualASeisEMenorOuIgualANove(){
        String message = diplomaService.formulaMensagem(8.0);
        String expectedMessage = "Sua média foi de 8.0 APROVADO";
        Assertions.assertEquals(expectedMessage, message);
    }

    @Test
    void mensagemDeveriaSerAPROVADOComParabensCasoAMediaSejaMaiorDoQueNove(){
        String message = diplomaService.formulaMensagem(9.5);
        String expectedMessage = "Sua média foi de 9.5 APROVADO. PARABÉNS!";
        Assertions.assertEquals(expectedMessage, message);
    }

    @Test
    void deveriaGerarDiplomaComMensagemEMediaDasNotas(){
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Matemática", 10),
                new Subject("Português", 8.5),
                new Subject("Física", 9.5)
        ));
        Student student = new Student("Hugo", subjects);
        ResponseDTO responseDTOExpected = new ResponseDTO(
                "Sua média foi de 9.33 APROVADO. PARABÉNS!",
                9.33,
                student
        );

        ResponseDTO response = this.diplomaService.getDiploma(student);
        Assertions.assertEquals(responseDTOExpected.message, response.message);
    }

    @Test
    void naoDeveriaAceitarListaVaziaDeMaterias(){
        Student student = new Student("Hugo", new ArrayList<>());
        Assertions.assertThrows(NumberFormatException.class,
                () -> this.diplomaService.getDiploma(student));

    }
}
