package co.edu.ucentral.servicio.usuarios.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.usuarios.model.Usuario;
import co.edu.ucentral.servicio.usuarios.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    
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
        Optional<Usuario> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optional.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    public ResponseEntity<?> editar(@Valid @PathVariable Long id, @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }

        Optional<Usuario> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuarioBD = optional.get();
        usuarioBD.setPassword(usuario.getPassword());
        usuarioBD.setEnabled(usuario.getEnabled());
        usuarioBD.setNombre(usuario.getNombre());
        usuarioBD.setApellido(usuario.getApellido());
        usuarioBD.setEmail(usuario.getEmail());
        usuarioBD.setRoles(usuario.getRoles());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBD));
    }

    private ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }

}
