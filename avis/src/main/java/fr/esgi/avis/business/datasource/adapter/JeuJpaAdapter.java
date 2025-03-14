package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Jeu;

import java.util.List;
import java.util.Optional;

public interface JeuJpaAdapter {
    Jeu save(Jeu jeu);
    List<Jeu> findAll();
    Optional<Jeu> findById(Long id);
}
