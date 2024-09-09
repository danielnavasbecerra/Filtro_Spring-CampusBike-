package com.danavas.campusbike.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danavas.campusbike.application.services.BicicletaService;
import com.danavas.campusbike.domain.models.Bicicleta;
import com.danavas.campusbike.infrastructure.repositories.BicicletaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BicicletaAdapter implements BicicletaService {
    @Autowired
    private BicicletaRepository bicicletaRepository;

    @Override
    public List<Bicicleta> findAll() {
        return bicicletaRepository.findAll();
    }

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    @Override
    public Bicicleta update(Long id, Bicicleta bicicleta) {
        return bicicletaRepository.findById(id).map(existingBicycle -> {
            existingBicycle.setMarca(bicicleta.getMarca());
            existingBicycle.setModelo(bicicleta.getModelo());
            existingBicycle.setPrecio(bicicleta.getPrecio());
            existingBicycle.setStock(bicicleta.getStock());

            return bicicletaRepository.save(existingBicycle);
        }).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        bicicletaRepository.deleteById(id);
    }

}
