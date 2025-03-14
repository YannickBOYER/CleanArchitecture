package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Utilisateur;

import java.util.List;

public interface UtilisateurUseCase {
    Utilisateur save(Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Utilisateur findById(Long id);
    void deleteById(Long id);
}
