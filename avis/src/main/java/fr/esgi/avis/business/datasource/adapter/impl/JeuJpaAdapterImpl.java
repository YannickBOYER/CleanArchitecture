package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.datasource.adapter.JeuJpaAdapter;
import fr.esgi.avis.business.datasource.entity.JeuEntity;
import fr.esgi.avis.business.datasource.mapper.JeuMapper;
import fr.esgi.avis.usecase.repository.JeuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JeuJpaAdapterImpl implements JeuJpaAdapter {
    private final JeuRepository jeuRepository;
    private final JeuMapper jeuMapper;

    public JeuJpaAdapterImpl(JeuRepository jeuRepository, JeuMapper jeuMapper) {
        this.jeuRepository = jeuRepository;
        this.jeuMapper = jeuMapper;
    }

    @Override
    public Jeu save(Jeu jeu) {
        final JeuEntity jeuEntity = jeuMapper.toEntity(jeu);
        return jeuMapper.toBusiness(jeuRepository.save(jeuEntity));
    }

    @Override
    public List<Jeu> findAll() {
        final List<JeuEntity> entites = jeuRepository.findAll();
        return entites.stream().map(jeuMapper::toBusiness).collect(Collectors.toList());
    }

    @Override
    public Page<Jeu> findAll(Pageable pageable) {
        final Page<JeuEntity> entites = jeuRepository.findAll(pageable);
        return entites.map(jeuMapper::toBusiness);
        //return entites.stream().map(jeuMapper::toBusiness).collect(Collectors.toList());
    }

    @Override
    public Optional<Jeu> findById(Long id) {
        return jeuRepository.findById(id).map(jeuMapper::toBusiness);
    }
}
