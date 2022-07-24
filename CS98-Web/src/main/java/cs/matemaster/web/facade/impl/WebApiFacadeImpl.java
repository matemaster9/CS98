package cs.matemaster.web.facade.impl;

import cs.matemaster.web.facade.WebApiFacade;
import cs.matemaster.web.service.impl.WebApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MateMaster
 * @since 2022/7/24
 */
@Component
@AllArgsConstructor
public class WebApiFacadeImpl implements WebApiFacade {

    private WebApiService WebApiService;

}
