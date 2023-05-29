package br.com.diegosst.archetype.adapter.input;

import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.event.BaseEntityEvent;

public interface SimpleService {

    BaseEntity getBaseEntityById(final String id);

    void publishBaseEntity(final BaseEntityEvent event);

}
