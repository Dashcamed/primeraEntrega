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
public class Producto {
    //se generan las columnas con el generation type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private Double precio;
    private int stock;
    private String categoria;

    // para que hibernate nos deje probar los metodos que les pasemos se hace una public panaderia() vacia !!muy importante
    public Producto() {
    }

    // se genera el constructor
    public Producto(Long id, String nombre, Double precio, int stock, String categoria, Panaderia panaderia) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.panaderia = panaderia;
    }

    // se genera la relacion en este caso muchos productos pertenecen a una panaderia y el join para unir a la panaderia
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "panaderia_id")
    private Panaderia panaderia;

}
