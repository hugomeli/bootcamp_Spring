package br.com.mercadolivre.obterdiploma.model.forms;

import br.com.mercadolivre.obterdiploma.model.entities.Student;
import br.com.mercadolivre.obterdiploma.model.entities.Subject;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotBlank
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^[A-Za-z_ ]*$")
    private String name;

    @Valid
    @NotNull
    @Size(max = 10)
    private List<SubjectDTO> subjectsDTO;


    public StudentDTO() {
    }

    public StudentDTO(String name, List<SubjectDTO> subjectsDTO) {
        this.name = name;
        this.subjectsDTO = subjectsDTO;
    }

    public static Student converteDTOparaAluno(StudentDTO studentDTO){
        return new Student(
                studentDTO.name,
                SubjectDTO.convert(studentDTO.subjectsDTO)
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjectsDTO;
    }

    public void setSubjects(List<SubjectDTO> subjectsDTO) {
        this.subjectsDTO = subjectsDTO;
    }

    public List<SubjectDTO> getSubjectsDTO() {
        return subjectsDTO;
    }

    public void setSubjectsDTO(List<SubjectDTO> subjectsDTO) {
        this.subjectsDTO = subjectsDTO;
    }
}
