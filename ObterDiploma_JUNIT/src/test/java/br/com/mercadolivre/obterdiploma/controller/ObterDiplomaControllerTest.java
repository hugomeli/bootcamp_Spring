package br.com.mercadolivre.obterdiploma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import br.com.mercadolivre.obterdiploma.model.forms.StudentDTO;
import br.com.mercadolivre.obterdiploma.model.forms.SubjectDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ObterDiplomaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void deveriaAnalisarAsNotas() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Afonso Morais",
                List.of(new SubjectDTO("Matemática", 9.0),
                        (new SubjectDTO("Geografia", 10.0))));

        String payload = mapper.writeValueAsString(studentDTO);

        double mediaEsperada = 9.5;
        String mensagemEsperada = "Sua média foi de 9.5 APROVADO. PARABÉNS!";

        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(mensagemEsperada))
                .andExpect(jsonPath("$.average").value(mediaEsperada));
    }

    @Test
    void naoDeveriaAnalizarAsNotasCasoOsParametrosSejamInvalidos() throws Exception {
        StudentDTO studentDTO = new StudentDTO("", List.of(
                new SubjectDTO("Matemática", 9.5),
                new SubjectDTO("Geografia", 5.6)
        ));

        String payload = mapper.writeValueAsString(studentDTO);

        mvc.perform(post("/analyzeNotes")
        .contentType("application/json")
        .content(payload))
                .andExpect(status().isBadRequest());
    }


}
