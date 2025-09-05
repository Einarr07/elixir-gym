package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.translate.EstadoEquipo;
import com.elixir_gym.domain.translate.TipoEquipo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ActualizarEquipoDto(
        @NotEmpty(message = "El nombre del equipo es obligatorio")
        String nombre,

        @NotNull(message = "El tipo del equipo es ogligatorio")
        TipoEquipo tipo,

        @NotNull(message = "El estado del equipo es obligatorio")
        EstadoEquipo estado
) {
}
