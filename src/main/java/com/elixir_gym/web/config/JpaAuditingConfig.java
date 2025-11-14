package com.elixir_gym.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {

        // Lógica para obtener el usuario actual desde Spring Security
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // Comprobar si hay un usuario autenticado
            if (authentication == null ||
                    !authentication.isAuthenticated() ||
                    authentication.getPrincipal().equals("anonymousUser")) {

                // Si no hay nadie (ej. un proceso de sistema o al crear los primeros datos)
                return Optional.of("SISTEMA");
            }

            // Devuelve el 'username' (o email, o lo que uses como identificador)
            return Optional.of(authentication.getName());
        };
    }
}
