package br.com.mercadolivre.obterdiploma.controller.utils;

import br.com.mercadolivre.obterdiploma.model.entities.Aluno;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;

public class CalculoMedia {

    public static double calculaMediaAluno(Aluno aluno){
        int qtdDisciplinas = aluno.getSubjects().size();
        return aluno.getSubjects().stream().mapToDouble(
                Subject::getNote).sum() / qtdDisciplinas;

    }
}
