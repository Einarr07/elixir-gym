package com.elixir_gym.domain.dto;

import com.elixir_gym.domain.translate.NivelEntrenamiento;

public record EntrenamientoDto(
        Long idEntrenamiento,
        String nombre,
        String descripcion,
        NivelEntrenamiento nivel,
        Integer semanas_de_duracion
) {
}
