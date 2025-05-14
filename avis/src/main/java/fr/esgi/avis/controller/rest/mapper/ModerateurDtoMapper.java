package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.controller.rest.dto.out.ModerateurResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ModerateurDtoMapper {
    public ModerateurResponseDTO toDto(Moderateur moderateur);
}
