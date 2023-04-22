package co.ucentral.edu.co.servicio.productos.service;

import java.util.Optional;

import co.ucentral.edu.co.servicio.productos.model.Producto;

public interface ProductoService {
    
    public Iterable<Producto> findAll();
    public Optional<Producto> findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);

}
