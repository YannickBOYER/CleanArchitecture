package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.controller.rest.dto.out.ClassificationResponseDTO;
import fr.esgi.avis.controller.rest.dto.out.PlateformeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PlateformeDtoMapper {
    public PlateformeResponseDTO toDto(Plateforme plateforme);
}
