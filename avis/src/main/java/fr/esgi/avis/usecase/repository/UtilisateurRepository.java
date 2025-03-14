package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
}
