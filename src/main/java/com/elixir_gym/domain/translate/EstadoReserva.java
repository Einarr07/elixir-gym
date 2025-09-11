package com.elixir_gym.domain.translate;

import com.elixir_gym.domain.exception.EstadoReservaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

public enum EstadoReserva {
    PENDIENTE("pendiente"),
    CONFIRMADA("confirmada"),
    CANCELADA("cancelada"),
    COMPLETADA("completa"),
    NO_ASISTIO("no asistio"),
    EXPIRADA("expirada");

    private String value;

    EstadoReserva(String estado) {
        this.value = estado;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EstadoReserva fromValue(String value) {
        for (EstadoReserva e : EstadoReserva.values()) {
            if(e.value.equals(value)) {
                return e;
            }
        }
        throw new EstadoReservaException(getValues());
    }

    public static List<String> getValues(){
        return Arrays.stream(values())
                .map(EstadoReserva::getValue)
                .toList();
    }
}
