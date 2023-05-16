package co.edu.ucentral.servicio.usuarios.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Page<Usuario> findAll(Pageable pageable);
    
}
