package com.elixir_gym.domain.dto;

public record GrupoMuscularDto(
        Long idGrupoMuscular,
        String nombre,
        String descripcion,
        EjercicioDto ejercicio
) {
}
