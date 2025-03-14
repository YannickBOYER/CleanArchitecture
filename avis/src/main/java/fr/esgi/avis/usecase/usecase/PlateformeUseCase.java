package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Plateforme;

import java.util.List;

public interface PlateformeUseCase {
    public List<Plateforme> findAll();
    public Plateforme findById(Long id);
}
