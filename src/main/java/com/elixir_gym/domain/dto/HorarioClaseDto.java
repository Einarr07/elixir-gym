package com.elixir_gym.domain.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record HorarioClaseDto(
        Long idHorario,
        LocalDate fecha,
        LocalTime hora_inicio,
        LocalTime hora_fin,
        ClaseDto clase,
        UsuarioDto entrenador
) {
}
