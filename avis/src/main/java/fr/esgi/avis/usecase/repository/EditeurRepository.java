package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.EditeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepository extends JpaRepository<EditeurEntity, Long> {
}
