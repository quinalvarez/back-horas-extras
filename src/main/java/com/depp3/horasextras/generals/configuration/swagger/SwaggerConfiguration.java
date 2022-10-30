package com.depp3.horasextras.generals.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("App Horas Extras")
                        .version("1.0.0")
                        .description("Aplicación para llevar el control de horas extras de tu personal")
                        .contact(new Contact()
                                .name("Joaquin Alvarez")
                                .email("joalvarez.depp3@gmail.com")
                                .url("https://github.com/quinalvarez")
                        )
                );
    }
}
