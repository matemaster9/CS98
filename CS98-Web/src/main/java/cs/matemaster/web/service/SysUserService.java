package cs.matemaster.web.service;

import cs.matemaster.common.dto.SysUserDTO;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
public interface SysUserService {

    /**
     * 注册用户，向数据库插入用户数据
     *
     * @param sysUser 注册用户信息
     * @return
     */
    boolean registerUser(SysUserDTO sysUser);
}
