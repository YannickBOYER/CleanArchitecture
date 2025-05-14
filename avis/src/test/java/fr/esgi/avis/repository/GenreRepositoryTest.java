package fr.esgi.avis.repository;

import fr.esgi.avis.business.datasource.entity.GenreEntity;
import fr.esgi.avis.usecase.repository.GenreRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")
class GenreRepositoryTest {
    @Autowired
    private GenreRepository repository;

    @Test
    @Order(1)
    void shouldSaveGenreAsEntity(){
        final long genreNumber = repository.count();
        assertEquals(genreNumber, repository.count());
        final GenreEntity genre = new GenreEntity("Action aventure");
        repository.save(genre);
        assertEquals(genreNumber + 1, repository.count());
    }
}
