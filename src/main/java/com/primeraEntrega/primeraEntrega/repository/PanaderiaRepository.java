package com.primeraEntrega.primeraEntrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeraEntrega.primeraEntrega.model.Panaderia;
import java.util.List;

//interfaz con metodos comunes
@Repository
public interface PanaderiaRepository extends JpaRepository <Panaderia, Long> {
    List<Panaderia> findByNombre(String nombre);
}
