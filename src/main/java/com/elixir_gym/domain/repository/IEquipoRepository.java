package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;

import java.util.List;
import java.util.Optional;

public interface IEquipoRepository {

    List<EquipoDto> findAll();

    Optional<EquipoDto> findById(long id);

    EquipoDto save(EquipoDto equipoDto);

    Optional<EquipoDto> update(long id, ActualizarEquipoDto equipoDto);

    void delteById(long id);

}
