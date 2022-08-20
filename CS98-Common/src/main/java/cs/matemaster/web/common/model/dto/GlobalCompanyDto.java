package cs.matemaster.web.common.model.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 财富世界500强公司
 *
 * @author MateMaster
 * @since 2022/8/18
 */
@Data
@ExcelTarget("GlobalCompany")
public class GlobalCompanyDto {

    /**
     * 世界排名
     */
    @Excel(name = "排名")
    private Integer rank;

    /**
     * 公司名称
     */
    @Excel(name = "公司名称(中文)")
    private String companyName;

    /**
     * 营业收入
     */
    @Excel(name = "营业收入(百万美元)")
    private BigDecimal income;

    /**
     * 利润
     */
    @Excel(name = "利润(百万美元)")
    private BigDecimal profit;

    /**
     * 所属国家
     */
    @Excel(name = "国家")
    private String country;

    /**
     * 年份
     */
    @Excel(name = "年份")
    private Integer year;
}
