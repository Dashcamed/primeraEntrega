package com.primeraEntrega.primeraEntrega.model;


import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

// se genera la entidad se importa lombok para setters y getters
@Entity
@Data
public class Panaderia {
    //se generan las columnas con el generation type
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;

    // para que hibernate nos deje probar los metodos que les pasemos se hace una public panaderia() vacia !!muy importante
    public Panaderia() {
    }

    // se genera el constructor
    public Panaderia(Long id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //se genera la relacion que va a tener con las otras entidades. en este caso una panaderia puede tener muchos clientes y muchos productos
    @OneToMany(mappedBy = "panaderia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productos;

    @OneToMany(mappedBy = "panaderia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> clientes;

    // Getters y Setters
}