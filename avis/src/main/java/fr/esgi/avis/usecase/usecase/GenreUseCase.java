package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Genre;

import java.util.List;

public interface GenreUseCase {
    public Genre save(Genre genre);
    public List<Genre> findAll();
    public Genre findById(Long id);
    public Genre update(Long id, Genre genre);
    public void delete(Long id);
}
