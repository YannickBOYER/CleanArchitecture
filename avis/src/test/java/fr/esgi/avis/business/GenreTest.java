package fr.esgi.avis.business;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GenreTest {

    @Test
    @Order(1)
    void shouldCreateGenre() {
        Genre genre = new Genre(1L, "Science-Fiction");
        assertEquals(1L, genre.getId());
        assertEquals("Science-Fiction", genre.getNom());
    }

    @Test
    @Order(2)
    void shouldSetGenre() {
        Genre genre = new Genre();
        genre.setId(2L);
        genre.setNom("Fantasy");

        assertEquals(2L, genre.getId());
        assertEquals("Fantasy", genre.getNom());
    }
}