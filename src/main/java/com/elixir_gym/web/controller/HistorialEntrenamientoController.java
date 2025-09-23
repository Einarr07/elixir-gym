package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;
import com.elixir_gym.domain.service.HistorialEntrenemaientoService;
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
@RequestMapping("api/historial-entrenameinto")
@AllArgsConstructor
@Tag(
        name = "Historial de entrenamiento",
        description = "Gestión de historiales de entrenamiento de los usuarios."
)
public class HistorialEntrenamientoController {

    private final HistorialEntrenemaientoService historialService;

    @Operation(summary = "Obtener todos los historiales")
    @ApiResponse(responseCode = "200", description = "Lista de historiales obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<HistorialEntrenamientoDto>> getHistorialEntrenamientos() {
        return ResponseEntity.ok(historialService.getAllHistorialEntrenamiento());
    }

    @Operation(summary = "Obtener historial por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial encontrado"),
            @ApiResponse(responseCode = "404", description = "Historial no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HistorialEntrenamientoDto> getHistorialEntrenamientoById(@PathVariable long id) {
        return ResponseEntity.ok(historialService.getById(id));
    }

    @Operation(summary = "Crear un nuevo historial")
    @ApiResponse(responseCode = "201", description = "Historial creado exitosamente")
    @PostMapping("/crear")
    public ResponseEntity<HistorialEntrenamientoDto> createHistorial(
            @RequestBody HistorialEntrenamientoDto historialEntrenamientoDto) {
        return new ResponseEntity<>(historialService.save(historialEntrenamientoDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un historial existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Historial no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistorialEntrenamientoDto> updateHistorial(
            @PathVariable long id,
            @Valid @RequestBody ActualizarHistorialEntrenamientoDto actualizarHistorialDto) {
        return ResponseEntity.ok(historialService.update(id, actualizarHistorialDto));
    }

    @Operation(summary = "Eliminar historial por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Historial eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Historial no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteHistorialById(@PathVariable long id) {
        historialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
