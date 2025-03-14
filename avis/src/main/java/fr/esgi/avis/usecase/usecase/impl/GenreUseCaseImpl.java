package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.datasource.adapter.GenreJpaAdapter;
import fr.esgi.avis.usecase.exception.GenreNotFoundException;
import fr.esgi.avis.usecase.usecase.GenreUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreUseCaseImpl implements GenreUseCase {
    private final GenreJpaAdapter jpaAdapter;

    public GenreUseCaseImpl(GenreJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }
    @Override
    public Genre save(Genre genre){
        return jpaAdapter.save(genre);
    }
    @Override
    public List<Genre> findAll(){
        return jpaAdapter.findAll();
    }
    @Override
    public Genre findById(Long id){
        final Optional<Genre> optionalGenre = jpaAdapter.findById(id);
        if(optionalGenre.isPresent()){
            return optionalGenre.get();
        }else{
            throw new GenreNotFoundException(id);
        }
    }
    @Override
    public Genre update(Long id, Genre genreUpdated){
        final Genre genre = findById(id);
        genre.setNom(genreUpdated.getNom());
        return save(genre);
    }
    @Override
    public void delete(Long id){
        final Genre genre = findById(id);
        jpaAdapter.delete(genre);
    }
}
