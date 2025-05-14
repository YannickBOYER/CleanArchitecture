package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Moderateur;
import fr.esgi.avis.business.datasource.entity.ModerateurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ModerateurMapper {
    Moderateur toBusiness(ModerateurEntity entity);
}
