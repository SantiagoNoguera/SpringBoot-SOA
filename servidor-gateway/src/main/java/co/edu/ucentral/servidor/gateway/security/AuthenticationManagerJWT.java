package co.edu.ucentral.servidor.gateway.security;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManagerJWT implements ReactiveAuthenticationManager {

    @SuppressWarnings("unchecked")
    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication.getCredentials().toString())
                .map(token -> {
                    //El Código de acceso a la aplicación se encripta en Base64, en el archivo AutorizationServerConfig.java del servicio-oauth se hace lo mismo.
                    SecretKey key = Keys.hmacShaKeyFor(Base64.getEncoder().encode("codigo_secreto_12345".getBytes()));

                    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
                })
                .map(claims -> {
                    String username = claims.get("user_name", String.class);
                    List<String> roles = claims.get("authorities", List.class);
                    Collection<GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                    return new UsernamePasswordAuthenticationToken(username, null, authorities);
                });
    }
    
}
