package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ClaseDto;
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

        return horarioClaseRepository.save(horarioClaseDto);
    }

    public HorarioClaseDto update(long id, ActualizarHorarioClaseDto actualizarHorarioClaseDto) {

        validarClase(actualizarHorarioClaseDto.clase().idClase());
        validarEntrenador(actualizarHorarioClaseDto.entrenador().idUsuario());

        return horarioClaseRepository.update(id, actualizarHorarioClaseDto)
                .orElseThrow(() -> new HorarioClaseException(id));
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
        UsuarioDto entrenador = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new NoEsEntrenadorException(idUsuario));

        boolean esEntrenador = entrenador.roles().stream()
                .anyMatch(role -> role.rol().equalsIgnoreCase("ENTRENADOR"));

        if (!esEntrenador) {
            throw new NoEsEntrenadorException(idUsuario);
        }
    }

    public void validarClase(long idClase){
        claseService.getById(idClase);
    }
}
