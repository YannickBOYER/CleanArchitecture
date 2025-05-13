package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.AvisEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisEntityRepository extends JpaRepository<AvisEntity, Long> {
    Page<AvisEntity> findByJeuId(Long jeuId, Pageable pageable);
}