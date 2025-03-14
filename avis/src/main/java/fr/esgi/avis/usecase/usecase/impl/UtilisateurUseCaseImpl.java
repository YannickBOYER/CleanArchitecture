package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Utilisateur;
import fr.esgi.avis.business.datasource.adapter.UtilisateurJpaAdapter;
import fr.esgi.avis.usecase.exception.UtilisateurNotFoundException;
import fr.esgi.avis.usecase.usecase.UtilisateurUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurUseCaseImpl implements UtilisateurUseCase {
    private final UtilisateurJpaAdapter jpaAdapter;
    public UtilisateurUseCaseImpl(UtilisateurJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return jpaAdapter.save(utilisateur);
    }
    @Override
    public List<Utilisateur> findAll() {
        return jpaAdapter.findAll();
    }

    public Utilisateur findById(Long id) {
        final Optional<Utilisateur> optionalUtilisateur = jpaAdapter.findById(id);
        if (optionalUtilisateur.isPresent()) {
            return optionalUtilisateur.get();
        } else {
            throw new UtilisateurNotFoundException(id);
        }
    }
    @Override
    public void deleteById(Long id) {
        final Utilisateur utilisateur = findById(id);
        jpaAdapter.delete(utilisateur);
    }
}
