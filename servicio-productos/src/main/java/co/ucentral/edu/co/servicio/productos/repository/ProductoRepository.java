package co.ucentral.edu.co.servicio.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.common.producto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
