package fr.esgi.avis.business.datasource.mapper;

import fr.esgi.avis.business.Editeur;
import fr.esgi.avis.business.datasource.entity.EditeurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface EditeurMapper {
    Editeur toBusiness(EditeurEntity entity);
    EditeurEntity toEntity(Editeur business);
}
