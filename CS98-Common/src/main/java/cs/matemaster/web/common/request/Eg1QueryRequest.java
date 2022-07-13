package cs.matemaster.web.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/11
 */
@Data
@ApiModel("测试请求")
public class Eg1QueryRequest {

    @ApiModelProperty("localStart")
    private String start;

    @ApiModelProperty("remoteStart")
    private String end;
}
