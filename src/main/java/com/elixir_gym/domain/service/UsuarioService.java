package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.dto.updates.ActualizarUsuarioDto;
import com.elixir_gym.domain.exception.CorreoExeption;
import com.elixir_gym.domain.exception.CorreoRegistradoException;
import com.elixir_gym.domain.exception.UsuarioInexistenteException;
import com.elixir_gym.domain.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioDto findById(long id) {
        return existenceChecker(id);
    }

    public UsuarioDto save(UsuarioDto usuarioDto) {

        if (usuarioRepository.findByEmail(usuarioDto.correo()).isPresent()) {
            throw new CorreoRegistradoException(usuarioDto.correo());
        }
        return usuarioRepository.save(usuarioDto);
    }

    public UsuarioDto update(long id, ActualizarUsuarioDto usuarioDto) {
        existenceChecker(id);

        return usuarioRepository.update(id, usuarioDto).orElseThrow(() -> new UsuarioInexistenteException(id));
    }

    public void deleteById(Long id) {
        existenceChecker(id);

        usuarioRepository.deleteById(id);
    }

    public UsuarioDto findByCorreo(String correo) {
        return usuarioRepository.findByEmail(correo)
                .orElseThrow(() -> new CorreoExeption(correo));
    }

    private UsuarioDto existenceChecker(long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioInexistenteException(id));
    }

}
