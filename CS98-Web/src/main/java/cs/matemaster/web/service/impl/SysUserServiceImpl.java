package cs.matemaster.web.service.impl;

import cs.matemaster.common.dto.SysUserDTO;
import cs.matemaster.common.exception.WebRuntimeException;
import cs.matemaster.web.constant.WebApiErrorCode;
import cs.matemaster.web.mapper.SysUserMapper;
import cs.matemaster.web.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Override
    public boolean registerUser(SysUserDTO sysUser) {

        SysUserDTO sysUserDTO = sysUserMapper.getUserByName(sysUser.getUsername());

        if (Objects.nonNull(sysUserDTO)) {
            throw new WebRuntimeException(WebApiErrorCode.SYS_USER_EXISTED_ERROR);
        }

        return sysUserMapper.insertUser(sysUser) == 1;
    }
}
