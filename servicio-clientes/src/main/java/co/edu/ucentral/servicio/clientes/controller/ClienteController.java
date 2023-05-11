package co.edu.ucentral.servicio.clientes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.common.cliente.model.Cliente;
import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.servicio.clientes.service.ClienteService;

@RestController
public class ClienteController extends CommonController<Cliente, ClienteService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> optional = service.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Cliente clienteBD = optional.get();
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setDireccion(cliente.getDireccion());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteBD));
    }

}
