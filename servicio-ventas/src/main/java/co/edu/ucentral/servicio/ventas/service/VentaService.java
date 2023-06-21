package co.edu.ucentral.servicio.ventas.service;

import co.edu.ucentral.common.cliente.model.Cliente;
import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonService;
import co.edu.ucentral.servicio.ventas.model.Venta;

public interface VentaService extends CommonService<Venta> {

    public Iterable<Venta> findByCliente(Cliente cliente);
    public Iterable<Venta> findByClienteId(Long id);

    //Feign method.
    public Iterable<Producto> findProducto();
    
}
