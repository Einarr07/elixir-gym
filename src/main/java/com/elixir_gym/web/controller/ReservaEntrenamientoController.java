package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;
import com.elixir_gym.domain.service.ReservaEntrenamientoService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("api/reserva-entrenamientos")
@AllArgsConstructor
@Tag(
        name = "Reserva de entrenamientos",
        description = "Gestión de reservaciones realizadas por los clientes para asistir a entrenamientos."
)
public class ReservaEntrenamientoController {

    private final ReservaEntrenamientoService reservaService;

    @Operation(summary = "Obtener todas las reservas de entrenamientos")
    @ApiResponse(responseCode = "200", description = "Lista de reservas obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<ReservaEntrenamientoDto>> getAll() {
        return ResponseEntity.ok(reservaService.getAll());
    }

    @Operation(summary = "Obtener una reserva de entrenamiento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntrenamientoDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(reservaService.getById(id));
    }

    @Operation(summary = "Crear una nueva reserva de entrenamiento")
    @ApiResponse(responseCode = "201", description = "Reserva creada exitosamente")
    @PostMapping("/crear")
    public ResponseEntity<ReservaEntrenamientoDto> create(@RequestBody ReservaEntrenamientoDto dto) {
        return new ResponseEntity<>(reservaService.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una reserva de entrenamiento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaEntrenamientoDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarReservaEntrenamientoDto dto) {

        return ResponseEntity.ok(reservaService.update(id, dto));
    }

    @Operation(summary = "Eliminar una reserva de entrenamiento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
