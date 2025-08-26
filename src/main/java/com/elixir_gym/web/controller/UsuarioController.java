package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.updates.ActualizarUsuarioDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioDto>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        return usuarioService.findById(id).map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuarioService.save(usuarioDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarUsuarioDto usuarioDto) {
        return usuarioService.update(id,usuarioDto).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
