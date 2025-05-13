package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Jeu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface JeuJpaAdapter {
    Jeu save(Jeu jeu);
    List<Jeu> findAll();
    Page<Jeu> findAll(Pageable pageable);
    Optional<Jeu> findById(Long id);
}
