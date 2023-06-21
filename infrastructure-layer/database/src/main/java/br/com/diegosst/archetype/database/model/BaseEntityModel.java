package br.com.diegosst.archetype.database.model;

import br.com.diegosst.archetype.domain.entity.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "base-entity")
public class BaseEntityModel extends BaseEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

}
