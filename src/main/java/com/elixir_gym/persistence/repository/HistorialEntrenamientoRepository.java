package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;
import com.elixir_gym.domain.repository.IHistorialEntrenamientoRepository;
import com.elixir_gym.persistence.crud.ICrudHistorialEntrenamientoEntity;
import com.elixir_gym.persistence.entity.HistorialEntrenamientoEntity;
import com.elixir_gym.persistence.mapper.IHistorialEntrenamientoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HistorialEntrenamientoRepository implements IHistorialEntrenamientoRepository {

    private final ICrudHistorialEntrenamientoEntity crudHistorialEntrenamiento;
    private final IHistorialEntrenamientoMapper historialEntrenamientoMapper;

    @Override
    public List<HistorialEntrenamientoDto> findAll() {
        return historialEntrenamientoMapper.toDtoList(crudHistorialEntrenamiento.findAll());
    }

    @Override
    public Optional<HistorialEntrenamientoDto> findById(long id) {
        return crudHistorialEntrenamiento.findById(id).map(historialEntrenamientoMapper::toDto);
    }

    @Override
    public HistorialEntrenamientoDto save(HistorialEntrenamientoDto entrenamientoDto) {
        HistorialEntrenamientoEntity historialEntity = historialEntrenamientoMapper.toEntity(entrenamientoDto);

        return historialEntrenamientoMapper.toDto(crudHistorialEntrenamiento.save(historialEntity));
    }

    @Override
    public Optional<HistorialEntrenamientoDto> update(long id, ActualizarHistorialEntrenamientoDto entrenamientoDto) {
        return crudHistorialEntrenamiento.findById(id)
                .map(historialExistente -> {
                    historialEntrenamientoMapper.updateHistorialEntrenamiento(entrenamientoDto, historialExistente);
                    return historialEntrenamientoMapper.toDto(crudHistorialEntrenamiento.save(historialExistente));
                });
    }

    @Override
    public void deleteById(long id) {
        crudHistorialEntrenamiento.deleteById(id);
    }
}
