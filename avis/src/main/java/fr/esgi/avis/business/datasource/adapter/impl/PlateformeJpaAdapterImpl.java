package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.datasource.entity.GenreEntity;
import fr.esgi.avis.business.datasource.entity.PlateformeEntity;
import fr.esgi.avis.business.datasource.mapper.PlateformeMapper;
import fr.esgi.avis.usecase.repository.PlateformeRepository;
import org.springframework.stereotype.Component;
import fr.esgi.avis.business.datasource.adapter.PlateformeJpaAdapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlateformeJpaAdapterImpl implements PlateformeJpaAdapter{

    private final PlateformeMapper mapper;

    private final PlateformeRepository repository;

    public PlateformeJpaAdapterImpl(PlateformeMapper mapper, PlateformeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<Plateforme> findAll() {
        return repository.findAll().stream().map(mapper::toBusiness).collect(Collectors.toList());
    }

    @Override
    public Optional<Plateforme> findById(Long id) {
        final Optional<PlateformeEntity> optionnalEntity = repository.findById(id);
        return optionnalEntity.map(mapper::toBusiness);
    }
}
