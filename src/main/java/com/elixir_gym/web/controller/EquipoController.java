package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;
import com.elixir_gym.domain.service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipo")
@AllArgsConstructor
@Tag(
        name = "Equipo",
        description = "Gestión de los equipos disponibles en el gimnasio. Permite registrar, consultar, actualizar y eliminar los equipos de entrenamiento."
)
public class EquipoController {

    private final EquipoService equipoService;

    @Operation(summary = "Obtener todos los equipos",
            description = "Devuelve una lista de todos los equipos registrados en el gimnasio")
    @ApiResponse(responseCode = "200", description = "Lista de equipos obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<EquipoDto>> getAllEquipos(){
        return ResponseEntity.ok(equipoService.findAll());
    }

    @Operation(summary = "Obtener un equipo por ID",
            description = "Devuelve la información de un equipo específico según su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipo encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDto> getEquipoById(@PathVariable long id){
        return ResponseEntity.ok(equipoService.findById(id));
    }

    @Operation(summary = "Registrar un nuevo equipo",
            description = "Permite crear un nuevo registro de equipo en el sistema del gimnasio")
    @ApiResponse(responseCode = "201", description = "Equipo creado correctamente")
    @PostMapping("/crear")
    public ResponseEntity<EquipoDto> createEquipo(@RequestBody EquipoDto equipoDto){
        return new ResponseEntity<>(equipoService.save(equipoDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un equipo existente",
            description = "Permite modificar la información de un equipo registrado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipo actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EquipoDto> updateEquipo(
            @PathVariable long id,
            @Valid @RequestBody ActualizarEquipoDto equipoDto){
        return ResponseEntity.ok(equipoService.update(id, equipoDto));
    }

    @Operation(summary = "Eliminar un equipo",
            description = "Elimina el registro de un equipo específico del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Equipo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable long id){
        equipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
