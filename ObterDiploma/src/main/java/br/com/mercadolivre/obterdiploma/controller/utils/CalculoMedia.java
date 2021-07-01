package br.com.mercadolivre.obterdiploma.controller.utils;

import br.com.mercadolivre.obterdiploma.model.entities.Aluno;
import br.com.mercadolivre.obterdiploma.model.entities.Disciplina;

public class CalculoMedia {

    public static double calculaMediaAluno(Aluno aluno){
        int qtdDisciplinas = aluno.getDisciplinasAprovadas().size();
        return aluno.getDisciplinasAprovadas().stream().mapToDouble(
                Disciplina::getNota).sum() / qtdDisciplinas;

    }
}
