package com.elixir_gym.persistence.mapper;

import org.mapstruct.Named;

public class EstadoUsuarioMapper {

    @Named("stringToBoolean")
    public static Boolean  stringToBoolean(String estado) {
        if (estado == null) return null;
        return "Activo".equalsIgnoreCase(estado);
    }

    @Named("booleanToString")
    public static String booleanToString(Boolean  estado) {
        if (estado == null) return null;
        return estado ? "Activo" : "Inactivo";
    }
}
