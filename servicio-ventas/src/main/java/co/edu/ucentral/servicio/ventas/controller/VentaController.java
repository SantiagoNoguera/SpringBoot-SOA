package co.edu.ucentral.servicio.ventas.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.common.cliente.model.Cliente;
import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.servicio.ventas.model.Venta;
import co.edu.ucentral.servicio.ventas.service.VentaService;

@RestController
public class VentaController extends CommonController<Venta, VentaService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Venta venta) {
        Optional<Venta> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Venta ventaBD = optional.get();
        ventaBD.setCantidad(venta.getCantidad());
        ventaBD.setCliente(venta.getCliente());
        ventaBD.setProducto(venta.getProducto());
        ventaBD.setValor(venta.getProducto().getPrecio());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaBD));
    }

    @GetMapping("/cliente")
    public ResponseEntity<?> listarVentasCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(service.findByCliente(cliente));
    }
    
}
