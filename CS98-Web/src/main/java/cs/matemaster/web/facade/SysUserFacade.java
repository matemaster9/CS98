package cs.matemaster.web.facade;

import cs.matemaster.common.dto.SysUserDTO;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
public interface SysUserFacade {

    /**
     * 注册用户
     *
     * @param sysUser
     * @return
     */
    boolean registerUser(SysUserDTO sysUser);
}
