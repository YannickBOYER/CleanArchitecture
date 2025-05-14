package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoueurRepository extends JpaRepository<JoueurEntity, Long> {
    Optional<JoueurEntity> findByPseudo(String pseudo);
}
