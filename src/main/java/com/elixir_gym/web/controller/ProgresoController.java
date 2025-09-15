package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ProgresoDto;
import com.elixir_gym.domain.dto.updates.ActualizarProgresoDto;
import com.elixir_gym.domain.service.ProgresoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
@AllArgsConstructor
public class ProgresoController {

    private final ProgresoService progresoService;

    @GetMapping("/todos")
    public ResponseEntity<List<ProgresoDto>> getAll() {
        return ResponseEntity.ok(progresoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgresoDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(progresoService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ProgresoDto> create(@RequestBody ProgresoDto progresoDto) {
        return new ResponseEntity<>(progresoService.save(progresoDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProgresoDto> update(@PathVariable long id,
                                              @Valid @RequestBody ActualizarProgresoDto progresoDto) {
        return ResponseEntity.ok(progresoService.update(id, progresoDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        progresoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
