package br.com.diegosst.archetype.mapper;

import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseEntityMapper {
    BaseEntityMapper INSTANCE = Mappers.getMapper(BaseEntityMapper.class);

    @Mapping(source = "id", target = "id")
    BaseEntity toEntity(final BaseEntityEvent entity);
}
