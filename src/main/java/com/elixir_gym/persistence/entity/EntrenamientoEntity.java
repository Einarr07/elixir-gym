package com.elixir_gym.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "entrenamientos")
@Getter @Setter
public class EntrenamientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenamiento")
    private Long idEntrenamiento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String nivel;

    @Column(nullable = false, name = "duracion_semanas")
    private Integer duracionSemanas;
}
