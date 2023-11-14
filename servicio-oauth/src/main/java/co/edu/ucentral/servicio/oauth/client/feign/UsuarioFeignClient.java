package co.edu.ucentral.servicio.oauth.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.common.usuario.model.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {
    
    @GetMapping("/buscar-username")
    public Usuario buscarPorUsername(@RequestParam("username") String username);

}
