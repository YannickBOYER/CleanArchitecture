package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Jeu;

import java.util.List;

public interface JeuUseCase {
    Jeu save(Jeu jeu);
    List<Jeu> findAll();
    Jeu findById(Long id);
}
