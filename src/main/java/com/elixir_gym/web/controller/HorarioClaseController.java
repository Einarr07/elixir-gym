package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;
import com.elixir_gym.domain.service.HorarioClaseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/horario-clase")
@AllArgsConstructor
public class HorarioClaseController {

    private HorarioClaseService horarioClaseService;

    @GetMapping("/todos")
    public ResponseEntity<List<HorarioClaseDto>> getAll(){
        return ResponseEntity.ok(horarioClaseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioClaseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(horarioClaseService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<HorarioClaseDto> create(@RequestBody HorarioClaseDto horarioClaseDto){
        return new ResponseEntity<>(horarioClaseService.create(horarioClaseDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HorarioClaseDto> update(
            @PathVariable long id,
            @Valid @RequestBody ActualizarHorarioClaseDto actualizarHorarioClaseDto
            ){
        return ResponseEntity.ok(horarioClaseService.update(id, actualizarHorarioClaseDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        horarioClaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
