package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.HistorialEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarHistorialEntrenamientoDto;
import com.elixir_gym.domain.service.HistorialEntrenemaientoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/historial-entrenameinto")
@AllArgsConstructor
public class HistorialEntrenamientoController {

    private final HistorialEntrenemaientoService historialService;

    @GetMapping("/todos")
    public ResponseEntity<List<HistorialEntrenamientoDto>> getHistorialEntrenamientos(){
        return ResponseEntity.ok(historialService.getAllHistorialEntrenamiento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialEntrenamientoDto>  getHistorialEntrenamientoById(@PathVariable long id){
        return ResponseEntity.ok(historialService.getById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<HistorialEntrenamientoDto> createHistorial(@RequestBody HistorialEntrenamientoDto historialEntrenamientoDto){
        return new ResponseEntity<>(historialService.save(historialEntrenamientoDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistorialEntrenamientoDto> updateHistorial(
            @PathVariable long id,
            @Valid @RequestBody ActualizarHistorialEntrenamientoDto actualizarHistorialDto){

        return ResponseEntity.ok(historialService.update(id, actualizarHistorialDto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteHistorialById(@PathVariable long id){
        historialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
