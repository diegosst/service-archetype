package br.com.diegosst.archetype.adapter.input.impl;

import br.com.diegosst.archetype.adapter.input.ArchetypeService;
import br.com.diegosst.archetype.adapter.output.ArchetypeEventSource;
import br.com.diegosst.archetype.adapter.output.ArchetypeRepository;
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
public class ArchetypeServiceImpl implements ArchetypeService {

    private final ArchetypeRepository archetypeRepository;
    private final ArchetypeEventSource archetypeEventSource;

    @Cacheable(value = "small", key = "#id")
    @Override
    public BaseEntity getBaseEntityById(final String id) {
        return archetypeRepository.findBaseEntityById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find an entity for the given id."));
    }

    @Override
    public List<BaseEntity> getAllBaseEntity() {
        return archetypeRepository.findAllBaseEntities();
    }

    @Override
    public void publishBaseEntity(final BaseEntityEvent event) throws JsonProcessingException {
        archetypeEventSource.publishBaseEntity(event);
    }
}
