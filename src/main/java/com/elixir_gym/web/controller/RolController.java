package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.RolDto;
import com.elixir_gym.domain.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rol")
@AllArgsConstructor
public class RolController {

    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDto>> findAll() {
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDto> findById(@PathVariable Long id) {
        return rolService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
