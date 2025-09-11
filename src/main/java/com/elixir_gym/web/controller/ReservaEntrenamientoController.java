package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;
import com.elixir_gym.domain.service.ReservaEntrenamientoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reserva-entrenamientos")
@AllArgsConstructor
public class ReservaEntrenamientoController {

    private final ReservaEntrenamientoService reservaService;

    @GetMapping("/todos")
    public ResponseEntity<List<ReservaEntrenamientoDto>> getAll() {
        return ResponseEntity.ok(reservaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntrenamientoDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(reservaService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaEntrenamientoDto> create(@RequestBody ReservaEntrenamientoDto dto) {
        return new ResponseEntity<>(reservaService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaEntrenamientoDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarReservaEntrenamientoDto dto) {

        return ResponseEntity.ok(reservaService.update(id, dto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
