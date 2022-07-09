package cs.matemaster.web.bff.facade.impl;

import cs.matemaster.common.vo.SysUserVO;
import cs.matemaster.web.bff.facade.WebBffFacade;
import cs.matemaster.web.bff.service.WebBffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Component
@AllArgsConstructor
public class WebBffFacadeImpl implements WebBffFacade {

    private WebBffService webBffService;

    @Override
    public SysUserVO getRandomUserInfo() {
        return webBffService.getRandomUserInfo();
    }
}
