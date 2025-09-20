package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horarios_clases")
@Getter
@Setter
public class HorarioClaseEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @Future(message = "La fecha debe ser futura")
    @Column(name = "fecha_clase", nullable = false)
    private LocalDate fechaClase;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "id_clase", nullable = false)
    private ClaseEntity clase;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
}
