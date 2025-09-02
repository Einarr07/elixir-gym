package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.dto.EjercicioDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ActualizarEquipoDto(
        @NotEmpty(message = "El nombre del equipo es obligatorio")
        String nombre,

        @NotEmpty(message = "El tipo del equipo es ogligatorio")
        String tipo,

        @NotEmpty(message = "El estado del equipo es obligatorio")
        String estado,

        @NotNull(message = "El ejercicio es obligatorio")
        EjercicioDto ejercicios
) {
}
