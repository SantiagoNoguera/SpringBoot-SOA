package co.ucentral.edu.co.servicio.productos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.ucentral.edu.co.servicio.productos.model.Producto;
import co.ucentral.edu.co.servicio.productos.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Producto> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Producto productoBD = optional.get();

        productoBD.setNombre(producto.getNombre());
        productoBD.setCantidad(producto.getCantidad());
        productoBD.setPrecio(producto.getPrecio());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoBD));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
