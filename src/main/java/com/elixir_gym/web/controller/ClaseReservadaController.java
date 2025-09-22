package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;
import com.elixir_gym.domain.service.ClaseReservadaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clase-reservada")
@AllArgsConstructor
public class ClaseReservadaController {

    private final ClaseReservadaService claseReservadaService;

    @GetMapping("/todos")
    public ResponseEntity<List<ClaseReservadaDto>> getAll() {
        return ResponseEntity.ok(claseReservadaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseReservadaDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(claseReservadaService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ClaseReservadaDto> create(@RequestBody ClaseReservadaDto claseReservadaDto) {
        return new ResponseEntity<>(claseReservadaService.save(claseReservadaDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClaseReservadaDto> update(@PathVariable long id,
                                                    @Valid @RequestBody ActualizarClaseReservadaDto claseReservadaDto) {
        return ResponseEntity.ok(claseReservadaService.update(id, claseReservadaDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        claseReservadaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
