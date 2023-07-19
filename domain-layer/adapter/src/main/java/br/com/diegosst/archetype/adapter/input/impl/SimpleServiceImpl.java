package br.com.diegosst.archetype.adapter.input.impl;

import br.com.diegosst.archetype.adapter.input.SimpleService;
import br.com.diegosst.archetype.adapter.output.SimpleEventSource;
import br.com.diegosst.archetype.adapter.output.SimpleRepository;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.domain.exception.EntityNotFoundException;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleServiceImpl implements SimpleService {

    private final SimpleRepository simpleRepository;
    private final SimpleEventSource simpleEventSource;

    @Cacheable(value = "small", key = "#id")
    @Override
    public BaseEntity getBaseEntityById(final String id) {
        return simpleRepository.findBaseEntityById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find an entity for the given id."));
    }

    @Override
    public List<BaseEntity> getAllBaseEntity() {
        return simpleRepository.findAllBaseEntities();
    }

    @Override
    public void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException {
        simpleEventSource.publishBaseEntity(event);
    }
}
