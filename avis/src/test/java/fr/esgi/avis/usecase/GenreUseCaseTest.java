package fr.esgi.avis.usecase;

import fr.esgi.avis.usecase.exception.GenreNotFoundException;
import fr.esgi.avis.usecase.usecase.GenreUseCase;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenreUseCaseTest {
    @Autowired
    private GenreUseCase useCase;

    @Test
    @Order(1)
    void shouldReturnGenreNotFoundException(){
        final Long id = 123456789L;
        Exception exception = assertThrows(
                GenreNotFoundException.class,
                ()->{
                    useCase.findById(id);
                }
        );
        assertEquals("Impossible de trouver le genre possédant l'id " + id, exception.getMessage());
    }
}
