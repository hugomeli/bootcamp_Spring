package br.com.mercadolivre.obterdiploma.utils;

import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;

public class CalculoMedia {

    public static double calculaMediaAluno(Student student){
        int qtdDisciplinas = student.getSubjects().size();
        return student.getSubjects().stream().mapToDouble(
                Subject::getNote).sum() / qtdDisciplinas;

    }
}
