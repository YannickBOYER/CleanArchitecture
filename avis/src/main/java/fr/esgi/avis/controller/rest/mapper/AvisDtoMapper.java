package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.controller.rest.dto.out.AvisResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AvisDtoMapper {
    public AvisResponseDTO toDto(Avis avis);
}
