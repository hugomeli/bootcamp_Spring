package br.com.mercadolivre.obterdiploma.model.forms;

import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;

import javax.validation.constraints.NotNull;
import java.util.List;

public class StudentDTO {

    @NotNull
    private String name;
    private List<Subject> subjects;


    public StudentDTO() {
    }

    public StudentDTO(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public static Student converteDTOparaAluno(StudentDTO studentDTO){
        return new Student(
                studentDTO.name,
                studentDTO.subjects
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
