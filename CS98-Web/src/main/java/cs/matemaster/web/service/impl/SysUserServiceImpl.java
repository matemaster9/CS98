package cs.matemaster.web.service.impl;

import cs.matemaster.web.mapper.SysUserMapper;
import cs.matemaster.web.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;
}
