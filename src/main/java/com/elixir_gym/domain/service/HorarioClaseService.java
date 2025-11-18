package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.HorarioClaseDto;
import com.elixir_gym.domain.dto.UsuarioDto;
import com.elixir_gym.domain.dto.updates.ActualizarHorarioClaseDto;
import com.elixir_gym.domain.exception.HorarioClaseException;
import com.elixir_gym.domain.exception.NoEsEntrenadorException;
import com.elixir_gym.persistence.repository.HorarioClaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorarioClaseService {

    private final HorarioClaseRepository horarioClaseRepository;
    private final UsuarioService usuarioService;
    private final ClaseService claseService;

    public List<HorarioClaseDto> getAll() {
        return horarioClaseRepository.findAll();
    }

    public HorarioClaseDto getById(long id) {
        return horarioChecker(id);
    }

    public HorarioClaseDto create(HorarioClaseDto horarioClaseDto) {

        validarClase(horarioClaseDto.clase().idClase());
        validarEntrenador(horarioClaseDto.entrenador().idUsuario());

        HorarioClaseDto creado = horarioClaseRepository.save(horarioClaseDto);

        var claseCompleta = claseService.getById(creado.clase().idClase());
        var entrenador = usuarioService.findById(creado.entrenador().idUsuario());

        return new HorarioClaseDto(
                creado.idHorario(),
                creado.fecha(),
                creado.hora_inicio(),
                creado.hora_fin(),
                claseCompleta,
                entrenador
        );
    }

    public HorarioClaseDto update(long id, ActualizarHorarioClaseDto actualizarHorarioClaseDto) {

        validarClase(actualizarHorarioClaseDto.clase().idClase());
        validarEntrenador(actualizarHorarioClaseDto.entrenador().idUsuario());

        HorarioClaseDto actualizado = horarioClaseRepository.update(id, actualizarHorarioClaseDto).orElseThrow(() -> new HorarioClaseException(id));

        var claseCompleta = claseService.getById(actualizado.clase().idClase());
        var entrenador = usuarioService.findById(actualizado.entrenador().idUsuario());

        return new HorarioClaseDto(
                actualizado.idHorario(),
                actualizado.fecha(),
                actualizado.hora_inicio(),
                actualizado.hora_fin(),
                claseCompleta,
                entrenador
        );
    }

    public void deleteById(long id) {
        horarioChecker(id);
        horarioClaseRepository.deleteById(id);
    }


    public HorarioClaseDto horarioChecker(long id) {
        return horarioClaseRepository.findById(id)
                .orElseThrow(() -> new HorarioClaseException(id));
    }

    public void validarEntrenador(long idUsuario) {
        UsuarioDto entrenador = usuarioService.findById(idUsuario);

        if (entrenador == null) {
            throw new NoEsEntrenadorException(idUsuario);
        }

        boolean esEntrenador = entrenador.roles().stream()
                .anyMatch(role -> role.rol().equalsIgnoreCase("ENTRENADOR"));

        if (!esEntrenador) {
            throw new NoEsEntrenadorException(idUsuario);
        }
    }

    public void validarClase(long idClase) {
        claseService.getById(idClase);
    }
}
