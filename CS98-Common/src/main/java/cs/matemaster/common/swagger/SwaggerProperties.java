package cs.matemaster.common.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author MateMaster
 * @since 2022/6/5
 */
@Configuration
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER)
@Data
public class SwaggerProperties {
    public static final String SWAGGER = "swagger";

    private boolean enable;

    private String description;

    private String title;

    private String version;
}
