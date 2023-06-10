package co.ucentral.edu.co.servicio.productos.service;

import java.util.List;
import java.util.Optional;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonService;

public interface ProductoService extends CommonService<Producto> {

    public List<Producto> findByNombre(String nombre);
    public List<Producto> findByPrecioAndCantidadOrderByIdDesc(Float precio, Integer cantidad);
    public List<Producto> findByPrecioBetween(Float precioIni, Float precioFin);
    public List<Producto> findByNombreIn(String[] nombre);
    public Producto findByNombreQuery(String nombre);
    public List<Producto> findByNombreLike(String nombre);
    public List<Producto> findAllNative();
    public Optional<Producto> findByIdNative(Long id);

}
