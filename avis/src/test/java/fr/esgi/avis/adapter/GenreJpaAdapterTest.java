package fr.esgi.avis.adapter;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.datasource.adapter.GenreJpaAdapter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenreJpaAdapterTest {
    @Autowired
    private GenreJpaAdapter adapter;

    @Test
    @Order(1)
    void shouldSaveGenreAsBusiness(){
        final Genre genre = adapter.save(new Genre("Action aventure"));
        assertNotNull(genre.getId());
        assertEquals("Action aventure", genre.getNom());
    }
}
