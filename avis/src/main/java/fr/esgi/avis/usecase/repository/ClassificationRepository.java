package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Long> {
}
