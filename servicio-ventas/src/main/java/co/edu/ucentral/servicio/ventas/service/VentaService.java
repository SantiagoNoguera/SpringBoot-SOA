package co.edu.ucentral.servicio.ventas.service;

import java.util.List;

import co.edu.ucentral.servicio.ventas.model.Venta;

public interface VentaService {

    public Iterable<Venta> findAll();
    public List<Venta> findVentaByProductoId(Long id);
    public Venta save(Venta venta);
    
}
