package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.business.datasource.adapter.JoueurJpaAdapter;
import fr.esgi.avis.business.datasource.entity.JoueurEntity;
import fr.esgi.avis.business.datasource.mapper.JoueurMapper;
import fr.esgi.avis.usecase.repository.JoueurRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JoueurJpaAdapterImpl implements JoueurJpaAdapter {
    private final JoueurRepository repo;
    private final JoueurMapper joueurMapper;

    public JoueurJpaAdapterImpl(JoueurRepository repo,
                                JoueurMapper joueurMapper) {
        this.repo = repo;
        this.joueurMapper = joueurMapper;
    }

    @Override
    public Optional<Joueur> findById(Long id) {
        final Optional<JoueurEntity> entity = repo.findById(id);
        return entity.map(joueurMapper::toBusiness);
    }

    @Override
    public Optional<Joueur> findByUsername(String username) {
        final Optional<JoueurEntity> entity = repo.findByPseudo(username);
        return entity.map(joueurMapper::toBusiness);
    }
}
