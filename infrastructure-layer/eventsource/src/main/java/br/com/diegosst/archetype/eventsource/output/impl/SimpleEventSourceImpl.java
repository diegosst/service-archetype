package br.com.diegosst.archetype.eventsource.output.impl;

import br.com.diegosst.archetype.adapter.output.SimpleEventSource;
import br.com.diegosst.archetype.adapter.output.SimpleRepository;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import br.com.diegosst.archetype.eventsource.publisher.SimpleEventPublisher;
import br.com.diegosst.archetype.mapper.BaseEntityMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleEventSourceImpl implements SimpleEventSource {

    private final SimpleEventPublisher simpleEventPublisher;
    private final SimpleRepository simpleRepository;

    @Override
    public void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException {
        simpleEventPublisher.publishEntity(event);
    }

    @Override
    public void storeBaseEntity(final BaseEntityEvent event) {
       simpleRepository.save(BaseEntityMapper.INSTANCE.toEntity(event));
    }
}
