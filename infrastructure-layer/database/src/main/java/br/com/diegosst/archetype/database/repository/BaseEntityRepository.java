package br.com.diegosst.archetype.database.repository;

import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.database.model.BaseEntityModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseEntityRepository extends MongoRepository<BaseEntityModel, String> {
    Optional<BaseEntity> findBaseEntityById(final String id);
}
