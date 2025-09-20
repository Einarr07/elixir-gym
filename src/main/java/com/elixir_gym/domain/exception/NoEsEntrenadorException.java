package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class NoEsEntrenadorException extends AppException {
    public NoEsEntrenadorException(long idUsuario) {
        super(
                "El usuario no es entrenador",
                "El usuario con id: " + idUsuario + " no tiene rol de ENTRENADOR",
                HttpStatus.BAD_REQUEST
        );
    }
}
