package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ejercicios")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class EjercicioEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Long idEjercicio;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "equipo_necesario")
    private String equipoNecesario;

    @ManyToOne
    @JoinColumn(
            name = "id_grupo_muscular",
            nullable = false
    )
    private GrupoMuscularEntity grupo;
}
