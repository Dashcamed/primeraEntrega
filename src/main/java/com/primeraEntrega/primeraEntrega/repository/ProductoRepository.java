package com.primeraEntrega.primeraEntrega.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeraEntrega.primeraEntrega.model.Producto;

//interfaz con metodos comunes
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPanaderiaId(Long panaderiaId);
}
