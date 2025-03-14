package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Classification;

public interface ClassificationUseCase {
    Classification findById(Long id);
}
