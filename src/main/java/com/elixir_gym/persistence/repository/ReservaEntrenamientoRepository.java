package com.elixir_gym.persistence.repository;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;
import com.elixir_gym.domain.repository.IReservaEntrenamientoRepository;
import com.elixir_gym.persistence.crud.ICrudReservaEntrenamientosEntity;
import com.elixir_gym.persistence.entity.ReservaEntrenamientoEntity;
import com.elixir_gym.persistence.mapper.ReservaEntrenamientoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ReservaEntrenamientoRepository implements IReservaEntrenamientoRepository {

    private final ICrudReservaEntrenamientosEntity crudReservaEntrenamiento;
    private final ReservaEntrenamientoMapper reservaEntrenamientoMapper;

    @Override
    public List<ReservaEntrenamientoDto> findAll() {
        return reservaEntrenamientoMapper.toDtoList(crudReservaEntrenamiento.findAll());
    }

    @Override
    public Optional<ReservaEntrenamientoDto> findById(long id) {
        return crudReservaEntrenamiento.findById(id).map(reservaEntrenamientoMapper::toDto);
    }

    @Override
    public ReservaEntrenamientoDto save(ReservaEntrenamientoDto reservasEntrenamientoDto) {
        ReservaEntrenamientoEntity reserva = reservaEntrenamientoMapper.toEntity(reservasEntrenamientoDto);
        return reservaEntrenamientoMapper.toDto(crudReservaEntrenamiento.save(reserva));
    }

    @Override
    public Optional<ReservaEntrenamientoDto> update(long id, ActualizarReservaEntrenamientoDto actualizarReservaDto) {
        return crudReservaEntrenamiento.findById(id).map(
                reservaEntrenamiento -> {
                    reservaEntrenamientoMapper.updateReservaEntrenamiento(actualizarReservaDto, reservaEntrenamiento);
                    return reservaEntrenamientoMapper.toDto(crudReservaEntrenamiento.save(reservaEntrenamiento));
                }
        );
    }

    @Override
    public void deleteById(long id) {
        crudReservaEntrenamiento.deleteById(id);
    }
}
