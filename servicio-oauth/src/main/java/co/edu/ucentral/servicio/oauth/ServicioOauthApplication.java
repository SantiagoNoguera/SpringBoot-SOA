package co.edu.ucentral.servicio.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServicioOauthApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ServicioOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		String passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);

		password = "67890";
		passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);

		password = "09876";
		passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);

		password = "54321";
		passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
	}

}
