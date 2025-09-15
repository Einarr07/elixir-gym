package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.ReservaEntrenamientoDto;
import com.elixir_gym.domain.dto.updates.ActualizarReservaEntrenamientoDto;
import com.elixir_gym.domain.exception.ReservaEntrenamientoException;
import com.elixir_gym.persistence.repository.ReservaEntrenamientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservaEntrenamientoService {

    private final ReservaEntrenamientoRepository reservaEntrenamientoRepository;

    public List<ReservaEntrenamientoDto> getAll(){
        return reservaEntrenamientoRepository.findAll();
    }

    public ReservaEntrenamientoDto getById(long id){
        return reservaChecker(id);
    }

    public ReservaEntrenamientoDto save(ReservaEntrenamientoDto reservaEntrenamientoDto){
        return reservaEntrenamientoRepository.save(reservaEntrenamientoDto);
    }

    public ReservaEntrenamientoDto update(long id, ActualizarReservaEntrenamientoDto actualizarReservaDto){
        return reservaEntrenamientoRepository.update(id, actualizarReservaDto)
                .orElseThrow(() -> new  ReservaEntrenamientoException(id));
    }

    public void deleteById(long id){
        reservaEntrenamientoRepository.deleteById(id);
    }

    public ReservaEntrenamientoDto reservaChecker(long id) {
        return reservaEntrenamientoRepository.findById(id)
                .orElseThrow(() -> new ReservaEntrenamientoException(id));
    }
}
