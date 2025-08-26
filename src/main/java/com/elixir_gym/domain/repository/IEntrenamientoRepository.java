package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;

import java.util.List;
import java.util.Optional;

public interface IEntrenamientoRepository {

    List<EntrenamientoDto> findAll();

    Optional<EntrenamientoDto> findById(long id);

    EntrenamientoDto save(EntrenamientoDto entrenamientoDto);

    Optional<EntrenamientoDto> update(long id, ActualizarEntrenamientoDto entrenamientoDto);

    void deleteById(long id);
}
