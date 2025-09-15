package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "progresos")
@Getter
@Setter
public class ProgresoEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progreso")
    private Long idProgreso;

    @Column(nullable = false)
    private LocalDate fecha;

    @DecimalMin(value = "30.00", inclusive = true, message = "El peso mínimo es 30kg")
    @DecimalMax(value = "300.00", inclusive = true, message = "El peso máximo es 300kg")
    @Column(nullable = false,
            precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) CHECK (peso >= 30 AND peso <= 300)"
    )
    private BigDecimal peso;

    @DecimalMin(value = "0.00", inclusive = true, message = "El porcentaje de grasa corporal no puede ser negativo")
    @DecimalMax(value = "60.00", inclusive = true, message = "El porcentaje de grasa corporal no puede superar el 60%")
    @Column(nullable = false,
            name = "grasa_corporal",
            precision = 5, scale = 2,
            columnDefinition = "DECIMAL(5,2) CHECK (grasa_corporal >= 0 AND grasa_corporal <= 60)"
    )
    private BigDecimal grasaCorporal;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
}
