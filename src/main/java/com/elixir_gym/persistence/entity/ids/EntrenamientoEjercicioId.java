package com.elixir_gym.persistence.entity.ids;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntrenamientoEjercicioId implements Serializable {

    private Long idEntrenamiento;
    private Long idEjercicio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof  EntrenamientoEjercicioId)) return false;
        EntrenamientoEjercicioId that = (EntrenamientoEjercicioId) o;
        return Objects.equals(idEntrenamiento, that.idEntrenamiento) &&
                Objects.equals(idEjercicio, that.idEjercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntrenamiento, idEjercicio);
    }
}
