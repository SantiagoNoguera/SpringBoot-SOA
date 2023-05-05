package co.edu.ucentral.servicio.ventas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.ventas.model.Cliente;
import co.edu.ucentral.servicio.ventas.model.Venta;
import co.edu.ucentral.servicio.ventas.service.ClienteService;
import co.edu.ucentral.servicio.ventas.service.VentaService;

@RestController
public class VentaController {

    @Autowired
    private VentaService service;

    @Autowired
    private ClienteService serviceCliente;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(venta));
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> buscarPorProductoId(@PathVariable Long id) {
        List<Venta> lista = service.findVentaByProductoId(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> buscarPorClienteId(@PathVariable Long id) {
        Optional<Cliente> optional = serviceCliente.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> modificar(@RequestBody Cliente cliente, @PathVariable Long id) {
        Optional<Cliente> optional = serviceCliente.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cliente clienteBD = optional.get();
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setDireccion(cliente.getDireccion());
        List<Venta> eliminados = new ArrayList<Venta>();

        clienteBD.getVentas().forEach(venta -> {
            if (!cliente.getVentas().contains(venta)) {
                eliminados.add(venta);
            }
        });

        eliminados.forEach(venta -> {
            clienteBD.removeVenta(venta);
        });

        clienteBD.setVentas(cliente.getVentas());

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCliente.save(clienteBD));
    }
    
}
