package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.business.Genre;
import fr.esgi.avis.controller.rest.dto.in.EditeurRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.EditeurResponseDTO;
import fr.esgi.avis.controller.rest.dto.out.GenreResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface EditeurDtoMapper {
    public Editeur toBusiness(EditeurRequestDTO requestDTO);
    public EditeurResponseDTO toDto(Editeur entity);
}
