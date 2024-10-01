package machinetest.nimap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

public class OpneApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://nimap-machine-test-java-production.up.railway.app"))
                .info(new Info().title("Your API Title")
                        .version("1.0")
                        .description("API description"));
    }
}
