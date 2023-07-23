package br.com.diegosst.archetype.eventsource.output.impl;

import br.com.diegosst.archetype.adapter.output.ArchetypeEventSource;
import br.com.diegosst.archetype.adapter.output.ArchetypeRepository;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import br.com.diegosst.archetype.eventsource.publisher.ArchetypeEventPublisher;
import br.com.diegosst.archetype.mapper.BaseEntityMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArchetypeEventSourceImpl implements ArchetypeEventSource {

    private final ArchetypeEventPublisher archetypeEventPublisher;
    private final ArchetypeRepository archetypeRepository;

    @Override
    public void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException {
        archetypeEventPublisher.publishEntity(event);
    }

    @Override
    public void storeBaseEntity(final BaseEntityEvent event) {
       archetypeRepository.save(BaseEntityMapper.INSTANCE.toEntity(event));
    }
}
