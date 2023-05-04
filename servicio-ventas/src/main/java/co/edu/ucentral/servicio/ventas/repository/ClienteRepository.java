package co.edu.ucentral.servicio.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.ventas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
