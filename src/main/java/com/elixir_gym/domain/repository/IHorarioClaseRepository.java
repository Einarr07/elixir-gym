package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;

import java.util.List;
import java.util.Optional;

public interface IHorarioClaseRepository {

    List<HorarioClaseDto> findAll();

    Optional<HorarioClaseDto> findById(long id);

    HorarioClaseDto save(HorarioClaseDto horarioClaseDto);

    Optional<HorarioClaseDto> update(long id, ActualizarHorarioClaseDto horarioClaseDto);

    void deleteById(long id);
}
