package info.md7.graphhopperdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "graphhopper")
@Getter
@Setter
public class GhProperties {

    String mapPath;
    String cachePath;
}
