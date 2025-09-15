package com.elixir_gym.domain.dto.updates;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ActualizarProgresoDto(
        @NotNull(message = "El id de usuario es obligatorio")
        Long idUsuario,

        @NotNull(message = "La fecha no puede ser nula")
        @PastOrPresent(message = "La fecha no puede ser futura")
        LocalDate fecha,

        @NotNull(message = "El peso no puede ser nulo")
        @DecimalMin(value = "30.00", inclusive = true, message = "El peso mínimo es 30kg")
        @DecimalMax(value = "300.00", inclusive = true, message = "El peso máximo es 300kg")
        BigDecimal peso,

        @NotNull(message = "La grasa corporal no puede ser nula")
        @DecimalMin(value = "0.00", inclusive = true, message = "El porcentaje de grasa corporal no puede ser negativo")
        @DecimalMax(value = "60.00", inclusive = true, message = "El porcentaje de grasa corporal no puede superar el 60%")
        BigDecimal grasa_corporal,

        @NotNull(message = "Las observaciones no pueden ser nulas")
        String observaciones
) {
}
