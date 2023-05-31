package co.ucentral.edu.co.servicio.productos.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.controller.CommonController;
import co.ucentral.edu.co.servicio.productos.service.ProductoService;
import jakarta.validation.Valid;

@Controller
public class ProductoController extends CommonController<Producto, ProductoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @Valid @RequestBody Producto producto, BindingResult result) {
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
        productoBD.setEspecificacion(producto.getEspecificacion());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoBD));
    }

    @PostMapping("/crear-con-imagen")
    public ResponseEntity<?> crearConImagen(@Valid Producto producto, @RequestParam MultipartFile archivo, BindingResult result) throws IOException {
        if (!archivo.isEmpty()) {
            producto.setImagen(archivo.getBytes());
        }

        return crear(producto, result);
    }

    @PutMapping("/editar-con-imagen/{id}")
    public ResponseEntity<?> editarConImagen(@PathVariable Long id, Producto producto, @RequestParam MultipartFile archivo) throws IOException {
        Optional<Producto> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Producto productoBD = optional.get();

        productoBD.setNombre(producto.getNombre());
        productoBD.setCantidad(producto.getCantidad());
        productoBD.setPrecio(producto.getPrecio());
        productoBD.setEspecificacion(producto.getEspecificacion());

        if (!archivo.isEmpty()) {
            productoBD.setImagen(archivo.getBytes());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoBD));
    }

    @GetMapping("/download/img/{id}")
    public ResponseEntity<?> verImagen(@PathVariable Long id) {
        Optional<Producto> optional = service.findById(id);

        if (!optional.isPresent() || optional.get().getImagen() == null) {
            return ResponseEntity.notFound().build();
        }

        Resource img = new ByteArrayResource(optional.get().getImagen());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok().body(service.findByNombre(nombre));
    }

    @GetMapping("/precio-cantidad")
    public ResponseEntity<?> buscarPorPrecioYCantidad(@RequestParam Float precio, @RequestParam Integer cantidad) {
        return ResponseEntity.ok().body(service.findByPrecioAndCantidadOrderByIdDesc(precio, cantidad));
    }

    @GetMapping("/precio-entre")
    public ResponseEntity<?> buscarPorPrecioEntre(@RequestParam Float precioIni, @RequestParam Float precioFin) {
        return ResponseEntity.ok().body(service.findByPrecioBetween(precioIni, precioFin));
    }

    @GetMapping("/nombre-en")
    public ResponseEntity<?> buscarPorNombreEn(@RequestParam String[] nombre) {
        return ResponseEntity.ok().body(service.findByNombreIn(nombre));
    }

    @GetMapping("/nombre-query")
    public ResponseEntity<?> buscarPorNombreQuery(@RequestParam String nombre) {
        return ResponseEntity.ok().body(service.findByNombreQuery(nombre));
    }

    @GetMapping("/nombre-like")
    public ResponseEntity<?> buscarPorNombreLike(@RequestParam String nombre) {
        return ResponseEntity.ok().body(service.findByNombreLike(nombre));
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<?> buscarPorIdNative(@PathVariable Long id) {
        Optional<Producto> optional = service.findByIdNative(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());
    }

    private ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }

}