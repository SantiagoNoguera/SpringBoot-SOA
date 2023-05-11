package co.edu.ucentral.servicio.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.ventas.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    public Iterable<Venta> findByCliente(Cliente cliente);
    
}
