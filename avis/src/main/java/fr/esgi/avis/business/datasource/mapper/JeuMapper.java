package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Jeu;
import fr.esgi.avis.business.datasource.entity.JeuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ClassificationMapper.class, EditeurMapper.class, GenreMapper.class, PlateformeMapper.class}
)
public interface JeuMapper {
    Jeu toBusiness(JeuEntity entity);

    JeuEntity toEntity(Jeu business);
}
