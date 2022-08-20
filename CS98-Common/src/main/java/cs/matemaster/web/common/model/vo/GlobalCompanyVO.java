package cs.matemaster.web.common.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author MateMaster
 * @since 2022/8/20
 */
@Data
@ApiModel("全球500强公司")
public class GlobalCompanyVO {

    @ApiModelProperty("世界排名")
    private Integer comRank;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("营业收入")
    private BigDecimal income;

    @ApiModelProperty("利润")
    private BigDecimal profit;

    @ApiModelProperty("所属国家")
    private String country;

}
