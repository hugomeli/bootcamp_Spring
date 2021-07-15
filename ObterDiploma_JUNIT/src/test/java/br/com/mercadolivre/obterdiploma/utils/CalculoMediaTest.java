package br.com.mercadolivre.obterdiploma.utils;

import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculoMediaTest {

    @Test
    void deveriaCalcularMediaEntreTresNotas(){
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Matemática", 10),
                new Subject("Português", 8.5),
                new Subject("Física", 9.5)
        ));
        Student student = new Student("Hugo", subjects);
        double average = CalculoMedia.calculaMediaAluno(student);
        Assertions.assertEquals(9.33, average);
    }
}
