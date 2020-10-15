package mx.gob.nayatit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Class configuration for Swagger UI
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Instance a new Docket object with information of swagger
     * @return  A Docker instance.
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage("mx.gob.nayatit.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("API REST backend - Producer.",
                "Servicios rest para catalogos.",
                "1.0",
                "Nay",
                new Contact("Nay", "https://www.nay.mx/", ""),
                "",
                "",
                Collections.emptyList()
        );

    }
}
