package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.datasource.adapter.ClassificationJpaAdapter;
import fr.esgi.avis.business.datasource.entity.ClassificationEntity;
import fr.esgi.avis.business.datasource.mapper.ClassificationMapper;
import fr.esgi.avis.usecase.repository.ClassificationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClassificationJpaAdapterImpl implements ClassificationJpaAdapter {
    private final ClassificationRepository repository;
    private final ClassificationMapper mapper;

    public ClassificationJpaAdapterImpl(ClassificationRepository repository, ClassificationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Classification> findById(Long id) {
        return repository.findById(id).map(mapper::toBusiness);
    }

    @Override
    public List<Classification> findAll() {
        final List<ClassificationEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toBusiness).collect(Collectors.toList());
    }
}
