package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;

import java.util.List;
import java.util.Optional;

public interface IHistorialEntrenamientoRepository {

    List<HistorialEntrenamientoDto> findAll();

    Optional<HistorialEntrenamientoDto> findById(long id);

    HistorialEntrenamientoDto save(HistorialEntrenamientoDto entrenamientoDto);

    Optional<HistorialEntrenamientoDto> update(long id, ActualizarHistorialEntrenamientoDto entrenamientoDto);

    void deleteById(long id);
}
