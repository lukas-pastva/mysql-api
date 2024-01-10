package api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {


    @Bean
    public OpenAPI springShopOpenAPI() {
        Info info = new Info()
                .title("DevOps")
                .description("Swagger API Specification for DevOps")
                .version("2.0");

        return new OpenAPI().info(info);
    }
}
