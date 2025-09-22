package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.translate.EstadoReserva;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ActualizarClaseReservadaDto(

        @NotNull(message = "El usuario es obligatorio")
        UsuarioDto usuario,

        @NotNull(message = "El horario es obligatorio")
        HorarioClaseDto horario,

        @Future(message = "La fecha de la reservación debe ser futura")
        @NotNull(message = "La reservación es obligatoria")
        LocalDate reservacion,

        @NotNull(message = "El estado de la reservación es obligatorio")
        EstadoReserva estado
) {
}
