package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.updates.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.domain.service.GrupoMuscularService;
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
@RequestMapping("/api/grupo-muscular")
@AllArgsConstructor
@Tag(
        name = "Grupos musculares",
        description = "Gestión de los diferentes grupos musculares. Permite consultar, registrar, actualizar y eliminar la información de cada grupo muscular."
)
public class GrupoMuscularController {

    private final GrupoMuscularService grupoMuscularService;

    @Operation(summary = "Obtener todos los grupos musculares",
            description = "Devuelve una lista con todos los grupos musculares registrados")
    @ApiResponse(responseCode = "200", description = "Lista de grupos musculares obtenida correctamente")
    @GetMapping("/todos")
    public ResponseEntity<List<GrupoMuscularDto>> findAll() {
        return ResponseEntity.ok(grupoMuscularService.findAll());
    }

    @Operation(summary = "Obtener un grupo muscular por ID",
            description = "Devuelve la información de un grupo muscular específico según su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grupo muscular encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GrupoMuscularDto.class))),
            @ApiResponse(responseCode = "404", description = "Grupo muscular no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<GrupoMuscularDto> findById(@PathVariable long id) {
        return grupoMuscularService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo grupo muscular",
            description = "Crea un nuevo grupo muscular dentro del sistema")
    @ApiResponse(responseCode = "201", description = "Grupo muscular creado correctamente")
    @PostMapping("/crear")
    public ResponseEntity<GrupoMuscularDto> create(@RequestBody GrupoMuscularDto grupoMuscularDto) {
        return new ResponseEntity<>(grupoMuscularService.save(grupoMuscularDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un grupo muscular",
            description = "Permite modificar la información de un grupo muscular existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grupo muscular actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Grupo muscular no encontrado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<GrupoMuscularDto> updateGrupoMuscular(@PathVariable long id,
                                                                @Valid
                                                                @RequestBody ActualizarGrupoMuscularDto actualizarGrupoMuscularDto) {
        return grupoMuscularService.update(id, actualizarGrupoMuscularDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un grupo muscular",
            description = "Elimina un grupo muscular del sistema según su identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Grupo muscular eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Grupo muscular no encontrado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteGrupoMuscular(@PathVariable long id) {
        grupoMuscularService.deleteGrupoMuscular(id);
        return ResponseEntity.noContent().build();
    }
}
