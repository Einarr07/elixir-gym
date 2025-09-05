package com.elixir_gym.domain.translate;

import com.elixir_gym.domain.exception.EstadoEquipoExeption;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

public enum EstadoEquipo {
    DISPONIBLE("disponible"),    // Se puede usar normalmente
    EN_MANTENIMIENTO("en mantenimiento"), // Fuera de servicio por reparación
    FUERA_DE_SERVICIO("fuera de servicio"), // No se puede usar (dañado o retirado)
    RESERVADO("reservado");  // Apartado para clase o usuario específico

    private final String value;

    EstadoEquipo(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator // cuando lo recibes en JSON, convierte desde este valor
    public static EstadoEquipo fromValue(String value) {
        for (EstadoEquipo estado : values()) {
            if (estado.value.equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new EstadoEquipoExeption(getValidValues());
    }

    public static List<String> getValidValues() {
        return Arrays.stream(values())
                .map(EstadoEquipo::getValue)
                .toList();
    }
}

