package br.com.mercadolivre.obterdiploma.model.DTO;


import br.com.mercadolivre.obterdiploma.model.entities.Student;

public class ResponseDTO {

    public String message;
    public double average;
    public Student student;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, double average, Student student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public static ResponseDTO converte(String message, Double average, Student student){
        return new ResponseDTO(
                message,
                average,
                student
        );
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
