package br.com.diegosst.archetype.database.mapper;

import br.com.diegosst.archetype.database.model.BaseEntityModel;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseEntityModelMapper {
    BaseEntityModelMapper INSTANCE = Mappers.getMapper(BaseEntityModelMapper.class);

    @Mapping(source = "id", target = "id")
    BaseEntityModel toModel(final BaseEntity entity);
}
