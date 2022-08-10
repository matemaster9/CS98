package cs.matemaster.web.controller;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.facade.WebApiFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Api(value = "WebApiController", tags = "系统控制器")
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class WebApiController {

    private WebApiFacade webApiFacade;

    @ApiOperation(value = "NPE", tags = "WEB-API")
    @GetMapping("/npe")
    public void getNPE() {
        Integer number = null;
        System.out.println(number > 1);
    }

    @ApiOperation(value = "获取用户信息", tags = "WEB-API")
    @GetMapping("/getSysUserDTOList")
    public List<SysUserDTO> getSysUserDTOList(int capacity) {
        return webApiFacade.getSysUserDTOList(capacity);
    }
}
