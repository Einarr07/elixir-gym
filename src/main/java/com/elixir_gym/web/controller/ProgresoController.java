package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;
import com.elixir_gym.domain.service.ProgresoService;
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
@RequestMapping("/api/progreso")
@AllArgsConstructor
@Tag(
        name = "Progreso",
        description = "Gestión del progreso físico de los usuarios."
)
public class ProgresoController {

    private final ProgresoService progresoService;

    @Operation(summary = "Obtener todo el progreso registrado")
    @ApiResponse(responseCode = "200", description = "Lista de progresos obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<ProgresoDto>> getAll() {
        return ResponseEntity.ok(progresoService.getAll());
    }

    @Operation(summary = "Obtener un progreso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progreso encontrado"),
            @ApiResponse(responseCode = "404", description = "Progreso no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProgresoDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(progresoService.getById(id));
    }

    @Operation(summary = "Registrar un nuevo progreso")
    @ApiResponse(responseCode = "201", description = "Progreso creado exitosamente")
    @PostMapping("/crear")
    public ResponseEntity<ProgresoDto> create(@RequestBody ProgresoDto progresoDto) {
        return new ResponseEntity<>(progresoService.save(progresoDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un progreso existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Progreso actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Progreso no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProgresoDto> update(@PathVariable long id,
                                              @Valid @RequestBody ActualizarProgresoDto progresoDto) {
        return ResponseEntity.ok(progresoService.update(id, progresoDto));
    }

    @Operation(summary = "Eliminar un progreso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Progreso eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Progreso no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        progresoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
