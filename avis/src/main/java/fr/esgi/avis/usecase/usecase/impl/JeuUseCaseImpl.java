package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.datasource.adapter.AvisJpaAdapter;
import fr.esgi.avis.business.datasource.adapter.JeuJpaAdapter;
import fr.esgi.avis.usecase.exception.JeuNotFoundException;
import fr.esgi.avis.usecase.usecase.JeuUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuUseCaseImpl implements JeuUseCase {

    private final JeuJpaAdapter adapter;
    private final AvisJpaAdapter avisJpaAdapter;

    public JeuUseCaseImpl(JeuJpaAdapter adapter, AvisJpaAdapter avisJpaAdapter) {
        this.adapter = adapter;
        this.avisJpaAdapter = avisJpaAdapter;
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
    public Page<Jeu> findAll(Pageable pageable) {
        return adapter.findAll(pageable);
    }

    @Override
    public Page<Avis> avis(Long id, Pageable pageable) {
        return avisJpaAdapter.findByJeu(id, pageable);
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
