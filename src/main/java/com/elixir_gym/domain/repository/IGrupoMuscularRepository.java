package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;

import java.util.List;
import java.util.Optional;

public interface IGrupoMuscularRepository {

    List<GrupoMuscularDto> findAll();

    Optional<GrupoMuscularDto> findById(long id);

    GrupoMuscularDto save(GrupoMuscularDto ejercicioDto);

    Optional<GrupoMuscularDto> update(long id, ActualizarGrupoMuscularDto grupoMuscularDto);

    void delteById(long id);
}
