package com.elixir_gym.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(nullable = false, name = "nombre_rol", unique = true)
    private String nombreRol;

    @Column(nullable = false, name = "descripcion_rol")
    private String descripcionRol;
}
