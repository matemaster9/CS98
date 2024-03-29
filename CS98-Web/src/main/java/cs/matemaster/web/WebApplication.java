package cs.matemaster.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@SpringBootApplication(scanBasePackages = WebApplication.ScanBasePackages)
@ConfigurationPropertiesScan(WebApplication.ScanBasePackages)
@EnableSwagger2
public class WebApplication {

    public static final String ScanBasePackages = "cs.matemaster.web";

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
