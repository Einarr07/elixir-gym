package com.elixir_gym.domain.service;

import com.elixir_gym.persistence.crud.ICrudUsuarioEntity;
import com.elixir_gym.persistence.entity.RolEntity;
import com.elixir_gym.persistence.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final ICrudUsuarioEntity crudUsuarioEntity;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioEntity usuario = crudUsuarioEntity.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email " + email));

        String[] rolesArray = usuario.getRoles()
                .stream()
                .map(RolEntity::getNombreRol)
                .toArray(String[]::new);

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(rolesArray)
                .build();
    }

}
