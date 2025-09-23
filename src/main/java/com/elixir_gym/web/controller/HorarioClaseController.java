package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;
import com.elixir_gym.domain.service.HorarioClaseService;
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
@RequestMapping("api/horario-clase")
@AllArgsConstructor
@Tag(
        name = "Horario de clase",
        description = "Gestión de los horarios en los que se imparten las clases."
)
public class HorarioClaseController {

    private final HorarioClaseService horarioClaseService;

    @Operation(summary = "Obtener todos los horarios de clase")
    @ApiResponse(responseCode = "200", description = "Lista de horarios obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<HorarioClaseDto>> getAll() {
        return ResponseEntity.ok(horarioClaseService.getAll());
    }

    @Operation(summary = "Obtener un horario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Horario encontrado"),
            @ApiResponse(responseCode = "404", description = "Horario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HorarioClaseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(horarioClaseService.getById(id));
    }

    @Operation(summary = "Crear un nuevo horario de clase")
    @ApiResponse(responseCode = "201", description = "Horario creado exitosamente")
    @PostMapping("/crear")
    public ResponseEntity<HorarioClaseDto> create(@RequestBody HorarioClaseDto horarioClaseDto) {
        return new ResponseEntity<>(horarioClaseService.create(horarioClaseDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un horario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Horario actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Horario no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HorarioClaseDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarHorarioClaseDto actualizarHorarioClaseDto
    ) {
        return ResponseEntity.ok(horarioClaseService.update(id, actualizarHorarioClaseDto));
    }

    @Operation(summary = "Eliminar un horario por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Horario eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Horario no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        horarioClaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
