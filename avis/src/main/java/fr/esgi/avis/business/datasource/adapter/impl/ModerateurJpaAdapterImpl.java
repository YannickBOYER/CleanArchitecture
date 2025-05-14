package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.business.datasource.adapter.ModerateurJpaAdapter;
import fr.esgi.avis.business.datasource.entity.ModerateurEntity;
import fr.esgi.avis.business.datasource.mapper.ModerateurMapper;
import fr.esgi.avis.usecase.repository.ModerateurRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ModerateurJpaAdapterImpl implements ModerateurJpaAdapter {
    private final ModerateurRepository repository;
    private final ModerateurMapper moderateurMapper;

    public ModerateurJpaAdapterImpl(ModerateurRepository repository,
                                    ModerateurMapper moderateurMapper) {
        this.repository = repository;
        this.moderateurMapper = moderateurMapper;
    }

    @Override
    public Optional<Moderateur> findById(Long id) {
        final Optional<ModerateurEntity> entity = repository.findById(id);
        return entity.map(moderateurMapper::toBusiness);
    }

    @Override
    public List<Moderateur> findAll() {
        final List<ModerateurEntity> entities = repository.findAll();
        return entities.stream().map(moderateurMapper::toBusiness).collect(Collectors.toList());
    }
}
