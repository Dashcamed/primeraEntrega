package com.primeraEntrega.primeraEntrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.primeraEntrega.primeraEntrega.model.Cliente;
import java.util.List;

//interfaz con metodos comunes

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByPanaderiaId(Long panaderiaId);
    List<Cliente> findByNombre(String nombre);

}
