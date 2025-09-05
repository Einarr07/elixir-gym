package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class TipoEquipoException extends AppException{

    public TipoEquipoException(List<String> valores) {
        super(
                "Tipo Invalido",
                "Los estados pueden ser: " + String.join(", ", valores),
                HttpStatus.BAD_REQUEST
        );
    }
}
