package br.com.cazzine.fleet_api;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FleetApiApplication {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Fleet Management API")
						.version("1.0")
						.description("API REST para gestão de frota de veículos corporativos. Construída com Spring Boot."));
	}

	public static void main(String[] args) {
		SpringApplication.run(FleetApiApplication.class, args);
	}



}
