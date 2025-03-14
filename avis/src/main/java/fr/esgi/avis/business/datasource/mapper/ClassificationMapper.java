package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Classification;
import fr.esgi.avis.business.datasource.entity.ClassificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ClassificationMapper {
    Classification toBusiness(ClassificationEntity entity);
    ClassificationEntity toEntity(Classification business);
}
