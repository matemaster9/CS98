package cs.matemaster.web.mapper;

import cs.matemaster.common.dto.SysUserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * sys_user
 *
 * @author MateMaster
 * @since 2022/7/6
 */
@Mapper
public interface SysUserMapper {

    /**
     * 依据username查找用户信息
     *
     * @param username 唯一存在
     * @return
     */
    @Select({"SELECT username, password " +
            "FROM sys_user " +
            "WHERE username = #{username} "
    })
    SysUserDTO getUserByName(String username);

    /**
     * 数据库插入用户信息
     *
     * @param sysUser
     * @return
     */
    @Insert({"INSERT INTO sys_user(username, password) " +
            "VALUES " +
            "(#{user.username}, #{user.password}) "
    })
    int insertUser(@Param("user") SysUserDTO sysUser);
}
