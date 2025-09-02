package com.elixir_gym.persistence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
public class AuditableEntity {

    @Column(name = "fecha_creacion")
    @CreatedDate
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    @LastModifiedDate
    private LocalDateTime fechaModificacion;

    @Column(name = "creado_por")
    @CreatedBy
    private String creadoPor;

    @Column(name = "modificado_por")
    @LastModifiedBy
    private String modificadoPor;
}
