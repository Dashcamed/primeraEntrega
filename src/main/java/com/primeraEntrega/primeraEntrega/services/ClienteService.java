package com.primeraEntrega.primeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeraEntrega.primeraEntrega.model.Cliente;
import com.primeraEntrega.primeraEntrega.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;

//se importa el service
@Service
public class ClienteService {
    // se importa el autowired para hacer referencia al repository
    @Autowired
    private ClienteRepository clienteRepository;

    //traer todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    // buscar cliente por id
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
    // buscar clientes por id de panaderia panaderia
    public List<Cliente> getClientesByPanaderiaId(Long panaderiaId) {
        return clienteRepository.findByPanaderiaId(panaderiaId);
    }
    // guardar clientes
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    //borrar cliente con validacion
    public void deleteCliente(Long id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            System.out.println("el cliente no existe");
        }
    }

    public List<Cliente> findClienteByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
