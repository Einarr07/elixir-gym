package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseDto;
import com.elixir_gym.domain.service.ClaseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clase")
@AllArgsConstructor
public class ClaseController {

    private final ClaseService claseService;

    @GetMapping("/todos")
    public ResponseEntity<List<ClaseDto>> getAll() {
        return ResponseEntity.ok(claseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(claseService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ClaseDto> create(@RequestBody ClaseDto claseDto) {
        return new ResponseEntity<>(claseService.save(claseDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ClaseDto> update(@PathVariable long id,
                                           @Valid @RequestBody ActualizarClaseDto actualizarClaseDto){
        return ResponseEntity.ok(claseService.updateClase(id, actualizarClaseDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        claseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
