package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.service.EjercicioService;
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
@RequestMapping("/api/ejercicio")
@AllArgsConstructor
@Tag(name = "Ejercicio", description = "Endpoints para la gestión de los ejercicios que se pueden realizar en el gimnasio")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    @Operation(summary = "Obtener todos los ejercicios", description = "Devuelve una lista con todos los ejercicios registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ejercicios obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EjercicioDto.class)))
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EjercicioDto>> findAll() {
        return ResponseEntity.ok(ejercicioService.findAll());
    }

    @Operation(summary = "Obtener ejercicio por ID", description = "Devuelve la información de un ejercicio específico mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ejercicio encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EjercicioDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró el ejercicio con el ID proporcionado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EjercicioDto> findById(@PathVariable long id) {
        return ejercicioService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo ejercicio", description = "Registra un nuevo ejercicio en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ejercicio creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EjercicioDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados en la solicitud")
    })
    @PostMapping("/crear")
    public ResponseEntity<EjercicioDto> create(@RequestBody EjercicioDto ejercicioDto) {
        return new ResponseEntity<>(ejercicioService.save(ejercicioDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un ejercicio", description = "Permite modificar los datos de un ejercicio existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ejercicio actualizado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EjercicioDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Ejercicio no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EjercicioDto> update(@PathVariable long id,
                                               @Valid @RequestBody ActualizarEjercicioDto actualizarEjercicioDto) {
        return ejercicioService.updateEjercicio(id, actualizarEjercicioDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un ejercicio", description = "Elimina un ejercicio existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ejercicio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Ejercicio no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        ejercicioService.deleteEjercicioById(id);
        return ResponseEntity.noContent().build();
    }
}
