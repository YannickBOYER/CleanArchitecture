package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurJpaAdapter {
    Utilisateur save(Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Optional<Utilisateur> findById(Long id);
    void delete(Utilisateur utilisateur);
}
