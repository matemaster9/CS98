package cs.matemaster.web.controller;

import cs.matemaster.web.common.model.ComStaff;
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
 * @since 2022/8/8
 */
@Api(value = "ComStaffController", tags = "员工控制器")
@RestController
@RequestMapping("/comStaff")
@AllArgsConstructor
public class ComStaffController {

    @ApiOperation("上传员工数据")
    @PostMapping("/upload")
    public Boolean upload(@RequestBody List<ComStaff> comStaffList) {
        return null;
    }
}
