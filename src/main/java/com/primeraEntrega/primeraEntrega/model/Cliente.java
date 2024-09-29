package com.primeraEntrega.primeraEntrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

// se genera la entidad se importa lombok para setters y getters
@Entity
@Data
public class Cliente {

    //se generan las columnas con el generation type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;

    // para que hibernate nos deje probar los metodos que les pasemos se hace una public client() vacia !!muy importante
    public Cliente() {
    }

    // se genera el constructor
    public Cliente(Long id, String nombre, String correo, String telefono, Panaderia panaderia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.panaderia = panaderia;
    }

    // se asigna la relacion y el join en este caso esta diseñado para que sean muchos clientes a una sola panaderia
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "panaderia_id")
    private Panaderia panaderia;


}
