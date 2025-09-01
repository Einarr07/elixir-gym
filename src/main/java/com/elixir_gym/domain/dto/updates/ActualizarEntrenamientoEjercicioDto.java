package com.elixir_gym.domain.dto.updates;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ActualizarEntrenamientoEjercicioDto(
        @NotNull(message = "El número de series es obligatorio")
        @Min(value = 1, message = "Debe haber al menos 1 serie")
        Integer series,

        @NotNull(message = "El número de repeticiones es obligatorio")
        @Min(value = 1, message = "Debe haber al menos 1 repetición")
        Integer repeticiones,

        @DecimalMin(value = "1.00", inclusive = true, message = "El peso mínimo es de 1kg")
        @DecimalMax(value = "500.00", inclusive = true, message = "El peso máximo es de 500kg")
        BigDecimal peso_sugerido,

        @NotNull(message = "El tiempo de descanso es obligatorio")
        @Positive(message = "El descanso debe ser mayor a 0 segundos")
        Integer descanso_segundos
) {
}
