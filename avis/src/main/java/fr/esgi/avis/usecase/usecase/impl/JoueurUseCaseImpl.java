package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.business.datasource.adapter.JoueurJpaAdapter;
import fr.esgi.avis.usecase.exception.JoueurNotFoundException;
import fr.esgi.avis.usecase.usecase.JoueurUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoueurUseCaseImpl implements JoueurUseCase {
    private final JoueurJpaAdapter adapter;

    public JoueurUseCaseImpl(JoueurJpaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Joueur findById(Long id) {
        final Optional<Joueur> optionalJoueur = adapter.findById(id);
        if(optionalJoueur.isPresent()){
            return optionalJoueur.get();
        }else{
            throw new JoueurNotFoundException(id);
        }
    }

    @Override
    public Joueur findByUsername(String username) {
        final Optional<Joueur> optionalJoueur = adapter.findByUsername(username);
        if(optionalJoueur.isPresent()){
            return optionalJoueur.get();
        }else{
            throw new JoueurNotFoundException(username);
        }
    }
}
