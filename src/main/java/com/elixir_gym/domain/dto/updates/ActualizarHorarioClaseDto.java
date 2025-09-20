package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ActualizarHorarioClaseDto(
        @Future(message = "La fecha debe ser futura")
        LocalDate fecha,

        @NotNull(message = "La hora de inicio no puede ser nula")
        LocalTime hora_inicio,

        @NotNull(message = "La hora fin no puede ser nula")
        LocalTime hora_fin,

        @NotNull(message = "La clase no puede ser nula")
        ClaseDto clase,

        @NotNull(message = "El usuario no puede ser nulo")
        UsuarioDto entrenador
) {
}
