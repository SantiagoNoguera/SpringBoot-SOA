package co.ucentral.edu.co.servicio.productos.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.ucentral.edu.co.servicio.productos.model.Producto;
import co.ucentral.edu.co.servicio.productos.service.ProductoService;
import jakarta.validation.Valid;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/pagina")
    public ResponseEntity<?> listar(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
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
    public ResponseEntity<?> crear(@Valid @RequestBody Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @PathVariable Long id, @RequestBody Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }

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

    private ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }

}
