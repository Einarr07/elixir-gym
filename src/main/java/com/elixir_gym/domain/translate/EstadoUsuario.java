package com.elixir_gym.domain.translate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstadoUsuario {

    ACTIVO(true), INACTIVO(false);

    private final boolean estado;

    public static EstadoUsuario fromBoolean(boolean value) {
        return value ? ACTIVO : INACTIVO;
    }
}
