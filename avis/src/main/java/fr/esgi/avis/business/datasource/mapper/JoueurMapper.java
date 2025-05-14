package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.business.datasource.entity.JoueurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface JoueurMapper {
    Joueur toBusiness(JoueurEntity entity);
}
