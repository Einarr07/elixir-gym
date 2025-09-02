package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EquipoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEquipoDto;
import com.elixir_gym.domain.service.EquipoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipo")
@AllArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping("/todos")
    public ResponseEntity<List<EquipoDto>> getAllEquipos(){
        return ResponseEntity.ok(equipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDto> getEquipoById(@PathVariable long id){
        return ResponseEntity.ok(equipoService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<EquipoDto> createEquipo(@RequestBody EquipoDto equipoDto){
        return new ResponseEntity<>(equipoService.save(equipoDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EquipoDto> updateEquipo(
            @PathVariable long id,
            @Valid @RequestBody ActualizarEquipoDto equipoDto){
        return ResponseEntity.ok(equipoService.update(id, equipoDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable long id){
        equipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
