package com.spring.course.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //Archivo de configuracion
@EnableSwagger2 //Habilito el uso de Swagger aca.
public class SwaggerConfig {
    //Solo me interesan documentar/explicar los archivos de controller porque ahí es donde tengo los endpoints de mi api
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select() //Selecciono
                .apis(RequestHandlerSelectors.basePackage("com.spring.course.web.controller")) //Pongo la ruta del paquete
                .build(); // construyo
    }
}
