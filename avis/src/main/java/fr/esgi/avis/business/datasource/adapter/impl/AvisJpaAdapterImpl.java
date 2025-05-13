package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.datasource.adapter.AvisJpaAdapter;
import fr.esgi.avis.business.datasource.entity.AvisEntity;
import fr.esgi.avis.business.datasource.mapper.AvisMapper;
import fr.esgi.avis.usecase.repository.AvisEntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class AvisJpaAdapterImpl implements AvisJpaAdapter {
    private final AvisEntityRepository repository;
    private final AvisMapper avisMapper;

    public AvisJpaAdapterImpl(AvisEntityRepository repository,
                              AvisMapper avisMapper) {
        this.repository = repository;
        this.avisMapper = avisMapper;
    }

    @Override
    public Page<Avis> findByJeu(Long id, Pageable pageable) {
        final Page<AvisEntity> entities = repository.findByJeuId(id, pageable);
        return entities.map(avisMapper::toBusiness);
    }
}
