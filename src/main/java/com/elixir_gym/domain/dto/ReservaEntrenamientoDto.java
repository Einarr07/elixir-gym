package com.elixir_gym.domain.dto;

import com.elixir_gym.domain.translate.EstadoReserva;

import java.time.LocalDate;

public record ReservaEntrenamientoDto(
        LocalDate fecha_reserva,
        EstadoReserva estado,
        Long idEntrenamiento,
        Long idUsuario
) {
}
