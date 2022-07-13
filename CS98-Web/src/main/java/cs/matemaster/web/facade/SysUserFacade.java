package cs.matemaster.web.facade;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.vo.SysUserVO;

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

    /**
     * 用户登陆
     *
     * @param sysUser
     * @return
     */
    Boolean login(SysUserVO sysUser);
}
