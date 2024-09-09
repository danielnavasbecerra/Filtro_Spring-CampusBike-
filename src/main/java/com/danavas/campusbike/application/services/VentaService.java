package com.danavas.campusbike.application.services;

import java.util.List;

import com.danavas.campusbike.domain.models.Venta;

public interface VentaService {

    List<Venta> findAll();

    Venta save(Venta venta);

    Venta update(Long id, Venta venta);

    void deleteById(Long id);
}
