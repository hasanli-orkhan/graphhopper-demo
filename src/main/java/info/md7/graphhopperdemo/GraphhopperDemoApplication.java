package info.md7.graphhopperdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Graphhopper Demo Application",
                version = "1.0.0"
        )
)
public class GraphhopperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphhopperDemoApplication.class, args);
    }

}
