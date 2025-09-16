package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.translate.NivelEntrenamiento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ActualizarClaseDto(
        @NotEmpty(message = "El nombre es obligatorio")
        String nombre,

        String descripcion,

        @NotNull(message = "El nivel es obligatorio")
        NivelEntrenamiento dificultad,

        @NotNull(message = "La duración es obligatoria")
        Integer duracion,

        @NotNull(message = "La capacidad máxima es obligatoria")
        Integer capacidad_max
) {
}
