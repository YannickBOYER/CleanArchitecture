package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Joueur;
import fr.esgi.avis.controller.rest.dto.out.JoueurResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface JoueurDtoMapper {
    public JoueurResponseDTO toDto(Joueur joueur);
}
