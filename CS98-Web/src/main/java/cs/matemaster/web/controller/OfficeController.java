package cs.matemaster.web.controller;

import cs.matemaster.web.common.model.vo.Global500VO;
import cs.matemaster.web.facade.OfficeFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/17
 */
@Api(value = "OfficeController", tags = "办公控制器")
@RestController
@RequestMapping("/office")
@AllArgsConstructor
public class OfficeController {

    private OfficeFacade officeFacade;

    @ApiOperation("上传员工数据")
    @PostMapping("/uploadCodingMapList")
    public Boolean uploadCodingMapList(@RequestBody MultipartFile file) {
        return null;
    }

    @ApiOperation("上传global500数据")
    @PostMapping("/uploadGlobalCompanyList")
    public Boolean uploadGlobalCompanyList(@RequestBody MultipartFile file) {
        return officeFacade.uploadGlobalCompanyList(file);
    }

    @ApiOperation("查询500强企业信息")
    @GetMapping("/getGlobal500")
    public Global500VO getGlobal500(Integer year) {
        return officeFacade.getGlobalCompanyList(year);
    }
}
