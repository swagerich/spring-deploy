package com.bootcamp.erich.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *
 * https://springdoc.org/#migrating-from-springfox
 * */

/*
 * http://localhost:8080/swagger-ui/index.html
 * http://localhost:8080/swagger-ui-crud.html
 * */
@Configuration
public class SwaggerConfig {

    /*@Bean //spring reconoce y ejecuta el metodo
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiDetails())
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

     private ApiInfo apiDetails(){
        return new ApiInfo(
                "SpringBootCampByErich",
                "Crud",
                "21",
                "www.github.com",
                new Contact("Erick Hc","swagerich.dev.gihub","erickhc.dev@gmail.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList()
        );
    }*/


   /* @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder().group("com.bootcamp.erich")
        .packagesToScan().build();
    }*/

    @Bean
    public OpenAPI openDetails() {
        return new OpenAPI()
                .info(new Info().title("SpringBootCompByErich")
                        .description("Spring Crud")
                        .version("v0.2.1")
                        .license(new License().name("Apache 2.0").url("wwww.spring.io"))).externalDocs(new ExternalDocumentation()
                        .description("SpringBoot Crud Documentacion")
                        .url("http://swagerich.com"));

    }


}
