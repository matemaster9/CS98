package cs.matemaster.web.bff.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Configuration
@ConfigurationProperties(prefix = SysBffConfig.PREFIX)
@Data
public class SysBffConfig {

    public static final String PREFIX = "web-bff-application";

    private String webApiUrl;
}
