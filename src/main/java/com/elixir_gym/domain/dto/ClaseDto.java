package com.elixir_gym.domain.dto;

import com.elixir_gym.domain.translate.NivelEntrenamiento;

public record ClaseDto(
        Long idClase,
        String nombre,
        String descripcion,
        NivelEntrenamiento dificultad,
        Integer duracion,
        Integer capacidad_max
) {
}
