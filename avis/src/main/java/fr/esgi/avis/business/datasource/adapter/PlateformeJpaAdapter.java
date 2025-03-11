package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Plateforme;
import java.util.List;
import java.util.Optional;

public interface PlateformeJpaAdapter {
    List<Plateforme> findAll();
    Optional<Plateforme> findById(Long id);
}
