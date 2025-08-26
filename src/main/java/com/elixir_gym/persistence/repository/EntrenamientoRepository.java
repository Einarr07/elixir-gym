package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.repository.IEntrenamientoRepository;
import com.elixir_gym.persistence.crud.ICrudEntrenamientosEntity;
import com.elixir_gym.persistence.entity.EntrenamientoEntity;
import com.elixir_gym.persistence.mapper.IEntrenamientoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EntrenamientoRepository implements IEntrenamientoRepository {

    private final ICrudEntrenamientosEntity crudEntrenamientosEntity;
    private final IEntrenamientoMapper entrenamientoMapper;

    @Override
    public List<EntrenamientoDto> findAll() {
        return entrenamientoMapper.toDtoList(crudEntrenamientosEntity.findAll());
    }

    @Override
    public Optional<EntrenamientoDto> findById(long id) {
        return crudEntrenamientosEntity.findById(id).map(entrenamientoMapper::toDto);
    }

    @Override
    public EntrenamientoDto save(EntrenamientoDto entrenamientoDto) {
        EntrenamientoEntity entrenamientoEntity = entrenamientoMapper.toEntity(entrenamientoDto);

        return entrenamientoMapper.toDto(crudEntrenamientosEntity.save(entrenamientoEntity));
    }

    @Override
    public Optional<EntrenamientoDto> update(long id, ActualizarEntrenamientoDto actualizarEntrenamientoDto) {
        return crudEntrenamientosEntity.findById(id)
                .map(entrenamientoExistente -> {
                    entrenamientoMapper.updateEntrenmiento(actualizarEntrenamientoDto, entrenamientoExistente);
                    return entrenamientoMapper.toDto(crudEntrenamientosEntity.save(entrenamientoExistente));
                });
    }

    @Override
    public void deleteById(long id) {
        crudEntrenamientosEntity.deleteById(id);
    }
}
