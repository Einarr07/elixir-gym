package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.translate.EstadoReserva;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ActualizarReservaEntrenamientoDto(

        @NotNull(message = "La fecha de la reserva no puede ser nula")
        @Future(message = "La fecha de la reserva debe ser en el futuro")
        LocalDate fecha_reserva,

        @NotNull(message = "El estado de la reserva no puede ser nulo")
        EstadoReserva estado,

        @NotNull(message = "El id del entrenamiento no puede ser nulo")
        Long idEntrenamiento,

        @NotNull(message = "El id del usuario no puede ser nulo")
        Long idUsuario
) {
}
