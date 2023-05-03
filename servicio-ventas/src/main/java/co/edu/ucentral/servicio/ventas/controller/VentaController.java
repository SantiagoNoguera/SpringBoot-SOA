package co.edu.ucentral.servicio.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.ventas.model.Venta;
import co.edu.ucentral.servicio.ventas.service.VentaService;

@RestController
public class VentaController {

    @Autowired
    private VentaService service;

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
    
}
