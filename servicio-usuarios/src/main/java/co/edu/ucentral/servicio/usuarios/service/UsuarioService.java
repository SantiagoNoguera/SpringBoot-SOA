package co.edu.ucentral.servicio.usuarios.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.ucentral.common.usuario.model.Usuario;

public interface UsuarioService {

    public Iterable<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);
    public Optional<Usuario> findById(Long id);
    public Usuario save(Usuario usuario);
    public void deleteById(Long id);
    
}
