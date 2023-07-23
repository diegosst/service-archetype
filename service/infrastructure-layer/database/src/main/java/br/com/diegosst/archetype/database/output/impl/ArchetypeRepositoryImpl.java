package br.com.diegosst.archetype.database.output.impl;

import br.com.diegosst.archetype.adapter.output.ArchetypeRepository;
import br.com.diegosst.archetype.database.mapper.BaseEntityModelMapper;
import br.com.diegosst.archetype.database.repository.BaseEntityRepository;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArchetypeRepositoryImpl implements ArchetypeRepository {

    private final BaseEntityRepository baseEntityRepository;

    @Override
    public Optional<BaseEntity> findBaseEntityById(final String id) {
        return baseEntityRepository.findBaseEntityById(id);
    }

    @Override
    public List<BaseEntity> findAllBaseEntities() {
        return baseEntityRepository.findAllBaseEntities();
    }

    @Override
    public void save(final BaseEntity baseEntity) {
        baseEntityRepository.save(BaseEntityModelMapper.INSTANCE.toModel(baseEntity));
    }
}
