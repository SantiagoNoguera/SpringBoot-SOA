package co.ucentral.edu.co.servicio.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.producto.model"})
@EnableDiscoveryClient
public class ServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProductosApplication.class, args);
	}

}
