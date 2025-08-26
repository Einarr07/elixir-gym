package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class CorreoRegistradoException extends AppException {

    public CorreoRegistradoException(String email) {
        super(
                "Correo registrado",
                "EL correo " + email + " ya existe",
                HttpStatus.BAD_REQUEST
        );
    }
}
