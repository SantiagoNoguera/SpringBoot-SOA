package co.edu.ucentral.servicio.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.servicio.ventas.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v WHERE v.producto.id = ?1")
    public List<Venta> findVentaByProductoId(Long id);
    
}
