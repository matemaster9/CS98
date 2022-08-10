package cs.matemaster.web.bff.controller;

import cs.matemaster.web.bff.facade.SysCmbFacade;
import cs.matemaster.web.bff.model.syscmb.CsaDummyRequest;
import cs.matemaster.web.bff.model.syscmb.vo.CsaDummyDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
@Api(value = "SysCmbController", tags = "业务模拟控制器")
@RestController
@RequestMapping("/cmb")
@AllArgsConstructor
public class SysCmbController {

    private SysCmbFacade sysCmbFacade;

    @ApiOperation("查询")
    @PostMapping("/queryDummyDataList")
    public List<CsaDummyDataVO> queryDummyDataList(@RequestBody CsaDummyRequest request) {
        return sysCmbFacade.queryDummyDataList(request);
    }
}
