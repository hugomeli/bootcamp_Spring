package br.com.mercadolivre.obterdiploma.model.forms;

import br.com.mercadolivre.obterdiploma.model.entities.Subject;

import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectDTO {

    @NotBlank
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[A-Za-z_áíó]*$")
    private String subject;

    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    private Double note;

    public SubjectDTO() {
    }

    public SubjectDTO(String subject, Double note) {
        this.subject = subject;
        this.note = note;
    }

    public Subject convert(){
        return new Subject(this.subject, this.note);
    }

    public static List<Subject> convert(List<SubjectDTO> subjectDTOS){
        return subjectDTOS.stream().map(SubjectDTO::convert).collect(Collectors.toList());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }


}
