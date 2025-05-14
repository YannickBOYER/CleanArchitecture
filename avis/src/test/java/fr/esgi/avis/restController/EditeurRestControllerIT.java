package fr.esgi.avis.restController;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.avis.controller.rest.dto.in.EditeurRequestDTO;
import fr.esgi.avis.usecase.exception.EditeurNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")
class EditeurRestControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void shouldCreateEditeur() throws Exception {
        final EditeurRequestDTO editeur = new EditeurRequestDTO();
        editeur.nom = "Kepler Interactive";

        String url = "/api/Editeurs";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(editeur)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    void shouldReturnEditeurNotFoundException() throws Exception{
        final Long id = 123456789L;
        String url = "/api/Editeurs/" + id;

        mockMvc.perform(delete(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    assertThat(result.getResolvedException()).isInstanceOf(EditeurNotFoundException.class);
                });
    }
}
