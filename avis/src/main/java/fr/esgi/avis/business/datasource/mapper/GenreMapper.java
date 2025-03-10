package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Genre;
import fr.esgi.avis.business.datasource.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface GenreMapper {
    Genre toBusiness(GenreEntity entity);

    GenreEntity toEntity(Genre business);
}
