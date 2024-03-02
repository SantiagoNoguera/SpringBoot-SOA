package co.edu.ucentral.servicio.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.producto.model", "co.edu.ucentral.common.cliente.model", "co.edu.ucentral.common.venta.model"})
@EnableFeignClients
@EnableDiscoveryClient
public class ServicioVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVentasApplication.class, args);
	}

}
