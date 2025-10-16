package com.elixir_gym.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) //
                .authorizeHttpRequests(auth -> auth
                        // Enpoints publicos
                        .requestMatchers("/api/auth/me").hasAnyRole("CLIENTE", "ADMIN")

                        // Usuarios
                        .requestMatchers("/api/usuario/todos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/usuario/crear").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuario/eliminar/*").hasRole("ADMIN")

                        // Cliente
                        .requestMatchers(HttpMethod.GET, "/api/usuario/*").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/usuario/actualizar/*").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/horario-clase/todos").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/horario-clase/*").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/clase/**").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/clase-reservada/crear").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/clase-reservada/mis-reservas/*").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/clase-reservada/actualizar/*").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers("/api/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .httpBasic(basic -> {
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
