package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ClaseReservadaDto;
import com.elixir_gym.domain.dto.updates.ActualizarClaseReservadaDto;
import com.elixir_gym.domain.exception.ClaseReservadaException;
import com.elixir_gym.persistence.repository.ClaseReservadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClaseReservadaService {

    private final ClaseReservadaRepository claseReservadaRepository;

    private final HorarioClaseService horarioClaseService;

    public List<ClaseReservadaDto> getAll() {
        return claseReservadaRepository.findAll();
    }

    public ClaseReservadaDto getById(long id) {
        return claseReservadaChecker(id);
    }

    public ClaseReservadaDto save(ClaseReservadaDto claseReservadaDto) {

        validarHorario(claseReservadaDto.horario().idHorario());

        return claseReservadaRepository.save(claseReservadaDto);
    }

    public ClaseReservadaDto update(long id, ActualizarClaseReservadaDto actualizarClaseReservadaDto) {

        validarHorario(actualizarClaseReservadaDto.horario().idHorario());

        return claseReservadaRepository.update(id, actualizarClaseReservadaDto)
                .orElseThrow(() -> new ClaseReservadaException(id));
    }

    public List<ClaseReservadaDto> findByUser(long idUser) {
        return claseReservadaRepository.findByUser(idUser);
    }

    public void deleteById(long id) {
        claseReservadaChecker(id);
        claseReservadaRepository.deleteById(id);
    }

    public ClaseReservadaDto claseReservadaChecker(long id) {
        return claseReservadaRepository.findById(id)
                .orElseThrow(() -> new ClaseReservadaException(id));
    }

    public void validarHorario(long idHorario) {
        horarioClaseService.getById(idHorario);
    }
}
