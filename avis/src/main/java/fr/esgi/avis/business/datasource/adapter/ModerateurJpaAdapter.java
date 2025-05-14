package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Moderateur;

import java.util.List;
import java.util.Optional;

public interface ModerateurJpaAdapter {
    Optional<Moderateur> findById(Long id);

    List<Moderateur> findAll();
}
