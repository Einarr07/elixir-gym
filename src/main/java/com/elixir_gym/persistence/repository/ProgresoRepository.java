package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;
import com.elixir_gym.domain.repository.IProgresoRepository;
import com.elixir_gym.persistence.crud.ICrudProgresoEntity;
import com.elixir_gym.persistence.entity.ProgresoEntity;
import com.elixir_gym.persistence.mapper.IProgresoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProgresoRepository implements IProgresoRepository {

    private final ICrudProgresoEntity crudProgresoEntity;
    private final IProgresoMapper progresoMapper;

    @Override
    public List<ProgresoDto> findAll() {
        return progresoMapper.toDtoList(crudProgresoEntity.findAll());
    }

    @Override
    public Optional<ProgresoDto> findById(long id) {
        return crudProgresoEntity.findById(id).map(progresoMapper::toDto);
    }

    @Override
    public ProgresoDto save(ProgresoDto progresoDto) {
        ProgresoEntity progresoEntity = progresoMapper.toEntity(progresoDto);

        return progresoMapper.toDto(crudProgresoEntity.save(progresoEntity));
    }

    @Override
    public Optional<ProgresoDto> update(long id, ActualizarProgresoDto progresoDto) {
        return crudProgresoEntity.findById(id).map(progresoentity -> {
            progresoMapper.updateProgreso(progresoDto, progresoentity);
            return progresoMapper.toDto(crudProgresoEntity.save(progresoentity));
        });
    }

    @Override
    public void deleteById(long id) {
        crudProgresoEntity.deleteById(id);
    }
}
