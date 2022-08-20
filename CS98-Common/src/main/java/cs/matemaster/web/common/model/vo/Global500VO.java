package cs.matemaster.web.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/20
 */
@Data
@ApiModel("全球500强")
public class Global500VO {

    @ApiModelProperty("年份")
    private Integer year;

    @ApiModelProperty("世界500强企业")
    private List<GlobalCompanyVO> globalCompanyList;
}
