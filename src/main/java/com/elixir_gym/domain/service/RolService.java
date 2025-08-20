package com.elixir_gym.domain.service;

import com.elixir_gym.domain.dto.RolDto;
import com.elixir_gym.domain.repository.IRolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolService {

    private final IRolRepository rolRepository;

    public List<RolDto>  findAll() {
        return rolRepository.findAll();
    }

    public Optional<RolDto> findById(Long id) {
        return rolRepository.findById(id);
    }

}
