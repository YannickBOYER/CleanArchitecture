package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Classification;

import java.util.Optional;

public interface ClassificationJpaAdapter {
    Optional<Classification> findById(Long id);
}
