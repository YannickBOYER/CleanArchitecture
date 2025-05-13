package fr.esgi.avis.usecase.usecase;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Jeu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JeuUseCase {
    Jeu save(Jeu jeu);
    List<Jeu> findAll();
    Page<Jeu> findAll(Pageable pageable);
    Page<Avis> avis(Long id, Pageable pageable);
    Jeu findById(Long id);
}
