package fr.esgi.avis.usecase.repository;

import fr.esgi.avis.business.datasource.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
