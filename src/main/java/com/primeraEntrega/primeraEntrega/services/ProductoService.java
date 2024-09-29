package com.primeraEntrega.primeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeraEntrega.primeraEntrega.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import com.primeraEntrega.primeraEntrega.model.Producto;

//se importa el service
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    // trae todos los productos
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    //trae un porducto por id
    public Optional<Producto> getProductoById(Long id){
        return productoRepository.findById(id);
    }
    // trae un producto por id de panaderia
    public List<Producto> getProductosByPanaderiaId(Long panaderiaId) {
        return productoRepository.findByPanaderiaId(panaderiaId);
    }
    // guarda un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    // borra un producto
    public void deleteProducto(Long id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        } else {
            System.out.println("el producto no existe");
        }
    }
    //modifica el stock de un producto
    public void updateStockProducto(Long productoId, int nuevoStock){

        Optional<Producto> productoOpt = productoRepository.findById(productoId);

        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            int stockActual = producto.getStock();
            producto.setStock(stockActual + nuevoStock);
            productoRepository.save(producto);
        } else {
            // Manejar el caso donde no se encontró el producto
            throw new RuntimeException("Producto no encontrado con id: " + productoId);
        }
    }
}
