package com.danavas.campusbike.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danavas.campusbike.domain.models.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{

}
