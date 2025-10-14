package com.elixir_gym.domain.exception;


import org.springframework.http.HttpStatus;

public class CorreoExeption extends AppException {
    public CorreoExeption(String correo) {
        super(
                "El correo electronico no se encuentra registrado",
                "El correo " + correo + " no se encuentra registrado",
                HttpStatus.NOT_FOUND
        );
    }
}
