package com.danavas.campusbike.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danavas.campusbike.application.services.BicicletaService;
import com.danavas.campusbike.domain.models.Bicicleta;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bicicleta")
@RequiredArgsConstructor
public class BicicletaController {
    @Autowired
    private BicicletaService bicicletaService;

    @GetMapping
    public ResponseEntity<List<Bicicleta>> findAll() {
        List<Bicicleta> bicicletas = bicicletaService.findAll();
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bicicleta> createBicycle(@RequestBody Bicicleta bicicleta) {
        Bicicleta newBicycle = bicicletaService.save(bicicleta);
        return new ResponseEntity<>(newBicycle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> updateBicycle(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
        Bicicleta updatedBicycle = bicicletaService.update(id, bicicleta);
        if (updatedBicycle != null) {
            return new ResponseEntity<>(updatedBicycle, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBicycle(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
