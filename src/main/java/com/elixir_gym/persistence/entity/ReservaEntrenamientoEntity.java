package com.elixir_gym.persistence.entity;

import com.elixir_gym.domain.translate.EstadoReserva;
import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reserva_entrenamientos")
@Getter @Setter
public class ReservaEntrenamientoEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private long idReserva;

    @Future(message = "La fecha de la reserva debe ser en el futuro")
    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado = EstadoReserva.PENDIENTE;

    @ManyToOne
    @JoinColumn(name = "id_entrenamiento", nullable = false)
    private EntrenamientoEntity entrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
}
