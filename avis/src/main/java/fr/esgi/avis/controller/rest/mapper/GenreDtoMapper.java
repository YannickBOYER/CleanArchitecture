package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.controller.rest.dto.in.GenreRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.GenreResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface GenreDtoMapper {
    public Genre toBusiness(GenreRequestDTO requestDTO);
    public GenreResponseDTO toDto(Genre genre);
}
