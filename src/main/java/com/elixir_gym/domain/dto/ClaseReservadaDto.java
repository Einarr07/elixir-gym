package com.elixir_gym.domain.dto;

import com.elixir_gym.domain.translate.EstadoReserva;

import java.time.LocalDate;

public record ClaseReservadaDto(
        Long idReserva,
        UsuarioDto usuario,
        HorarioClaseDto horario,
        LocalDate reservacion,
        EstadoReserva estado
) {
}
