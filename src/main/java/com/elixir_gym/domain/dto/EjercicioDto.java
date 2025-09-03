package com.elixir_gym.domain.dto;

import java.util.List;

public record EjercicioDto(
        Long idEjercicio,
        String nombre,
        String descripcion,
        String video,
        String imagen,
        String equipo_necesario,
        GrupoMuscularDto grupo_muscular,
        List<EquipoDto> equipos
) {
}
