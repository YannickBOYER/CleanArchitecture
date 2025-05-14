package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Classification;

import java.util.List;

public interface ClassificationUseCase {
    Classification findById(Long id);
    List<Classification> findAll();
}
