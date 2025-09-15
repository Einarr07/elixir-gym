package com.elixir_gym.domain.dto;

import java.time.LocalDate;

public record HistorialEntrenamientoDto(
        Long idHistorial,
        Long idEntrenamiento,
        Long idUsuario,
        LocalDate inicio,
        LocalDate fin,
        Boolean completado
) {
}
