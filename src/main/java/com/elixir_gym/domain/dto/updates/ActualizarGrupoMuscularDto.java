package com.elixir_gym.domain.dto.updates;

import com.elixir_gym.domain.dto.EjercicioDto;

public record ActualizarGrupoMuscularDto(
        String nombre,
        String descripcion,
        EjercicioDto ejercicio
) {
}
