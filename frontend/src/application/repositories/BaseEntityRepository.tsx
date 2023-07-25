import { BaseEntity } from "../../domain/models/BaseEntity";

export interface BaseEntityRepository {
    getBaseEntities: () => Promise<BaseEntity[]>;
    getBaseEntityById: (id: string) => Promise<BaseEntity>;
}