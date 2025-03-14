package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.datasource.adapter.JeuJpaAdapter;
import fr.esgi.avis.usecase.exception.JeuNotFoundException;
import fr.esgi.avis.usecase.usecase.JeuUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuUseCaseImpl implements JeuUseCase {

    private final JeuJpaAdapter adapter;

    public JeuUseCaseImpl(JeuJpaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Jeu save(Jeu jeu) {
        return adapter.save(jeu);
    }

    @Override
    public List<Jeu> findAll() {
        return adapter.findAll();
    }

    @Override
    public Jeu findById(Long id) {
        Optional<Jeu> optionalJeu = adapter.findById(id);
        if(optionalJeu.isPresent()){
            return optionalJeu.get();
        }else{
            throw new JeuNotFoundException(id);
        }
    }
}
