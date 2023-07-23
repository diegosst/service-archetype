package br.com.diegosst.archetype.adapter.output;

import br.com.diegosst.archetype.domain.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface ArchetypeRepository {

    Optional<BaseEntity> findBaseEntityById(final String id);
    List<BaseEntity> findAllBaseEntities();
    void save(final BaseEntity baseEntity);

}
