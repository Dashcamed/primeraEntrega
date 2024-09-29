package com.primeraEntrega.primeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeraEntrega.primeraEntrega.model.Panaderia;
import com.primeraEntrega.primeraEntrega.repository.PanaderiaRepository;
import java.util.List;
import java.util.Optional;

//se importa el service
@Service
public class PanaderiaService {
    // se importa el autowired para hacer referencia al repository
    @Autowired
    private PanaderiaRepository panaderiaRepository;
    // trae todas las panaderias
    public List<Panaderia> getAllPanaderias(){
        return panaderiaRepository.findAll();
    }
    // trae una panaderia por id
    public Optional<Panaderia> getPanaderiaById(Long id){
        return panaderiaRepository.findById(id);
    }
    // guarda una panaderia o sucursal
    public Panaderia savePanaderia(Panaderia panaderia){
        return panaderiaRepository.save(panaderia);
    }
    // borra una panaderia con validacion
    public void deletePanaderia(Long id){
        if (panaderiaRepository.existsById(id)){
            panaderiaRepository.deleteById(id);
        } else {
            System.out.println("La panaderia no existe");
        }
    }

    public List<Panaderia> findPanaderiaByNombre(String nombre){
        return panaderiaRepository.findByNombre(nombre);
    }
}
