package br.com.mercadolivre.obterdiploma.model.DTO;


import br.com.mercadolivre.obterdiploma.model.entities.Aluno;

public class ResponseDTO {

    public String message;
    public double average;
    public Aluno aluno;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, double average, Aluno aluno) {
        this.message = message;
        this.average = average;
        this.aluno = aluno;
    }

    public static ResponseDTO converte(String message, Double average, Aluno aluno){
        return new ResponseDTO(
                message,
                average,
                aluno
        );
    }
}
