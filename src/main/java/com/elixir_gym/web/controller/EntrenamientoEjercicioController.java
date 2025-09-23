package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;
import com.elixir_gym.domain.exception.EjercicioInexistenteException;
import com.elixir_gym.domain.exception.EntrenamientoInexistenteException;
import com.elixir_gym.domain.service.EjercicioService;
import com.elixir_gym.domain.service.EntrenamientoEjercicioService;
import com.elixir_gym.domain.service.EntrenamientoService;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import com.elixir_gym.persistence.repository.EjercicioRepository;
import com.elixir_gym.persistence.repository.EntrenamientoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenamiento-ejercicio")
@AllArgsConstructor
@Tag(name = "Entrenamiento y ejercicios", description = "Entrenamientos combinados con los ejercicios correspondientes")
public class EntrenamientoEjercicioController {

    private final EntrenamientoEjercicioService entrenamientoEjercicioService;


    @Operation(summary = "Obtener todas las relaciones entrenamiento-ejercicio",
            description = "Devuelve una lista con todas las relaciones entre entrenamientos y ejercicios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntrenamientoEjercicioDto.class)))
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EntrenamientoEjercicioDto>> getAll() {
        return ResponseEntity.ok(entrenamientoEjercicioService.findAll());
    }

    @Operation(summary = "Obtener una relación por IDs",
            description = "Devuelve la relación entre un entrenamiento y un ejercicio según sus IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntrenamientoEjercicioDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró la relación solicitada")
    })
    @GetMapping("/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<EntrenamientoEjercicioDto> findById(@PathVariable long idEntrenamiento,
                                                              @PathVariable long idEjercicio) {
        return ResponseEntity.ok(entrenamientoEjercicioService.findById(idEntrenamiento, idEjercicio));
    }

    @Operation(summary = "Crear una nueva relación entrenamiento-ejercicio",
            description = "Crea una nueva relación entre un entrenamiento y un ejercicio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación creada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntrenamientoEjercicioDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping("/crear")
    public ResponseEntity<EntrenamientoEjercicioDto> create(@RequestBody EntrenamientoEjercicioDto entrenamientoDto) {
        return ResponseEntity.ok(entrenamientoEjercicioService.save(entrenamientoDto));
    }

    @Operation(summary = "Actualizar una relación entrenamiento-ejercicio",
            description = "Actualiza una relación existente entre un entrenamiento y un ejercicio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relación actualizada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntrenamientoEjercicioDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Relación no encontrada")
    })
    @PutMapping("/actualizar/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<EntrenamientoEjercicioDto> update(
            @PathVariable long idEntrenamiento,
            @PathVariable long idEjercicio,
            @Valid @RequestBody ActualizarEntrenamientoEjercicioDto entrenamientoEjercicioDto
    ){
        return ResponseEntity.ok(entrenamientoEjercicioService
                .updateEntrenamientoEjericio(idEntrenamiento, idEjercicio, entrenamientoEjercicioDto));
    }

    @Operation(summary = "Eliminar una relación entrenamiento-ejercicio",
            description = "Elimina la relación entre un entrenamiento y un ejercicio según sus IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relación eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Relación no encontrada")
    })
    @DeleteMapping("/eliminar/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<Void> deleteById(
            @PathVariable long idEntrenamiento,
            @PathVariable long idEjercicio
    ){
        entrenamientoEjercicioService.deleteById(idEntrenamiento, idEjercicio);
        return ResponseEntity.noContent().build();
    }
}
