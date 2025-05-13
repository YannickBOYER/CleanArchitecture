package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Avatar;
import fr.esgi.avis.business.datasource.entity.AvatarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AvatarMapper {
    Avatar toBusiness(AvatarEntity entity);
    AvatarEntity toEntity(Avatar business);
}
