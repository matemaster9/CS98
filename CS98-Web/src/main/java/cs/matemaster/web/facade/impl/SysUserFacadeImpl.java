package cs.matemaster.web.facade.impl;

import cs.matemaster.web.facade.SysUserFacade;
import cs.matemaster.web.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Component
@AllArgsConstructor
public class SysUserFacadeImpl implements SysUserFacade {

    private SysUserService sysUserService;
}
