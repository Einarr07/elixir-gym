package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.translate.NivelEntrenamiento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ActualizarEntrenamientoDto(

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "La descripcion es obligatoria")
        String descripcion,

        @NotNull(message = "El nivel es obligatorio")
        NivelEntrenamiento nivel,

        @NotNull(message = "Las semanas de duración son obligatorias")
        @Positive(message = "Las semanas deben ser un número positivo")
        Integer semanas_de_duracion
) {
}
