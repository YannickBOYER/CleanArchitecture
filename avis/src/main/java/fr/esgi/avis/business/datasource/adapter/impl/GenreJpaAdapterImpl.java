package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.datasource.adapter.GenreJpaAdapter;
import fr.esgi.avis.business.datasource.entity.GenreEntity;
import fr.esgi.avis.business.datasource.mapper.GenreMapper;
import fr.esgi.avis.usecase.repository.GenreRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GenreJpaAdapterImpl implements GenreJpaAdapter {
    private final GenreMapper mapper;
    private final GenreRepository repository;

    public GenreJpaAdapterImpl(GenreMapper genreMapper, GenreRepository genreRepository){
        this.mapper = genreMapper;
        this.repository = genreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        final GenreEntity entity = mapper.toEntity(genre);
        return mapper.toBusiness(repository.save(entity));
    }

    @Override
    public List<Genre> findAll() {
        return repository.findAll().stream().map(mapper::toBusiness).collect(Collectors.toList());
    }

    @Override
    public Optional<Genre> findById(Long id) {
        final Optional<GenreEntity> optionnalEntity = repository.findById(id);
        return optionnalEntity.map(mapper::toBusiness);
    }

    @Override
    public void delete(Genre genre) {
        final GenreEntity genreEntity = mapper.toEntity(genre);
        repository.delete(genreEntity);
    }
}
