package com.elixir_gym.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @DecimalMin(value = "30.00", inclusive = true, message = "El peso mínimo es 30kg")
    @DecimalMax(value = "300.00", inclusive = true, message = "El peso máximo es 300kg")
    @Column(precision = 5, scale = 2, columnDefinition = "DECIMAL(5,2) CHECK (peso > 30 AND peso < 300)")
    private BigDecimal peso;

    @DecimalMin(value = "0.50", inclusive = true, message = "La altura mínima es 0.5m")
    @DecimalMax(value = "2.50", inclusive = true, message = "La altura máxima es 2.5m")
    @Column(precision = 3, scale = 2, columnDefinition = "DECIMAL(3,2) CHECK (altura > 0.5 AND altura < 3)")
    private BigDecimal altura;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "estado_usuario", nullable = false)
    private Boolean estadoUsuario;
}
