package com.elixir_gym.domain.dto;

import java.math.BigDecimal;

public record EntrenamientoEjercicioDto(
        Long idEntrenamiento,
        Long idEjercicio,
        Integer series,
        Integer repeticiones,
        BigDecimal peso_sugerido,
        Integer descanso_segundos
) {
}
