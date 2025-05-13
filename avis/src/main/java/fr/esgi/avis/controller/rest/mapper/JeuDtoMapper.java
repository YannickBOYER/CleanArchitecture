package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.controller.rest.dto.in.JeuRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.JeuResponseDTO;
import fr.esgi.avis.usecase.usecase.ClassificationUseCase;
import fr.esgi.avis.usecase.usecase.EditeurUseCase;
import fr.esgi.avis.usecase.usecase.GenreUseCase;
import fr.esgi.avis.usecase.usecase.PlateformeUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {GenreUseCase.class, EditeurUseCase.class, ClassificationUseCase.class, PlateformeUseCase.class}
)
public interface JeuDtoMapper {
    @Mapping(target = "genre", source = "genreId")
    @Mapping(target = "editeur", source = "editeurId")
    @Mapping(target = "classification", source = "classificationId")
    @Mapping(target = "plateformes", source = "plateformesIds")
    public Jeu toBusiness(JeuRequestDTO requestDTO);
    public JeuResponseDTO toDto(Jeu jeu);
}
