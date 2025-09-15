package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class EstadoReservaException extends AppException{
    public EstadoReservaException(List<String> values) {
        super(
                "Estado de reserva incorrecto",
                "Los valores validos para el estado de reserva son: " + String.join(", ", values),
                HttpStatus.BAD_REQUEST
        );
    }
}
