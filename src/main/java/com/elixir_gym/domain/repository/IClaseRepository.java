package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;

import java.util.List;
import java.util.Optional;

public interface IClaseRepository {

    List<ClaseDto> findAll();

    Optional<ClaseDto> findById(long id);

    ClaseDto save(ClaseDto claseDto);

    Optional<ClaseDto> update(long id, ActualizarClaseDto actualizarClaseDto);

    void deleteById(long id);
}
