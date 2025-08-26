package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class UsuarioInexistenteException extends AppException{

    public UsuarioInexistenteException(long id) {
        super(
                "Usuario inexistente",
                "El usuario con el id " + id + " no existe",
                HttpStatus.BAD_REQUEST
        );
    }
}
