package com.elixir_gym.domain.translate;

import com.elixir_gym.domain.exception.NivelEntrenamientoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

public enum NivelEntrenamiento {
    PRINCIPIANTE("principiante"),
    INTERMEDIO("intermedio"),
    AVANZADO("avanzado");

    private final String value;

    NivelEntrenamiento(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static NivelEntrenamiento fromValue(String value) {
        for (NivelEntrenamiento nivel : values()) {
            if (nivel.value.equalsIgnoreCase(value)) {
                return nivel;
            }
        }
        throw new NivelEntrenamientoException(getValidValues());
    }

    public static List<String> getValidValues() {
        return Arrays.stream(values())
                .map(NivelEntrenamiento::getValue)
                .toList();
    }
}
