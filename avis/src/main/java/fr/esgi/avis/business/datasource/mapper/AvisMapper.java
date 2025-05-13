package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Avis;
import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.datasource.entity.AvisEntity;
import fr.esgi.avis.business.datasource.entity.ClassificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AvisMapper {
    Avis toBusiness(AvisEntity entity);
    AvisEntity toEntity(Avis business);
}
