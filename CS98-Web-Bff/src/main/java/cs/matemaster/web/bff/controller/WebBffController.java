package cs.matemaster.web.bff.controller;

import cs.matemaster.web.common.dto.SysUserDTO;
import cs.matemaster.web.common.model.PageDataView;
import cs.matemaster.web.common.request.Eg1QueryRequest;
import cs.matemaster.web.common.request.QuerySysUserRequest;
import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.bff.facade.WebBffFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("打印")
    @GetMapping("/printSysWebCfg")
    public void printSysWebCfg() {
        webBffFacade.print();
    }

    @ApiOperation("查询")
    @PostMapping("/querySysWebCfg")
    public void querySysWebCfg(@RequestBody Eg1QueryRequest request) {
        webBffFacade.querySysWebCfg(request);
    }

    @ApiOperation("分页查询用户信息")
    @PostMapping("/getPagingList")
    public PageDataView<SysUserDTO> getPagingList(QuerySysUserRequest request) {
        return webBffFacade.getPagingList(request);
    }
}
