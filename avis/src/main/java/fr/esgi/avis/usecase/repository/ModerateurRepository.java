package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.ModerateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerateurRepository extends JpaRepository<ModerateurEntity, Long> {
}
