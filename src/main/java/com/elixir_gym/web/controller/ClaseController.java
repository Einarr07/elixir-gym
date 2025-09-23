package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;
import com.elixir_gym.domain.service.ClaseService;
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
@RequestMapping("api/clase")
@AllArgsConstructor
@Tag(name = "Clase", description = "Endpoints para la gestión de las clases dentro del gimnasio")
public class ClaseController {

    private final ClaseService claseService;

    @Operation(summary = "Obtener todas las clases", description = "Devuelve una lista con todas las clases registradas en el gimnasio.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clases obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseDto.class)))
    })
    @GetMapping("/todos")
    public ResponseEntity<List<ClaseDto>> getAll() {
        return ResponseEntity.ok(claseService.getAll());
    }

    @Operation(summary = "Obtener clase por ID", description = "Devuelve la información de una clase específica mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clase encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseDto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró la clase con el ID proporcionado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClaseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(claseService.getById(id));
    }

    @Operation(summary = "Crear una nueva clase", description = "Registra una nueva clase en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Clase creada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados en la solicitud")
    })
    @PostMapping("/crear")
    public ResponseEntity<ClaseDto> create(@RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(claseService.save(claseDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar clase existente", description = "Permite modificar los datos de una clase mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clase actualizada correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClaseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Clase no encontrada")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClaseDto> update(@PathVariable long id,
                                           @Valid @RequestBody ActualizarClaseDto actualizarClaseDto){
        return ResponseEntity.ok(claseService.updateClase(id, actualizarClaseDto));
    }

    @Operation(summary = "Eliminar clase", description = "Elimina una clase existente mediante su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Clase eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Clase no encontrada")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        claseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
