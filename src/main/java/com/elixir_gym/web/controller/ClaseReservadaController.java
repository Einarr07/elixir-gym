package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;
import com.elixir_gym.domain.service.ClaseReservadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clase-reservada")
@AllArgsConstructor
@Tag(name = "Clase reservada", description = "Endpoints para la gestión de reservaciones que los clientes realizan para las clases")
public class ClaseReservadaController {

    private final ClaseReservadaService claseReservadaService;

    @Operation(summary = "Obtener todas las reservaciones", description = "Devuelve una lista con todas las clases reservadas por los clientes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reservaciones obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseReservadaDto.class)))
    })
    @GetMapping("/todos")
    public ResponseEntity<List<ClaseReservadaDto>> getAll() {
        return ResponseEntity.ok(claseReservadaService.getAll());
    }

    @Operation(summary = "Obtener reservación por ID", description = "Devuelve los detalles de una clase reservada en base a su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservación encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseReservadaDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró la reservación con el ID proporcionado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClaseReservadaDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(claseReservadaService.getById(id));
    }

    @Operation(summary = "Crear una nueva reservación", description = "Registra una nueva clase reservada por un cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservación creada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseReservadaDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados en la solicitud")
    })
    @PostMapping("/crear")
    public ResponseEntity<ClaseReservadaDto> create(@RequestBody ClaseReservadaDto claseReservadaDto) {
        return new ResponseEntity<>(claseReservadaService.save(claseReservadaDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una reservación", description = "Permite modificar los datos de una reservación existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservación actualizada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseReservadaDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Reservación no encontrada")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClaseReservadaDto> update(@PathVariable long id,
                                                    @Valid @RequestBody ActualizarClaseReservadaDto claseReservadaDto) {
        return ResponseEntity.ok(claseReservadaService.update(id, claseReservadaDto));
    }

    @Operation(summary = "Eliminar reservación", description = "Elimina una reservación de clase existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reservación eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Reservación no encontrada")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        claseReservadaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
