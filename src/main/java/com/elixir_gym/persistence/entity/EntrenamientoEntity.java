package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "entrenamientos")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class EntrenamientoEntity extends AuditableEntity {

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
