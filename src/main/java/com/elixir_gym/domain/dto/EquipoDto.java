package com.elixir_gym.domain.dto;

public record EquipoDto(
        Long idEquipo,
        String nombre,
        String tipo,
        String estado,
        EjercicioDto ejercicios
) {
}
