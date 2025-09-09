package com.elixir_gym.domain.dto.updates;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public record ActualizarHistorialEntrenamientoDto(

        @NotNull(message = "El id del entrenamiento es obligatorio")
        Long idEntrenamiento,

        @NotNull(message = "El id del usuario es obligatorio")
        Long idUsuario,

        @NotNull(message = "La fecha de inicio no puede ser nula")
        @PastOrPresent(message = "La fecha de inicio no puede ser futura")
        LocalDate inicio,

        @PastOrPresent(message = "La fecha de fin no puede ser futura")
        LocalDate fin,

        @NotNull(message = "El estado de completado es obligatorio")
        Boolean completado
) {
}
