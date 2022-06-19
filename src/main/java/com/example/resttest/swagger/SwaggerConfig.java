package com.example.resttest.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Rest API Server")
                                .version("1.0.0")
                                .termsOfService("https://github.com/MaxRyazan/RestTest")
                                .contact(
                                        new Contact()
                                                .email("no4ta87@mail.ru")
                                                .name("MaxRyazan")
                                )
                );
    }


}
