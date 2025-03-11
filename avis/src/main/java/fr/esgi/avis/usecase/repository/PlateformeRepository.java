package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.PlateformeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateformeRepository extends JpaRepository<PlateformeEntity, Long> {
}
