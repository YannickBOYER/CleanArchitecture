package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.datasource.adapter.AvisJpaAdapter;
import fr.esgi.avis.usecase.exception.AvisNotFoundException;
import fr.esgi.avis.usecase.usecase.AvisUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvisUseCaseImpl implements AvisUseCase {
    private final AvisJpaAdapter avisJpaAdapter;

    public AvisUseCaseImpl(AvisJpaAdapter avisJpaAdapter) {
        this.avisJpaAdapter = avisJpaAdapter;
    }

    public Avis findById(Long id){
        final Optional<Avis> optionalAvis = avisJpaAdapter.findById(id);
        if(optionalAvis.isPresent()){
            return optionalAvis.get();
        }else{
            throw new AvisNotFoundException(id);
        }
    }


    @Override
    public void delete(Long id) {
        final Avis avis = findById(id);
        avisJpaAdapter.delete(avis);
    }

    @Override
    public Avis save(Avis avis) {
        return avisJpaAdapter.save(avis);
    }
}
