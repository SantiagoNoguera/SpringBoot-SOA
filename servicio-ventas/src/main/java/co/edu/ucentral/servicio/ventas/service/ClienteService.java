package co.edu.ucentral.servicio.ventas.service;

import java.util.Optional;

import co.edu.ucentral.servicio.ventas.model.Cliente;

public interface ClienteService {

    public Iterable<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public Cliente save(Cliente cliente);
    public void deleteById(Long id);
    
}
