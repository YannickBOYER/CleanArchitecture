package fr.esgi.avis.controller.rest.mapper;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.controller.rest.dto.in.AvisRequestDTO;
import fr.esgi.avis.controller.rest.dto.out.AvisResponseDTO;
import fr.esgi.avis.usecase.usecase.JeuUseCase;
import fr.esgi.avis.usecase.usecase.JoueurUseCase;
import fr.esgi.avis.usecase.usecase.ModerateurUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {JeuUseCase.class, JoueurUseCase.class, ModerateurUseCase.class}
)
public interface AvisDtoMapper {
    public AvisResponseDTO toDto(Avis avis);

    @Mapping(target = "jeu", source = "idJeu")
    @Mapping(target = "joueur", source = "idJoueur")
    @Mapping(target = "moderateur", source = "idModerateur")
    public Avis toBusiness(AvisRequestDTO avisRequestDTO);
}
