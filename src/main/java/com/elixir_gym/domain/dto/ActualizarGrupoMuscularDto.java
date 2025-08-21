package com.elixir_gym.domain.dto;

public record ActualizarGrupoMuscularDto(
        String nombre,
        String descripcion,
        EjercicioDto ejercicio
) {
}
