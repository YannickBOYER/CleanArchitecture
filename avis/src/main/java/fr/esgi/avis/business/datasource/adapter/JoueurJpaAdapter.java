package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Joueur;

import java.util.Optional;

public interface JoueurJpaAdapter {
    Optional<Joueur> findById(Long id);

    Optional<Joueur> findByUsername(String username);
}
