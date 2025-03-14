package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<JeuEntity, Long> {
}
