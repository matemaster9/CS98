package cs.matemaster.web.common.model.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/8/17
 */
@Data
@ExcelTarget("CodingMap")
public class CodingMapDto {

    @Excel(name = "编码")
    private String code;

    @Excel(name = "页面元素")
    private String element;
}
