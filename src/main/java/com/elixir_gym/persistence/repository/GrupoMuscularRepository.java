package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.updates.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.domain.repository.IGrupoMuscularRepository;
import com.elixir_gym.persistence.crud.ICrudGrupoMuscularEntity;
import com.elixir_gym.persistence.entity.GrupoMuscularEntity;
import com.elixir_gym.persistence.mapper.IGrupoMuscularMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GrupoMuscularRepository implements IGrupoMuscularRepository {

    private final ICrudGrupoMuscularEntity crudGrupoMuscularEntity;
    private final IGrupoMuscularMapper grupoMuscularMapper;


    @Override
    public List<GrupoMuscularDto> findAll() {
        return grupoMuscularMapper.toDtoList(crudGrupoMuscularEntity.findAll());
    }

    @Override
    public Optional<GrupoMuscularDto> findById(long id) {
        return crudGrupoMuscularEntity.findById(id).map(grupoMuscularMapper::toDto);
    }

    @Override
    public GrupoMuscularDto save(GrupoMuscularDto ejercicioDto) {
        GrupoMuscularEntity grupoEntity = grupoMuscularMapper.toEntity(ejercicioDto);

        return grupoMuscularMapper.toDto(crudGrupoMuscularEntity.save(grupoEntity));
    }

    @Override
    public Optional<GrupoMuscularDto> update(long id, ActualizarGrupoMuscularDto grupoMuscularDto) {

        return crudGrupoMuscularEntity.findById(id).map(grupoMuscularExistente -> {
            grupoMuscularMapper.updateGrupoMuscular(grupoMuscularDto, grupoMuscularExistente);
            return grupoMuscularMapper.toDto(crudGrupoMuscularEntity.save(grupoMuscularExistente));
        });
    }

    @Override
    public void delteById(long id) {
        crudGrupoMuscularEntity.deleteById(id);
    }
}
