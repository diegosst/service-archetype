package br.com.diegosst.archetype.adapter.output;

import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ArchetypeEventSource {
    void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException;
    void storeBaseEntity(final BaseEntityEvent event);
}
