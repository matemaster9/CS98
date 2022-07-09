package cs.matemaster.web.facade.impl;

import cs.matemaster.common.dto.SysUserDTO;
import cs.matemaster.common.exception.WebRuntimeException;
import cs.matemaster.web.constant.WebApiErrorCode;
import cs.matemaster.web.facade.SysUserFacade;
import cs.matemaster.web.service.SysUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Component
@AllArgsConstructor
public class SysUserFacadeImpl implements SysUserFacade {

    private SysUserService sysUserService;

    @Override
    public boolean registerUser(SysUserDTO sysUser) {
        if (Objects.isNull(sysUser)) {
            return false;
        }
        if (StringUtils.isBlank(sysUser.getUsername()) || StringUtils.isBlank(sysUser.getPassword())) {
            throw new WebRuntimeException(WebApiErrorCode.SYS_USER_INFO_NULL_ERROR);
        }
        return sysUserService.registerUser(sysUser);
    }
}
