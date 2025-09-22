package com.elixir_gym.persistence.entity;

import com.elixir_gym.domain.translate.EstadoReserva;
import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clases_reservadas")
@Getter @Setter
public class ClaseReservadaEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Future(message = "La fecha debe ser futura")
    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "estado_reserva")
    private EstadoReserva estadoReserva = EstadoReserva.PENDIENTE;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioClaseEntity horario;
}
