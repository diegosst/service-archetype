package br.com.diegosst.archetype.adapter.output;

import br.com.diegosst.archetype.event.BaseEntityEvent;

public interface SimpleEventSource {
    void publishBaseEntity(final BaseEntityEvent event);
    void storeBaseEntity(final BaseEntityEvent event);
}
