package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;

import java.util.List;
import java.util.Optional;

public interface IProgresoRepository {

    List<ProgresoDto> findAll();

    Optional<ProgresoDto> findById(long id);

    ProgresoDto save(ProgresoDto progresoDto);

    Optional<ProgresoDto> update(long id, ActualizarProgresoDto progresoDto);

    void deleteById(long id);
}
