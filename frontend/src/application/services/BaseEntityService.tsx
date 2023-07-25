import { BaseEntityRepository } from "../repositories/BaseEntityRepository";
import { BaseEntity } from "../../domain/models/BaseEntity";

export const BaseEntityService = (repository: BaseEntityRepository): BaseEntityRepository => ({
    getBaseEntityById: (id: string) => {
        return repository.getBaseEntityById(id);
    },
    getBaseEntities: () => {
        return repository.getBaseEntities();
    },
    addBaseEntity: (entity: BaseEntity) => {
        return repository.addBaseEntity(entity);
    }
});