package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Avis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AvisJpaAdapter {
    Page<Avis> findByJeu(Long id, Pageable pageable);
    Optional<Avis> findById(Long id);
    void delete(Avis avis);
    Avis save(Avis avis);
}
