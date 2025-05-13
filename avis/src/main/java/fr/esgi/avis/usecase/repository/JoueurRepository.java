package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<JoueurEntity, Long> {
}
