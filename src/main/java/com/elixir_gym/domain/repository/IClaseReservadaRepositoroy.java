package com.elixir_gym.domain.repository;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;

import java.util.List;
import java.util.Optional;

public interface IClaseReservadaRepositoroy {

    List<ClaseReservadaDto> findAll();

    Optional<ClaseReservadaDto> findById(Long id);

    ClaseReservadaDto save(ClaseReservadaDto dto);

    Optional<ClaseReservadaDto>  update(long id, ActualizarClaseReservadaDto dto);

    void deleteById(long id);
}
