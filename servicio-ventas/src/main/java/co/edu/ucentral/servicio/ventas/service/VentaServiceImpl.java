package co.edu.ucentral.servicio.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.cliente.model.Cliente;
import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonServiceImpl;
import co.edu.ucentral.servicio.ventas.client.feign.ProductoFeignClient;
import co.edu.ucentral.servicio.ventas.model.Venta;
import co.edu.ucentral.servicio.ventas.repository.VentaRepository;

@Service
public class VentaServiceImpl extends CommonServiceImpl<Venta, VentaRepository> implements VentaService {

    @Autowired
    private ProductoFeignClient productoFeign;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Venta> findByCliente(Cliente cliente) {
        return repository.findByCliente(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Venta> findByClienteId(Long id) {
        return repository.findByClienteId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> findProducto() {
        return productoFeign.listar();
    }
    
}
