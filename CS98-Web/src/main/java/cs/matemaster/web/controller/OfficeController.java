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

    @ApiOperation("导出500强企业信息到excel")
    @GetMapping("/exportGlobal500")
    public void exportGlobal500(Integer year) {
        officeFacade.exportGlobal500(year);
    }

    @ApiOperation("将Excel数据解析成List<Map>")
    @PostMapping("/toMapList")
    public void toMapList(@RequestBody MultipartFile file) {
        officeFacade.toMapList(file);
    }
}
