package br.com.lixotruck.lixotruck;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Lixo-Truck API")
                        .description("API Rest da aplicação Lixo-Truck, contendo as funcionalidades de CRUD de usuários, caminhões, motoristas, entre outras...")
                        .contact(new Contact()
                                .name("Time Lixo-Truck")
                                .email("diegotsouza@outlook.com")));
    }
}
