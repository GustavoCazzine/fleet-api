package br.com.cazzine.fleet_api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // Define o nome do nosso esquema de segurança
        String securitySchemeName = "basicAuth";

        return new OpenAPI()
                .info(new Info().title("Fleet API").version("1.0").description("API de gerenciamento de frotas"))

                // Avisa ao Swagger que a API inteira exige esse esquema de segurança
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))

                // Ensina ao Swagger COMO é esse esquema (HTTP Basic Auth -> Usuário e Senha)
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")));
    }
}