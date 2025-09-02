package com.elixir_gym.domain.exception;

import org.springframework.http.HttpStatus;

public class EquipoIniexistenteExeption extends AppException {

    public EquipoIniexistenteExeption(long id) {
        super(
                "Equipo Iniexistente",
                "El equipo con id: " + id + " no existe",
                HttpStatus.NOT_FOUND
        );
    }
}
