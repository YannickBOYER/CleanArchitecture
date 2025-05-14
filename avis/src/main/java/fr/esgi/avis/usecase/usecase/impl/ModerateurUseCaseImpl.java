package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.datasource.adapter.ModerateurJpaAdapter;
import fr.esgi.avis.business.datasource.entity.ModerateurEntity;
import fr.esgi.avis.usecase.exception.GenreNotFoundException;
import fr.esgi.avis.usecase.exception.ModerateurNotFoundException;
import fr.esgi.avis.usecase.usecase.ModerateurUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModerateurUseCaseImpl implements ModerateurUseCase {
    private final ModerateurJpaAdapter adapter;

    public ModerateurUseCaseImpl(ModerateurJpaAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Moderateur findById(Long id){
        final Optional<Moderateur> optionalModerateur = adapter.findById(id);
        if(optionalModerateur.isPresent()){
            return optionalModerateur.get();
        }else{
            throw new ModerateurNotFoundException(id);
        }
    }

    @Override
    public List<Moderateur> findAll() {
        return adapter.findAll();
    }
}
