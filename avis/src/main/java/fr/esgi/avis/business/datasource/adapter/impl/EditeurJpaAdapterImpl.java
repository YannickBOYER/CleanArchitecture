package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.business.datasource.adapter.EditeurJpaAdapter;
import fr.esgi.avis.business.datasource.entity.EditeurEntity;
import fr.esgi.avis.business.datasource.mapper.EditeurMapper;
import fr.esgi.avis.usecase.repository.EditeurRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EditeurJpaAdapterImpl implements EditeurJpaAdapter {
    private final EditeurMapper mapper;

    private final EditeurRepository repository;

    public EditeurJpaAdapterImpl(EditeurMapper mapper, EditeurRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Editeur save(Editeur editeur) {
        final EditeurEntity entity = mapper.toEntity(editeur);
        return mapper.toBusiness(repository.save(entity));
    }

    @Override
    public List<Editeur> findAll() {
        return repository.findAll().stream().map(mapper::toBusiness).collect(Collectors.toList());
    }

    @Override
    public Optional<Editeur> findById(Long id) {
        return repository.findById(id).map(mapper::toBusiness);
    }

    @Override
    public void delete(Editeur editeur) {
        final EditeurEntity entity = mapper.toEntity(editeur);
        repository.delete(entity);
    }
}
