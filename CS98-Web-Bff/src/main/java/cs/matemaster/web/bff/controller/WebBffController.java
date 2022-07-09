package cs.matemaster.web.bff.controller;

import cs.matemaster.common.vo.SysUserVO;
import cs.matemaster.web.bff.facade.WebBffFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Api(value = "WebBffController", tags = "系统控制器")
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class WebBffController {

    private WebBffFacade webBffFacade;

    @ApiOperation("获取随机用户")
    @PostMapping("/rdmUser")
    public SysUserVO getRandomUser() {
        return webBffFacade.getRandomUserInfo();
    }
}
