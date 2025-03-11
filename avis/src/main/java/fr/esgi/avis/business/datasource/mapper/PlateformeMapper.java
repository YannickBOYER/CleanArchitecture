package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Plateforme;
import fr.esgi.avis.business.datasource.entity.PlateformeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PlateformeMapper {
    Plateforme toBusiness(PlateformeEntity entity);

    PlateformeEntity toEntity(Plateforme business);
}
