package com.elixir_gym.domain.translate;

import com.elixir_gym.domain.exception.TipoEquipoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

public enum TipoEquipo {
    LIBRE("libre"),                  // Barras, mancuernas, kettlebells
    MAQUINA("maquina"),              // Máquinas guiadas (prensa, polea, smith)
    ACCESORIO("accesorio"),          // Colchonetas, bandas elásticas, fitball
    ESTRUCTURA("estructura"),        // Jaulas, paralelas, barra fija
    CARDIO("cardio"),                // Cinta, bicicleta, elíptica, remo
    PESO_CORPORAL("peso corporal");  // No requiere equipo, solo el cuerpo

    private final String value;

    TipoEquipo(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TipoEquipo fromValue(String value) {
        for (TipoEquipo tipo : values()) {
            if (tipo.value.equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new TipoEquipoException(getValidValues());
    }

    public static List<String> getValidValues() {
        return Arrays.stream(values())
                .map(TipoEquipo::getValue)
                .toList();
    }
}
