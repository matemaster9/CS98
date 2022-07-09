package cs.matemaster.web.service;

import cs.matemaster.common.dto.SysUserDTO;
import cs.matemaster.common.vo.SysUserVO;

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

    /**
     * 登陆，依据数据库比对用户数据
     *
     * @param sysUser
     * @return
     */
    Boolean login(SysUserVO sysUser);
}
