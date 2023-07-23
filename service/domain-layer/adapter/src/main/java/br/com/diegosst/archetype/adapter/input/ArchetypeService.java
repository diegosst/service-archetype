package br.com.diegosst.archetype.adapter.input;

import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ArchetypeService {

    BaseEntity getBaseEntityById(final String id);

    List<BaseEntity> getAllBaseEntity();

    void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException;
}
