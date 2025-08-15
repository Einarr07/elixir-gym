package com.elixir_gym.domain.exception;

public class CorreoRegistradoException extends RuntimeException {

    public CorreoRegistradoException(String email) {
        super("EL correo " + email + " ya existe");;
    }
}
