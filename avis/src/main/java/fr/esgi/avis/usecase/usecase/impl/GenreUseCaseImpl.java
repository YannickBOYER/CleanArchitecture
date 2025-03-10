package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.datasource.adapter.GenreJpaAdapter;
import fr.esgi.avis.usecase.usecase.GenreUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreUseCaseImpl implements GenreUseCase {
    private final GenreJpaAdapter jpaAdapter;

    public GenreUseCaseImpl(GenreJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }

    public Genre save(Genre genre){
        return jpaAdapter.save(genre);
    }
    public List<Genre> findAll(){
        return jpaAdapter.findAll();
    }
    public Genre findById(Long id){
        return jpaAdapter.findById(id);
    }
    public Genre update(Long id, Genre genre){
        return jpaAdapter.update(id, genre);
    }
    public void delete(Long id){
        jpaAdapter.delete(id);
    }
}
