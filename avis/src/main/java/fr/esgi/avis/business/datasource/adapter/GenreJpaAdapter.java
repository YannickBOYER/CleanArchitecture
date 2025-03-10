package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Genre;

import java.util.List;

public interface GenreJpaAdapter {
    Genre save(Genre genre);
    List<Genre> findAll();
    Genre findById(Long id);
    Genre update(Long id, Genre genre);
    void delete(Long id);
}
