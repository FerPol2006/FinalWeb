package com.upiiz.ajax.services;

import com.upiiz.ajax.models.Aspirante;
import com.upiiz.ajax.repositories.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspiranteServiceImpl implements AspiranteService {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    public List<Aspirante> getAllAspirantes() {
        return aspiranteRepository.findAll();
    }

    @Override
    public Optional<Aspirante> getAspiranteById(Long id) {
        return aspiranteRepository.findById(id);
    }

    @Override
    public Aspirante saveAspirante(Aspirante aspirante) {
        return aspiranteRepository.save(aspirante);
    }

    @Override
    public void deleteAspirante(Long id) {
        aspiranteRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return aspiranteRepository.existsByEmail(email);
    }
}
