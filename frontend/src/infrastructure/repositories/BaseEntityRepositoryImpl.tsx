import { Http } from "../../application/repositories/Http";
import { BaseEntityRepository } from "../../application/repositories/BaseEntityRepository";
import { BaseEntity } from "../../domain/models/BaseEntity";

export const BaseEntityRepositoryImpl = (client: Http): BaseEntityRepository => ({
    getBaseEntities: async () => {
        const entities = await client.get<BaseEntity[]>("/");
        return entities;
    },
    getBaseEntityById: async (id: string) => {
        const entity = await client.get<BaseEntity>("/" + id);
        return entity;
    },
    addBaseEntity: async (entity: BaseEntity) => {
        await client.post("/", entity);
    }
});