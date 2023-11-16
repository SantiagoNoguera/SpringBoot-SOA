package co.edu.ucentral.servidor.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        // Accesos permitidos de los usuarios según los roles asignados.
        return http.authorizeExchange()
                .pathMatchers("/api/security/oauth/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/productos", "/api/usuarios", "/api/productos/{id}").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/usuarios/{id}").hasAnyRole("ADMIN", "USER")
                .pathMatchers("/api/productos/**", "/api/usuarios/**").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().csrf().disable()
                .build();
    }

}
