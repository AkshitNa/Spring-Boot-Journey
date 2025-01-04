package nautiDevelopers.RestfulCRUD.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student API")
                        .version("Java Version 21")
                        .description("By Akshit Nautiyal")
                        .summary("Student Backend for Project KVFRI")
                        .termsOfService("https://github.com/AkshitNa")
                        .contact(new Contact()
                                .name("Team nautiDevelopers")
                                .email("nauti.akshit001@gmail.com")
                                .url("https://www.linkedin.com/in/nautiyalakshit777/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Local Development Server"),
                        new Server()
                                .url("http://localhost:8082")
                                .description("Production Server")
                ))
                .tags(List.of(
                        new Tag()
                                .name("Student APIs"),
                        new Tag()
                                .name("Hello APIs")
                ));

                //In case we have JWT Authentication

//                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//                .components(new Components().addSecuritySchemes("bearerAuth",
//                        new SecurityScheme()
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")
//                                .in(SecurityScheme.In.HEADER)
//                                .name("Authorization")
//                ));

    }
}
