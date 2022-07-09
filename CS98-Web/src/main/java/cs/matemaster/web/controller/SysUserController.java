package cs.matemaster.web.controller;

import cs.matemaster.common.dto.SysUserDTO;
import cs.matemaster.common.vo.SysUserVO;
import cs.matemaster.web.facade.SysUserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Api(value = "SysUserController", tags = "系统用户控制器")
@RestController
@RequestMapping("/sys-user-config")
@AllArgsConstructor
public class SysUserController {

    private SysUserFacade sysUserFacade;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Boolean register(SysUserDTO sysUser) {
        return true;
    }

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public Boolean login(SysUserVO sysUser) {
        return true;
    }

    @ApiOperation("获取随机用户")
    @GetMapping("/rdmUser")
    public SysUserVO getRandomUser() {
        return SysUserVO.rdmUser();
    }
}
