package br.com.mercadolivre.obterdiploma.model.entities;

import java.util.List;

public class Aluno {

    private String nome;
    private List<Disciplina> disciplinasAprovadas;

    public Aluno(String nome, List<Disciplina> disciplinasAprovadas) {
        this.nome = nome;
        this.disciplinasAprovadas = disciplinasAprovadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasAprovadas() {
        return disciplinasAprovadas;
    }

    public void setDisciplinasAprovadas(List<Disciplina> disciplinasAprovadas) {
        this.disciplinasAprovadas = disciplinasAprovadas;
    }

    public void adicionaDisciplinaAprovada(Disciplina disciplinaAprovada){
        disciplinasAprovadas.add(disciplinaAprovada);
    }
}
