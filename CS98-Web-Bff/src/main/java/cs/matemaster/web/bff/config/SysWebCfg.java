package cs.matemaster.web.bff.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author MateMaster
 * @since 2022/7/11
 */
@Data
@Configuration
public class SysWebCfg {

    @Value("${query-time.local-start}")
    private String localQueryStartDate;

    @Value("${query-time.remote-start}")
    private String remoteQueryStartDateDate;
}
