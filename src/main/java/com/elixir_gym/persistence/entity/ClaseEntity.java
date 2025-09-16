package com.elixir_gym.persistence.entity;

import com.elixir_gym.domain.translate.NivelEntrenamiento;
import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clases")
@Getter
@Setter
public class ClaseEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long idClase;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelEntrenamiento nivel;

    @Column(nullable = false)
    private Integer duracion;

    @Column(nullable = false, name = "capacidad_max")
    private Integer capacidadMax;
}
