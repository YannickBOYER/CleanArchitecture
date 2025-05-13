/*package fr.esgi.avis.business.datasource.adapter.impl;

import fr.esgi.avis.business.Utilisateur;
import fr.esgi.avis.business.datasource.adapter.UtilisateurJpaAdapter;
import fr.esgi.avis.business.datasource.entity.UtilisateurEntity;
import fr.esgi.avis.business.datasource.mapper.UtilisateurMapper;
import fr.esgi.avis.usecase.repository.UtilisateurRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UtilisateurJpaAdapterImpl implements UtilisateurJpaAdapter {
    private final UtilisateurMapper mapper;
    private final UtilisateurRepository repository;

    public UtilisateurJpaAdapterImpl(UtilisateurMapper mapper, UtilisateurRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        final UtilisateurEntity entity = mapper.toEntity(utilisateur);
        return mapper.toBusiness(repository.save(entity));
    }
    @Override
    public List<Utilisateur> findAll() {
        return repository.findAll().stream().map(mapper::toBusiness).collect(Collectors.toList());
    }
    @Override
    public Optional<Utilisateur> findById(Long id) {
        return repository.findById(id).map(mapper::toBusiness);
    }
    @Override
    public void delete(Utilisateur utilisateur) {
        final UtilisateurEntity entity = mapper.toEntity(utilisateur);
        repository.delete(entity);
    }
}
*/