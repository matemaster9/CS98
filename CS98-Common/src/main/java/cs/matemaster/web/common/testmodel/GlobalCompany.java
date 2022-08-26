package cs.matemaster.web.common.testmodel;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author MateMaster
 * @since 2022/8/21
 */
@Data
public class GlobalCompany {
    private Integer rank;
    private String companyName;
    private BigDecimal income;
    private BigDecimal profit;
    private String country;
    private Integer year;
}
