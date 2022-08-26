package cs.matemaster.web.common.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/8/17
 */
@Data
@ApiModel("编码映射")
public class CodingMapVO {

    @ApiModelProperty("编码")
    @JsonProperty("code")
    private String code;

    @ApiModelProperty("页面元素")
    @JsonProperty("element")
    private String element;
}
