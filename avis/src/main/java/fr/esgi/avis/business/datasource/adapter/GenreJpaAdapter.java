package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreJpaAdapter {
    Genre save(Genre genre);
    List<Genre> findAll();
    Optional<Genre> findById(Long id);
    void delete(Genre genre);

}
