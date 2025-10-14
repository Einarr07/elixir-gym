package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.dto.updates.ActualizarUsuarioDto;
import com.elixir_gym.domain.service.UsuarioService;
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
@RequestMapping("/api/usuario")
@AllArgsConstructor
@Tag(name = "Usuarios", description = "Todo el registro de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/todos")
    @Operation(summary = "Listar todos los usuarios", description = "Obtiene todos los usuarios registrados en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida correctamente")
    public ResponseEntity<List<UsuarioDto>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por ID", description = "Obtiene un usuario específico según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/crear")
    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponse(responseCode = "201", description = "Usuario creado correctamente")
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioService.save(usuarioDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<UsuarioDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarUsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.update(id, usuarioDto));
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario eliminado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
