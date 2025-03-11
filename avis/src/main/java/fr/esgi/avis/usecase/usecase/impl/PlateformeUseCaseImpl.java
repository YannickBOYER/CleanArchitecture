package fr.esgi.avis.usecase.usecase.impl;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.datasource.adapter.PlateformeJpaAdapter;
import fr.esgi.avis.business.exception.GenreNotFoundException;
import fr.esgi.avis.usecase.usecase.PlateformeUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlateformeUseCaseImpl implements PlateformeUseCase {
    private final PlateformeJpaAdapter jpaAdapter;

    public PlateformeUseCaseImpl(PlateformeJpaAdapter jpaAdapter) {
        this.jpaAdapter = jpaAdapter;
    }
    public List<Plateforme> findAll(){
        return jpaAdapter.findAll();
    }
    public Plateforme findById(Long id){
        final Optional<Plateforme> optionalPlateforme = jpaAdapter.findById(id);
        if(optionalPlateforme.isPresent()){
            return optionalPlateforme.get();
        }else{
            throw new GenreNotFoundException(id);
        }
    }
}
