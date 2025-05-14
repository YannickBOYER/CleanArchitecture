package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Moderateur;

import java.util.List;

public interface ModerateurUseCase {
    Moderateur findById(Long id);

    List<Moderateur> findAll();
}
