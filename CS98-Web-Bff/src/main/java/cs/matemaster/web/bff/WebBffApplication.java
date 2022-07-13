package cs.matemaster.web.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@SpringBootApplication(scanBasePackages = "cs.matemaster.web")
@ConfigurationPropertiesScan("cs.matemaster.web")
@EnableSwagger2
public class WebBffApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBffApplication.class, args);
    }
}
