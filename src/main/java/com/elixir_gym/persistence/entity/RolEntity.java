package com.elixir_gym.persistence.entity;

import com.elixir_gym.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class RolEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(nullable = false, name = "nombre_rol", unique = true)
    private String nombreRol;

    @Column(nullable = false, name = "descripcion_rol")
    private String descripcionRol;
}
