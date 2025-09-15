package com.elixir_gym.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProgresoDto(
        Long idProgreso,
        Long idUsuario,
        LocalDate fecha,
        BigDecimal peso,
        BigDecimal grasa_corporal,
        String observaciones
) {
}
