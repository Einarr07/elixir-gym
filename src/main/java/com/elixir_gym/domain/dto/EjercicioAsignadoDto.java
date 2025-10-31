package com.elixir_gym.domain.dto;

import java.math.BigDecimal;

public record EjercicioAsignadoDto(
        Long idEntrenamiento,
        Long idEjercicio,
        String nombre,
        Integer series,
        Integer repeticiones,
        BigDecimal peso_sugerido,
        Integer descanso_segundos
) {
}
