package com.danavas.campusbike.application.services;

import java.util.List;

import com.danavas.campusbike.domain.models.Bicicleta;

public interface BicicletaService {

    List<Bicicleta> findAll();

    Bicicleta save(Bicicleta bicicleta);

    Bicicleta update(Long id, Bicicleta bicicleta);

    void deleteById(Long id);
}
