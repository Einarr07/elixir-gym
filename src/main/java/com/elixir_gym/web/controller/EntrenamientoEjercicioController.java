package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.EntrenamientoEjercicioDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarEntrenamientoEjercicioDto;
import com.elixir_gym.domain.exception.EjercicioInexistenteException;
import com.elixir_gym.domain.exception.EntrenamientoInexistenteException;
import com.elixir_gym.domain.service.EjercicioService;
import com.elixir_gym.domain.service.EntrenamientoEjercicioService;
import com.elixir_gym.domain.service.EntrenamientoService;
import com.elixir_gym.persistence.entity.ids.EntrenamientoEjercicioId;
import com.elixir_gym.persistence.repository.EjercicioRepository;
import com.elixir_gym.persistence.repository.EntrenamientoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenamiento-ejercicio")
@AllArgsConstructor
public class EntrenamientoEjercicioController {

    private final EntrenamientoEjercicioService entrenamientoEjercicioService;


    @GetMapping
    public ResponseEntity<List<EntrenamientoEjercicioDto>> getAll() {
        return ResponseEntity.ok(entrenamientoEjercicioService.findAll());
    }

    @GetMapping("/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<EntrenamientoEjercicioDto> findById(@PathVariable long idEntrenamiento,
                                                              @PathVariable long idEjercicio) {
        return ResponseEntity.ok(entrenamientoEjercicioService.findById(idEntrenamiento, idEjercicio));
    }

    @PostMapping("/crear")
    public ResponseEntity<EntrenamientoEjercicioDto> create(@RequestBody EntrenamientoEjercicioDto entrenamientoDto) {
        return ResponseEntity.ok(entrenamientoEjercicioService.save(entrenamientoDto));
    }

    @PutMapping("/actualizar/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<EntrenamientoEjercicioDto> update(
            @PathVariable long idEntrenamiento,
            @PathVariable long idEjercicio,
            @Valid @RequestBody ActualizarEntrenamientoEjercicioDto entrenamientoEjercicioDto
            ){
        return ResponseEntity.ok(entrenamientoEjercicioService
                .updateEntrenamientoEjericio(idEntrenamiento, idEjercicio, entrenamientoEjercicioDto));
    }

    @DeleteMapping("/eliminar/{idEntrenamiento}/{idEjercicio}")
    public ResponseEntity<Void> deleteById(
            @PathVariable long idEntrenamiento,
            @PathVariable long idEjercicio
            ){
        entrenamientoEjercicioService.deleteById(idEntrenamiento, idEjercicio);
        return ResponseEntity.noContent().build();
    }
}
