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

    @Query(value = "SELECT e FROM BaseEntityModel e WHERE e.id = ?1")
    Optional<BaseEntity> findBaseEntityById(final String id);

    @Query(value = "SELECT e FROM BaseEntityModel e")
    List<BaseEntity> findAllBaseEntities();
}
