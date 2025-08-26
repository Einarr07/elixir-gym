package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.service.EntrenamientoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenamiento")
@AllArgsConstructor
public class EntrenamientoController {

    private final EntrenamientoService entrenamientoService;

    @GetMapping("/todos")
    public ResponseEntity<List<EntrenamientoDto>> getAll() {
        return ResponseEntity.ok(entrenamientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenamientoDto> getById(@PathVariable long id) {
        return entrenamientoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<EntrenamientoDto> create(@RequestBody EntrenamientoDto entrenamientoDto) {
        return new ResponseEntity<>(entrenamientoService.save(entrenamientoDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntrenamientoDto> update(@PathVariable long id,
                                                   @Valid
                                                   @RequestBody ActualizarEntrenamientoDto actualizarEntrenamientoDto) {
        return entrenamientoService.update(id, actualizarEntrenamientoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        entrenamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
