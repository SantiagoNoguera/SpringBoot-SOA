package co.ucentral.edu.co.servicio.productos.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImpl;
import co.ucentral.edu.co.servicio.productos.model.Producto;
import co.ucentral.edu.co.servicio.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {
    
}