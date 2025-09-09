package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Entity
@Table(name = "entrenamientos_ejercicios")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class  EntrenamientoEjercicioEntity extends AuditableEntity {

    @EmbeddedId
    private EntrenamientoEjercicioId id;

    @ManyToOne
    @MapsId("idEntrenamiento")
    @JoinColumn(name = "id_entrenamiento")
    private EntrenamientoEntity entrenamiento;

    @ManyToOne
    @MapsId("idEjercicio")
    @JoinColumn(name = "id_ejercicio")
    private EjercicioEntity ejercicio;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer repeticiones;

    @DecimalMin(value = "1.00", inclusive = true, message = "El peso minimo es de 1kg")
    @DecimalMax(value = "500.00", inclusive = true, message = "El peso maximo es de 500kg")
    @Column(precision = 5, scale = 2, columnDefinition = "DECIMAL(5,2)")
    private BigDecimal pesoSugerido;

    @Column(name = "descanso_segundos")
    private Integer descansoSegundos;
}
