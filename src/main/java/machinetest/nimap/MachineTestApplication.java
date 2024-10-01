package machinetest.nimap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Nimap Machine Test API",
                version = "1.0",
                description = "API documentation for the Nimap Machine Test project"
        )
)
public class MachineTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MachineTestApplication.class, args);
    }

}
