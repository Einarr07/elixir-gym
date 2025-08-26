package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.ActualizarGrupoMuscularDto;
import com.elixir_gym.domain.dto.GrupoMuscularDto;
import com.elixir_gym.persistence.repository.GrupoMuscularRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo-muscular")
@AllArgsConstructor
public class GrupoMuscularController {

    private final GrupoMuscularRepository grupoMuscularRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<GrupoMuscularDto>> findAll() {
        return ResponseEntity.ok(grupoMuscularRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoMuscularDto> findById(@PathVariable long id) {
        return grupoMuscularRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<GrupoMuscularDto> create(@RequestBody GrupoMuscularDto grupoMuscularDto) {
        return new ResponseEntity<>(grupoMuscularRepository.save(grupoMuscularDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<GrupoMuscularDto> updateGrupoMuscular(@PathVariable long id,
                                                                @Valid
                                                                @RequestBody ActualizarGrupoMuscularDto actualizarGrupoMuscularDto) {

        return grupoMuscularRepository.update(id, actualizarGrupoMuscularDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteGrupoMuscular(@PathVariable long id) {
        grupoMuscularRepository.delteById(id);
        return ResponseEntity.noContent().build();
    }
}
