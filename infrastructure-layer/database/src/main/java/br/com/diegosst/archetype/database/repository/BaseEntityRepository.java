package br.com.diegosst.archetype.database.repository;

import br.com.diegosst.archetype.database.model.BaseEntityModel;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseEntityRepository extends MongoRepository<BaseEntityModel, String> {
    Optional<BaseEntity> findBaseEntityById(final String id);

    @Query("SELECT e FROM BaseEntityModel")
    List<BaseEntity> findAllBaseEntities();
}
