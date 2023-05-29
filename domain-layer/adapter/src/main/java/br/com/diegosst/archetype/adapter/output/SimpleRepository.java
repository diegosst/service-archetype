package br.com.diegosst.archetype.adapter.output;

import br.com.diegosst.archetype.domain.entity.BaseEntity;

import java.util.Optional;

public interface SimpleRepository {

    Optional<BaseEntity> findBaseEntityById(final String id);
    void save(final BaseEntity baseEntity);

}
