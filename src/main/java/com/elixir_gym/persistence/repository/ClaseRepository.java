package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;
import com.elixir_gym.domain.repository.IClaseRepository;
import com.elixir_gym.persistence.crud.ICrudClaseEntity;
import com.elixir_gym.persistence.entity.ClaseEntity;
import com.elixir_gym.persistence.mapper.IClaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClaseRepository implements IClaseRepository {

    private final ICrudClaseEntity crudClaseEntity;
    private final IClaseMapper mapper;


    @Override
    public List<ClaseDto> findAll() {
        return mapper.toDtoList(crudClaseEntity.findAll());
    }

    @Override
    public Optional<ClaseDto> findById(long id) {
        return crudClaseEntity.findById(id).map(mapper::toDto);
    }

    @Override
    public ClaseDto save(ClaseDto claseDto) {
        ClaseEntity claseEntity = mapper.toEntity(claseDto);
        return mapper.toDto(crudClaseEntity.save(claseEntity));
    }

    @Override
    public Optional<ClaseDto> update(long id, ActualizarClaseDto actualizarClaseDto) {
        return crudClaseEntity.findById(id).map(claseEntity -> {
            mapper.updateClase(actualizarClaseDto, claseEntity);
            return mapper.toDto(crudClaseEntity.save(claseEntity));
        });
    }

    @Override
    public void deleteById(long id) {
        crudClaseEntity.deleteById(id);
    }
}
