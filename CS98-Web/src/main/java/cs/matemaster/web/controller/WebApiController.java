package cs.matemaster.web.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Api(value = "WebApiController", tags = "系统控制器")
@RestController
@RequestMapping("/sys")
@AllArgsConstructor
public class WebApiController {

    @GetMapping("/npe")
    public void getNPE() {
        Integer number = null;
        System.out.println(number > 1);
    }
}
