package com.upiiz.ajax.services;

import com.upiiz.ajax.models.Carrera;
import com.upiiz.ajax.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    @Override
    public Optional<Carrera> getCarreraById(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public Carrera updateCarrera(Long id, Carrera carreraDetails) {
        Optional<Carrera> optionalCarrera = carreraRepository.findById(id);
        if (optionalCarrera.isPresent()) {
            Carrera carrera = optionalCarrera.get();
            carrera.setNombre(carreraDetails.getNombre());
            carrera.setSemestres(carreraDetails.getSemestres());
            carrera.setObservaciones(carreraDetails.getObservaciones());
            return carreraRepository.save(carrera);
        }
        return null;
    }

    @Override
    public void deleteCarrera(Long id) {
        carreraRepository.deleteById(id);
    }
}
