package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Utilisateur;
import fr.esgi.avis.business.datasource.entity.UtilisateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UtilisateurMapper {
    Utilisateur toBusiness(UtilisateurEntity entity);
    UtilisateurEntity toEntity(Utilisateur business);
}
