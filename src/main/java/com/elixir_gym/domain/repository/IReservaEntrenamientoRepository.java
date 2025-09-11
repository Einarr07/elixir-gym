package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;

import java.util.List;
import java.util.Optional;

public interface IReservaEntrenamientoRepository {

    List<ReservaEntrenamientoDto> findAll();

    Optional<ReservaEntrenamientoDto>  findById(long id);

    ReservaEntrenamientoDto save(ReservaEntrenamientoDto reservasEntrenamiento);

    Optional<ReservaEntrenamientoDto> update(long id, ActualizarReservaEntrenamientoDto actualizarReserva);

    void deleteById(long id);
}
