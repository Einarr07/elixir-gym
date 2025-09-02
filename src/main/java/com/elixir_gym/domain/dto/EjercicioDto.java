package com.elixir_gym.domain.dto;

public record EjercicioDto(
        Long idEjercicio,
        String nombre,
        String descripcion,
        String video,
        String imagen,
        String equipo_necesario,
        GrupoMuscularDto grupo_muscular,
        EquipoDto equipos
) {
}
