package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class EstadoEquipoExeption extends AppException {

    public EstadoEquipoExeption(List<String> valores) {
        super(
                "Estado inválido",
                "Los valores válidos son: " + String.join(", ", valores),
                HttpStatus.BAD_REQUEST
        );
    }
}
