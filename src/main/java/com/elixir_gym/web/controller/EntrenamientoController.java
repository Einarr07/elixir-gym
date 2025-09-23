package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.service.EntrenamientoService;
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
@RequestMapping("/api/entrenamientos")
@AllArgsConstructor
@Tag(name = "Entrenamiento", description = "Aquí se puede encontrar todos los entrenamientos registrados/creados")
public class EntrenamientoController {

    private final EntrenamientoService entrenamientoService;

    @Operation(summary = "Obtener todos los entrenamientos",
            description = "Devuelve una lista con todos los entrenamientos registrados")
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<EntrenamientoDto>> getAll() {
        return ResponseEntity.ok(entrenamientoService.findAll());
    }

    @Operation(summary = "Obtener un entrenamiento por ID",
            description = "Devuelve un entrenamiento específico según su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenamiento encontrado"),
            @ApiResponse(responseCode = "404", description = "Entrenamiento no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntrenamientoDto> getById(@PathVariable long id) {
        return entrenamientoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo entrenamiento",
            description = "Registra un nuevo entrenamiento en la base de datos")
    @ApiResponse(responseCode = "201", description = "Entrenamiento creado correctamente")
    @PostMapping("/crear")
    public ResponseEntity<EntrenamientoDto> create(@Valid @RequestBody EntrenamientoDto entrenamientoDto) {
        return new ResponseEntity<>(entrenamientoService.save(entrenamientoDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un entrenamiento",
            description = "Modifica la información de un entrenamiento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenamiento actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Entrenamiento no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntrenamientoDto> update(@PathVariable long id,
                                                   @Valid @RequestBody ActualizarEntrenamientoDto actualizarEntrenamientoDto) {
        return entrenamientoService.update(id, actualizarEntrenamientoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un entrenamiento",
            description = "Elimina un entrenamiento según su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Entrenamiento eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Entrenamiento no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        entrenamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
