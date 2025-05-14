package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Joueur;

public interface JoueurUseCase {
    Joueur findById(Long id);

    Joueur findByUsername(String username);
}
