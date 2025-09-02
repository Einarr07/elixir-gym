package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;
import com.elixir_gym.domain.repository.IEquipoRepository;
import com.elixir_gym.persistence.crud.ICrudEquipoEntity;
import com.elixir_gym.persistence.entity.EquipoEntity;
import com.elixir_gym.persistence.mapper.IEquipoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EquipoRepository implements IEquipoRepository {

    private final ICrudEquipoEntity crudEquipoEntity;
    private final IEquipoMapper equipoMapper;

    @Override
    public List<EquipoDto> findAll() {
        return equipoMapper.toDtoList(crudEquipoEntity.findAll());
    }

    @Override
    public Optional<EquipoDto> findById(long id) {
        return crudEquipoEntity.findById(id).map(equipoMapper::toDto);
    }

    @Override
    public EquipoDto save(EquipoDto equipoDto) {
        EquipoEntity equipoEntity = equipoMapper.toEntity(equipoDto);

        return equipoMapper.toDto(crudEquipoEntity.save(equipoEntity));
    }

    @Override
    public Optional<EquipoDto> update(long id, ActualizarEquipoDto equipoDto) {
        return crudEquipoEntity.findById(id)
                .map(equipoExistente -> {
                    equipoMapper.updateEquipo(equipoDto, equipoExistente);
                    return equipoMapper.toDto(crudEquipoEntity.save(equipoExistente));
                });
    }

    @Override
    public void delteById(long id) {
        crudEquipoEntity.deleteById(id);
    }
}
