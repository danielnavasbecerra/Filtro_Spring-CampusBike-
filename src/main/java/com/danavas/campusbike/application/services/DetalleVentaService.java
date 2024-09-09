package com.danavas.campusbike.application.services;

import java.util.List;

import com.danavas.campusbike.domain.models.DetalleVenta;

public interface DetalleVentaService {

    List<DetalleVenta> findAll();

    DetalleVenta save(DetalleVenta detalleVenta);

    DetalleVenta update(Long id, DetalleVenta detalleVenta);

    void deleteById(Long id);
}
