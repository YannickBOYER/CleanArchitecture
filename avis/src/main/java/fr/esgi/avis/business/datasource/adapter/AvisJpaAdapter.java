package fr.esgi.avis.business.datasource.adapter;

import fr.esgi.avis.business.Avis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AvisJpaAdapter {
    Page<Avis> findByJeu(Long id, Pageable pageable);
}
