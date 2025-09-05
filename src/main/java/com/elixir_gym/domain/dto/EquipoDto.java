package com.elixir_gym.domain.dto;

import com.elixir_gym.domain.translate.EstadoEquipo;
import com.elixir_gym.domain.translate.TipoEquipo;

public record EquipoDto(
        Long idEquipo,
        String nombre,
        TipoEquipo tipo,
        EstadoEquipo estado
) {
}
