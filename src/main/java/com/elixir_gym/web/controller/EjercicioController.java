package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.updates.ActualizarEjercicioDto;
import com.elixir_gym.domain.dto.EjercicioDto;
import com.elixir_gym.domain.service.EjercicioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicio")
@AllArgsConstructor
public class EjercicioController {

    private final EjercicioService ejercicioService;

    @GetMapping("/todos")
    public ResponseEntity<List<EjercicioDto>> findAll() {
        return ResponseEntity.ok(ejercicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioDto> findById(@PathVariable long id) {
        return ejercicioService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<EjercicioDto> create(@RequestBody EjercicioDto ejercicioDto) {
        return new ResponseEntity<>(ejercicioService.save(ejercicioDto),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EjercicioDto> update(@PathVariable long id,
                                               @Valid
                                               @RequestBody ActualizarEjercicioDto actualizarEjercicioDto) {

        return ejercicioService.updateEjercicio(id, actualizarEjercicioDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        ejercicioService.deleteEjercicioById(id);
        return ResponseEntity.noContent().build();
    }
}
