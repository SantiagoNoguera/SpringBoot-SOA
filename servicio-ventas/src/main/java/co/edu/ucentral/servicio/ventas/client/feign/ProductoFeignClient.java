package co.edu.ucentral.servicio.ventas.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.ucentral.common.producto.model.Producto;

@FeignClient(name = "servicio-productos", url = "http://localhost:8002")
public interface ProductoFeignClient {

    @GetMapping("/")
    public Iterable<Producto> listar();
    
}
