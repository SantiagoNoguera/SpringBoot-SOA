package co.ucentral.edu.co.servicio.productos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonServiceImpl;
import co.ucentral.edu.co.servicio.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioAndCantidadOrderByIdDesc(Float precio, Integer cantidad) {
        return repository.findByPrecioAndCantidadOrderByIdDesc(precio, cantidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetween(Float precioIni, Float precioFin) {
        return repository.findByPrecioBetween(precioIni, precioFin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombreIn(String[] nombre) {
        return repository.findByNombreIn(nombre);
    }
    
}