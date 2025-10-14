package com.elixir_gym.web.controller;

import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @GetMapping("/me")
    public ResponseEntity<UsuarioDto> me(Authentication authentication) {
        String correo = authentication.getName();
        UsuarioDto dto = usuarioService.findByCorreo(correo);
        return ResponseEntity.ok(dto);
    }
}
