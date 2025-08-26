package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class RolInexistenteException extends AppException {

    public RolInexistenteException(long id) {
        super(
                "Rol inexistente",
                "El rol con el id " + id + " no existe",
                HttpStatus.BAD_REQUEST
        );
    }
}
